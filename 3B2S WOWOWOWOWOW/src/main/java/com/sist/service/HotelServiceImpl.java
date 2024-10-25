package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.HotelDAO;
import com.sist.vo.HotelVO;

@Service
public class HotelServiceImpl implements HotelService{
	@Autowired
	private HotelDAO hDao;
	
	@Override
	public List<HotelVO> hotelListData(int start , int end) {
		// TODO Auto-generated method stub
		return hDao.hotelListData(start,end);
	}

	@Override
	public int hotelTotalPage() {
		// TODO Auto-generated method stub
		return hDao.hotelTotalPage();
	}

	@Override
	public HotelVO hotelDetailData(int hno) {
		// TODO Auto-generated method stub
		return hDao.hotelDetailData(hno);
	}

	@Override
	public HotelVO hotelReserveData(int hno) {
		// TODO Auto-generated method stub
		return hDao.hotelReserveData(hno);
		
	}

	@Override
	public void hotelJjimincrement(int hno) {
		// TODO Auto-generated method stub
		hDao.hotelJjimincrement(hno);
	}

	@Override
	public void hotelJjimInsert(Map map) {
		// TODO Auto-generated method stub
		hDao.hotelJjimInsert(map);
	}

	@Override
	public void hotelJjimDelete(Map map) {
		// TODO Auto-generated method stub
		hDao.hotelJjimDelete(map);
	}

	@Override
	public void hotelJjimDecrement(int hno) {
		// TODO Auto-generated method stub
		hDao.hotelJjimDecrement(hno);
	}

	@Override
	public int jjimcheck(Map map) {
		// TODO Auto-generated method stub
		return hDao.jjimcheck(map);
	}


}
