package com.youth.common.tools;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassNamw SysLog
 * @Description TODO
 * @Author limaoda
 * @Date 2018/10/916:56
 * @Version 1.0
 **/
public class SysLog implements Serializable {


    private static final long serialVersionUID = -2641530220836492374L;

    private Long id;

    /**
     用户名
     **/
    private String username;

    /**
     操作
     **/
    private String operation;

    /**
     方法名
     **/
    private String method;

    /**
     参数
     **/
    private String params;

    /**
     ip地址
     **/
    private String ip;

    /**
     操作时间
     **/
    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
