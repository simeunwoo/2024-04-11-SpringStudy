package com.sist.web;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;
/*
 * 	화면 변경 => FreeBoardController
 * 	데이터 관리 (사용자 요청 / 서버 응답) => FreeBoardRestController (Front와 매칭)
 * 
 * 	FreeBoardRestController => 화면 변경이 불가능 => 데이터만 처리
 */
@RestController
public class FreeBoardRestController {

	@Autowired
	private FreeBoardService fbService;
	
	@GetMapping(value="freeboard/list_vue.do",produces="text/plain;charset=UTF-8")
	// text/plain (JSON), text/html, text/xml
	public String freeboard_list(int page) throws Exception
	{
		int rowSize=15;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		
		List<FreeBoardVO> list=fbService.freeboardListData(start, end);
		int count=fbService.freeboardRowCount();
		int totalpage=(int)(Math.ceil(count/(double)rowSize));
		
		count=count-((page*rowSize)-rowSize);
		
		String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		Map map=new HashMap();
		map.put("list", list);
		map.put("count", count);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("today", today);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
	
	@PostMapping(value="freeboard/insert_vue.do",produces="text/plain;charset=UTF-8")
	// ResponseEntity<List> : router
	public String freeboard_insert(FreeBoardVO vo,HttpSession session)
	{
		String result="";
		
		// id, name => HttpSession을 이용한다
		String id=(String)session.getAttribute("userId");
		String name=(String)session.getAttribute("userName");
		System.out.println("Retrieved userId: " + id); // 로그 추가
		System.out.println("Retrieved userName: " + name); // 로그 추가
		
		try
		{
			vo.setId(id);
			vo.setName(name);
			
			fbService.freeboardInsert(vo);
			
			result="yes";
		}catch(Exception ex)
		{
			result=ex.getMessage();
		}
		
		return result;
	}
	
	// 상세 보기
	@GetMapping(value="freeboard/detail_vue.do",produces="text/plain;charset=UTF-8")
	public String freeboard_detail(int no) throws Exception
	{
		// 조회수 증가
		
		// 데이터 전송
		FreeBoardVO vo=fbService.freeboardDetailData(no);
		
		// JSON 변경
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(vo);
		
		// 전송
		return json;
	}
	
	@GetMapping(value="freeboard/delete_vue.do",produces="text/plain;charset=UTF-8")
	public String freeboard_delete(int no) throws Exception
	{
		String result="";
		try
		{
			// DB 연동
			fbService.freeboardDelete(no);
			result="yes";
		}catch(Exception ex)
		{
			result=ex.getMessage();
		}
		
		return "";
	}
}
