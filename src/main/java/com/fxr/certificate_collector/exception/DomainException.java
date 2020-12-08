package com.fxr.certificate_collector.exception;

import com.fxr.certificate_collector.utils.result.ResultCode;

/**
 * @author fanXiaoRui
 * @date 2020/11/24 21:56
 */

public class DomainException extends RuntimeException {

    private int errCode = ResultCode.Unknown_Exception.getCode();

    public DomainException() {
        super(ResultCode.Unknown_Exception.getMessage());
    }

    public DomainException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.errCode = resultCode.getCode();
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }
}
