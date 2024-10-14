package com.sist.dao;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReserveDAO {

	@Autowired
	private ReserveMapper mapper;
	
	public List<FoodVO> reserveFoodInfoData(Map map)
	{
		return mapper.reserveFoodInfoData(map);
	}
	
	public int reserveFoodTotalPage(String type)
	{
		return mapper.reserveFoodTotalPage(type);
	}
	
	public void reserveInsert(ReserveVO vo)
	{
		mapper.reserveInsert(vo);
	}
	
	public List<ReserveVO> reserveMyPageListData(String id)
	{
		return mapper.reserveMyPageListData(id);
	}
	
	public List<ReserveVO> reserveAdminListData()
	{
		return mapper.reserveAdminListData();
	}
	
	public void reserveOk(int rno)
	{
		mapper.reserveOk(rno);
	}
}
