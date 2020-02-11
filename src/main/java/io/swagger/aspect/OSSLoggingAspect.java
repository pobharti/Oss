package io.swagger.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OSSLoggingAspect {

	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//setup pointcut declaration
	@Pointcut("execution(* io.swagger.service.*.*(..))")
	private void forServicePackage(){}
	
	@Pointcut("execution(* io.swagger.controller.*.*(..))")
	private void forControllerPackage(){}
	
	@Pointcut("execution(* io.swagger.dao.*.*(..))")
	private void forDaoPackage(){}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow(){}
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		//display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("===> in @Before calling method: " +theMethod);
		
		
		// display the arguments to the method
		
		
		//get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		//loop and display args
		for(Object tempArg: args) {
			myLogger.info("====> argument: "+tempArg);
		}
		
		
	}
	
	
	// add @After returning advice
	@AfterReturning(
				pointcut = "forAppFlow()",
				returning = "theResult"
			)
	public void afteReturning(JoinPoint theJoinPoint, Object theResult) {
		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("===> in @AfterReturning from method: " +theMethod);
		
		
		//display the data
		myLogger.info("===> result: "+theResult);
		
	
}
}