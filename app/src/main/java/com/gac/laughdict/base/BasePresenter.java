package com.gac.laughdict.base;


public interface BasePresenter<T extends EmptyView> {
    void attachView(T view);

    void detachView();
}
