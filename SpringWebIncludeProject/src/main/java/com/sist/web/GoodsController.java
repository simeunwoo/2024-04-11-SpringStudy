package com.sist.web;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.service.*;
import com.sist.dao.*;
import com.sist.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GoodsController {

	@Autowired
	private GoodsService g;
	
	@GetMapping("goods/list.do")
	public String goods_list(String page,Model model,HttpServletRequest request)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		int rowSize=16;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		map.put("start", start);
		map.put("end", end);
		
		List<GoodsVO> list=g.goodsListData(map);
		int totalpage=g.goodsTotalPage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		Cookie[] cookies=request.getCookies();
		List<GoodsVO> cList=new ArrayList<GoodsVO>();
		if(cookies!=null)
		{
			// 최신부터 담는다
			for(int i=cookies.length-1;i>=0;i--)
			{
				if(cookies[i].getName().startsWith("goods_"))
				{
					String no=cookies[i].getValue();
					GoodsVO vo=g.goodsCookieData(Integer.parseInt(no));
					cList.add(vo);
				}
			}
		}
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		model.addAttribute("cList", cList);
		model.addAttribute("size", cList.size());
		
		model.addAttribute("main_jsp", "../goods/list.jsp");
		return "main/main";
	}
	
	@GetMapping("goods/detail_before.do")
	public String goods_detail_before(int no,HttpServletResponse response,RedirectAttributes ra)
	{
		Cookie cookie=new Cookie("goods_"+no, String.valueOf(no));
		cookie.setMaxAge(60*60*24);
		cookie.setPath("/");
		response.addCookie(cookie);
		
		ra.addAttribute("no", no);
		
		return "redirect:../goods/detail.do";
	}
	
	@GetMapping("goods/detail.do")
	public String goods_detail(int no,Model model)
	{
		GoodsVO vo=g.goodsDetailData(no);
		
		model.addAttribute("vo", vo);
		
		model.addAttribute("main_jsp", "../goods/detail.jsp");
		return "main/main";
	}
	
	@GetMapping("goods/cookie_all.do")
	public String goods_cookie_all(HttpServletRequest request,Model model)
	{
		Cookie[] cookies=request.getCookies();
		List<GoodsVO> cList=new ArrayList<GoodsVO>();
		if(cookies!=null)
		{
			for(int i=cookies.length-1;i>=0;i--)
			{
				if(cookies[i].getName().startsWith("goods_"))
				{
					String no=cookies[i].getValue();
					GoodsVO vo=g.goodsCookieData(Integer.parseInt(no));
					cList.add(vo);
				}
			}
		}
		
		model.addAttribute("cList", cList);
		model.addAttribute("size", cList.size());
		
		model.addAttribute("main_jsp", "../goods/cookie_all.jsp");
		return "main/main";
	}
	
	@GetMapping("goods/cookie_delete.do")
	public String goods_cookie_delete(HttpServletRequest request,HttpServletResponse response)
	{
		Cookie[] cookies=request.getCookies();
		if(cookies!=null)
		{
			for(int i=0;i<cookies.length;i++)
			{
				if(cookies[i].getName().startsWith("recipe_"))
				{
					cookies[i].setPath("/");
					cookies[i].setMaxAge(0); // 쿠키 삭제
					response.addCookie(cookies[i]); // 브라우저에 알림
				}
			}
		}
		
		return "redirect:../goods/list.do";
	}
}
