package com.youth.sso.framework.web.exception.user;

/**
 *
 * 功能描述:
 *
 *  @Author xupeng
 *  @Description 用户密码不正确或不符合规范异常类
 *  @Date 18:06 2018/10/17
 *  @Param
 *  @return
 **/

public class UserPasswordNotMatchException extends UserException
{
    private static final long serialVersionUID = 1L;

    public UserPasswordNotMatchException()
    {
        super("user.password.not.match", null);
    }
}
