package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.GnDService;
import com.sist.vo.GnDVO;
import com.sist.vo.HotelVO;

@RestController
public class GnDRestController {
   @Autowired
   private GnDService gService;
   
   @GetMapping(value="gnd/team_vue.do",produces="text/plain;charset=UTF-8")
   public String gnd_team_list(int page , String team) throws Exception{
	   int rowSize=6;
	   int start=(rowSize*page)-(rowSize-1);
	   int end=rowSize*page;
	   
	   Map map= new HashMap();
	   map.put("pTeam", team);
	   map.put("pStart", start);
	   map.put("pEnd", end);
	   
	   List<GnDVO> list=gService.gndTeamListData(map);
	   int totalpage=gService.gndTeamTotalPage(team);
	   
	   final int BLOCK=10;
	   int startPage=((page-1)/BLOCK*BLOCK)+1;
	   int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   
	   // 데이터를 모아서 => JSON으로 만들고 => VueJS로 전송 (React/React-Query/Redux/ThymeLeaf)
	   // JSON : Map 형식 => {키:값}
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

}
