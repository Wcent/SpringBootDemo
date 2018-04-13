package org.cent.SpringBootDemo.utils;

import org.cent.SpringBootDemo.enums.ResultCode;

/**
 * 封装统一响应报文结果类
 * @author cent
 * @version 1.0
 */
public class Result {
    private int code;
    private String msg;
    private Object data;

    /**
     * 构造无数据响应报文
     * @param resultCode 状态码
     */
    public Result(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        data = null;
    }

    /**
     * 构造有数据响应报文
     * @param resultCode 状态码
     * @param data 数据
     */
    public Result(ResultCode resultCode, Object data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
