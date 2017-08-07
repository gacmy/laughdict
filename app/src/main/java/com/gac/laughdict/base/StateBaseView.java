package com.gac.laughdict.base;

import android.content.Context;
import android.util.AttributeSet;


import com.gac.laughdict.widget.statelayout.StateLayout;

import butterknife.Unbinder;

/**
 * Created by gacmy on 2017/6/8.
 */

public class StateBaseView  extends StateLayout {
    /**
     * 是否被销毁
     */
    protected boolean mActive;
    protected Context mContext;
    protected Unbinder unbinder;

    public StateBaseView(Context context) {
        super(context);
    }

    public StateBaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StateBaseView(Context context, AttributeSet attrs, int defStyleAttr) {
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

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
//        DialogUtils.dismissNetError();
//        DialogUtils.canceDialog();
        mActive = false;
        unbinder.unbind();
        mContext = null;
    }
}