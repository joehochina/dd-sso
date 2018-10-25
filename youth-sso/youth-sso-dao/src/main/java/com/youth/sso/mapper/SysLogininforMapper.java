package com.youth.sso.mapper;

import com.youth.sso.entity.SysLogininfor;

import java.util.List;


/**
 *
 * 功能描述:
 *
 *  @Author xupeng
 *  @Description 系统访问日志情况信息 数据层
 *  @Date 17:23 2018/10/17
 *  @Param
 *  @return
 **/

public interface SysLogininforMapper
{
    /**
     * 新增系统登录日志
     * 
     * @param logininfor 访问日志对象
     */
    public void insertLogininfor(SysLogininfor logininfor);

    /**
     * 查询系统登录日志集合
     * 
     * @param logininfor 访问日志对象
     * @return 登录记录集合
     */
    public List<SysLogininfor> selectLogininforList(SysLogininfor logininfor);

    /**
     * 批量删除系统登录日志
     * 
     * @param ids 需要删除的数据
     * @return
     */
    public int deleteLogininforByIds(String[] ids);

    /**
     * 清空系统登录日志
     */
    public int cleanLogininfor();
}
