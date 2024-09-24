package com.sist.web;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
import com.sist.vo.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Vue와 연결
@RestController
public class DataBoardRestController {

	@Autowired
	private DataBoardDAO dao;
	
	@GetMapping("databoard/list_vue.do")
	public String databoard_list(int page) throws Exception
	{
		int rowSize=10;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		
		List<DataBoardVO> list=dao.databoardListData(start, end);
		int count=dao.databoardCount();
		int totalpage=(int)(Math.ceil(count/10.0));
		count=count-((rowSize*page)-rowSize);
		
		// Vue로 데이터 전송
		Map map=new HashMap();
		map.put("list", list);
		map.put("count", count);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		
		// 자바스크립트 연결 => Map을 JSON으로 => Kotlin, Flutter
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
}
