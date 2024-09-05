package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.service.*;
import com.sist.vo.*;

@Controller
public class RecipeController {

/*	@Autowired // 생성자 활용 / 이런 경우 객체 생성 가능성 있음
	public RecipeController(RecipeService rService)
	{
		this.rService=rService;
	} */
	
	@Autowired
	private RecipeService rService;
	
	@GetMapping("recipe/detail.do")
	public String recipe_detail(int no,Model model) // Model(결과값)은 JSP로 전송 시에 사용 : forward
	{
		// 데이터베이스 연결 => 데이터를 읽기
		/*
		private int no;
		private String poster,title,chef,chef_poster,chef_profile,
			info1,info2,info3,content,foodmake,data;
		 */
		
		// detail.jsp로 출력할 데이터 보내주기
		
		model.addAttribute("main_jsp", "../recipe/detail.jsp");
		return "main/main"; 
	}
}
