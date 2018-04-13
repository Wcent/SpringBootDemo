package org.cent.SpringBootDemo.enums;

/**
 * 结果状态码及描述枚举类
 * @author cent
 * @version 1.0
 */
public enum ResultCode {
    SUCCESS(0, "请求成功"),
    UNKNOWN_ERROR(-1, "未知异常"),
    WARN(-2, "网络异常，请稍后再试"),
    WRONG_URL(-3, "访问地址无效"),
    NO_USER(1, "查询结果为空"),
    ADD_ERROR(2, "新增失败"),
    UPDATE_ERROR(3, "更新失败"),
    DELETE_ERROR(4, "删除失败");

    private int code;
    private String msg;

    /**
     * 构造结果状态码及描述
     * @param code 状态码
     * @param msg 结果描述
     */
    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
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
}

