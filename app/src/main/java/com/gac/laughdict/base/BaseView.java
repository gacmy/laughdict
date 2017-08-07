package com.gac.laughdict.base;


public interface BaseView<T> {
    void setPresenter(T presenter);
    void showError(String msg);
}
