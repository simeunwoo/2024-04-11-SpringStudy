package com.sist.web;
import java.util.*;
import com.sist.service.*;
import com.sist.dao.*;
import com.sist.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoodsController {

	@Autowired
	private GoodsService g;
	
	@GetMapping("goods/list.do")
	public String goods_list(String page,Model model)
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
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		model.addAttribute("main_jsp", "../goods/list.jsp");
		return "main/main";
	}
	
	@GetMapping("goods/detail.do")
	public String goods_detail(int no,Model model)
	{
		GoodsVO vo=g.goodsDetailData(no);
		
		model.addAttribute("vo", vo);
		
		model.addAttribute("main_jsp", "../goods/detail.jsp");
		return "main/main";
	}
}
