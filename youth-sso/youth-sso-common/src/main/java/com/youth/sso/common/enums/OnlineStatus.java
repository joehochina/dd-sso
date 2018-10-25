package com.youth.sso.common.enums;

/**
 *
 * 功能描述:
 *
 *  @Author xupeng
 *  @Description 用户会话
 *  @Date 16:53 2018/10/17
 *  @Param
 *  @return
 **/

public enum OnlineStatus
{
    /** 用户状态 */
    on_line("在线"), off_line("离线");

    private final String info;

    private OnlineStatus(String info)
    {
        this.info = info;
    }

    public String getInfo()
    {
        return info;
    }
}
