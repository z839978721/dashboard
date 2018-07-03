package com.cloud.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ResultHandle {

    private final static Logger logger = LoggerFactory.getLogger(ResultHandle.class);

    /**
     * 判断错误是否是已定义的已知错误，不是则由未知错误代替，同时记录在log中
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public static Result get(Exception e){
        if(e instanceof ResultException){
            ResultException resultException = (ResultException) e;
            return ResultUtil.error(resultException.getCode(),resultException.getMessage());
        }else {
            logger.error("系统异常={}",e);
            return ResultUtil.error(ResultEnum.UNKNOW_ERROR);
        }
    }

}
