package com.sist.aop;
import java.util.*;
import com.sist.service.*;
import com.sist.vo.*;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect // 공통 모듈
@Component // 메모리 할당
public class CommonsAspect {

	@Autowired
	private FoodService fService;
	
	// @After : finally => 무조건 실행
	@After("execution(* com.sist.web.*Controller.*(..))")
	public void footerCookieSend()
	{
		// request를 가지고 온다
	}
}
