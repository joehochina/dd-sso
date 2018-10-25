package com.youth.sso.framework.web.exception.user;

/**
 *
 * 功能描述:
 *
 *  @Author xupeng
 *  @Description 用户不存在异常类
 *  @Date 18:05 2018/10/17
 *  @Param
 *  @return
 **/

public class UserNotExistsException extends UserException
{
    private static final long serialVersionUID = 1L;

    public UserNotExistsException()
    {
        super("user.not.exists", null);
    }
}
