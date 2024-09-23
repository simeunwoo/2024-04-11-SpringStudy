package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.BoardDAO;

@Controller
// 화면 제어 => 화면만 변경
public class BoardController {

	@Autowired
	private BoardDAO dao;
	
	@GetMapping("board/list.do")
	public String board_list()
	{
		return "board/list";
	}
	
	@GetMapping("board/insert.do")
	public String board_insert()
	{
		return "board/insert";
	}
	
	@GetMapping("board/detail.do")
	public String board_detail(int no,Model model)
	{
		model.addAttribute("no", no); // Vue에서 받는 방법
		
		return "board/detail";
	}
}
