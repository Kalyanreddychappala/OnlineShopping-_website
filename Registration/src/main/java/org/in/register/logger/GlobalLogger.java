package org.in.register.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GlobalLogger {
	
	
	private static final Logger LOGGER=LoggerFactory.getLogger(GlobalLogger.class);
	@Pointcut("execution(* org.in.register.controller..*(..))")
	public void pointcut() {
		
	}
	
	@Around("pointcut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		LOGGER.info("start->>"+joinPoint.getSignature());
		Object obj=joinPoint.proceed();
		LOGGER.info("end->>"+joinPoint.getSignature());
		return obj;
	}
}
