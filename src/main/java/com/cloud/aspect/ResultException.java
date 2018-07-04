package com.cloud.aspect;

public class ResultException extends RuntimeException {

    /**
     * 返回结果异常处理
     */
    private static final long serialVersionUID = 1L;
    private Integer code;

    /**
     * 加入错误状态值
     * @param resultEnum
     */
    public ResultException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    /**
     * 自定义错误信息
     * @param message
     * @param code
     */
    public ResultException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
