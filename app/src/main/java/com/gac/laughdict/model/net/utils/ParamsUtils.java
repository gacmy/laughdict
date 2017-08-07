package com.gac.laughdict.model.net.utils;

import org.json.JSONObject;

import java.security.MessageDigest;

/**
 * Created by gacmy on 2017/3/17.
 */
public class ParamsUtils {


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
