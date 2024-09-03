package com.sist.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// 공통 모듈
@Aspect // 메모리 할당을 하지 않는 어노테이션이다 <aop:aspect>
@Component // 메모리 할당을 하는 어노테이션이다
public class BoardAOP {

	@Around("execution(* com.sist.web.*Controller.*(..))")
	public Object logtime(ProceedingJoinPoint jp)
	{
		Object obj=null;
		try
		{
			long start=System.currentTimeMillis();
			obj=jp.proceed();
			System.out.println("요청 메소드 : "+jp.getSignature().getName());
			
			long end=System.currentTimeMillis();
			System.out.println("요청 처리 소요 시간 : "+(end-start));
		}catch(Throwable ex) {} // jp.proceed() 때문에 Exception보다 큰 예외 처리가 필요 => Throwable 사용
		
		return obj;
	}
}
