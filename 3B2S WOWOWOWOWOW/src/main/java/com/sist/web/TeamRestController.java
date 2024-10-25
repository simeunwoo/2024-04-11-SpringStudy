package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;

@RestController
public class TeamRestController {

	@Autowired
	private TeamService tService;
	
	@GetMapping(value="team/ranking_vue.do",produces="text/plain;charset=UTF-8")
	public String team_ranking(String year) throws Exception
	{
		List<TeamVO> list=tService.teamRankingData();
		
		Map map=new HashMap();
		map.put("list", list);
		map.put("year", year);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
}
