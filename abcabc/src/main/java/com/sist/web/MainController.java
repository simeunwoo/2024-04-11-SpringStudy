package com.sist.web;
import java.util.*;
import com.sist.vo.*;
import com.sist.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// jsp 연동
@Controller
@RequestMapping("main/")
public class MainController {
	
	@Autowired
	private ScheduleService sService;
	@Autowired
	private TeamService tService;
	@Autowired
	private NoticeService nService;
	
	@GetMapping("main.do")
	public String main_main(Model model)
	{
		List<ScheduleVO> sList=sService.scheduleListMainData();
		List<TeamVO> rList=tService.teamRankingMainData();
		List<NoticeVO> nList=nService.noticeListMainData();
		
		model.addAttribute("sList", sList);
		model.addAttribute("rList", rList);
		model.addAttribute("nList", nList);
		
		return "main";
	}
}
