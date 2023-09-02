package com.demo;

import com.demo.exception.MyException;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogAspect {

    @Pointcut("bean(*Controller)")
    private void commonPointCut() {
    }

    @Around("commonPointCut()")
    public ResponseEntity<Object> commonApiLog(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();
        Object result;
        long duration;
        try {
            result = joinPoint.proceed();
            duration = System.currentTimeMillis() - startTime;
            MDC.put("duration", duration / 1000 + "." + duration % 1000 + "s");
            log.info("test");
        } catch (MyException e) {
            log.error(e.getMessage(), e);
            MDC.clear();
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            MDC.clear();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
        MDC.clear();
        return ResponseEntity.ok(result);
    }


    private StringBuilder buildParametersAsMsg(Object[] args) {
        StringBuilder logMessage = new StringBuilder();
        logMessage.append("Args: [");

        for (int i = 0; i < args.length; i++) {
            Object arg = args[i];
            logMessage.append(argToString(arg));

            if (i < args.length - 1) {
                logMessage.append(", ");
            }
        }

        return logMessage.append("]");
    }

    private String argToString(Object arg) {
        if (arg == null) {
            return "null";
        }
//        if (arg instanceof String) {
//            return "\"" + arg + "\"";
//        }
        return arg.toString();
    }

}
