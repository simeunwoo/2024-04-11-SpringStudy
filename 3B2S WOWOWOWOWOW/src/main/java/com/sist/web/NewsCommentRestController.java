package com.sist.web;
import org.apache.commons.collections.map.HashedMap;
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
public class NewsCommentRestController {
   @Autowired
   private NewsCommentService nService;
   
   public String newsCommonsListData(int page,int nno,int type) throws Exception
   {
	   Map map=new HashMap();
	   int rowSize=10;
	   int start=(rowSize*page)-(rowSize-1);
	   int end=rowSize*page;
	   
	   map.put("start", start);
	   map.put("end", end);
	   map.put("nno", nno);
	   map.put("type", type);
	   
	   List<NewsCommentVO> list=nService.newsCommentListData(map);
	   int totalpage=nService.newsCommentTotalPage(map);
	   
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
   
   @GetMapping(value = "comment/list_vue.do",produces = "text/plain;charset=UTF-8")
   public String newsComment_list(int page, int nno, int type) throws Exception
   {
	   return newsCommonsListData(page, nno, type);
   }
   
   @PostMapping(value="comment/insert_vue.do",produces = "text/plain;charset=UTF-8")
   public String newsComment_insert(NewsCommentVO vo,HttpSession session) throws Exception
   {
	  String id=(String)session.getAttribute("userId");
	  String name=(String)session.getAttribute("userName");
	  String sex=(String)session.getAttribute("sex");
	  vo.setId(id);
	  vo.setName(name);
	  vo.setSex(sex);
	  nService.newsCommentInsert(vo);

	  return newsCommonsListData(1, vo.getNno(), vo.getType());
   }
   @PostMapping(value="comment/reply_insert_vue.do",produces = "text/plain;charset=UTF-8")
   public String newsComment_reply_insert(int cno,NewsCommentVO vo,HttpSession session)
   throws Exception
   {
	   String id=(String)session.getAttribute("userId");
	   String name=(String)session.getAttribute("userName");
	   String sex=(String)session.getAttribute("sex");
	   vo.setId(id);
	   vo.setName(name);
	   vo.setSex(sex);
	   nService.newsCommentReplyReplyInsert(cno, vo);
	   return newsCommonsListData(1, vo.getNno(), vo.getType());
   }
   @GetMapping(value="comment/delete_vue.do",produces = "text/plain;charset=UTF-8")
   public String newsComment_delete(int cno,int nno,int type)
   throws Exception
   {
	   NewsCommentVO vo=nService.newsCommentDeleteInfoData(cno);
	   Map map=new HashedMap();
	   map.put("cno", cno);
	   map.put("group_id", vo.getGroup_id());
	   map.put("group_step", vo.getGroup_step());
	   nService.newsCommentDelete(map);
	   nService.newsReplyDecrement(nno);
	   return newsCommonsListData(1, nno, type);
   }
   
   @PostMapping(value="comment/update_vue.do",produces = "text/plain;charset=UTF-8")
   public String newsComment_update(NewsCommentVO vo) throws Exception
   {
	   nService.newsCommentUpdate(vo);
	   return newsCommonsListData(1, vo.getNno(), vo.getType());
   }
}
