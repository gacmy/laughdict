package com.gac.laughdict.presenter.contract;

import com.gac.laughdict.base.BasePresenter;
import com.gac.laughdict.base.BaseView;
import com.gac.laughdict.model.bean.TextBean;

import java.util.List;


/**
 * Created by gacmy on 2017/8/7.
 */

public interface TextContract {
    interface View extends BaseView<Presenter> {
        boolean isActive();
        public void showContent(List<TextBean> list);
        public void showMoreContent(List<TextBean> list);
    }
    interface Presenter extends BasePresenter{
        void onRefresh();
        void getContent();
        public void onLoadMore();
    }
}




























