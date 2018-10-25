package com.youth.sso.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.youth.sso.common.enums.DataSourceType;

/**
 *
 * 功能描述:
 *
 *  @Author xupeng
 *  @Description 自定义多数据源切换注解
 *  @Date 16:46 2018/10/17
 *  @Param
 *  @return
 **/

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource
{
    /**
     * 切换数据源名称
     */
    public DataSourceType value() default DataSourceType.MASTER;
}
