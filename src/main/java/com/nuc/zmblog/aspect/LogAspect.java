package com.nuc.zmblog.aspect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

// 实例化 到 spring 容器中
@Component
@Aspect
public class LogAspect {

    @Data
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    private static class RequestLog {
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;
    }
//    日志记录器
    private final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut(value = "execution(* com.nuc.zmblog.controller.*.*(..))")
    public void log() {

    }

    @Before("log()")
    public void beforeMethod(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes != null ? requestAttributes.getRequest() : null;
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(url,ip,classMethod,args);
        logger.info("---------before---------");
        logger.info("\n"  + "请求信息 :" + "\n "
                        + "\t url :" + requestLog.getUrl() + "\n" +
                        "\t ip :" + requestLog.getIp() + "\n"+
                        "\t requestMethod : " + requestLog.getClassMethod() +"\n" +
                        "\t args :" + Arrays.toString(args)
        );
    }

    @AfterReturning(returning = "result" , pointcut = "log()")
    public void afterReturnMethod(Object result) {
        logger.info("result(返回通知)" + result);
    }

    @After("log()")
    public void afterMethod() {
//        logger.info("----------after----------");
    }

}
