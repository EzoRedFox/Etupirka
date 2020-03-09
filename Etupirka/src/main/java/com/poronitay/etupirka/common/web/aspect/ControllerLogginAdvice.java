package com.poronitay.etupirka.common.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.poronitay.etupirka.common.util.TimeWatch;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class ControllerLogginAdvice {

    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object contollerLog(ProceedingJoinPoint  joinPoint) throws Throwable {

        Object returnValue;

        log.info(joinPoint.getSignature() + " : 開始");
        TimeWatch timeWatch = new TimeWatch();
        try {
            returnValue = joinPoint.proceed();

        } catch (Throwable ex) {
            log.error("エラーが発生しました。", ex);
            throw ex;
        }

        log.info(joinPoint.getSignature() + " : 終了 : " + timeWatch.getTimeString());

        return returnValue;

    }


}
