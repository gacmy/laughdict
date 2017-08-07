package com.gac.laughdict.base;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.gac.laughdict.utils.SystemUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by gacmy on 2017/3/15.
 */
public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements EmptyView {
    private final String TAG = getClass().getSimpleName();
    protected Context mContext;
    protected boolean isConnection = false; // 判断网络状态是否连接 默认为false;
    protected View rootView;
    protected T mPresenter;
    protected Unbinder unbinder;
    private boolean isViewPrepared; // 标识fragment视图已经初始化完毕
    private boolean hasFetchData; // 标识已经触发过懒加载数据

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context != null){
            this.mContext = context;
        }else{
            mContext = getActivity();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isConnection = SystemUtils.checkNet(mContext);
       // regReceiver();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(rootView == null){
            rootView = inflater.inflate(getLayoutResource(),container,false);
        }
        ViewGroup parent = (ViewGroup)rootView.getParent();
        if(parent != null){
            parent.removeView(rootView);
        }
        unbinder = ButterKnife.bind(this, rootView);
        initView(inflater);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initEvent();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(mPresenter != null){
            mPresenter.attachView(this);
        }
        isViewPrepared = true;
        lazyFetchDataIfPrepared();
    }
    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d("BaseFragment", getClass().getName() + "------>isVisibleToUser = " + isVisibleToUser);
        if (isVisibleToUser) {
            lazyFetchDataIfPrepared();
        }
    }


    private void lazyFetchDataIfPrepared() {
        // 用户可见fragment && 没有加载过数据 && 视图已经准备完毕
        if (getUserVisibleHint() && !hasFetchData && isViewPrepared) {
            hasFetchData = true;
            lazyFetchData();
        }

    }
    /**
     * 懒加载的方式获取数据，仅在满足fragment可见和视图已经准备好的时候调用一次
     */
    protected void lazyFetchData() {
        Log.v(TAG, getClass().getName() + "------>lazyFetchData");
    }
    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // view被销毁后，将可以重新触发数据懒加载，因为在viewpager下，fragment不会再次新建并走onCreate的生命周期流程，将从onCreateView开始
        hasFetchData = false;
        isViewPrepared = false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        if (netListener != null)
//            mContext.unregisterReceiver(netListener);
        if (mPresenter != null)
            mPresenter.detachView();
        if (unbinder != null)
            unbinder.unbind();
    }
    protected void initView(LayoutInflater inflater) {
    }

    protected void initEvent() {
    }
    protected abstract int getLayoutResource();
    private void regReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
      //  mContext.registerReceiver(netListener, filter);
    }

//    private BroadcastReceiver netListener = new BroadcastReceiver() {
//
//        String wifiAction = "android.net.wifi.WIFI_STATE_CHANGED";
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            String action = intent.getAction();
//            if (!TextUtils.isEmpty(action) && action.equals(wifiAction)) {
//                isConnection = SystemUtils.checkNet(context);
//            }
//        }
//    };

}























