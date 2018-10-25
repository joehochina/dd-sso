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
 *  @Description swagger 接口
 *  @Date 18:15 2018/10/17
 *  @Param
 *  @return
 **/

@Controller
@RequestMapping("/tool/swagger")
public class SwaggerController extends BaseController
{
    @RequiresPermissions("tool:swagger:view")
    @GetMapping()
    public String index()
    {
        return redirect("/swagger-ui.html");
    }
}
