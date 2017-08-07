package com.gac.laughdict.utils;

import android.text.TextUtils;

import java.util.Random;


public class StringUtils {
    /**
     * 去掉特殊字符
     *
     * @param s
     * @return
     */
    public static String removeOtherCode(String s) {
        if (TextUtils.isEmpty(s))
            return "";
        s = s.replaceAll("\\<.*?>|\\n", "");
        return s;
    }

    /**
     * 判断非空
     *
     * @param str
     * @return
     */
    public static String isEmpty(String str) {
        String result = TextUtils.isEmpty(str) ? "" : str;
        return result;
    }

    /**
     * 根据Url获取catalogId
     *
     * @param url
     * @return
     */
    public static String getCatalogId(String url) {
        String catalogId = "";
        if (!TextUtils.isEmpty(url) && url.contains("="))
            catalogId = url.substring(url.lastIndexOf("=") + 1);
        return catalogId;
    }

    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        }
        return reference;
    }

    public static int getRandomNumber(int min, int max) {
        return new Random().nextInt(max) % (max - min + 1) + min;
    }

    public static String getErrorMsg(String msg) {
        if (msg.contains("*")) {
            msg = msg.substring(msg.indexOf("*") + 1);
            return msg;
        } else
            return "";
    }
/**
 *
 *  mEtPrice.setOnFocusChangeListener(new View.OnFocusChangeListener() {
@Override
public void onFocusChange(View v, boolean hasFocus) {
if(!hasFocus){
if(mEtPrice.getText() != null){
if(!TextUtils.isEmpty(mEtPrice.getText().toString())){
mEtPrice.setText(StringUtils.processNumStr(mEtPrice.getText().toString()));
}
}
return;

}
}
});
 *
 * */
    ////小数点法则---一位和两位显示两位     三位显示三位     三位以上显示三位
    public static String processNumStr(String str){
        StringBuilder newstr = new StringBuilder();
        String[] spiltStr = str.split("\\.");
      ///  AppLog.Logd("StringUtils","spiltStr length:"+spiltStr.length);
        if(spiltStr.length == 1){
            newstr.append(str+".00");
            return newstr.toString();
        }
       /// AppLog.Logd("StringUtils","spiltStr length:"+spiltStr.length);
        if(spiltStr.length == 2){
         ///   AppLog.Logd("StringUtils","spiltStr[1]:"+spiltStr[1]);
            if(spiltStr[1].length() == 1){
                newstr.append(str+"0");
                return newstr.toString();
            }
            if(spiltStr[1].length() == 2){
                newstr.append(str);
                return newstr.toString();
            }
            if(spiltStr[1].length() == 3){
                newstr.append(str);
                return newstr.toString();
            }
            if(spiltStr[1].length() > 3){
                float num = Float.parseFloat(str);
                float newnum = (float) Math.round(num*1000)/1000;

                String temp = newnum+"";
                ///AppLog.Logd("StringUtils","temp:"+temp);
                String[] strarray = temp.split("\\.");
                String strs = strarray[1].substring(0,3);
                newstr.append(strarray[0]+"."+strs);
                return newstr.toString();
            }
        }
        return str;

    }
}
