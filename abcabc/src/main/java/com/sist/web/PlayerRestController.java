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
	
	@GetMapping(value="player/list_vue.do",produces="text/plain;charset=UTF-8")
	public String player_list(int bPage,int pPage) throws Exception
	{
		int rowSize=20;
		int bStart=(rowSize*bPage)-(rowSize-1);
		int bEnd=rowSize*bPage;
		int pStart=(rowSize*pPage)-(rowSize-1);
		int pEnd=rowSize*pPage;
		
		List<BatterVO> bList=pService.batterListData(bStart, bEnd);
		List<PitcherVO> pList=pService.pitcherListData(pStart, pEnd);
		int bTotalpage=pService.batterTotalPage();
		int pTotalpage=pService.pitcherTotalPage();
		
		// Vue로 데이터 전송
		Map map=new HashMap();
		map.put("bList", bList);
		map.put("pList", pList);
		map.put("bCurpage", bPage);
		map.put("pCurpage", pPage);
		map.put("bTotalpage", bTotalpage);
		map.put("pTotalpage", pTotalpage);
		
		// 자바스크립트 연결 => Map을 JSON으로 => Kotlin, Flutter
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
}
