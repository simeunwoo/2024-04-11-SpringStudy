package com.sist.web;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.vo.*;
import com.sist.service.*;

@Controller
public class ScheduleController {
	
	@GetMapping("schedule/schedule.do")
	public String schedule_schedule()
	{
		return "schedule/schedule";
	}
}
