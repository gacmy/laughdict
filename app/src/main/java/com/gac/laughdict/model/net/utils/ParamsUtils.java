package com.gac.laughdict.model.net.utils;

import org.json.JSONObject;

import java.security.MessageDigest;
import java.util.HashMap;

/**
 * Created by gacmy on 2017/3/17.
 */
public class ParamsUtils {
    public static HashMap<String,String> getLaughParams(String ...params ){
        HashMap<String,String> param =  new HashMap<>();
        param.put("key","4486e7f3ad2fb806622807a66bc0f492");
        int length = params.length/2;
        for(int i = 1; i <= length; i++){
            param.put(params[(i-1)*2],params[i*2-1]);
        }
        return param;
    }
    public static HashMap<String,String> getParams(String ...params ){
        HashMap<String,String> param =  new HashMap<>();
        int length = params.length/2;
        for(int i = 1; i <= length; i++){
            param.put(params[(i-1)*2],params[i*2-1]);
        }
        return param;
    }

    public static JSONObject getParams(JSONObject json){
        JSONObject params = new JSONObject();
        try {
            params.put("sign","");
            params.put("token","");
            params.put("params",json);
            String sign = getMD5(params.toString());
            params.put("sign",sign);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return params;
    }

    public static String getMD5(String message) throws Exception {

        byte[] bytes = message.getBytes("UTF-8");
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(bytes);
        bytes = messageDigest.digest();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            if ((bytes[i] & 0xff) < 0x10) {
                sb.append("0");
            }

            sb.append(Long.toString(bytes[i] & 0xff, 16));
        }

        return sb.toString().toLowerCase();
    }

}
