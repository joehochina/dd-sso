package com.youth.sso.framework.web.exception.user;

/**
 *
 * 功能描述:
 *
 *  @Author xupeng
 *  @Description 用户锁定异常类
 *  @Date 18:04 2018/10/17
 *  @Param
 *  @return
 **/

public class UserBlockedException extends UserException
{
    private static final long serialVersionUID = 1L;

    public UserBlockedException(String reason)
    {
        super("user.blocked", new Object[] { reason });
    }
}
