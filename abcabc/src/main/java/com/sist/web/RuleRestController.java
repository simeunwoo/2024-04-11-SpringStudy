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
public class RuleRestController {
  @Autowired
  private RuleService rService;
  @GetMapping(value = "guide/rule_search.do", produces = "text/plain;charset=UTF-8")
  public String guide_rule_search(int page, String rs) throws Exception {
	  Map map = new HashMap();

	   List<RuleVO> ruleList=rService.ruleFind(map);
	   
	   map=new HashMap();
	   map.put("list", ruleList);
	   
	   // JSON으로 변환후 전송 
	   ObjectMapper mapper=new ObjectMapper();
	   String json=mapper.writeValueAsString(map);
	   return json;
  }
  @GetMapping(value = "guide/rule_vue.do", produces = "text/plain;charset=UTF-8")
  public String guide_rule(int page) throws Exception	{
	  int rowSize = 9;
	  int start=(rowSize*page)-(rowSize-1);
	  int end=rowSize*page;
	  
	  List<RuleVO> ruleList = rService.ruleListData(start, end);
	  int count = rService.ruleCount();
	  int totalpage=(int)(Math.ceil(count/(double)rowSize));
	  count=count-((page*rowSize)-rowSize);
	  
	  String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	  
	  Map map = new HashMap();
	  map.put("ruleList", ruleList);
	  map.put("count", count);
	  map.put("curpage", page);
	  map.put("totalpage", totalpage);
	  map.put("today", today);
	   
	  ObjectMapper mapper = new ObjectMapper();
	  String json=mapper.writeValueAsString(map);
	  
	  return json;
  }
  
  /*
  @PostMapping(value = "guide/rule_insert_vue.do", produces = "text/plain;charset=UTF-8")
  public String rule_insert(BoardVO vo, HttpSession session) {
	  String result="";
	  String id=(String)session.getAttribute("userId");
	  String name=(String)session.getAttribute("userName");
	  try {
		  vo.setId(id);
		  vo.setName(name);
		  
		  rService.ruleInsert(vo);
		  
		  result="yes";
	  }catch(Exception ex) {
		  result = ex.getMessage();
	  }
	  return result;
  }
  */
  
  @GetMapping(value = "guide/rule_detail_vue.do", produces = "text/plain;charset=UTF-8")
  public String guide_rule_detail(int no) throws Exception {
	  RuleVO vo = rService.ruleDetailData(no);
	  
	  // JSON 변경
	  ObjectMapper mapper = new ObjectMapper();
	  String json = mapper.writeValueAsString(vo);
	  
	  // 전송
	  return json;
  }
  
  /*
  @GetMapping(value = "guide/rule_delete_vue.do", produces = "text/plain;charset=UTF-8")
  public String rule_delete(int no) throws Exception {
	  String result="";
	  try {
		  rService.ruleDelete(no);
		  result="yes";
	  }catch(Exception ex) {
		  result=ex.getMessage();
	  }
	  return result;
  }
  
  @GetMapping(value = "guide/rule_update_vue.do", produces = "text/plain;charset=UTF-8")
  public String rule_update(int no) throws Exception {
	  RuleVO vo = rService.ruleUpdateData(no);
	  ObjectMapper mapper = new ObjectMapper();
	  String json = mapper.writeValueAsString(vo);
	  return json;
  }
  
  
  @PostMapping(value = "guide/rule_update_ok_vue.do", produces = "text/plain;charset=UTF-8")
  public String rule_update_ok(BoardVO vo) {
	  String result="";
	  try {
		  rService.ruleUpdate(vo);
		  result="yes";
	  }catch(Exception ex) {
		  result = ex.getMessage();
	  }
	  
	  return result;
  }
   */
}































