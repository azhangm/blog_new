package com.nuc.zmblog.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 控制器异常处理程序
 *
 * @author 74282
 * @date 2022/09/27
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 异常处理程序
     *
     * @param request 请求
     * @param e       异常
     * @return {@link ModelAndView}
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request,Exception e) {
        logger.error("requestUrl{},Exception : {}" , request.getRequestURL() , e);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("url",request.getRequestURL());
        modelAndView.addObject("error",e);
        modelAndView.setViewName("error/error");
        return modelAndView;
    }
}
