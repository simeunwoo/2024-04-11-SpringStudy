package com.sist.web;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.*;
import com.sist.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Model => 사용자 요청 처리 => 사용자 정의 ~Model, 스프링 => ~Controller, 스트럿츠 => ~Action
@Controller
@RequestMapping("food/") // 미리 써놓으면 "food/" 부분은 아래쪽에서 나중에 굳이 안 쓰고 생략 가능
public class FoodController {

	// 필요한 객체 => DAO => 스프링에 등록된 객체 얻기
	@Autowired
	private FoodDAO dao;
	
	/*
	 * 	@RequestMapping => GetMapping + PostMapping
	 * 	@GetMapping => GET 방식
	 * 	@PostMapping => POST 방식
	 * 
	 * 	request/response는 사용하지 않는다
	 * 	================
	 * 
	 * 	list.do?page=1
	 * 	detail.do?fno=100
	 * 	public String food_detail(int fno,Model model)
	 * 
	 * 	page는 String 설정한 이유 => 처음에 null값이기 때문에 (int는 null값을 받지 못한다)
	 * 	처음에 null값이다? => String으로 설정해야 된다
	 */
	@GetMapping("list.do") // "food/" 부분 생략 가능
	public String food_list(String page,Model model)
	{
		// String page=request.getParameter("page")
		// Model => 전송 객체 (이미 존재하는 클래스)(request 대신 JSP로 값을 전송하는 클래스)
		// 사용자가 전송한 값은 매개 변수를 통하여 값을 받는다
		// request : Cookie 사용
		// response : Cookie 사용, 파일 업로드
		
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=20;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		
		List<FoodVO> list=dao.foodListData(start, end);
		int totalpage=dao.foodTotalpage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		/*
		 * 	request.setAttribute("aaa",list);
		 * 
		 * 	class Model
		 * 	{
		 * 		public void addAttribute(String key,Object obj)
		 * 		{
		 * 			request.setAttribute(key,obj);
		 * 		}
		 * 	}
		 */
		// 전체 객체 => Model
		// request, response => 가급적이면 사용하지 않는다
		// ------------------ IP가 존재 (보안)
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		
		return "food/list"; // 파일명만 지정
	}
	
	@PostMapping("insert1.do")
	public String food_insert1(HttpServletRequest request,HttpServletResponse response)
	{
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		
		MemberVO vo=new MemberVO();
		vo.setName(name);
		vo.setSex(sex);
		vo.setAddress(address);
		vo.setPhone(phone);
		vo.setEmail(email);
		
		request.setAttribute("vo", vo);
		
		return "food/detail";
	}
	@PostMapping("insert2.do")
	public String food_insert2(String name,String sex,String address,String phone,String email,Model model)
	{
		MemberVO vo=new MemberVO();
		vo.setName(name);
		vo.setSex(sex);
		vo.setAddress(address);
		vo.setPhone(phone);
		vo.setEmail(email);
		
		model.addAttribute("vo", vo);
		
		return "food/detail";
	}
	@PostMapping("insert3.do")
	// ===> 커맨드 객체 : VO 단위로 값을 받아서 => 매개 변수로 넘겨준다
	// name="" => 멤버 변수명과 동일
	public String food_insert3(MemberVO vo,Model model)
	{
		model.addAttribute("vo", vo);
		
		return "food/detail";
	}
}
