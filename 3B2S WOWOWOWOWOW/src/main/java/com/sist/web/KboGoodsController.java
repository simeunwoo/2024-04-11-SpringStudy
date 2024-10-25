package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.service.*;
import com.sist.vo.*;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class KboGoodsController {
	@Autowired
	private KboGoodsService kgService;
	
	@GetMapping("kbogoods/list.do")
	public String kbogoods_list() {
		return "kbogoods/list";
	}
	
	@GetMapping("kboGoods/detail_before.do")
	   public String kbogoods_detail_before(int gno,HttpServletResponse response,RedirectAttributes ra)
	   {
		   // forward => Model를 이용해서 데이터 전송 
		   // redirect => RedirectAttributes이용해서 데이터 전송 
		   Cookie cookie=new Cookie("kboGoods_"+gno, String.valueOf(gno));
		   cookie.setMaxAge(60*60*24);
		   cookie.setPath("/");
		   response.addCookie(cookie);
		   ra.addAttribute("gno", gno);
		   return "redirect:../kboGoods/detail.do";
	   }

	
	   @GetMapping("kboGoods/detail.do")
	   public String food_detail(int gno,Model model,HttpSession session)
	   {
		   String id=(String)session.getAttribute("userId");
		   
		   KboGoodsVO vo=kgService.kboGoodsDetailData(gno);
		   model.addAttribute("vo", vo);
		   model.addAttribute("gno", gno);
		   model.addAttribute("sessionId", id);
		   
		   return "kbogoods/detail";
	   }
	   

}
