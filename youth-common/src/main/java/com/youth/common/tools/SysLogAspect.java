package com.youth.common.tools;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import java.lang.reflect.Method;
import java.util.Date;

/**
 * @ClassNamw SysLogAspect
 * @Description TODO
 * @Author limaoda
 * @Date 2018/10/916:59
 * @Version 1.0
 **/
@Aspect
@Component
public class SysLogAspect {

    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation( com.youth.common.tools.MyLog)")
    public void logPoinCut() {
    }

    //切面 配置通知
    @AfterReturning(value = "logPoinCut()",returning="rvt")
    public void saveSysLog(JoinPoint joinPoint,Object rvt ) {
        System.out.println("切面。。。。。"+rvt);
        //保存日志
        SysLog sysLog = new SysLog();

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();

        //获取操作
        MyLog myLog = method.getAnnotation(MyLog.class);
        if (myLog != null) {
            String value = myLog.value();
            sysLog.setOperation(value);//保存获取的操作
        }

        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = method.getName();
        sysLog.setMethod(className + "." + methodName);

        //请求的参数
        Object[] args = joinPoint.getArgs();
        //将参数所在的数组转换成json
        String params = JSON.toJSONString(args);
        sysLog.setParams(params);

        sysLog.setCreateDate(new Date());
        //获取用户名
        sysLog.setUsername("XXXXX");

        //获取用户ip地址
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        sysLog.setIp(request.getRemoteAddr());



        System.out.println(sysLog.toString());
        //调用service保存SysLog实体类到数据库
       // sysLogService.save(sysLog);
    }

}
