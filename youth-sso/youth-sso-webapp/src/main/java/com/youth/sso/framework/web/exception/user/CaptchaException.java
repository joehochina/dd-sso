package com.youth.sso.framework.web.exception.user;

/**
 *
 * 功能描述:
 *
 *  @Author xupeng
 *  @Description 验证码错误异常类
 *  @Date 18:03 2018/10/17
 *  @Param
 *  @return
 **/

public class CaptchaException extends UserException
{
    private static final long serialVersionUID = 1L;

    public CaptchaException()
    {
        super("user.jcaptcha.error", null);
    }
}
