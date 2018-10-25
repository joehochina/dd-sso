package com.youth.sso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 *
 * 功能描述:
 *
 *  @Author xupeng
 *  @Description 启动程序
 *  @Date 18:17 2018/10/17
 *  @Param
 *  @return
 **/

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@MapperScan("com.youth.sso.mapper")
public class YouthSsoApplication
{
    public static void main(String[] args)
    {
//        // System.setProperty("spring.devtools.restart.enabled", "false");
//        SpringApplication.run(YouthSsoApplication.class, args);
//        System.out.println("ლ(´ڡ`ლ)ﾞ  youth sso 启动成功   ლ(´ڡ`ლ)ﾞ  \n" );

        SpringApplication sa=new SpringApplication(YouthSsoApplication.class);
        // 禁用devTools热部署
        //System.setProperty("spring.devtools.restart.enabled", "false");
        // 禁用命令行更改application.properties属性
        sa.setAddCommandLineProperties(false);
        sa.run(args);
        System.out.println("ლ(´ڡ`ლ)ﾞ  youth sso 启动成功   ლ(´ڡ`ლ)ﾞ 阿弥陀佛 \n");

    }
}