package com.gac.laughdict.presenter.contract;

import com.gac.laughdict.base.BasePresenter;
import com.gac.laughdict.base.BaseView;
import com.gac.laughdict.model.bean.ImageBean;

import java.util.List;


/**
 * Created by gacmy on 2017/8/7.
 */

public interface ImageContract {
    interface View extends BaseView<Presenter> {
        boolean isActive();
        void showContent(List<ImageBean> list);
        void showMoreContent(List<ImageBean> list);
    }
    interface Presenter extends BasePresenter{
        void onRefresh();
        void getContent();
        public void onLoadMore();
    }
}




























