package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.HotelMapper;
import com.sist.vo.HotelVO;

@Repository
public class HotelDAO {
	@Autowired
	private HotelMapper mapper;
	public List<HotelVO> hotelListData(int start,int end){
		return mapper.hotelListData(start,end);
	}
	public int hotelTotalPage() {
		return mapper.hotelTotalPage();
	}
	public HotelVO hotelDetailData(int hno) {
		mapper.hotelHitIncrement(hno);
		return mapper.hotelDetailData(hno);
	}
	public HotelVO hotelReserveData(int hno) {
		return mapper.hotelReserveData(hno);
	}
	////////////// jjim //////////////////
	public void hotelJjimincrement(int hno) {
		mapper.hotelJjimincrement(hno);
	}
	public void hotelJjimInsert(Map map) {
		mapper.hotelJjimInsert(map);
	}
	public void hotelJjimDelete(Map map) {
		mapper.hotelJjimDelete(map);
	}
	public void hotelJjimDecrement(int hno) {
		mapper.hotelJjimDecrement(hno);
	}
	public int jjimcheck(Map map) {
		System.out.println(mapper.jjimcheck(map));
		return mapper.jjimcheck(map);
	}
	
	
}
