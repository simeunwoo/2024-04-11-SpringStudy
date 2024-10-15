package com.sist.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.*;
import com.sist.vo.*;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerDAO pDao;

	@Override
	public BatterVO batterDetailData(int bno) {
		// TODO Auto-generated method stub
		return pDao.batterDetailData(bno);
	}

	@Override
	public PitcherVO pitcherDetailData(int pno) {
		// TODO Auto-generated method stub
		return pDao.pitcherDetailData(pno);
	}

	@Override
	public int batterTotalPage(String fd) {
		// TODO Auto-generated method stub
		return pDao.batterTotalPage(fd);
	}

	@Override
	public int pitcherTotalPage(String fd) {
		// TODO Auto-generated method stub
		return pDao.pitcherTotalPage(fd);
	}

	@Override
	public List<BatterVO> batterListData(Map map) {
		// TODO Auto-generated method stub
		return pDao.batterListData(map);
	}

	@Override
	public List<PitcherVO> pitcherListData(Map map) {
		// TODO Auto-generated method stub
		return pDao.pitcherListData(map);
	}

	@Override
	public List<BatterVO> batterChartData() {
		// TODO Auto-generated method stub
		return pDao.batterChartData();
	}

	@Override
	public List<PitcherVO> pitcherChartData() {
		// TODO Auto-generated method stub
		return pDao.pitcherChartData();
	}
	
	
}
