package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminpageController {

	   @GetMapping("adminpage/adminpage_main.do")
	   public String adminpage_main()
	   {
		   return "adminpage";
	   }
	   @GetMapping("adminpage/adminpage_reserve.do")
	   public String adminpage_reserve()
	   {
		   return "adminpage/adminpage_reserve";
	   }
}

