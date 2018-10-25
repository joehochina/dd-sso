package com.youth.sso.common.enums;

/**
 *
 * 功能描述:
 *
 *  @Author xupeng
 *  @Description 用户状态
 *  @Date 16:56 2018/10/17
 *  @Param
 *  @return
 **/

public enum UserStatus
{
    OK("0", "正常"), DISABLE("1", "停用"), DELETED("2", "删除");

    private final String code;
    private final String info;

    UserStatus(String code, String info)
    {
        this.code = code;
        this.info = info;
    }

    public String getCode()
    {
        return code;
    }

    public String getInfo()
    {
        return info;
    }
}
