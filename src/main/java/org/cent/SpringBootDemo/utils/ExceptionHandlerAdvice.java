package org.cent.SpringBootDemo.utils;

import org.cent.SpringBootDemo.enums.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常处理类
 * @author cent
 * @version 1.0
 */
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    private Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    /**
     * 捕获所有未知异常，记录日志信息，输出调用栈，最后返回结果
     * @param e 未知异常
     * @param request http请求信息（请求行，请求消息头，请求消息体）
     * @return 统一结果描述报文
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e, HttpServletRequest request) {
        logger.error("url={}", request.getRequestURL());
        e.printStackTrace();
        return new Result(ResultCode.UNKNOWN_ERROR);
    }
}
