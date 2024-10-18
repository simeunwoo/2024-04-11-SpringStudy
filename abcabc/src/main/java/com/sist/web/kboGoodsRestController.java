package com.sist.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;
import com.sist.vo.*;

import java.util.*;

@RestController
public class kboGoodsRestController {
	@Autowired
	private KboGoodsService kgService;
	
	@GetMapping(value="kboGoods/list_vue.do",produces = "text/plain;charset=UTF-8")
	public String kboGoods_list(int page) throws Exception{
	int rowSize=15;
	int start=(rowSize*page)-(rowSize-1);
	int end=rowSize*page;
	
	List<KboGoodsVO> list=kgService.kboGoodsListData(start, end);
	int totalpage=kgService.kboGoodsTotalPage();
	
	final int BLOCK=5;
	int startPage=((page-1)/BLOCK*BLOCK)+1;
	int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
	
	if(endPage>totalpage) {
		endPage=totalpage;
	}
		   
	Map map=new HashMap();
	map.put("list", list);
	map.put("curpage", page);
	map.put("totalpage", totalpage);
	map.put("startPage", startPage);
	map.put("endPage", endPage);
	
	// JSON으로 변환후 전송 
	ObjectMapper mapper=new ObjectMapper();
	String json=mapper.writeValueAsString(map);
	return json;
	}
	
	@GetMapping(value="kboGoods/find_vue.do",produces = "text/plain;charset=UTF-8")
	public String kboGoods_find(int page, String fd) throws Exception{
	int rowSize=15;
	int start=(rowSize*page)-(rowSize-1);
	int end=rowSize*page;
	Map map=new HashMap();
	map.put("start",start);
	map.put("end", end);	
	map.put("fd", fd);
	
	List<KboGoodsVO> list=kgService.kboGoodsFindListData(map);
	int totalpage=kgService.kboGoodsFindTotalPage(map);
	
	final int BLOCK=5;
	int startPage=((page-1)/BLOCK*BLOCK)+1;
	int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
	
	if(endPage>totalpage) {
		endPage=totalpage;
	}
		   
	map=new HashMap();
	map.put("list", list);
	map.put("curpage", page);
	map.put("totalpage", totalpage);
	map.put("startPage", startPage);
	map.put("endPage", endPage);
	
	// JSON으로 변환후 전송 
	ObjectMapper mapper=new ObjectMapper();
	String json=mapper.writeValueAsString(map);
	return json;
	}

	@GetMapping(value="kboGoods/detail_vue.do",produces = "text/plain;charset=UTF-8")
   public String kboGoods_detail(int gno) throws Exception
   {
		KboGoodsVO vo=kgService.kboGoodsDetailData(gno);
	   ObjectMapper mapper=new ObjectMapper();
	   String json=mapper.writeValueAsString(vo);
	   return json;
   }
	
}
