package com.sist.web;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
// 화면 변경 => FreeBoardController
// 데이터 관리 (사용자 요청 / 서버 응답) => Front와 매칭 (FreeBoardRestController)
// FreeBoardRestController는 화면 변경이 불가능하다 : 데이터만 처리
import java.util.*;

import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;
import com.sist.vo.*;
@RestController
public class NoticeRestController {
   @Autowired
   private NoticeService nService;
   
   @GetMapping(value="notice/list_vue.do",produces = "text/plain;charset=UTF-8")
   // => text/plain(JSON) ,  text/html  , text/xml
   public String notice_list(int page) throws Exception
   {
	   int rowSize=15;
	   int start=(rowSize*page)-(rowSize-1);
	   int end=rowSize*page;
	   
	   List<NoticeVO> list=nService.noticeListData(start, end);
	   int count=nService.noticeRowCount();
	   int totalpage=(int)(Math.ceil(count/(double)rowSize));
	   count=count-((page*rowSize)-rowSize);
	   
	   String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	   
	   Map map=new HashedMap();
	   map.put("list", list);
	   map.put("count", count);
	   map.put("curpage", page);
	   map.put("totalpage", totalpage);
	   map.put("today", today);
	   
	   
	   ObjectMapper mapper=new ObjectMapper();
	   String json=mapper.writeValueAsString(map);
	   
	   return json;
   }
   /*
    *    ***NO                                        NOT NULL NUMBER
		 ID                                                 VARCHAR2(20)
		 NAME                                      NOT NULL VARCHAR2(50)
		 ***SUBJECT                                   NOT NULL VARCHAR2(2000)
		 ***CONTENT                                   NOT NULL CLOB
		 ***REGDATE                                            DATE
		 ***HIT                                                NUMBER
    */
   @PostMapping(value = "notice/insert_vue.do",produces = "text/plain;charset=UTF-8")
   // ResponseEntity<List> : router 
   public String notice_insert(NoticeVO vo,HttpSession session)
   {
	   String result="";
	   // id, name => HttpSession을 이용한다 
	   String id=(String)session.getAttribute("userId");
	   String name=(String)session.getAttribute("userName");
	   try
	   {
		   vo.setId(id);
		   vo.setName(name);
		   
		   nService.noticeInsert(vo);
		   
		   result="yes";
	   }catch(Exception ex)
	   {
		   result=ex.getMessage();
	   }
	   return result;
   }
   // 상세보기 
   @GetMapping(value="notice/detail_vue.do",produces = "text/plain;charset=UTF-8")
   public String notice_detail(int no) throws Exception
   {
	   // 조회수 증가 
	   // 데이터 전송 
	   NoticeVO vo=nService.noticeDetailData(no);
	   // JSON변경
	   ObjectMapper mapper=new ObjectMapper();
	   String json=mapper.writeValueAsString(vo);
	   // 전송 
	   return json;
   }
   
   @GetMapping(value="notice/delete_vue.do",produces = "text/plain;charset=UTF-8")
   public String notice_delete(int no) throws Exception
   {
	   String result="";
	   try
	   {
		   // DB연동
		   nService.noticeDelete(no);
		   result="yes";
	   }catch(Exception ex)
	   {
		   result=ex.getMessage();   
	   }
	   return result;
   }
   @GetMapping(value = "notice/update_vue.do",produces = "text/plain;charset=UTF-8")
   public String notice_update(int no) throws Exception
   {
	   NoticeVO vo=nService.noticeUpdateData(no);
	   ObjectMapper mapper=new ObjectMapper();
	   String json=mapper.writeValueAsString(vo);
	   return json;
   }
   @PostMapping(value="notice/update_ok_vue.do",produces = "text/plain;charset=UTF-8")
   public String notice_update_ok(NoticeVO vo)
   {
	   String result="";
	   try
	   {
		   
		   nService.noticeUpdate(vo);
		   result="yes";
	   }catch(Exception ex)
	   {
		   result=ex.getMessage();   
	   }
	   return result;
   }
}





