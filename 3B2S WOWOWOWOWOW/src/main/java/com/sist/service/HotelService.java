package com.sist.service;

import java.util.List;
import java.util.Map;

import com.sist.vo.HotelVO;

public interface HotelService {
	public List<HotelVO> hotelListData(int start , int end);
	public int hotelTotalPage();
	public HotelVO hotelDetailData(int hno);
	public HotelVO hotelReserveData(int hno);

	
	/////////// jjim /////////////
	public void hotelJjimincrement(int hno);
	public void hotelJjimInsert(Map map);
	public void hotelJjimDelete(Map map);
	public void hotelJjimDecrement(int hno);
	public int jjimcheck(Map map);
}
