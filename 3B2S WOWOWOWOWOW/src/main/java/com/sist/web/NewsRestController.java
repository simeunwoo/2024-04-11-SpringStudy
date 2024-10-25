package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.util.Date;
import java.text.*;
import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;
import java.sql.*;


@RestController
public class NewsRestController {
	  @Autowired
      private NewsService nService;
    
	  @GetMapping(value="news/list_vue.do",produces = "text/plain;charset=UTF-8")
	  public String news_list(int page,String nd) throws Exception
	  { 
	   	 int rowSize=12;
	   	 int start=(rowSize*page)-(rowSize-1);
	   	 int end=rowSize*page;
	   	 Map map=new HashMap();
	   	 map.put("start",start);
	   	 map.put("end", end);
	     map.put("nd", nd);
	   	 
   	     List<NewsVO> list=nService.newsListData(map);
   	     //List<NewsVO> nlist=nService.newsHitTop8();
	   	 int totalpage=nService.newsTotalPage(map);
	   	  
	     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 for (NewsVO vo : list) {
			  vo.setFtime(sdf.format(vo.getTime())); 
	     }
	   	   
	   	 final int BLOCK=10;
	   	 int startPage=((page-1)/BLOCK*BLOCK)+1;
	   	 int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
	   	   
	   	 if(endPage>totalpage)
	   		 endPage=totalpage;
	   	   
	   	 map=new HashMap();
	   	 map.put("list", list);
	   	 //map.put("nlist", nlist);
	   	 map.put("curpage", page);
	   	 map.put("totalpage", totalpage);
	   	 map.put("startPage", startPage);
	   	 map.put("endPage", endPage);
	   	   
	   	 // JSON으로 변환후 전송 
	   	 ObjectMapper mapper=new ObjectMapper();
	   	 String json=mapper.writeValueAsString(map);
	   	 return json;
	 }
     @GetMapping(value = "news/detail_vue.do",produces = "text/plain;charset=UTF-8")
  	 public String news_detail(int nno) throws Exception
  	 {
  	 	NewsVO vo=nService.newsDetailData(nno);
  		
  		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  		vo.setFtime(sdf.format(vo.getTime()));
  		
  		ObjectMapper mapper=new ObjectMapper();
  		String json=mapper.writeValueAsString(vo);
  		return json;
  	 }
}
