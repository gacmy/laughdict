package com.gac.laughdict.model.net.utils;

import java.io.Serializable;

/**
 * Created by gacmy on 2017/3/20.
 */
public class CommonJson<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -3440061414071692254L;

    private String code;
    private String msg;

    /**
     * 数据
     */
    private T data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
