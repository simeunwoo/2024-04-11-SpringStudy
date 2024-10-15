package com.sist.web;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyPageController {

	@GetMapping("mypage/mypage_main.do")
	public String mypage_main()
	{
		return "mypage";
	}
	
	@GetMapping("mypage/mypage_reserve.do")
	public String mypage_reserve()
	{
		return "mypage/mypage_reserve";
	}
	
	@GetMapping("mypage/mypage_cart.do")
	public String mypage_cart()
	{
		return "mypage/mypage_cart";
	}
}
