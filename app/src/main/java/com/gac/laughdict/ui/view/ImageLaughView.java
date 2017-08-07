package com.gac.laughdict.ui.view;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.gac.demo.refresh.decoration.DividerDecoration;
import com.gac.demo.refresh.layout.SmartRefreshLayout;
import com.gac.demo.refresh.layout.api.RefreshLayout;
import com.gac.demo.refresh.layout.listener.OnLoadmoreListener;
import com.gac.demo.refresh.layout.listener.OnRefreshListener;
import com.gac.laughdict.R;
import com.gac.laughdict.base.StateBaseView;
import com.gac.laughdict.model.bean.ImageBean;
import com.gac.laughdict.presenter.contract.FirstContract;
import com.gac.laughdict.presenter.contract.ImageContract;
import com.gac.laughdict.ui.adapter.ImageLaughAdapter;
import com.gac.laughdict.utils.ScreenUtil;
import com.gac.laughdict.utils.StringUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gacmy on 2017/8/7.
 */

public class ImageLaughView extends StateBaseView implements ImageContract.View{
    ImageContract.Presenter mPresenter;

    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView mRv;
    ImageLaughAdapter mAdapter;
    public ImageLaughView(Context context) {
        super(context);
        init();
    }
    public ImageLaughView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void  init(){
        mContext = getContext();
        inflate(mContext, R.layout.view_image, this);
        unbinder = ButterKnife.bind(this);
        initView();
        mActive = true;
    }
    private void initView(){
        showProgressView();
        initRecyclerView();
    }

    private void initRecyclerView(){
        mRv.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        mRv.setLayoutManager(new LinearLayoutManager(getContext()));
        mRv.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new ImageLaughAdapter(getContext());
        DividerDecoration itemDecoration = new DividerDecoration(getContext().getResources().getColor(R.color.divider_color), ScreenUtil.dip2px(getContext(),5f),0,0);
        itemDecoration.setDrawLastItem(true);
        itemDecoration.setDrawHeaderFooter(false);

        mRv.addItemDecoration(itemDecoration);
        mRv.setAdapter(mAdapter);
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mPresenter.onRefresh();
            }
        });
        mRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                mPresenter.onLoadMore();
            }
        });
    }
    @Override
    public boolean isActive() {
        return mActive;
    }

    @Override
    public void showContent(List<ImageBean> list) {
        mRefreshLayout.finishRefresh();
        if(list == null || list.size() == 0){
            showEmptyView();
            return;
        }else{
            showContentView();
        }
        mAdapter.clear();
        mAdapter.addAll(list);
    }

    @Override
    public void showMoreContent(List<ImageBean> list) {
        mRefreshLayout.finishLoadmore();
        mAdapter.addAll(list);
    }

    @Override
    public void setPresenter(ImageContract.Presenter presenter) {
        mPresenter = StringUtils.checkNotNull(presenter);
    }

    @Override
    public void showError(String msg) {
        showErrorView(msg);
    }
}
