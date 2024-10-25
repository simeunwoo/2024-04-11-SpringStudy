package com.sist.web;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;
@RestController
public class HotelCommentRestController {
   @Autowired
   private HotelCommentService cService;
   
   public String commonsListData(int page,int rno,int type) throws Exception
   {
	   Map map=new HashMap();
	   int rowSize=10;
	   int start=(rowSize*page)-(rowSize-1);
	   int end=rowSize*page;
	   
	   map.put("start", start);
	   map.put("end", end);
	   map.put("rno", rno);
	   map.put("type", type);
	   
	   List<HotelCommentVO> list=cService.commentListData(map);
	   int totalpage=cService.commentTotalPage(map);
	   
	   final int BLOCK=5;
	   int startPage=((page-1)/BLOCK*BLOCK)+1;
	   int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
	   
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   map=new HashedMap();
	   map.put("list", list);
	   map.put("curpage", page);
	   map.put("totalpage", totalpage);
	   map.put("startPage", startPage);
	   map.put("endPage", endPage);
	   
	   ObjectMapper mapper=new ObjectMapper();
	   String json=mapper.writeValueAsString(map);
	   
	   return json;
   }
   
   @GetMapping(value = "comment/h_list_vue.do",produces = "text/plain;charset=UTF-8")
   public String comment_list(int page, int rno, int type) throws Exception
   {
	   return commonsListData(page, rno, type);
   }
   
   @PostMapping(value="comment/h_insert_vue.do",produces = "text/plain;charset=UTF-8")
   public String comment_insert(HotelCommentVO vo,HttpSession session) throws Exception
   {
	  String id=(String)session.getAttribute("userId");
	  String name=(String)session.getAttribute("userName");
	  String sex=(String)session.getAttribute("sex");
	  vo.setId(id);
	  vo.setName(name);
	  vo.setSex(sex);
	  cService.commentInsert(vo);
	  // INSERT INTO spring_comment(cno,rno,id,name,sex,msg,group_id,type)
	  //id,name => 저장 
	  return commonsListData(1, vo.getRno(), vo.getType());
   }
   @PostMapping(value="comment/h_reply_insert_vue.do",produces = "text/plain;charset=UTF-8")
   public String comment_reply_insert(int cno,HotelCommentVO vo,HttpSession session)
   throws Exception
   {
	   String id=(String)session.getAttribute("userId");
	   String name=(String)session.getAttribute("userName");
	   String sex=(String)session.getAttribute("sex");
	   vo.setId(id);
	   vo.setName(name);
	   vo.setSex(sex);
	   cService.commentReplyReplyInsert(cno, vo);
	   return commonsListData(1, vo.getRno(), vo.getType());
   }
   @GetMapping(value="comment/h_delete_vue.do",produces = "text/plain;charset=UTF-8")
   public String comment_delete(int cno,int rno,int type)
   throws Exception
   {
	   
	   // 데이터베이스 연동 
	   HotelCommentVO vo=cService.commentDeleteInfoData(cno);
	   Map map=new HashedMap();
	   map.put("cno", cno);
	   map.put("group_id", vo.getGroup_id());
	   map.put("group_step", vo.getGroup_step());
	   cService.commentDelete(map);
	   cService.hotelReplyDecrement(rno);
	   return commonsListData(1, rno, type);
   }
   
   @PostMapping(value="comment/h_update_vue.do",produces = "text/plain;charset=UTF-8")
   public String comment_update(HotelCommentVO vo) throws Exception
   {
	   cService.commentUpdate(vo);
	   return commonsListData(1, vo.getRno(), vo.getType());
   }
}
