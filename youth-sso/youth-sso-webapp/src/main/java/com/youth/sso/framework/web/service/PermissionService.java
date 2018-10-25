package com.youth.sso.framework.web.service;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

/**
 *
 * 功能描述:
 *
 *  @Author xupeng
 *  @Description js调用 thymeleaf 实现按钮权限可见性
 *  @Date 18:09 2018/10/17
 *  @Param
 *  @return
 **/

@Service("permission")
public class PermissionService
{
    public String hasPermi(String permission)
    {
        return isPermittedOperator(permission) ? "" : "hidden";
    }

    private boolean isPermittedOperator(String permission)
    {
        return SecurityUtils.getSubject().isPermitted(permission);
    }
}
