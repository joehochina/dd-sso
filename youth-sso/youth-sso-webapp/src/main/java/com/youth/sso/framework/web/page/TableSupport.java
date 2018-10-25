package com.youth.sso.framework.web.page;

import com.youth.sso.common.constant.Constants;
import com.youth.sso.framework.util.ServletUtils;

/**
 *
 * 功能描述:
 *
 *  @Author xupeng
 *  @Description 表格数据处理
 *  @Date 18:07 2018/10/17
 *  @Param
 *  @return
 **/

public class TableSupport
{
    /**
     * 封装分页对象
     */
    public static PageDomain getPageDomain()
    {
        PageDomain pageDomain = new PageDomain();
        pageDomain.setPageNum(ServletUtils.getParameterToInt(Constants.PAGE_NUM));
        pageDomain.setPageSize(ServletUtils.getParameterToInt(Constants.PAGE_SIZE));
        pageDomain.setOrderByColumn(ServletUtils.getParameter(Constants.ORDER_BY_COLUMN));
        pageDomain.setIsAsc(ServletUtils.getParameter(Constants.IS_ASC));
        return pageDomain;
    }

    public static PageDomain buildPageRequest()
    {
        return getPageDomain();
    }
}
