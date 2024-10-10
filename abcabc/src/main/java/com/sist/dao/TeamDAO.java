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
}
