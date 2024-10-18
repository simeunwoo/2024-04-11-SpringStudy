package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Service
public class StadiumServiceImpl implements StadiumService{
	@Autowired
	private StadiumDAO sDao;

	@Override
	public List<StadiumVO> stadiumListData(int start, int end) {
		// TODO Auto-generated method stub
		return sDao.stadiumListData(start, end);
	}

	@Override
	public int stadiumTotalPage() {
		// TODO Auto-generated method stub
		return sDao.stadiumTotalPage();
	}

	@Override
	public StadiumVO stadiumDetailData(int no) {
		// TODO Auto-generated method stub
		return sDao.stadiumDetailData(no);
	}
}
