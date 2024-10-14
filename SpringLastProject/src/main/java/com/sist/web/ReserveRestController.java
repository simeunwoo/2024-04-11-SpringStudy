package com.sist.web;
import java.util.*;
import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReserveRestController {

	@Autowired
	private ReserveService rService;
	
	@GetMapping(value="reserve/reserve_main_vue.do",produces="text/plain;charset=UTF-8")
	public String reserve_food_info(String type,int page) throws Exception
	{
		int rowSize=30;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		
		Map map=new HashMap();
		map.put("type", type);
		map.put("start", start);
		map.put("end", end);
		
		List<FoodVO> list=rService.reserveFoodInfoData(map);
		int totalpage=rService.reserveFoodTotalPage(type);
		
		map=new HashMap();
		map.put("list", list);
		map.put("type", type);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		// response.data={}
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json; // 자바스크립트(jQuery, Vue.js, AJAX)와 연동
	}
}
