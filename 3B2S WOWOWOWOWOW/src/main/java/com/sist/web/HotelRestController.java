package com.sist.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
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
	
	@GetMapping(value="hotel/find_vue.do",produces = "text/plain;charset=UTF-8")
	public String hotel_find(String name) throws Exception{
		System.out.println("s");
		String strUrl="http://localhost:9200/hotel/_search?q=name="+URLEncoder.encode(name,"UTF-8");
		URL url = new URL(strUrl);
		// url 연결
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		StringBuffer sb = new StringBuffer(); // 데이터를 모아둔다
		if(conn!=null) { // 사이트에 연결이 된 경우
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			while(true) {
				String data = in.readLine();
				if(data==null) break;
				sb.append(data);
			}
			in.close();
		}
		return sb.toString();
	}
	@PostMapping(value="hotel/jjim_vue.do",produces = "text/plain;charset=UTF-8")
	public String hotel_jjim(int hno, HttpSession session){
		String id=(String)session.getAttribute("userId");
		Map map = new HashMap();
		map.put("hno", hno);
		map.put("id", id);
		hService.hotelJjimInsert(map);
		map = new HashMap();
		hService.hotelJjimincrement(hno);
		return "";
	}
	@PostMapping(value="hotel/del_jjim_vue.do",produces = "text/plain;charset=UTF-8")
	public String del_hotel_jjim(int hno , HttpSession session){
		String id=(String)session.getAttribute("userId");
		Map map = new HashMap();
		map.put("hno", hno);
		map.put("id", id);
		hService.hotelJjimDelete(map);
		map = new HashMap();
		hService.hotelJjimDecrement(hno);
		return "";
	}
}
