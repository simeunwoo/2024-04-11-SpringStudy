package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sist.dao.*;
import com.sist.vo.*;

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
	public List<BatterVO> batterListData(int start, int end) {
		// TODO Auto-generated method stub
		return pDao.batterListData(start, end);
	}

	@Override
	public List<PitcherVO> pitcherListData(int start, int end) {
		// TODO Auto-generated method stub
		return pDao.pitcherListData(start, end);
	}
	
	
}
