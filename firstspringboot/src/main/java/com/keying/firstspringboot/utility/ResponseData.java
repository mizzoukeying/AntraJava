package com.keying.firstspringboot.utility;

public class ResponseData {
    private Integer code;
    private Object Data;
    private String msg;

    public ResponseData() {
    }

    public ResponseData(Integer code, Object data, String msg) {
        this.code = code;
        this.Data = data;
        this.msg = msg;
    }


    public static ResponseData success(String msg) {

        return new ResponseData(0, null, msg);
    }

    public static ResponseData success(Object data) {

        return new ResponseData(0, data, null);
    }


    public static ResponseData success(Object data, String msg) {

        return new ResponseData(0, data, msg);
    }


    public static ResponseData failed(String msg) {

        return new ResponseData(-1, null, msg);
    }
}
