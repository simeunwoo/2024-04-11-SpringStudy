package com.sist.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.HotelService;
import com.sist.service.ReserveService;
import com.sist.vo.*;

@RestController
public class HotelRestController {
	@Autowired
	private HotelService hService;
	@Autowired
	private ReserveService rService;
	
	@GetMapping(value="hotel/list_vue.do",produces="text/plain;charset=UTF-8")
	public String hotel_list(int page) throws Exception {
		int rowSize=6;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		
		List<HotelVO> list=hService.hotelListData(start, end);
		int totalpage=hService.hotelTotalPage();
		
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		
		// 데이터를 모아서 => JSON으로 만들고 => VueJS로 전송 (React/React-Query/Redux/ThymeLeaf)
		// JSON : Map 형식 => {키:값}
		Map map=new HashMap();
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
	@GetMapping(value="hotel/detail_vue.do",produces="text/plain;charset=UTF-8")
	public String hotel_detail(int hno) throws Exception {
		HotelVO vo = hService.hotelDetailData(hno);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(vo);
		
		return json;
	}
	@GetMapping(value="hotel/reserve_vue.do",produces="text/plain;charset=UTF-8")
	public String hotel_reserve(int hno) throws Exception{
		HotelVO vo = hService.hotelReserveData(hno);
		Map map = new HashMap();
		map.put("hotel_vo", vo);
		List<String> rList = new ArrayList<String>();
		rList.add("D");
		rList.add("C");
		rList.add("B");
		rList.add("A");
		rList.add("S");
		
		map.put("rList", rList);
		
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(map);
		
		return json;
	}
	@PostMapping(value="hotel/reserve_ok_vue.do",produces = "text/plain;charset=UTF-8")
	  public String reserve_ok(ReserveVO vo,HttpSession session) 
	  {
		  String result="";
		  System.out.println("vo:"+vo);
		  try
		  {
		    String id=(String)session.getAttribute("userId");
		    vo.setId(id);
		    rService.reserveInsert(vo);
		    result="yes";
		  }catch(Exception ex)
		  {
			result=ex.getMessage();  
		  }
		  /*System.out.println("맛집번호:"+vo.getFno());
		  System.out.println("예약일:"+vo.getRday());
		  System.out.println("예약시간:"+vo.getRtime());
		  System.out.println("인원:"+vo.getRinwon());*/
		  return result;
	  }
}
