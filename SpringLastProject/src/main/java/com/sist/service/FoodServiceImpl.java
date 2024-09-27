package com.sist.service;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodDAO fDao;

	@Override
	public List<FoodVO> foodHitTop5() {
		// TODO Auto-generated method stub
		return fDao.foodHitTop5();
	}

	@Override
	public List<FoodVO> foodListData(int start, int end) {
		// TODO Auto-generated method stub
		return fDao.foodListData(start, end);
	}

	@Override
	public int foodTotalPage() {
		// TODO Auto-generated method stub
		return fDao.foodTotalPage();
	}

	@Override
	public FoodVO foodDetailData(int fno) {
		// TODO Auto-generated method stub
		return fDao.foodDetailData(fno);
	}

	// Cookie용
	@Override
	public FoodVO foodInfoData(int fno) {
		// TODO Auto-generated method stub
		return fDao.foodInfoData(fno);
	}
}
