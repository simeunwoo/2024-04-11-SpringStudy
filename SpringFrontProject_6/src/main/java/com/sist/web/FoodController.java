package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 화면만 변경
public class FoodController {

	@GetMapping("food/list.do")
	public String food_list()
	{
		return "food/list";
	}
}
