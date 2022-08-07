package com.zzz.furn.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zjlniubbb
 * @version 1.0
 */
public class Msg {
    private int code;
    private String msg;
    private Map<String, Object> extend = new HashMap<String, Object>();

    public static Msg success() {
        Msg res = new Msg();
        res.setCode(200);
        res.setMsg("success");
        return res;
    }

    public static Msg fail() {
        Msg res = new Msg();
        res.setCode(400);
        res.setMsg("fail");
        return res;
    }

    public Msg add(String key, Object value) {
        this.getExtend().put(key, value);
        return this;
    }

    public Msg() {
    }

    public Msg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Msg(int code, String msg, Map<String, Object> extend) {
        this.code = code;
        this.msg = msg;
        this.extend = extend;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}

