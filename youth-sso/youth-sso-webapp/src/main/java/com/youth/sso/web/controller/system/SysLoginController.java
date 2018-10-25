package com.youth.sso.web.controller.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.youth.sso.common.base.AjaxResult;
import com.youth.sso.common.utils.StringUtils;
import com.youth.sso.entity.SysUser;
import com.youth.sso.framework.util.ServletUtils;
import com.youth.sso.web.core.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;

import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 *
 * 功能描述:
 *
 *  @Author xupeng
 *  @Description 登录验证
 *  @Date 18:12 2018/10/17
 *  @Param
 *  @return
 **/
@Api(value ="SysLoginController" ,description = "登录验证模块")
@Controller
public class SysLoginController extends BaseController
{
    @ApiOperation(value = "用户登录 login",notes = "get请求，参数 request 和 response， 错误代码 code:1 msg:未登录或登录超时。请重新登录")
    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response)
    {
        // 如果是Ajax请求，返回Json字符串。
        if (ServletUtils.isAjaxRequest(request))
        {
            return ServletUtils.renderString(response, "{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }

        return "login";
    }


    @ApiOperation(value = "用户登录ajaxLogin",notes="    " +
            "            data: {\n" +
            "            \"username\": username,\n" +
            "            \"password\": password,\n" +
            "            \"validateCode\" : validateCode,\n" +
            "            \"rememberMe\": rememberMe\n" +
            "        },登录成功返回userId")
    @PostMapping("/login")
   // @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult ajaxLogin(String username, String password, Boolean rememberMe)
    {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        Subject subject = SecurityUtils.getSubject();
        try
        {
            subject.login(token);
            SysUser user = (SysUser) subject.getPrincipal();
           // return AjaxResult.success();
            return AjaxResult.loginSuccess(0,user.getUserId()+"");

        }
        catch (AuthenticationException e)
        {
            String msg = "用户或密码错误";
            if (StringUtils.isNotEmpty(e.getMessage()))
            {
                msg = e.getMessage();
            }
            return error(msg);
        }
    }

    @GetMapping("/unauth")
    public String unauth()
    {
        return "/error/unauth";
    }
}
