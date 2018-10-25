package com.youth.sso.web.controller.system;

import java.util.List;

import com.youth.sso.common.config.Global;
import com.youth.sso.entity.SysMenu;
import com.youth.sso.entity.SysUser;
import com.youth.sso.facade.ISysMenuService;
import com.youth.sso.web.core.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


/**
 *
 * 功能描述:
 *
 *  @Author xupeng
 *  @Description 首页 业务处理
 *  @Date 18:12 2018/10/17
 *  @Param
 *  @return
 **/

@Controller
public class SysIndexController extends BaseController
{
    @Autowired
    private ISysMenuService menuService;

    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap)
    {
        // 取身份信息
        SysUser user = getUser();
        // 根据用户id取出菜单
        List<SysMenu> menus = menuService.selectMenusByUser(user);
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("copyrightYear", Global.getCopyrightYear());
        return "index";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap)
    {
        mmap.put("version", Global.getVersion());
        return "main";
    }
}
