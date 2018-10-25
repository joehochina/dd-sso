package com.youth.common.tools;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultInfo<T>  implements Serializable {

    private static final long serialVersionUID = 8404218499656932187L;

    public static final int SUCCESS = 200;
    public static final int DATA_NOT_FOUND = 204;
    public static final int FAILURE = 300;
    public static final int ERROR = 500;
    public static final int INVALID_PARAM = 400;
    public static final int UNAUTHORIZED = 401;
    public static final int INVALID_TOKEN = 402;
    public static final int FORBIDOM = 402;
    public static final int NOT_FOUND = 404;
    public static final String MSG_SUCCESS = "执行成功";
    public static final String MSG_FAILURE = "执行失败";
    public static final String MSG_DATA_NOT_FOUND = "查询结果为空";
    public static final String MSG_NOT_FOUND = "找不到请求的资源";
    public static final String MSG_INVALID_PARAM = "请求参数错误";
    public static final String MSG_ERROR = "系统发生异常";
    public static final String MSG_UNAUTHORIZED = "未授权的访问";
    public static final String MSG_INVALID_TOKEN = "无效的Token";
    public static final String MSG_FORBIDOM = "禁止访问";
    private Integer code;
    private String message;
    private Long timestamp;
    private T data;

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResultInfo() {
    }

    public ResultInfo(Integer code, String message) {
        this.code = code;
        this.timestamp = System.currentTimeMillis();
        this.message = message;
    }

    public ResultInfo(Integer code, String message, T data) {
        this.code = code;
        this.timestamp = System.currentTimeMillis();
        this.message = message;
        this.data = data;
    }
}
