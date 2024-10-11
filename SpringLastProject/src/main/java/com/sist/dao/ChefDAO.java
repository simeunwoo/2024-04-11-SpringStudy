package com.sist.dao;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ChefDAO {

	@Autowired
	private ChefMapper mapper;
	
	public ChefVO chefToday()
	{
		return mapper.chefToday();
	}
	
	public List<ChefVO> chefListData(Map map)
	{
		return mapper.chefListData(map);
	}
	
	public int chefTotalPage()
	{
		return mapper.chefTotalPage();
	}
}
