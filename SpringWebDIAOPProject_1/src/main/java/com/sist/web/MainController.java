package com.sist.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Spring MVC에서 필요
public class MainController {

	@RequestMapping("main/main.do")
	public String main_page(HttpServletRequest request,HttpServletResponse response)
	{
		request.setAttribute("msg", "Hello Spring MVC");
		return "main/main"; // .jsp를 붙이지 않는다
	}
}