package com.fxr.certificate_collector.utils.result;

/** 设置消息码、消息文本、消息数据
 * @author fanXiaoRui
 * @date 2020/11/24 21:46
 */
public class Result<T> {

    private int code;
    private String message;
    private T data;

    public Result(){

    }

    public Result(int code, String message, T data) {
        this(code, message);
        this.data = data;
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
