package com.sist.web;
import com.sist.vo.*;
import com.sist.service.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // => Router
public class GoodsController {
	
	@Autowired
	private GoodsService gService;

	@GetMapping("goods/list.do")
	public String goods_list()
	{
		return "goods/list";
	}

	@GetMapping("goods/detail.do")
	public String goods_detail(int no,Model model)
	{
		// hit 증가
		gService.goodsHitIncrement(no);
		
		model.addAttribute("no", no);
		
		return "goods/detail";
	}
}
