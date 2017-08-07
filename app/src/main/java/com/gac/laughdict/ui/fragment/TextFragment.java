package com.gac.laughdict.ui.fragment;

import android.view.LayoutInflater;

import com.gac.laughdict.R;
import com.gac.laughdict.base.BaseFragment;
import com.gac.laughdict.presenter.TextPresenter;
import com.gac.laughdict.ui.view.TextLaughView;

import butterknife.BindView;

/**
 * Created by gacmy on 2017/8/4.
 */

public class TextFragment extends BaseFragment {
    @BindView(R.id.textlaughView)
    TextLaughView mView;




    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_text;
    }

    @Override
    protected void initView(LayoutInflater inflater) {
        mPresenter = new TextPresenter(mView,getActivity());
    }

    @Override
    protected void lazyFetchData() {
        //super.lazyFetchData();
    }


}




























