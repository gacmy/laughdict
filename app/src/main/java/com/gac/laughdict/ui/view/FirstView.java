package com.gac.laughdict.ui.view;

import android.content.Context;
import android.util.AttributeSet;

import com.gac.laughdict.R;
import com.gac.laughdict.base.StateBaseView;
import com.gac.laughdict.presenter.contract.FirstContract;
import com.gac.laughdict.utils.StringUtils;

import butterknife.ButterKnife;

/**
 * Created by gacmy on 2017/8/7.
 */

public class FirstView extends StateBaseView implements FirstContract.View{
    FirstContract.Presenter mPresenter;
    public FirstView(Context context) {
        super(context);
        init();
    }
    public FirstView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void  init(){
        mContext = getContext();
        inflate(mContext, R.layout.view_first, this);
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
    public void setPresenter(FirstContract.Presenter presenter) {
        mPresenter = StringUtils.checkNotNull(presenter);
    }

    @Override
    public void showError(String msg) {

    }
}
