package com.gac.laughdict.ui.fragment;

import android.view.LayoutInflater;

import com.gac.laughdict.R;
import com.gac.laughdict.base.BaseFragment;
import com.gac.laughdict.presenter.ImagePresenter;
import com.gac.laughdict.ui.view.ImageLaughView;

import butterknife.BindView;

/**
 * Created by gacmy on 2017/8/4.
 */

public class ImageFragment extends BaseFragment {
    @BindView(R.id.imageLaughView) ImageLaughView mView;
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_image;
    }

    @Override
    protected void initView(LayoutInflater inflater) {
        mPresenter = new ImagePresenter(mView,getActivity());
    }
}
