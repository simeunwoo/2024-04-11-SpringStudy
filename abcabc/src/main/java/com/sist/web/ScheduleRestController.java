package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;
import com.sist.vo.*;
import java.util.*;

@RestController
public class ScheduleRestController {

	@Autowired
	private ScheduleService sService;
	
	@RequestMapping(value="schedule/schedule_vue.do",produces="text/plain;charset=UTF-8")
	public String schedule(int month,int day,Model model) throws Exception
	{
	     List<ScheduleVO> games = sService.scheduleListData(month, day);  
	        
	        Map map=new HashMap();
			map.put("games", games);
			map.put("month", month);
			map.put("day", day);
			
			// 자바스크립트 연결 => Map을 JSON으로 => Kotlin, Flutter
			ObjectMapper mapper=new ObjectMapper();
			String json=mapper.writeValueAsString(map);
			
			return json;
	}

}
