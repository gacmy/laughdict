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

    private String error_code;
    private String reason;

    /**
     * 数据
     */
    private T result;


    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
