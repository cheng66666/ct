package com.example.administrator.ct.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.administrator.ct.common.MobileShopApp;

public class SpTools {

    private static final String CONFIG_FILE_NAME = "mobileshop_config_file";

    /**
     * @param key
     * @param value
     */
    public static void putBoolean(String key,boolean value){
        SharedPreferences sp = MobileShopApp.getsContext().getSharedPreferences(CONFIG_FILE_NAME, Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).commit();
    }

    /**
     * @param key
     * @param defValue
     * @return
     */
    public static boolean getBoolean(String key,boolean defValue){
        SharedPreferences sp = MobileShopApp.getsContext().getSharedPreferences(CONFIG_FILE_NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key, defValue);
    }

    /**
     * @param key
     * @param value
     */
    public static void putString(String key,String value){
        SharedPreferences sp = MobileShopApp.getsContext().getSharedPreferences(CONFIG_FILE_NAME, Context.MODE_PRIVATE);
        sp.edit().putString(key, value).commit();
    }

    /**
     * @param key
     * @param defValue
     * @return
     */
    public static String getString(String key,String defValue){
        SharedPreferences sp = MobileShopApp.getsContext().getSharedPreferences(CONFIG_FILE_NAME, Context.MODE_PRIVATE);
        return sp.getString(key, defValue);
    }

    /**
     * @param key
     * @param value
     */
    public static void putInt(String key,int value){
        SharedPreferences sp = MobileShopApp.getsContext().getSharedPreferences(CONFIG_FILE_NAME, Context.MODE_PRIVATE);
        sp.edit().putInt(key, value).commit();
    }

    /**
     * @param key
     * @param defValue
     * @return
     */
    public static int getInt(String key,int defValue){
        SharedPreferences sp = MobileShopApp.getsContext().getSharedPreferences(CONFIG_FILE_NAME, Context.MODE_PRIVATE);
        return sp.getInt(key, defValue);
    }

}
