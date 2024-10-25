package com.sist.web;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
import org.apache.http.cookie.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;
import com.sist.vo.*;

@RestController
public class MyPageRestController {
	@Autowired 
	private ReserveService rService;
	@Autowired
	private HotelService hService;
	@Autowired
	private KboGoodsService kgService;
	@Autowired
	private BoardService bService;
	@Autowired
	private CommentService cService;
	@Autowired
	private MemberService mService;
	@Autowired
	private NewsService nService;
	
	@GetMapping(value="mypage/reserve_info_vue.do",produces="text/plain;charset=UTF-8")
	public String reserve_info(int hno , int rno) throws Exception{
		ReserveVO vo = rService.reserveInfoData(rno);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(vo);
		return json;
	}
	@GetMapping(value="mypage/mypage_reserve_vue.do",produces = "text/plain;charset=UTF-8")
	  public String mypage_reserve(HttpSession session) throws Exception
	  {
		  String id=(String)session.getAttribute("userId");
		  System.out.println(id);
		  List<ReserveVO> list=rService.reserveMyPageListData(id);
		  ObjectMapper mapper=new ObjectMapper();
		  String json=mapper.writeValueAsString(list);
		  return json;
	  }
	
	  @GetMapping(value="mypage/mypage_cart_vue.do",produces = "text/plain;charset=UTF-8")
	  public String mypage_cart(HttpSession session) throws Exception
	  {
		  String id=(String) session.getAttribute("userId");
		  List<KboGoodsCartVO> list=kgService.goodsCartListData(id);
		  
		  ObjectMapper mapper=new ObjectMapper();
		  String json=mapper.writeValueAsString(list);
		  
		  return json;
	  }
	  
	  @GetMapping(value="mypage/mypage_buy_vue.do",produces = "text/plain;charset=UTF-8")
	  public String mypage_buy(HttpSession session) throws Exception
	  {
		  String id=(String) session.getAttribute("userId");
		  List<KboGoodsCartVO> list=kgService.goodsCartListData(id);
		  
		  ObjectMapper mapper=new ObjectMapper();
		  String json=mapper.writeValueAsString(list);
		  
		  return json;
	  }
	  
	  @GetMapping(value="mypage/mypage_board_vue.do",produces = "text/plain;charset=UTF-8")
	  public String mypage_board(HttpSession session) throws Exception
	  {
		  String id=(String) session.getAttribute("userId");
		  List<BoardVO> list=bService.mypageBoardListData(id);
		  
		  ObjectMapper mapper=new ObjectMapper();
		  String json=mapper.writeValueAsString(list);
		  
		  return json;
	  }
	

	  @GetMapping(value="mypage/mypage_comment_vue.do",produces = "text/plain;charset=UTF-8")
	  public String mypage_comment(HttpSession session) throws Exception
	  {
		  String id=(String) session.getAttribute("userId");
		  List<CommentVO> list=cService.mypageCommentListData(id);
		  
		  ObjectMapper mapper=new ObjectMapper();
		  String json=mapper.writeValueAsString(list);
		  
		  return json;
	  }

	  @GetMapping(value="mypage/mypage_home_vue.do", produces = "text/plain;charset=UTF-8")
	   public String mypage_menu(HttpSession session,HttpServletRequest request) throws Exception {
	       String id = (String) session.getAttribute("userId");

	       // 사용자 기본 정보 가져오기
	       MemberVO vo = mService.memberInfoData(id);

	       // 구매 수 가져오기
	       int BuyCount = mService.mypageBuyCount(id);

	       // 장바구니 수 가져오기
	       int CartCount = mService.mypageCartCount(id);
	       
	       // 티켓 예약수 가져오기
	       int TicketCount = mService.mypageTicketCount(id);
	       
	       // 호텔 예약수 가져오기
	       int HotelCount = mService.mypageHotelCount(id);
	       
	       int BoardCount = mService.mypageBoardCount(id);
	       
	       int ReplyCount = mService.mypageReplyCount(id);
	       
	       
			/*
			 * Cookie[] cookies = request.getCookies(); List<NewsVO> cookie_list = new
			 * ArrayList<>(); if (cookies != null) { for (int i = cookies.length - 1; i >=
			 * 0; i--) { if (cookies[i].getTitle().startsWith("news_")) { String nno =
			 * cookies[i].getValue(); NewsVO nvo =
			 * nService.mainCookieListData(Integer.parseInt(nno)); int percent = (int)
			 * (Math.round(nvo.getTotalprice() / (double) nvo.getTargetprice() * 100));
			 * nvo.setFm_percent(new DecimalFormat("###,###").format(percent)); // 상태 설정 (오픈
			 * 전/후 여부 판단) SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); Date
			 * now = new Date(); if (now.before(nvo.getStartdate())) { nvo.setOf(1); // 오픈 전
			 * 상태 } cookie_list.add(nvo); } } }
			 */


	       // 알림 신청 수와 구매 목록 수를 VO에 포함하거나 새로운 Map에 담기
	       Map map= new HashMap<>();
	       map.put("memberInfo", vo);
	       map.put("BuyCount", BuyCount);
	       map.put("CartCount", CartCount);
	       map.put("HotelCount", HotelCount);
	       map.put("TicketCount", TicketCount);
	       map.put("BoardCount", BoardCount);
	       map.put("ReplyCount", ReplyCount);
			/* map.put("latest_list", cookie_list); */
	       // JSON으로 변환
	       ObjectMapper mapper = new ObjectMapper();
	       String json = mapper.writeValueAsString(map);

	       return json;
	   }

}


















