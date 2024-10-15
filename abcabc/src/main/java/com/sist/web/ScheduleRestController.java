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
	public String schedule_schedule(int page,int month,int day) throws Exception
	{
		int rowSize=10;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		
	     List<ScheduleVO> games = sService.scheduleListData(month, day);
	     int totalpage=sService.scheduleTotalPage(month, day);
	     
	     final int BLOCK=10;
	     int startPage=((page-1)/BLOCK*BLOCK)+1;
		 int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		 if(endPage>totalpage)
		 	 endPage=totalpage;
	        
	        Map map=new HashMap();
			map.put("games", games);
			//map.put("month", month);
			//map.put("day", day);
			map.put("curpage", page);
			map.put("totalpage", totalpage);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
			
			// 자바스크립트 연결 => Map을 JSON으로 => Kotlin, Flutter
			ObjectMapper mapper=new ObjectMapper();
			String json=mapper.writeValueAsString(map);
			
			return json;
	}

}
