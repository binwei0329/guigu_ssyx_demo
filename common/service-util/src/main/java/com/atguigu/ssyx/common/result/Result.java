package com.atguigu.ssyx.common.result;

import lombok.Data;

@Data
public class Result<T> {
    //状态码
    private Integer code;
    //信息
    private String message;
    //数据
    private T data;

    //构造私有化
    private Result(){}

    public static<T> Result<T> build(T data, ResultCodeEnum resultCodeEnum){
        Result<T> result = new Result<>();
        //创建Resullt对象，设置值，返回对象
        if(data != null){
            result.setData(data);
        }

        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }

    //成功的方法
    public static<T> Result<T> ok(T data){
        return build(data, ResultCodeEnum.SUCCESS);
    }

    //失败的方法
    public static<T> Result<T> fail(T data) {
        return build(data,ResultCodeEnum.FAIL);
    }
}
