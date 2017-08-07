package com.gac.laughdict.base;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;


import com.gac.laughdict.app.App;
import com.gac.laughdict.utils.SystemUtils;

import butterknife.Unbinder;

/**
 * Created by gacmy on 2017/3/15.
 */
public abstract class BaseActivity <T extends BasePresenter> extends AppCompatActivity implements EmptyView{
    protected  boolean isConnection = false;
    protected T mPresenter;
    protected Unbinder unbinder;
    protected boolean mActivie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTranslucentStatus(true);

        isConnection = SystemUtils.checkNet(this);
        regReceiver();
        regNetReceiver();

        App.getInstance().registerActivity(this);
        //initBugout();
        if(mPresenter != null){
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
       // Bugout.onResume(this);
        mActivie = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
     //   Bugout.onPause(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
       // Bugout.onDispatchTouchEvent(this,event);
        return super.dispatchTouchEvent(event);
    }

    //初始化bugout
//    private void initBugout(){
//        BugoutConfig config = new BugoutConfig.Builder(getApplicationContext())
//                .withAppKey("6ce3d97ebcbf167aa4a0df303cb0bebb")     // 您的应用的项目 Key,如果已经在 Manifest 中配置则此处可略
//                .withAppChannel("hlt")     // 发布应用的渠道,如果已经在 Manifest 中配置则此处可略
//                .withUserInfo("gac")    // 用户信息-崩溃分析根据用户记录崩溃信息
//                .withDebugModel(true)    // 输出更多SDK的debug信息
//                .withErrorActivity(true)    // 发生崩溃时采集Activity信息
//                .withCollectNDKCrash(true) //  收集NDK崩溃信息
//                .withOpenCrash(true)    // 收集崩溃信息开关
//                .withOpenEx(true)     // 是否收集异常信息
//                .withReportOnlyWifi(true)    // 仅在 WiFi 下上报崩溃信息
//                .withReportOnBack(true)    // 当APP在后台运行时,是否采集信息
//                .withQAMaster(false)    // 是否收集摇一摇反馈
//                .withCloseOption(true)   // 是否在摇一摇菜单展示‘关闭摇一摇选项’
//               // .withLogcat(true)  // 是否系统操作信息
//                .build();
//
//        Bugout.init(config);
//
//
//    }
    protected void initView(){

    }
    protected void initEvent(){

    }

    /**
     * 注册广播，监听网络状态
     */
    private void regReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        registerReceiver(netListener, filter);
    }

    /**
     * 监听网络连接状态
     */
    private void regNetReceiver(){
        IntentFilter filter=new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        this.registerReceiver(netConnectListener, filter);
    }

    private void unRegNetReceiver(){
        unregisterReceiver(netConnectListener);
    }
    /**
     * 设置沉浸式
     *
     * @param on
     */
    protected void setTranslucentStatus(boolean on) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
//           win.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
//                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            if (on) {
                winParams.flags |= bits;
            } else {
                winParams.flags &= ~bits;
            }
            win.setAttributes(winParams);
        }
    }


    private BroadcastReceiver netConnectListener =  new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager=(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mobNetInfo=connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            NetworkInfo wifiNetInfo=connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if(mobNetInfo == null || wifiNetInfo == null){
                isConnection = false;
                return;
            }
            if (!mobNetInfo.isConnected() && !wifiNetInfo.isConnected()) {
                 isConnection = false;
                 //DialogUtils.showErrorDialg(context,"","网络连接断开");
                 //ToastUtil.warn(context,"网络断开连接");
                //改变背景或者 处理网络的全局变量
            }else {
                //改变背景或者 处理网络的全局变量
                isConnection = true;
            }
        }
    };
    private BroadcastReceiver netListener = new BroadcastReceiver() {

        String wifiAction = "android.net.wifi.WIFI_STATE_CHANGED";

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action) && action.equals(wifiAction)) {
                isConnection = SystemUtils.checkNet(context);
                boolean flag = SystemUtils.isWifiConnect(context);
                if(!flag){
                    //ToastUtil.warn(context,"wifi断开连接");
                    if(!isConnection){
                     // ToastUtil.warn(context,"网络断开连接");
                    }
                }else{
                    //ToastUtil.warn(context,"wifi回复正常");
                }

            }
        }
    };
    private void setTitleHeight(View view) {
//        if (view != null) {
//            ColorRelativeLayout title = (ColorRelativeLayout) view.findViewById(R.id.title);
//            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
//                if (title != null) {
//                    ViewGroup.LayoutParams lp = title.getLayoutParams();
//                    lp.height = ScreenUtil.dip2px(this, 48);
//                    title.setLayoutParams(lp);
//                    title.setPadding(0, 0, 0, 0);
//                }
//            }
//        }
    }

    protected static View getRootView(Activity context) {
        return ((ViewGroup) context.findViewById(android.R.id.content)).getChildAt(0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getInstance().unregisterActivity(this);
        if (netListener != null)
            unregisterReceiver(netListener);
        if(netConnectListener != null){
            unRegNetReceiver();
        }
        if (mPresenter != null)
            mPresenter.detachView();
        if (unbinder != null)
            unbinder.unbind();
    }

}
