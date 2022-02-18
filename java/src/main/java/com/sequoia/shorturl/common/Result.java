package com.sequoia.shorturl.common;

import com.sequoia.shorturl.enums.ErrorEnum;
import com.sequoia.shorturl.exception.DefinitionException;
import lombok.Data;

/**
 * @Description:
 * @Author: usr1999
 * @Create: 2021/9/20
 */
@Data
public class Result<T> {

    private Boolean success;
    private String code;
    private String msg;

    // 数据
    private T data;
    public Result() {}

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Result fail(String msg){
        return new Result("0", msg);
    }

    //自定义返回结果的构造方法
    public Result(Boolean success, String code, String msg,T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    //自定义异常返回的结果
    public static Result defineError(DefinitionException de){
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(de.getErrorCode());
        result.setMsg(de.getErrorMsg());
        result.setData(null);
        return result;
    }

    //其他异常处理方法返回的结果
    public static Result otherError(ErrorEnum errorEnum){
        Result result = new Result();
        result.setMsg(errorEnum.getErrorMsg());
        result.setCode(errorEnum.getErrorCode());
        result.setSuccess(false);
        result.setData(null);
        return result;
    }

}
