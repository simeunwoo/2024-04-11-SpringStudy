package com.sist.web;
import java.util.*;
import com.sist.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 화면만 변경
@Controller
public class DataBoardController {

//	@Autowired
//	private DataBoardDAO dao;
	
	@GetMapping("databoard/list.do")
	public String databoard_list()
	{
		return "databoard/list";
	}
}
