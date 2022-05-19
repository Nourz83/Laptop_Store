package com.theblackpearl.laptopstore.dataManagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

import com.theblackpearl.laptopstore.constants.AppStrings;
import com.theblackpearl.laptopstore.models.Company;
import com.theblackpearl.laptopstore.models.Laptop;
import com.theblackpearl.laptopstore.models.User;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    public String companyTable = "Company";
    public String userTable = "Users";
    public String laptopTable = "LAPTOP_TABLE";

    public DataBaseHelper(Context context) {
        super(context, AppStrings.dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String[] queries = {
                "CREATE TABLE " + companyTable + "(id INTEGER PRIMARY KEY , name TEXT)",
                "CREATE TABLE " + userTable + "(id INTEGER PRIMARY KEY , username TEXT , password TEXT , name TEXT )",
                "CREATE TABLE " + laptopTable + "(id INTEGER PRIMARY KEY , manufacturer TEXT , model TEXT , GPU TEXT , CPU TEXT , RAM TEXT , HARD_TYPE TEXT , HARD_SIZE TEXT , IMAGE TEXT)"
        };
        db.execSQL(queries[0]);
        db.execSQL(queries[1]);
        db.execSQL(queries[2]);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addLaptop(Laptop laptop) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("manufacturer", laptop.getManufacturer());
        contentValues.put("model", laptop.getModel());
        contentValues.put("GPU", laptop.getGPU());
        contentValues.put("CPU", laptop.getCPU());
        contentValues.put("RAM", laptop.getRAM());
        contentValues.put("HARD_TYPE", laptop.getHARD_TYPE());
        contentValues.put("HARD_SIZE", laptop.getHARD_SIZE());
        contentValues.put("IMAGE", laptop.getIMAGE());
        db.insert(laptopTable, null, contentValues);
        db.close();
    }

    void addCompany(Company company) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", company.getName());
        db.insert(companyTable, null, contentValues);
        db.close();
    }

    public boolean addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Users WHERE username = ?" , new String[]{user.getUserName()});
        if(cursor.getCount() > 0)
        {
            db.close();
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", user.getUserName());
        contentValues.put("password", user.getPassword());
        contentValues.put("name", user.getName());
        long l = db.insert(userTable, null, contentValues);
        System.out.println(l);
        db.close();
        return true;
    }

    Laptop getLaptopById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + laptopTable + "WHERE id = " + id;
        Cursor cursor = db.rawQuery(query, null);
        Laptop laptop = new Laptop(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6),
                cursor.getString(7),
                cursor.getString(8)
        );
        return laptop;
    }

    public List<Laptop> getAllLaptop() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + laptopTable, null);
        List<Laptop> laptops = new ArrayList<Laptop>();
        if (cursor.moveToFirst()) {
            do {
                Laptop laptop = new Laptop(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8)
                );
                laptops.add(laptop);
            } while (cursor.moveToNext());
        }
        return laptops;
    }

    public void deleteLaptop(int id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(laptopTable, "id" + "=?", new String[]{Integer.toString(id)});
        sqLiteDatabase.close();
    }

    public User getUser(User user) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String[] args = {user.getUserName().toString() , user.getPassword().toString()};
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Users where username = ? and password = ?", args );
        System.out.println(user.getUserName());
        System.out.println(user.getPassword());
        System.out.println(cursor.getCount());
        //System.out.println("SELECT * FROM " + userTable + " WHERE username = " + user.getName() + " AND password = " + user.getPassword());
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            User user1 = new User(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            return user1;
        } else {
            return null;
        }
    }
    public void printAllUser()
    {
        Cursor cursor = this.getWritableDatabase().rawQuery("SELECT * FROM Users" , null);
        cursor.moveToFirst();
        do {
            System.out.println(cursor.getInt(0) + " " + cursor.getString(1) + " " + cursor.getString(2) + " " + cursor.getString(3));
        }while (cursor.moveToNext());
    }
    List<Company> getAllCompany() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + companyTable, null);
        List<Company> companies = new ArrayList<Company>();
        if (cursor.moveToFirst()) {
            do {
                Company company = new Company(
                        cursor.getInt(0),
                        cursor.getString(1)
                );
                companies.add(company);
            } while (cursor.moveToNext());
        }
        return companies;
    }
}

