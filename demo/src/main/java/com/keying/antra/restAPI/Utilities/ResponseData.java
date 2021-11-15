package com.keying.antra.restAPI.Utilities;

public class ResponseData {
    private Integer code;
    private Object Data;
    private String msg;

    public ResponseData(Integer code, Object data, String msg) {
        this.code = code;
        Data = data;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        Data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }





    public static ResponseData buildSuccess(Integer code, Object data, String msg) {
        return new ResponseData(code, data, msg);
    }


    public static ResponseData buildError(Integer code, String msg) {
        return new ResponseData(code, null, msg);
    }


}
