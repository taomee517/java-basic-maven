package com.basic.java.util;

public class PRException extends RuntimeException {
    private String msg;
    private int code = 500;

    public PRException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public PRException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public PRException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public PRException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
