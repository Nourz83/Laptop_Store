package com.theblackpearl.laptopstore.dataManagement;

public class SqfLiteHelper {
    String userQuery = "Create TABLE User (id INTEGER PRIMARY KEY , username TEXT , password TEXT)";
    String laptopsQuery = "CREATE TABLE Laptops(id INTEGER PRIMARY KEY , NAME TEXT , IMAGE TEXT , DESCRIPTION TEXT , GRAPHICS TEXT , RAM TEXT , HARD_TYPE  TEXT , HARD_SIZE TEXT , CPU TEXT)";
    String companyQuery = "CREATE TABLE Company(id INTEGER PRIMARY KEY , NAME TEXT)";

}
