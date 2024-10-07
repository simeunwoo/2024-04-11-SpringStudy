package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;

@RestController
public class PlayerRestController {

	@Autowired
	private PlayerService pService;
	
	@GetMapping(value="player/batter_list_vue.do",produces="text/plain;charset=UTF-8")
	public String batter_list(int page) throws Exception
	{
		int rowSize=20;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		
		List<BatterVO> list=pService.batterListData(start, end);
		int totalpage=pService.batterTotalPage();
		
		final int BLOCK=5;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		// Vue로 데이터 전송
		Map map=new HashMap();
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		// 자바스크립트 연결 => Map을 JSON으로 => Kotlin, Flutter
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
	
	@GetMapping(value="player/pitcher_list_vue.do",produces="text/plain;charset=UTF-8")
	public String pitcher_list(int page) throws Exception
	{
		int rowSize=20;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		
		List<PitcherVO> list=pService.pitcherListData(start, end);
		int totalpage=pService.pitcherTotalPage();
		
		// Vue로 데이터 전송
		Map map=new HashMap();
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		
		// 자바스크립트 연결 => Map을 JSON으로 => Kotlin, Flutter
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
}
