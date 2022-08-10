package com.zzz.book.util;

import lombok.Data;

/**
 * @author zjlniubbb
 * @version 1.0
 */
@Data
public class MyUtils {
    private Boolean flag;
    private Object data;
    private String msg;

    public MyUtils() {
    }

    public MyUtils(Boolean flag) {
        this.flag = flag;
    }

    public MyUtils(String msg) {
        this.msg = msg;
    }

    public MyUtils(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public MyUtils(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public MyUtils(Boolean flag, Object data, String msg) {
        this.flag = flag;
        this.data = data;
        this.msg = msg;
    }
}
