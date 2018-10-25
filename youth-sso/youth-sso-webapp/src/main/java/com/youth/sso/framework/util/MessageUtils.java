package com.youth.sso.framework.util;

import org.springframework.context.MessageSource;

/**
 *
 * 功能描述:
 *
 *  @Author xupeng
 *  @Description 获取消息
 *  @Date 18:01 2018/10/17
 *  @Param
 *  @return
 **/

public class MessageUtils
{
    /**
     * 根据消息键和参数 获取消息 委托给spring messageSource
     *
     * @param code 消息键
     * @param args 参数
     * @return
     */
    public static String message(String code, Object... args)
    {
        MessageSource messageSource = SpringUtils.getBean(MessageSource.class);
        return messageSource.getMessage(code, args, null);
    }
}
