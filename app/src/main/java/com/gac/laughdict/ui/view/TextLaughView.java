package com.gac.laughdict.ui.view;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.gac.demo.refresh.decoration.DividerDecoration;
import com.gac.demo.refresh.layout.SmartRefreshLayout;
import com.gac.demo.refresh.layout.api.RefreshLayout;
import com.gac.demo.refresh.layout.listener.OnLoadmoreListener;
import com.gac.demo.refresh.layout.listener.OnRefreshListener;
import com.gac.laughdict.R;
import com.gac.laughdict.base.StateBaseView;
import com.gac.laughdict.model.bean.TextBean;
import com.gac.laughdict.presenter.contract.FirstContract;
import com.gac.laughdict.presenter.contract.TextContract;
import com.gac.laughdict.ui.adapter.TextLaughAdapter;
import com.gac.laughdict.utils.ScreenUtil;
import com.gac.laughdict.utils.StringUtils;
import com.gac.laughdict.utils.SystemUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.internal.Util;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * Created by gacmy on 2017/8/7.
 */

public class TextLaughView extends StateBaseView implements TextContract.View{
    TextContract.Presenter mPresenter;
    @BindView(R.id.refreshLayout) SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.recyclerView) RecyclerView mRv;
    TextLaughAdapter mAdapter;

    public TextLaughView(Context context) {
        super(context);
        init();
    }
    public TextLaughView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void  init(){
        mContext = getContext();
        inflate(mContext, R.layout.view_text, this);
        unbinder = ButterKnife.bind(this);
        initView();
        mActive = true;
    }
    private void initView(){
        showProgressView();
        initRecyclerView();

    }

    private void initRecyclerView(){
            mRv.addItemDecoration(new DividerItemDecoration(getContext(), VERTICAL));
            mRv.setLayoutManager(new LinearLayoutManager(getContext()));
            mRv.setItemAnimator(new DefaultItemAnimator());
            mAdapter = new TextLaughAdapter(getContext());
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
    public void showContent(List<TextBean> list) {
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
    public void showMoreContent(List<TextBean> list) {
        mRefreshLayout.finishLoadmore();
        mAdapter.addAll(list);
    }

    @Override
    public void setPresenter(TextContract.Presenter presenter) {
        mPresenter = StringUtils.checkNotNull(presenter);
    }

    @Override
    public void showError(String msg) {
        showErrorView(msg);
    }
}
