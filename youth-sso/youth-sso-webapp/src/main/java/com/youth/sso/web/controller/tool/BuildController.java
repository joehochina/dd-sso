package com.youth.sso.web.controller.tool;

import com.youth.sso.web.core.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * 功能描述:
 *
 *  @Author xupeng
 *  @Description build 表单构建
 *  @Date 18:14 2018/10/17
 *  @Param
 *  @return
 **/

@Controller
@RequestMapping("/tool/build")
public class BuildController extends BaseController
{
    private String prefix = "tool/build";

    @RequiresPermissions("tool:build:view")
    @GetMapping()
    public String build()
    {
        return prefix + "/build";
    }
}
