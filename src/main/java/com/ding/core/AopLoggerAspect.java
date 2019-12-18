package com.ding.core;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Enumeration;

@Component
@Aspect
public class AopLoggerAspect {
	private static final Logger log = Logger.getLogger(AopLoggerAspect.class);

	@Pointcut("execution(public * com.ding.controller.*.*(..)) ")
	public void pointCut() { }

	@Around(value="@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public Object writeLog(ProceedingJoinPoint joinPoint) throws Throwable {
		MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		Object[] args = joinPoint.getArgs();
		Parameter[] parameters = method.getParameters();
		String[] parameterNames = methodSignature.getParameterNames();
		StringBuilder sb = new StringBuilder();
		sb.append("--controller: "+method.getDeclaringClass().getName());
		sb.append("--handlerMethod: "+method.getName());
		sb.append("--requestParam: { ");
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = ((ServletRequestAttributes) ra).getRequest();
		Enumeration parameter = request.getParameterNames();
		while(parameter.hasMoreElements()) {
			String paraName=(String) parameter.nextElement();
			String paraVal = request.getParameter(paraName);
			sb.append(paraName).append(":").append(paraVal).append(",");
		}
		sb.append("}");
		log.info(sb.toString());
		return joinPoint.proceed();
	}

	@AfterThrowing(pointcut = "pointCut()", throwing = "throwable")
	public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
		log.error(throwable.getMessage(), throwable);
	}
}
