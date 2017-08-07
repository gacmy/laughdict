package com.gac.laughdict.model.net.utils;

import android.util.Log;

import com.gac.laughdict.BuildConfig;


/**
 * Created by gacmy on 2017/3/17.
 */
public class L {
    public static void d(String tag, String msg){
       // if(!BuildConfig.IS_DEBUG){
            System.out.println("**************************************************");
            Log.d(tag,msg);
            System.out.println("**************************************************");
    //    }
    }
    public static void e(String tag, String msg){
        if(BuildConfig.IS_DEBUG){
            System.out.println("**************************************************");
            Log.e(tag,msg);
            System.out.println("**************************************************");
        }
    }
    public static void v(String tag, String msg){
        if(BuildConfig.IS_DEBUG){
            System.out.println("**************************************************");
            Log.v(tag,msg);
            System.out.println("**************************************************");
        }
    }
    public static void i(String tag, String msg){
        if(BuildConfig.IS_DEBUG){
            System.out.println("**************************************************");
            Log.i(tag,msg);
            System.out.println("**************************************************");
        }
    }
}
