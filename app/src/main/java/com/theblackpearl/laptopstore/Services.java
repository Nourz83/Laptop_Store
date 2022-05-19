package com.theblackpearl.laptopstore;

import android.content.Context;

import com.theblackpearl.laptopstore.dataManagement.DataBaseHelper;
import com.theblackpearl.laptopstore.dataManagement.SharedPreferenceHelper;
import com.theblackpearl.laptopstore.models.User;

public class Services {
    public static int login(User user , Context context)
    {
        SharedPreferenceHelper sharedPreferenceHelper = new SharedPreferenceHelper(context);
        if(user.getUserName().equals("admin") && user.getPassword().equals("admin"))
        {

            sharedPreferenceHelper.setUser(user);
            return 0;
        }
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
        if(dataBaseHelper.getUser(user , context))
        {

            return 1;
        }
        else{
            return 2;
        }

    }
    public static void logout(Context context)
    {
        SharedPreferenceHelper sharedPreferenceHelper = new SharedPreferenceHelper(context);
        sharedPreferenceHelper.clear();
    }
}
