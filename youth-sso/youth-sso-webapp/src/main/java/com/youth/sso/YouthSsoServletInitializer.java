package com.youth.sso;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
 *
 * 功能描述:
 *
 *  @Author xupeng
 *  @Description web容器中进行部署
 *  @Date 18:17 2018/10/17
 *  @Param
 *  @return
 **/

public class YouthSsoServletInitializer extends SpringBootServletInitializer
{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(YouthSsoApplication.class);
    }
}
