package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPageController {

	@GetMapping("adminpage/adminpage_main.do")
	public String adminpage_main()
	{
		return "adminpage";
	}
	
	@GetMapping("adminpage/adminpage_joinupdate.do")
	public String adminpage_joinupdate()
	{
		return "adminpage/adminpage_joinupdate";
	}
	
	@GetMapping("adminpage/adminpage_jjim.do")
	public String adminpage_jjim()
	{
		return "adminpage/adminpage_jjim";
	}	
}
