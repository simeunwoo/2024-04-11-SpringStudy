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
public class CommentRestController {
   @Autowired
   private CommentService cService;
   
   public String commonsListData(int page,int no,int type) throws Exception
   {
	   Map map=new HashMap();
	   int rowSize=10;
	   int start=(rowSize*page)-(rowSize-1);
	   int end=rowSize*page;
	   
	   map.put("start", start);
	   map.put("end", end);
	   map.put("no", no);
	   map.put("type", type);
	   
	   List<CommentVO> list=cService.commentListData(map);
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
   
   @GetMapping(value = "comment/board_list_vue.do",produces = "text/plain;charset=UTF-8")
   public String comment_list(int page, int no, int type) throws Exception
   {
	   return commonsListData(page, no, type);
   }
   
   @PostMapping(value="comment/board_insert_vue.do",produces = "text/plain;charset=UTF-8")
   public String comment_insert(CommentVO vo,HttpSession session) throws Exception
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
	  return commonsListData(1, vo.getNo(), vo.getType());
   }
   @PostMapping(value="comment/board_reply_insert_vue.do",produces = "text/plain;charset=UTF-8")
   public String comment_reply_insert(int cno,CommentVO vo,HttpSession session)
   throws Exception
   {
	   String id=(String)session.getAttribute("userId");
	   String name=(String)session.getAttribute("userName");
	   String sex=(String)session.getAttribute("sex");
	   vo.setId(id);
	   vo.setName(name);
	   vo.setSex(sex);
	   cService.commentReplyReplyInsert(cno, vo);
	   return commonsListData(1, vo.getNo(), vo.getType());
   }
   @GetMapping(value="comment/board_delete_vue.do",produces = "text/plain;charset=UTF-8")
   public String comment_delete(int cno,int no,int type)
   throws Exception
   {
	   
	   // 데이터베이스 연동 
	   CommentVO vo=cService.commentDeleteInfoData(cno);
	   Map map=new HashedMap();
	   map.put("cno", cno);
	   map.put("group_id", vo.getGroup_id());
	   map.put("group_step", vo.getGroup_step());
	   cService.commentDelete(map);
	   cService.boardReplyDecrement(no);
	   return commonsListData(1, no, type);
   }
   
   @PostMapping(value="comment/board_update_vue.do",produces = "text/plain;charset=UTF-8")
   public String comment_update(CommentVO vo) throws Exception
   {
	   cService.commentUpdate(vo);
	   return commonsListData(1, vo.getNo(), vo.getType());
   }
}