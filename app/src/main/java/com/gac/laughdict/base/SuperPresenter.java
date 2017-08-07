package com.gac.laughdict.base;

/**
 * Created by gacmy on 2017/3/15.
 */
public class SuperPresenter <T extends EmptyView> implements BasePresenter<T> {
    protected T mView;
    @Override
    public void attachView(T view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
