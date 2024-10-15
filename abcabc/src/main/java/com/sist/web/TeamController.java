package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.vo.*;
import com.sist.service.*;

@Controller
public class TeamController {

	@Autowired
	private TeamService tService;
	
	@GetMapping("team/list.do")
	public String team_list(Model model)
	{
		List<TeamDetailVO> list=tService.teamListData();
		
		model.addAttribute("list", list);
			
		return "team/list";
	}
	
	@GetMapping("team/detail.do")
	public String team_detail(Model model,String name)
	{
		TeamDetailVO vo=tService.teamDetailData(name);
		
		model.addAttribute("vo", vo);
		
		return "team/detail";
	}
	
	@GetMapping("team/ranking.do")
	public String team_ranking()
	{
		return "team/ranking";
	}
}
