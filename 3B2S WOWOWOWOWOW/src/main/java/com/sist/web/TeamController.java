package com.sist.web;
import java.text.SimpleDateFormat;
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
	
	@GetMapping("weather/weather.do")
	   public String weather_weather(Model model) 
	   {
		   SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		   Date date=new Date();
		   StringTokenizer st=new StringTokenizer(sdf.format(date),"-");
		   String today=st.nextToken()+"년도 "+st.nextToken()+"월 "+st.nextToken()+"일";
		   model.addAttribute("today", today);
		   return "weather/weather";   
	   }
}
