package com.sist.service;

import java.util.List;

import com.sist.vo.HotelVO;

public interface HotelService {
	public List<HotelVO> hotelListData(int start , int end);
	public int hotelTotalPage();
	public HotelVO hotelDetailData(int hno);
	public HotelVO hotelReserveData(int hno);

}
