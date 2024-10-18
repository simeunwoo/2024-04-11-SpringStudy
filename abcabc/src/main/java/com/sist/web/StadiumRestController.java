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
public class StadiumRestController {
	@Autowired
    private StadiumService sService;
	
	@GetMapping(value = "stadium/list_vue.do", produces = "text/plain;charset=UTF-8")
    public String stadium_list(int page) throws Exception {
		  int rowSize=9;
		  int start=(rowSize*page)-(rowSize-1);
		  int end=rowSize*page;
		  Map map = new HashMap();
		  map.put("start", start);
		  map.put("end", end);
		 
		  
		  List<StadiumVO> list=sService.stadiumListData(start, end);
		  int totalpage=sService.stadiumTotalPage();
		  
		  
		  final int BLOCK=10;
		  int startPage=((page-1)/BLOCK*BLOCK)+1;
		  int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		   
		  if(endPage>totalpage)
		     endPage=totalpage;
		  
		  map=new HashMap();
		  map.put("list", list);
		  map.put("curpage", page);
		  map.put("totalpage", totalpage);
		  map.put("startPage", startPage);
		  map.put("endPage", endPage);
		  
		  ObjectMapper mapper=new ObjectMapper();
		  String json=mapper.writeValueAsString(map);
		  
		  return json;
    }
	@GetMapping(value="stadium/detail_vue.do",produces = "text/plain;charset=UTF-8")
	public String stadium_detail(int no) throws Exception
	   {
		   StadiumVO vo=sService.stadiumDetailData(no);
		   ObjectMapper mapper=new ObjectMapper();
		   String json=mapper.writeValueAsString(vo);
		   return json;
	   }
}
