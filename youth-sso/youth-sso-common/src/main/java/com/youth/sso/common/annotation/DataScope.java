package com.youth.sso.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * 功能描述:
 *
 *  @Author xupeng
 *  @Description 数据权限过滤注解
 *  @Date 16:31 2018/10/17
 *  @Param
 *  @return
 **/

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataScope
{
    /**
     * 表的别名
     */
    String tableAlias() default "";
}
