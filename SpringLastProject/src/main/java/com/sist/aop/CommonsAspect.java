package com.sist.aop;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.sist.service.*;
import com.sist.vo.*;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect // 공통 모듈
@Component // 메모리 할당
public class CommonsAspect {

	@Autowired
	private FoodService fService;
	/*
	 * 	DispatcherServlet
	 * 	=> 연결 클래스
	 * 		@Controller / @RestController
	 */
	// @After : finally => 무조건 실행
	@After("execution(* com.sist.web.*Controller.*(..))")
	public void footerCookieSend()
	{
		// request를 가지고 온다
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		Cookie[] cookies=request.getCookies();
		List<FoodVO> list=new ArrayList<FoodVO>();
		
		if(cookies!=null)
		{
			for(int i=cookies.length-1;i>=0;i--)
			{
				// Cookie(key, value) => Cookie("food_1","1")
				if(cookies[i].getName().startsWith("food_"))
				{
					String fno=cookies[i].getValue();
					FoodVO vo=fService.foodInfoData(Integer.parseInt(fno));
					list.add(vo);
				}
			}
		}
		
		request.setAttribute("cList", list);
	}
}
