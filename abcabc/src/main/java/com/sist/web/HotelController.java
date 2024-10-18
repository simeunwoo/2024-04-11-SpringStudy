package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.service.*;
import com.sist.vo.*;

import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class HotelController {
	@Autowired
	private HotelService hService;
	
	@GetMapping("hotel/list.do")
	public String hotel_list()
	{
		return "hotel/list";
	}
	@GetMapping("hotel/detail_before.do")
	public String hotel_detail_before(int hno,HttpServletResponse response , RedirectAttributes ra)
	{
		Cookie cookie = new Cookie("hotel_"+hno,String.valueOf(hno));
		cookie.setMaxAge(60*60*24);
		cookie.setPath("/");
		response.addCookie(cookie);
		
		ra.addAttribute("hno",hno);
		return "redirect:../hotel/detail.do";
	}
	@GetMapping("hotel/detail.do")
	public String hotel_detail(int hno,Model model,HttpSession session)
	{
		String id=(String)session.getAttribute("userId");
		HotelVO vo = hService.hotelDetailData(hno);
		int rprice=vo.getPrice();
		DecimalFormat formatter = new DecimalFormat("#,###");
		String price = formatter.format(rprice);
		model.addAttribute("price", price);
		model.addAttribute("vo", vo);
		model.addAttribute("session", session);
		model.addAttribute("hno", hno);
		return "hotel/detail";
	}
	@GetMapping("hotel/find.do")
	public String hotel_find() {
		return "hotel/find";
	}
	@GetMapping("hotel/reserve.do")
	public String reserve_hotel(int hno,HttpServletRequest request) {
		
		request.setAttribute("hno", hno);
		return "hotel/reserve";
	}
}
