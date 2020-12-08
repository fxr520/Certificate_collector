package com.fxr.certificate_collector.utils.result;

/**
 * @author fanXiaoRui
 * @date 2020/11/24 21:58
 */
public class SuccessResult<T> extends Result<T> {

    public SuccessResult(){

    }

    public SuccessResult(T data) {
        super(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

}
