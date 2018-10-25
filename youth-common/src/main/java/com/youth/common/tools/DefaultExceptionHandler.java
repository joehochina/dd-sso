package com.youth.common.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 监听全部异常
 */
@ControllerAdvice
public class DefaultExceptionHandler {


    public static final String NETWORK_BAD = "网络请求失败";

    public static final String NETWORK_DELAYED = "网络延时，请稍后再试";


    public static final String TIME_OUT = "连接超时！";

    private static Logger LOG = LoggerFactory.getLogger(DefaultExceptionHandler.class);



    /**
     *
     * 功能描述: 捕获未知异常
     *
     *  @Author limaoda
     *  @Description //TODO
     *  @Date 21:05 2018/10/8
     *  @param
     *  @return
     **/
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private ResultInfo<Object> defaultExceptionHandler(Exception e) {
        LOG.error("》》》 defaultExceptionHandler ");
        e.printStackTrace();
        LOG.error(e.getMessage());
        ResultInfo<Object> resultInfo = new ResultInfo<Object>(ResultInfo.ERROR, "服务器繁忙....");
        return resultInfo;
    }


    /**
     *
     * 功能描述: 捕获参数异常
     *
     *  @Author limaoda
     *  @Description //TODO
     *  @Date 21:05 2018/10/8
     *  @param
     *  @return
     **/
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultInfo<Object> handleValidException(MethodArgumentNotValidException e) {
        LOG.error("》》》 handleValidException");
        return new ResultInfo(ResultInfo.ERROR, e.getBindingResult().getFieldError().getDefaultMessage());

    }

    
    /**
     *
     * 功能描述: 捕获重复插入异常
     *
     *  @Author limaoda
     *  @Description //TODO
     *  @Date 15:31 2018/10/9
     *  @param 
     *  @return 
     **/
    @ResponseBody
    @ExceptionHandler(DuplicateKeyException.class)
    public ResultInfo<Object> DuplicateKeyException(DuplicateKeyException e) {
        LOG.error("》》》 DuplicateKeyException");
        return new ResultInfo(ResultInfo.ERROR, "不要重复添加");

    }



}
