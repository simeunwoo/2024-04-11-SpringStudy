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
	public List<StadiumVO> stadiumListData() {
		// TODO Auto-generated method stub
		return sDao.stadiumListData();
	}

	@Override
	public StadiumVO stadiumDetailData(int no) {
		// TODO Auto-generated method stub
		return sDao.stadiumDetailData(no);
	}

	@Override
	public List<HotelVO> stadiumHotelListData(String hd) {
		// TODO Auto-generated method stub
		return sDao.stadiumHotelListData(hd);
	}

	@Override
	public List<FoodVO> stadiumFoodListData(String fd) {
		// TODO Auto-generated method stub
		return sDao.stadiumFoodListData(fd);
	}

	@Override
	public HotelVO stadiumHotelDetailData(int hno) {
		// TODO Auto-generated method stub
		return sDao.stadiumHotelDetailData(hno);
	}

	@Override
	public FoodVO stadiumFoodDetailData(int fno) {
		// TODO Auto-generated method stub
		return sDao.stadiumFoodDetailData(fno);
	}
}
