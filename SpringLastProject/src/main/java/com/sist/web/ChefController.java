package com.sist.web;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.vo.*;

@Controller // 화면 변경
public class ChefController {

	@GetMapping("chef/list.do")
	public String chef_list()
	{
		return "chef/make";
	}
	
}
