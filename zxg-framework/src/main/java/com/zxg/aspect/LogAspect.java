package com.zxg.aspect;

import com.alibaba.fastjson.JSON;
import com.zxg.annotation.SystemLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
@Slf4j
public class LogAspect {
    
    
    
    @Pointcut("@annotation(com.zxg.annotation.SystemLog)")
    public void gt(){}
    
    
    @Around("gt()")
    public Object printLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{


        Object res;
        try {
            handleBefore(proceedingJoinPoint);
            res = proceedingJoinPoint.proceed();
            handleAfter(res);
        } finally {
            log.info("=============end=============="+System.lineSeparator());
        }

        return res;
    }

    private void handleAfter(Object res) {

        // 打印出参
        log.info("Response       : {}", JSON.toJSONString(res));

    }

    private void handleBefore(ProceedingJoinPoint proceedingJoinPoint) {

        ServletRequestAttributes requestAttribute= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = requestAttribute.getRequest();

        SystemLog systemLog=getSystemLog(proceedingJoinPoint);

        log.info("=======Start=======");
        // 打印请求 URL
        log.info("URL            : {}",httpServletRequest.getRequestURL());
        // 打印描述信息
        log.info("BusinessName   : {}",systemLog.businessName());
        // 打印 Http method
        log.info("HTTP Method    : {}",httpServletRequest.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        log.info("Class Method   : {}.{}", proceedingJoinPoint.getSignature().getDeclaringTypeName(),((MethodSignature) proceedingJoinPoint.getSignature()).getName());
        // 打印请求的 IP
        log.info("IP             : {}",httpServletRequest.getRemoteHost());
        // 打印请求入参
        log.info("Request Args   : {}", JSON.toJSONString(proceedingJoinPoint.getArgs()));

    }

    private SystemLog getSystemLog(ProceedingJoinPoint proceedingJoinPoint) {
       MethodSignature method= (MethodSignature) proceedingJoinPoint.getSignature();
       return method.getMethod().getAnnotation(SystemLog.class);
    }
}
