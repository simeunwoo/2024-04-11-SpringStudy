package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SeoulController {

	@GetMapping("seoul/seoul_location.do")
	public String seoul_location()
	{
		return "seoul/seoul_location";
	}
}
