package com.cloud.aspect.result;

public class ResultUtil {

    /**
     * 返回成功，传入返回体具体出參
     * @param object
     * @return
     */
    public static Result success(Object object){
        Result result = new Result();
        result.setStatus(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMessage());
        result.setData(object);

        return result;
    }

    /**
     * 提供给部分不需要出參的接口
     * @return
     */
    public static Result success(){
        return success(null);
    }

    /**
     * 返回异常信息，在已知的范围内
     * @param resultEnum
     * @return
     */
    public static Result error(ResultEnum resultEnum){
        Result result = new Result();
        result.setStatus(resultEnum.getCode());
        result.setMessage(resultEnum.getMessage());
        result.setData(null);
        return result;
    }

    /**
     * 自定义错误信息
     * @param code
     * @param message
     * @return
     */
    public static Result error(Integer code,String message){
        Result result = new Result();
        result.setStatus(code);
        result.setMessage(message);
        result.setData(null);
        return result;
    }
}
