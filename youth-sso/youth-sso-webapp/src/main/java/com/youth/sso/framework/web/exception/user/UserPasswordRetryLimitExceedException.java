package com.youth.sso.framework.web.exception.user;

/**
 *
 * 功能描述:
 *
 *  @Author xupeng
 *  @Description 用户错误最大次数异常类
 *  @Date 18:06 2018/10/17
 *  @Param
 *  @return
 **/

public class UserPasswordRetryLimitExceedException extends UserException
{
    private static final long serialVersionUID = 1L;

    public UserPasswordRetryLimitExceedException(int retryLimitCount)
    {
        super("user.password.retry.limit.exceed", new Object[] { retryLimitCount });
    }
}
