package com.youth.sso.framework.web.exception.user;

import com.youth.sso.framework.web.exception.base.BaseException;

/**
 *
 * 功能描述:
 *
 *  @Author xupeng
 *  @Description 用户信息异常类
 *  @Date 18:05 2018/10/17
 *  @Param
 *  @return
 **/

public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
