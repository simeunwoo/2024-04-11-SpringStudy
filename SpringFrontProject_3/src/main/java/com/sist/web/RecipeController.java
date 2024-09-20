package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.RecipeDAO;

@Controller
public class RecipeController {

	@Autowired
	private RecipeDAO dao;
	
	@GetMapping("recipe/list.do")
	public String recipe_list()
	{
		return "recipe/list";
	}
	
	@GetMapping("recipe/detail.do")
	public String recipe_detail(int no,Model model)
	{
		model.addAttribute("no", no);
		
		return "recipe/list";
	}
}
