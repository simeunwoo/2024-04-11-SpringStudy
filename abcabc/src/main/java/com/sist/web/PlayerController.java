package com.sist.web;
import java.util.*;
import com.sist.vo.*;
import com.sist.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlayerController {

	@Autowired
	private PlayerService pService;
	
	@GetMapping("player/batter_list.do")
	public String player_batter_list()
	{
		return "player/batter_list";
	}
	
	@GetMapping("player/pitcher_list.do")
	public String player_pitcher_list()
	{
		return "player/pitcher_list";
	}
	
	@GetMapping("player/batter_detail.do")
	public String player_batter_detail(int bno,Model model)
	{
		BatterVO vo=pService.batterDetailData(bno);
		
		model.addAttribute("bno", bno);
		model.addAttribute("vo", vo);
		
		return "player/batter_detail";
	}
	
	@GetMapping("player/pitcher_detail.do")
	public String player_pitcher_detail(int pno,Model model)
	{
		PitcherVO vo=pService.pitcherDetailData(pno);
		
		model.addAttribute("pno", pno);
		model.addAttribute("vo", vo);
		
		return "player/pitcher_detail";
	}
	
	@GetMapping("player/vs.do")
	public String player_vs()
	{
		return "player/vs";
	}
}
