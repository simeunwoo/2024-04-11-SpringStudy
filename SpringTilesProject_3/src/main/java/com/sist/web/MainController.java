package com.sist.web;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("main/main.do")
	public String main_main()
	{
		return "main";
	}
}
