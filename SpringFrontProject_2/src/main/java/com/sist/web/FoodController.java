package com.sist.web;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 출력에 필요한 데이터 전송, 화면을 변경해주는 역할
public class FoodController {

	// 필요한 클래스 설정 => 스프링에서 주소값을 주입	
	@Autowired
	private FoodDAO dao;
	
	// 사용자 요청에 따라서 처리 => 구분 (URI 주소로 구분)
	// 1) 일반 JSP 활용
	@GetMapping("food/list.do")
	public String food_list(String page,Model model)
	{
		return "food/list";
	}
	
	// 2) VueJS 활용
	@GetMapping("food/list2.do")
	public String food_list2()
	{
		return "food/list2";
	}
}
