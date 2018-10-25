package com.youth.sso.common.enums;

/**
 *
 * 功能描述:
 *
 *  @Author xupeng
 *  @Description 业务操作类型
 *  @Date 16:52 2018/10/17
 *  @Param
 *  @return
 **/

public enum BusinessType
{
    /**
     * 其它
     */
    OTHER,

    /**
     * 新增
     */
    INSERT,

    /**
     * 修改
     */
    UPDATE,

    /**
     * 删除
     */
    DELETE,

    /**
     * 授权
     */
    GRANT,

    /**
     * 导出
     */
    EXPORT,

    /**
     * 导入
     */
    IMPORT,

    /**
     * 强退
     */
    FORCE,

    /**
     * 生成代码
     */
    GENCODE,
    
    /**
     * 清空
     */
    CLEAN,
}
