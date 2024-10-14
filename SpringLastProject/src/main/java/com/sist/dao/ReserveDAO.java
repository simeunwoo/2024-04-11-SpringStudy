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
}
