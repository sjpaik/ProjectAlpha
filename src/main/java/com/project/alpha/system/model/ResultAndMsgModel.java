package com.project.alpha.system.model;

import java.io.Serializable;

public class ResultAndMsgModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean result;
    private String msg;
    private Object obj;

    public ResultAndMsgModel() { }

    public ResultAndMsgModel(boolean result, String msg) {
        this.result = result;
        this.msg = msg;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

}
