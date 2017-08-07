package com.gac.laughdict.ui.view;

import android.content.Context;
import android.util.AttributeSet;

import com.gac.laughdict.R;
import com.gac.laughdict.base.StateBaseView;
import com.gac.laughdict.presenter.contract.FirstContract;
import com.gac.laughdict.presenter.contract.MyContract;
import com.gac.laughdict.utils.StringUtils;

import butterknife.ButterKnife;

/**
 * Created by gacmy on 2017/8/7.
 */

public class MyView extends StateBaseView implements MyContract.View{
    MyContract.Presenter mPresenter;
    public MyView(Context context) {
        super(context);
        init();
    }
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void  init(){
        mContext = getContext();
        inflate(mContext, R.layout.view_my, this);
        unbinder = ButterKnife.bind(this);
        initView();
        mActive = true;
    }
    private void initView(){

    }
    @Override
    public boolean isActive() {
        return mActive;
    }

    @Override
    public void setPresenter(MyContract.Presenter presenter) {
        mPresenter = StringUtils.checkNotNull(presenter);
    }

    @Override
    public void showError(String msg) {
        showErrorView(msg);
    }
}
