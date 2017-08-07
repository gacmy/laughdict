package com.gac.laughdict.model.net;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;


import com.gac.laughdict.model.bean.BaseData;
import com.gac.laughdict.model.net.http.HttpStatus;
import com.gac.laughdict.model.net.okhttp.OkHttpUtils;
import com.gac.laughdict.model.net.utils.GsonUtil;

import java.lang.ref.WeakReference;
import java.util.regex.Pattern;

/**
 * Created by gacmy on 2017/3/21.
 */
public class ImageUploadTask extends AsyncTask<Object, Integer, String> {
    PostFormCompleteListener mListener;
    String fileUrl;
    private String mType;
    private WeakReference<Context> weakReference;
    public void ImageUplaodTaks(Context context){

    }
    public ImageUploadTask(PostFormCompleteListener listener,Context context){
        mListener = listener;
        weakReference = new WeakReference<>(context);
    }

    @Override
    protected String doInBackground(Object[] params) {
        String json = null;
        String req_url  =  (String)params[0];
        if(params.length>=2) {
            if(params[1] != null){
                fileUrl = (String) params[1];
            }
            if(params[2] != null){
                mType = (String) params[2];
            }
        }
        if(json != null){
           // Log.d("httputils","-------------------params:"+json.toString());
        }
        String response = OkHttpUtils.uploadImages(fileUrl,req_url,mType,weakReference.get());
        return response;
    }
    /**
     * 返回不是200 时候异常处理
     * @param str
     * @return 返回true 说明接口有异常
     */
    protected boolean processNetError(String str){
        if(TextUtils.isEmpty(str)){
            mListener.onError("");
            return true;
        }
        //System.out.println("-------------processNetError:"+str);
        if(isNumeric(str)){
            mListener.onError(HttpStatus.getMessage(Integer.parseInt(str)));
            return true;
        }
        return false;
    }
    /**
     * 判断字符串是否是数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
    @Override
    protected void onPostExecute(String result) {
        if(processNetError(result)){
            // postFormCompleteListener.postFormComplete(null,null);
            return;
        }

        processNetData(result);

    }


    /**
     * 对服务器返回数据进行格式转换
     * 根据服务器返回的json字符串
     * @param str
     * @return
     */
    protected void processNetData(String str){
        if(TextUtils.isEmpty(str)){
            mListener.onError("");
            return;
        }
       // Log.d("httputils","------json str res:"+str);
        BaseData res = GsonUtil.GsonToBean(str,BaseData.class);
        if(res != null){
          //  Log.d("httputils","------res:"+res.toString());
//            String code = res.getError_code();
//          //  L.d("httputils","code:"+code);
//            if(!TextUtils.isEmpty(code) && code.equals("1")){
//
//                if(res.getData()!=null){
//                    mListener.onSuccess(str,fileUrl);
//                }else{
//                    mListener.onSuccess("null",fileUrl);
//                }
//
//            }else{
//                mListener.onError(res.getMsg());
//            }

        }

    }

    public interface PostFormCompleteListener {
        public void onSuccess(String res, String fileurl);


        public void onError(String msg);

    }
}
