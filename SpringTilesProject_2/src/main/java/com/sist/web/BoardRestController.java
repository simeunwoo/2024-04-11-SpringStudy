package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

@RestController
public class BoardRestController {

	@Autowired
	private BoardDAO bDao;
	
	@GetMapping(value="board/list_vue.do",produces="text/plain;charset=UTF-8")
	public List<BoardVO> board_list(int page)
	{
		List<BoardVO> list=null;
		
		return list;
	}
	
}
