package com.developer.corson.patchdatafromstudentsys.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by le on 2016/4/29.
 */
public class SessionManager {

    Context context;
    SharedPreferences sp;

    public static void put(Context context, String key, String val){
       SharedPreferences sp = context.getSharedPreferences(context.getPackageName(), 0 );
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, val);
        editor.commit();
    }



    public static String get(Context context, String key, String defaultVal){
        SharedPreferences sp = context.getSharedPreferences(context.getPackageName(), 0);
        return sp.getString(key, defaultVal);
    }


    public static  void  clear(Context context){
        SharedPreferences sp = context.getSharedPreferences(context.getPackageName(), 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
    }
}
