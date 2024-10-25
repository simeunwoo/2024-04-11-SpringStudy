package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class TeamDAO {

	@Autowired
	private TeamMapper mapper;
	
	public List<TeamDetailVO> teamListData()
	{
		return mapper.teamListData();
	}
	
	public TeamDetailVO teamDetailData(String name)
	{
		return mapper.teamDetailData(name);
	}
	
	public List<TeamVO> teamRankingData()
	{
		return mapper.teamRankingData();
	}
	/*
		mapper.seoulShopDetailData(map);
	   List<SeoulVO> list=(List<SeoulVO>)map.get("pResult");
	   return list.get(0);
	 */
	
	public List<TeamVO> teamRankingMainData()
	{
		return mapper.teamRankingData();
	}
}
