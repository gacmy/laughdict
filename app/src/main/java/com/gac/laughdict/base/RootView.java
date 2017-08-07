package com.gac.laughdict.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;


import com.gac.laughdict.model.net.okhttp.OkHttpUtils;

import butterknife.Unbinder;

//import butterknife.Unbinder;


public class RootView extends LinearLayout {
    /**
     * 是否被销毁
     */
    protected boolean mActive;
    protected Context mContext;
    protected Unbinder unbinder;
    public   boolean isFirstLoading = true;
    public boolean isShutDown = true;//关闭页面的时候是否 关闭所有请求
    public RootView(Context context) {
        super(context);
    }

    public RootView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RootView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
//    public void showDialog(){
//        DialogUtils.showProgressDialog(getContext());
//    }
//
//
//    public void hideDiaog(){
//        DialogUtils.canceDialog();
//
//    }
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mActive = true;
    }

//    public void showProgressView(StateLayout layout){
//        if(layout != null){
//            layout.showProgressView();
//        }
//
//    }
//
//    public void showEmptyView(StateLayout layout){
//        if(layout != null){
//            layout.showEmptyView();
//        }
//
//    }
//    public void showContentView(StateLayout layout){
//        if(layout != null){
//            layout.showContentView();
//        }
//
//    }
//    public void showErrorView(StateLayout layout,String msg){
//        if(TextUtil.isEmpty(msg)){
//            msg = "网络错误";
//        }
//        if(layout != null){
//            layout.showErrorView(msg);
//        }
//
//    }
    @Override
    protected void onDetachedFromWindow() {
     //   DialogUtils.canceDialog();
        super.onDetachedFromWindow();
      //  DialogUtils.dismissNetError();

        mActive = false;
        unbinder.unbind();
        if(isShutDown){
            OkHttpUtils.shutDownHttpConn();
        }

        mContext = null;
    }
}
