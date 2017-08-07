package com.gac.laughdict.model.net;


import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;


import com.gac.laughdict.model.bean.BaseData;
import com.gac.laughdict.model.net.http.HttpStatus;
import com.gac.laughdict.model.net.okhttp.OkHttpUtils;
import com.gac.laughdict.model.net.utils.GsonUtil;
import com.widget.dialog.ProgressDialog;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by gacmy
 */
public class HttpAsyncTask<T> extends AsyncTask<Object, Integer, String> {

    private WeakReference<Context> weakReference;
    PostFormCompleteListener postFormCompleteListener;
    public boolean isShowing = false;
    ProgressDialog mDialog;
    public String content = "正在加载中...";
    Activity activity;
    public static int METHOD_POST = 0;
    public static int METHOD_GET = 1;
    private int mMethod = 0;
    private boolean mCancelable = false;
    private String jsonParams;
    private Map<String,String> mapParams;
    private String mUrl;
    //默认post json提交数据
    public HttpAsyncTask(Context context) {
        weakReference = new WeakReference<>(context);
        mMethod = 0;
        isShowing = false;
        activity = (Activity)context;

    }


    //content 加载框的内容  isShow 是否显示加载框  cancelable 加载框是否可以取消
    public HttpAsyncTask(Context context, String content, boolean isShow, final boolean cancelable,int method) {
        weakReference = new WeakReference<>(context);
        isShowing = isShow;
        activity = (Activity)context;
        mMethod = method;
        mCancelable = cancelable;
        if(mDialog == null && isShow){
            mDialog = new ProgressDialog(activity);
            mDialog .setMsg(content);
            mDialog.setCancelable(cancelable);

        }
    }
    //get请求 还是 post请求
    public  HttpAsyncTask setMethod(int method){
        mMethod = method;
        return this;
    }

    public HttpAsyncTask setURL(String url){
        mUrl = url;
        return this;
    }
    //对话框是否取消
    public HttpAsyncTask setDialogCancelable(boolean cancelable){
        mCancelable = cancelable;
        return this;
    }
    //是否显示对话框
    public HttpAsyncTask setShowDialog(boolean isShowing){
        this.isShowing = isShowing;
        return this;
    }

    public HttpAsyncTask setJsonParams(String json){
        jsonParams = json;
        return this;
    }
    public HttpAsyncTask setMapParams(Map<String,String> params){
        mapParams = params;
        return this;
    }
    //建立对话框的时候 调用build方法
    public HttpAsyncTask build(){
        if(mDialog == null && isShowing){
            mDialog = new ProgressDialog(activity);
            mDialog .setMsg(content);
            mDialog.setCancelable(mCancelable);

        }
        return this;
    }
    //显示对话框的提示信息
    public HttpAsyncTask setDialogMsg(String msg){
        content = msg;
        return  this;
    }
    @Override
    protected void onPreExecute() {
        if (null != activity && !activity.isFinishing() && mDialog != null && isShowing) {
            mDialog.show();
        }
       // DialogUtils.showProgressDialog();
    }



    @Override
    protected String doInBackground(Object... params) {
        String res = "";
        if(mMethod == METHOD_GET){
            res = OkHttpUtils.commonGet(mUrl,mapParams,weakReference.get());
        }else{
            res = OkHttpUtils.commonJson(mUrl,jsonParams,weakReference.get());
        }
        return res;
    }

    @Override
    protected void onPostExecute(String result) {

        if (null != activity && !activity.isFinishing() && mDialog != null && isShowing)  {
           mDialog.dismiss();
        }

        //处理网络返回的 404等异常信息
        if(processNetError(result)){
           // postFormCompleteListener.postFormComplete(null,null);
            return;
        }

        processNetData(result);
    }


    /**
     * 统一处理返回数据是否 是异常数据 例如 token过期
     * 处理错误消息 有错误返回true 正常返回false
     * @param result
     * @return
     */
  //  protected abstract boolean processResData(Map<String,Object> result);





    /**
     * 对服务器返回数据进行格式转换
     * 根据服务器返回的json字符串
     * @param str
     * @return
     */
    protected void processNetData(String str){
        if(TextUtils.isEmpty(str)){
            postFormCompleteListener.onError("");
            return;
        }
        Log.d("httputils","------json str res:"+str);
        BaseData res = GsonUtil.GsonToBean(str,BaseData.class);
        if(res != null){
            Log.d("httputils","------res:"+res.toString());
            int code = res.getError_code();
            if(code == 0){
                if(res.getResult()!=null){
                    postFormCompleteListener.onSuccess(str);
                }else{
                    postFormCompleteListener.onSuccess(null);
                }
            }else{
                postFormCompleteListener.onError(res.getReason());
            }


        }

    }


    @Override
    protected void onCancelled() {
        super.onCancelled();
        Log.d("httputils","-------------------onCancelled:");
        OkHttpUtils.shutDownHttpConn();
    }

    /**
     * 返回不是200 时候异常处理
     * @param str
     * @return 返回true 说明接口有异常
     */
    protected boolean processNetError(String str){
        if(TextUtils.isEmpty(str)){
            postFormCompleteListener.onError("");
            return true;
        }
       System.out.println("-------------processNetError:"+str);
        if(isNumeric(str)){
            postFormCompleteListener.onError(HttpStatus.getMessage(Integer.parseInt(str)));
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

    /**
     * 网络请求回调
     * @param postFormCompleteListener
     */
    public HttpAsyncTask setPostCompleteListener(PostFormCompleteListener postFormCompleteListener) {
        this.postFormCompleteListener = postFormCompleteListener;
        return this;
    }

    public interface PostFormCompleteListener {
        public void onSuccess(String res);
        public void onError(String msg);

    }
}
