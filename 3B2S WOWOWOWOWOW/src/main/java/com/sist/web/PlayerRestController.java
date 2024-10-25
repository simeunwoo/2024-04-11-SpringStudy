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
	public String batter_list(int page,String fd) throws Exception
	{
		int rowSize=20;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		
		Map map=new HashMap();
		map.put("pStart", start);
		map.put("pEnd", end);
		map.put("pFd", fd);
		
		List<BatterVO> list=pService.batterListData(map);
		int totalpage=pService.batterTotalPage(fd);
		
		final int BLOCK=5;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		// Vue로 데이터 전송
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
	public String pitcher_list(int page,String fd) throws Exception
	{
		int rowSize=20;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("fd", fd);
		
		List<PitcherVO> list=pService.pitcherListData(map);
		int totalpage=pService.pitcherTotalPage(fd);
		
		final int BLOCK=5;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		// Vue로 데이터 전송
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
	
	@GetMapping(value="player/batter_detail_vue.do",produces="text/plain;charset=UTF-8")
	public String batter_detail(int bno) throws Exception
	{
		BatterVO bvo=pService.batterDetailData(bno);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(bvo);
		
		return json;
	}
	
	@GetMapping(value="player/pitcher_detail_vue.do",produces="text/plain;charset=UTF-8")
	public String pitcher_detail(int pno) throws Exception
	{
		PitcherVO pvo=pService.pitcherDetailData(pno);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(pvo);
		
		return json;
	}
	
	@GetMapping(value="player/vs_vue.do",produces="text/plain;charset=UTF-8")
	public String player_vs() throws Exception
	{
		List<BatterVO> bList=pService.batterChartData();
		List<PitcherVO> pList=pService.pitcherChartData();
		
		Map map=new HashMap();
		map.put("bList", bList);
		map.put("pList", pList);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
}
