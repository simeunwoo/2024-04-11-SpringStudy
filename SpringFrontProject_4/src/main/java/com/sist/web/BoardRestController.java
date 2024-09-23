package com.sist.web;
import java.text.SimpleDateFormat;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
import com.sist.vo.*;
import com.sist.mapper.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // JSON, 일반 문자열, 숫자
// 화면 제어는 불가능 => 자바스크립트나 다른 언어로 데이터 전송 ex) Ajax, Vue, React, Next ...
// => 모바일 : Kotlin, Flutter, Dart ...
// => 서버를 나눠서 처리 => MSA (Spring Cloud)
public class BoardRestController {

	@Autowired
	private BoardDAO dao;
	
	@GetMapping(value="board/list_vue.do",produces="text/plain;charset=UTF-8")
	public String board_list(int page) throws Exception
	{
		int rowSize=10;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		
		List<BoardVO> list=dao.boardListData(start, end);
		int count=dao.boardTotalPage();
		int totalpage=(int)(Math.ceil(count/10.0));
		count=count-((rowSize*page)-rowSize);
		
		// 화면 출력 => 데이터 전송 (자바스크립트 => JSON)
		Map map=new HashMap();
		map.put("list", list);
		map.put("count", count);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("today", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
	
	@PostMapping(value="board/insert_vue.do",produces="text/plain;charset=UTF-8")
	public String board_insert(BoardVO vo) throws Exception
	{
		String result="yes";
		try
		{
			result="yes";
			dao.boardInsert(vo);
		}catch(Exception ex)
		{
			ex.printStackTrace();
			result="no";
		}
		
		return result;
	}
	
	@GetMapping(value="board/detail_vue.do",produces="text/plain;charset=UTF-8")
	public String board_detail(int no) throws Exception
	{
		BoardVO vo=dao.boardDetailData(no);
		
		// JSON
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(vo);
		
		return json;
	}
}
