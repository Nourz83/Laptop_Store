package com.theblackpearl.laptopstore.dataManagement;

import android.content.Context;
import android.content.SharedPreferences;

import com.theblackpearl.laptopstore.constants.AppStrings;
import com.theblackpearl.laptopstore.models.User;

public class SharedPreferenceHelper {
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;
    public SharedPreferenceHelper(Context context){
        sharedPreferences = context.getSharedPreferences(AppStrings.dbName , Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    public void setUser(User user)
    {

        editor.putString("username" , user.getUserName());
        editor.putString("password" , user.getPassword());
        editor.putString("name" , user.getName());
        editor.putBoolean("admin" , user.getUserName().equals("admin"));
        editor.commit();
    }
    public User getUser(){
        User user = new User();
        String username = sharedPreferences.getString("username" , null);
        String password = sharedPreferences.getString("password" , null);
        String name = sharedPreferences.getString("name" , null);
        if(username == null)
        {
            return null;
        }
        user.setUserName(username);
        user.setPassword(password);
        user.setName(name);
        return user;
    }
    public  boolean getType()
    {
        return sharedPreferences.getBoolean("admin" , false);
    }
    public void clear()
    {
        editor.clear();
        editor.commit();
    }
}
