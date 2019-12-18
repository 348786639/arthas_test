package com.ding.core;

import com.ding.entity.Result;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

@Component
@Aspect
public class AopValidatorAspect {
    private static final Logger log = Logger.getLogger(AopValidatorAspect.class);

    @Around("execution(public * com.ding.controller.*.*(..)) && args(..,bindingResult)")
    public Object doAround(ProceedingJoinPoint pjp, BindingResult bindingResult) throws Throwable  {

        if(bindingResult.hasErrors()){
            Result res = new Result();
            String errmsg = "";
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.error("参数校验：：：：："+error.getDefaultMessage());
                errmsg+=error.getDefaultMessage()+"</br>";
            }
            res.setMsg(errmsg);
            res.setSuccess(false);
            return res;
        }

        return pjp.proceed();
    }
}
