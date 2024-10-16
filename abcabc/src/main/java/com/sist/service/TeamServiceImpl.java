package com.sist.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.vo.*;
import com.sist.dao.*;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamDAO tDao;

	@Override
	public List<TeamDetailVO> teamListData() {
		// TODO Auto-generated method stub
		return tDao.teamListData();
	}

	@Override
	public TeamDetailVO teamDetailData(String name) {
		// TODO Auto-generated method stub
		return tDao.teamDetailData(name);
	}

	@Override
	public List<TeamVO> teamRankingData() {
		// TODO Auto-generated method stub
		return tDao.teamRankingData();
	}
}
