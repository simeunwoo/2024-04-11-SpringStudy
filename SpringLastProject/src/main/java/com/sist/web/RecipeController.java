package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // DispatcherServlet
public class RecipeController {

	@GetMapping("recipe/list.do")
	public String recipe_list()
	{
		return "recipe/list";
	}
	// return은 반드시 => 파일명, .do => Router
	
	@GetMapping("recipe/detail.do")
	public String recipe_detail(int no,Model model)
	{
		model.addAttribute("no", no);
		
		return "recipe/detail";
	}
}
