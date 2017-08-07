package com.gac.laughdict.presenter.contract;

import com.gac.laughdict.base.BasePresenter;
import com.gac.laughdict.base.BaseView;


/**
 * Created by gacmy on 2017/8/7.
 */

public interface FirstContract {
    interface View extends BaseView<Presenter> {
        boolean isActive();
    }
    interface Presenter extends BasePresenter{
        void onRefresh();
        void getContent();
        public void onLoadMore();
    }
}




























