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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
public class ScheduleRestController {

	@Autowired
	private ScheduleService sService;
	
/*	@RequestMapping(value="schedule/schedule_vue.do",produces="text/plain;charset=UTF-8")
	public String schedule_schedule(int page,int month,int day) throws Exception
	{
		int rowSize=10;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("month", month);
		map.put("day", day);
		
	     List<ScheduleVO> games=sService.scheduleListData(map);
	     int totalpage=sService.scheduleTotalPage(map);
	     
	     final int BLOCK=10;
	     int startPage=((page-1)/BLOCK*BLOCK)+1;
		 int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		 if(endPage>totalpage)
		 	 endPage=totalpage;
	        
	        map=new HashMap();
			map.put("games", games);
			map.put("curpage", page);
			map.put("totalpage", totalpage);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
			map.put("month", month);
			map.put("day", day);
			
			// 자바스크립트 연결 => Map을 JSON으로 => Kotlin, Flutter
			ObjectMapper mapper=new ObjectMapper();
			String json=mapper.writeValueAsString(map);
			
			return json;
	} */

	@RequestMapping(value="schedule/schedule_vue.do",produces="text/plain;charset=UTF-8")
	public String schedule_schedule(int page,int month,int day) throws Exception
	{
		Map map=new HashMap();
		map.put("month", month);
		map.put("day", day);
		
		int rowSize=sService.scheduleRowCount(map);
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		
	     List<ScheduleVO> games=sService.scheduleListData(map);
	     int count=sService.scheduleRowCount(map);
	     int totalpage=(int)Math.ceil((double)rowSize/10);
	     
	     final int BLOCK=10;
	     int startPage=((page-1)/BLOCK*BLOCK)+1;
		 int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		 if(endPage>totalpage)
		 	 endPage=totalpage;
	        
	        map=new HashMap();
			map.put("games", games);
			map.put("curpage", page);
			map.put("totalpage", totalpage);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
			map.put("month", month);
			map.put("day", day);
			
			// 자바스크립트 연결 => Map을 JSON으로 => Kotlin, Flutter
			ObjectMapper mapper=new ObjectMapper();
			String json=mapper.writeValueAsString(map);
			
			return json;
	}
}
