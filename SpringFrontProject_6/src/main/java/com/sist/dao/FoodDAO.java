package com.sist.dao;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FoodDAO {

	@Autowired
	private FoodMapper mapper;
	
	public List<FoodVO> foodTypeListData(Map map)
	{
		return mapper.foodTypeListData(map);
	}
	
	public int foodTypeTotalPage(String type)
	{
		return mapper.foodTypeTotalPage(type);
	}
}
