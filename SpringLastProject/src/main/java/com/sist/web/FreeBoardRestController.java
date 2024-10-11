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
	
	@PostMapping(value="freeboard/insert_vue.do", produces="text/plain;charset=UTF-8")
	public String freeboard_insert(FreeBoardVO vo, HttpSession session) {
	    String result = "";

	    // id, name => HttpSession을 이용하여 가져옴
	    Object userIdObj = session.getAttribute("userId");
	    Object userNameObj = session.getAttribute("userName");

	    try {
	        // userId가 Boolean일 경우 String으로 변환하여 저장
	        if (userIdObj instanceof Boolean) {
	            session.setAttribute("userId", String.valueOf(userIdObj));
	            userIdObj = session.getAttribute("userId");  // 업데이트된 값 다시 가져오기
	        }

	        // userName이 Boolean일 경우 String으로 변환하여 저장
	        if (userNameObj instanceof Boolean) {
	            session.setAttribute("userName", String.valueOf(userNameObj));
	            userNameObj = session.getAttribute("userName");  // 업데이트된 값 다시 가져오기
	        }

	        // userId와 userName이 String 타입인지 확인 후 처리
	        if (userIdObj instanceof String && userNameObj instanceof String) {
	            String id = (String) userIdObj;
	            String name = (String) userNameObj;

	            vo.setId(id);
	            vo.setName(name);

	            fbService.freeboardInsert(vo);
	            result = "yes";
	        } else {
	            // 타입이 맞지 않을 경우 오류 처리
	            result = "세션에 저장된 userId 또는 userName이 잘못된 타입입니다.";
	        }
	    } catch (Exception ex) {
	        result = ex.getMessage();
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
		
		return result;
	}
	
	@GetMapping(value="freeboard/update_vue.do",produces="text/plain;charset=UTF-8")
	public String freeboard_update(int no) throws Exception
	{
		FreeBoardVO vo=fbService.freeboardUpdateData(no);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(vo);
		
		return json;
	}
	
	@PostMapping(value="freeboard/update_ok_vue.do",produces="text/plain;charset=UTF-8")
	public String freeboard_update_ok(FreeBoardVO vo/*int no,String subject,String content*/)
	{
		String result="";
		
		try
		{
			/*
			(int no,String subject,String content로 설정한 경우 필요한 코딩)
			FreeBoardVO vo=new FreeBoardVO();
			vo.setNo(no);
			vo.setSubject(subject);
			vo.setContent(content);
			*/
			fbService.freeboardUpdate(vo);
			
			result="yes";
		}catch(Exception ex)
		{
			result=ex.getMessage();
		}
		
		return result;
	}
	
}
