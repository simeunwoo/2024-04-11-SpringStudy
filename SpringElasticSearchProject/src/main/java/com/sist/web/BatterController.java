package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BatterController {

	@GetMapping("batter/find.do")
	public String batter_find()
	{
		return "batter/find";
	}
}
