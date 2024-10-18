package com.sist.web;


import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpSession;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.vo.*;
import com.sist.service.*;


@RestController
public class BoardRestController {
  @Autowired
  private BoardService bService;
  
  @GetMapping(value = "board/list_vue.do", produces = "text/plain;charset=UTF-8")
  public String board_list(int page) throws Exception	{
	  int rowSize = 20;
	  int start=(rowSize*page)-(rowSize-1);
	  int end=rowSize*page;
	  
	  List<BoardVO> list = bService.boardListData(start, end);
	  int count = bService.boardCount();
	  int totalpage=(int)(Math.ceil(count/(double)rowSize));
	  count=count-((page*rowSize)-rowSize);
	  
	  String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	  
	  Map map = new HashMap();
	  map.put("list", list);
	  map.put("count", count);
	  map.put("curpage", page);
	  map.put("totalpage", totalpage);
	  map.put("today", today);
	   
	  ObjectMapper mapper = new ObjectMapper();
	  String json=mapper.writeValueAsString(map);
	  
	  return json;
  }
  
  
  @PostMapping(value = "board/insert_vue.do", produces = "text/plain;charset=UTF-8")
  public String board_insert(BoardVO vo, HttpSession session) {
	  String result="";
	  String id=(String)session.getAttribute("userId");
	  String name=(String)session.getAttribute("userName");
	  try {
		  vo.setId(id);
		  vo.setName(name);
		  
		  bService.boardInsert(vo);
		  
		  result="yes";
	  }catch(Exception ex) {
		  result = ex.getMessage();
	  }
	  return result;
  }
  
  
  @GetMapping(value = "board/detail_vue.do", produces = "text/plain;charset=UTF-8")
  public String board_detail(int no) throws Exception {
	  BoardVO vo = bService.boardDetailData(no);
	  
	  // JSON 변경
	  ObjectMapper mapper = new ObjectMapper();
	  String json = mapper.writeValueAsString(vo);
	  
	  // 전송
	  return json;
  }
  
  @GetMapping(value = "board/delete_vue.do", produces = "text/plain;charset=UTF-8")
  public String board_delete(int no) throws Exception {
	  String result="";
	  try {
		  bService.boardDelete(no);
		  result="yes";
	  }catch(Exception ex) {
		  result=ex.getMessage();
	  }
	  return result;
  }
  
  @GetMapping(value = "board/update_vue.do", produces = "text/plain;charset=UTF-8")
  public String board_update(int no) throws Exception {
	  BoardVO vo = bService.boardUpdateData(no);
	  ObjectMapper mapper = new ObjectMapper();
	  String json = mapper.writeValueAsString(vo);
	  return json;
  }
  
  
  @PostMapping(value = "board/update_ok_vue.do", produces = "text/plain;charset=UTF-8")
  public String board_update_ok(BoardVO vo) {
	  String result="";
	  try {
		  bService.boardUpdate(vo);
		  result="yes";
	  }catch(Exception ex) {
		  result = ex.getMessage();
	  }
	  
	  return result;
  }
}































