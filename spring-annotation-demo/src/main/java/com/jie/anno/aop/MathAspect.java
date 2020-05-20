package com.jie.anno.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MathAspect {

	@Pointcut("execution(public int com.jie.anno.service.MathCalculator.div(..))")
	public void pointCut() {

	}

	@Before("pointCut()")
	public void logStart(JoinPoint joinPoint) {
		System.out.println(String.format("前置操作  @Before %s", joinPoint.getSignature().getName()));
	}

	@After("pointCut()")
	public void logEnd(JoinPoint joinPoint) {
		System.out.println(String.format("后置操作  @After %s", joinPoint.getSignature().getName()));
	}

	@AfterReturning(value="pointCut()", returning = "res")
	public void logReturning(Integer res) {
		System.out.println(String.format("后置操作  @AfterReturning %s", res));
	}

	@AfterThrowing(value="pointCut()", throwing = "exception")
	public void logThrowing(Exception exception) {
		System.out.println(String.format("异常操作  @AfterReturning %s", exception));
	}
}
