package com.fxr.certificate_collector.handler;

import com.fxr.certificate_collector.exception.DomainException;
import com.fxr.certificate_collector.utils.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/** 统一异常处理
 * @author fanXiaoRui
 * @date 2020/11/24 22:00
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = DomainException.class)
    public Result domainExceptionHandler(DomainException e) {
        e.printStackTrace();
        Result result = new Result(e.getErrCode(), e.getMessage(),new Date());
        return result;
    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    public Result EntityNotFoundExceptionHandler(EntityNotFoundException e) {
        Result result = new Result(250, "该模块不存在",new Date());
        return result;
    }

}
