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
	public int batterTotalPage() {
		// TODO Auto-generated method stub
		return pDao.batterTotalPage();
	}

	@Override
	public int pitcherTotalPage() {
		// TODO Auto-generated method stub
		return pDao.pitcherTotalPage();
	}

	@Override
	public List<BatterVO> batterListData(Map map) {
		// TODO Auto-generated method stub
		return pDao.batterListData(map);
	}

	@Override
	public List<PitcherVO> pitcherListData(int start, int end) {
		// TODO Auto-generated method stub
		return pDao.pitcherListData(start, end);
	}
	
	
}
