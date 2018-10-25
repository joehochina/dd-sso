package com.youth.sso.framework.web.service;

import com.youth.sso.facade.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * 功能描述:
 *
 *  @Author xupeng
 *  @Description html调用 thymeleaf 实现参数管理
 *  @Date 18:08 2018/10/17
 *  @Param
 *  @return
 **/

@Service("config")
public class ConfigService
{
    @Autowired
    private ISysConfigService configService;

    /**
     * 根据键名查询参数配置信息
     * 
     * @param configName 参数名称
     * @return 参数键值
     */
    public String getKey(String configKey)
    {
        return configService.selectConfigByKey(configKey);
    }
}
