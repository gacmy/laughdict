package com.gac.laughdict.model.net.okhttp;


import android.content.Context;
import android.text.TextUtils;


import com.gac.laughdict.model.net.utils.HttpConfig;
import com.gac.laughdict.model.net.utils.L;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by gacmy
 */
public class OkHttpUtils {

    private static OkHttpClient mClient;
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/jpg");
    public static OkHttpClient getClient(Context context){
        if(mClient == null){
            mClient = new OkHttpClient.Builder().connectTimeout(HttpConfig.CONNECT_TIMTEOUT, TimeUnit.SECONDS).
            readTimeout(HttpConfig.READ_TIMEOUT, TimeUnit.SECONDS).//cookieJar(new CookiesManager(context)).//需要保存cookie 回传cookie使用cookiesManager
                    writeTimeout(HttpConfig.WRITE_TIMEOUT, TimeUnit.SECONDS).
                    build();
           // mClient.setCookieHandler(new CookieManager(new PersistentCookieStore(context), CookiePolicy.ACCEPT_ALL));
        }
        return mClient;
    }

    /**
     * get 请求
     * @param url
     * @param params
     * @return
     */
    public static String commonGet(String url, Map<String,String> params, Context context){
        mClient=getClient(context);
        HttpUrl httpUrl = getHttpUrl(url,params);
        Request request = new Request.Builder().url(httpUrl).build();
        try {
            Response response = mClient.newCall(request).execute();
            if(response.isSuccessful()){
                if(response.code()== 200)
                     return response.body().string();
            }
            return response.code()+"";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String uploadImages(String filePath, String url, String type, Context context){
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        File f=new File(filePath);

        if (f!=null) {
            builder.addFormDataPart("files", filePath, RequestBody.create(MEDIA_TYPE_PNG, f));
        }

        //添加其它信息
        builder.addFormDataPart("type",type);
//        builder.addFormDataPart("mapX", SharedInfoUtils.getLongitude());
//        builder.addFormDataPart("mapY",SharedInfoUtils.getLatitude());
//        builder.addFormDataPart("name",SharedInfoUtils.getUserName());


        MultipartBody requestBody = builder.build();
        //构建请求
        Request request = new Request.Builder()
                .url(url).addHeader("Connection", "close")//地址
              //  .addHeader("Cookie",SPUtils.getCookie(context))
                .post(requestBody)//添加请求体
                .build();
        mClient = getClient(context);
        try {
            Response response  = mClient.newCall(request).execute();

            if(response.code() == 200){
                return response.body().string();
            }else{
                return response.code()+"";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }


    //创建一个RequestBody(参数1：数据类型 参数2传递的json串)

//        CacheControl cc = new CacheControl.Builder()
//                //不使用缓存，但是会保存缓存数据
//                .noCache()
//                //不使用缓存，同时也不保存缓存数据
//                // .noStore()
//                //只使用缓存，（如果我们要加载的数据本身就是本地数据时，可以使用这个，不过目前尚未发现使用场景）
//                //.onlyIfCached()
//                //手机可以接收响应时间小于当前时间加上10s的响应
////                .minFresh(10,TimeUnit.SECONDS)
//                //手机可以接收有效期不大于10s的响应
////                .maxAge(10,TimeUnit.SECONDS)
//                //手机可以接收超出5s的响应
//                //.maxStale(5,TimeUnit.SECONDS)
//                .build();
    //创建一个请求对象
    // Request request = new Request.Builder().url(url).post(requestBody).build();
    /**
     * json 格式请求
     * @param url
     * @param json
     * @return
     */
    public static String commonJson(String url, String json, Context context){
        //申明给服务端传递一个json串
        //创建一个OkHttpClient对象
        String exception="";
       // Log.d("-----","url:"+url);
        mClient = getClient(context);
        if(json == null){
            json = "";
        }
        MediaType type=MediaType.parse("application/json; charset=utf-8");
        Request request = null;
       if(TextUtils.isEmpty(json)){
           request = new Request.Builder().url(url).get().addHeader("Connection", "close").get().build();//addHeader("Cookie",SPUtils.getCookie(context)).get().build();.addHeader("Set-Cookie",SPUtils.getCookie(context))
        }else{
            RequestBody requestBody = RequestBody.create(type, json);
            request = new Request.Builder().url(url).post(requestBody).addHeader("Connection", "close").build();//addHeader("Cookie",SPUtils.getCookie(context)).build();.addHeader("Set-Cookie",SPUtils.getCookie(context))

        }

//        for(int i = 0; i < request.headers().size(); i++){
//            L.d("cookie","name:"+request.headers().name(i)+ " value:"+request.headers().get(request.headers().name(i)));
//        }


        Response response = null;
        //发送请求获取响应
        try {
             response=mClient.newCall(request).execute();
            //判断请求是否成功
            if(response.isSuccessful()){
                //打印服务端返回结果

                if(response.code()== 200){
                   String res =  response.body().string();
                    System.out.println("------res:"+res);
                    return res;
                }


            }

            return response.code()+"";

        } catch (Exception e) {
            e.printStackTrace();

            return null;

        }finally{
            if(response != null){
                response.body().close();
            }
            //return null;
        }


    }

    /**
     * post 传参数请求
     * @param url
     * @param params
     */
    public static String commonPost(String url, Map<String,String> params, Context context){
        mClient = getClient(context);
       FormBody.Builder builder = new FormBody.Builder();
        if(null!=params && params.size()>0) {
            for(String key:params.keySet()) {
                if(null!=params.get(key)) {
                    String valueStr = params.get(key).toString();
                    builder.add(key,valueStr);
                }
                System.out.println("-----------请求参数------------"+key+":"+params.get(key));
            }
        }
        FormBody body = builder.build();
        Request request = new Request.Builder().url(url).post(body).build();
        try {
            Response response = mClient.newCall(request).execute();
//            for(int i = 0; i < response.headers().size();i++){
//                L.d("login","key:"+response.headers().name(i)+" value:"+response.headers().get(response.headers().name(i)));
//            }
            String cookieval = response.header("set-cookie");

            if(cookieval != null) {
                String cookie = cookieval.substring(0, cookieval.indexOf(";"));
               // SPUtils.setCookie(cookie,context);
            }else{
              //  SPUtils.setCookie("",context);
            }
            if(response.isSuccessful()){
                if(response.code()== 200)
                    return response.body().string();

            }
            return response.code()+"";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static HttpUrl getHttpUrl(String url, Map<String,String> params){
         HttpUrl.Builder builder =  HttpUrl.parse(url).newBuilder();
         setParams(builder,params);

        return builder.build();
    }

    public static void setParams(HttpUrl.Builder builder,Map<String,String> params){
        if(null!=params && params.size()>0) {
            for(String key:params.keySet()) {
                if(null!=params.get(key)) {
                    String valueStr = params.get(key).toString();
                    builder.addQueryParameter(key,valueStr);
                }
                System.out.println("-----------请求参数------------"+key+":"+params.get(key));
            }
        }
    }

    //停止连接
    public static void shutDownHttpConn() {
        L.d("httputil","shutDownHttpConn");
        if(null != mClient) {
            try{
                mClient.dispatcher().cancelAll();
            } catch(Exception e) {
                System.out.println("---"+e.getMessage());
            }
        }
    }
}
