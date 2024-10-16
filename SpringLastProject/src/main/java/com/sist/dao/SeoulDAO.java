package com.sist.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.SeoulMapper;
import com.sist.vo.SeoulVO;

@Repository
public class SeoulDAO {

	@Autowired
	private SeoulMapper mapper;
	
	public List<SeoulVO> seoulLocationListData(Map map)
	{
		return mapper.seoulLocationListData(map);
	}

	public List<SeoulVO> seoulNatureListData(Map map)
	{
		return mapper.seoulNatureListData(map);
	}

	public List<SeoulVO> seoulShopListData(Map map)
	{
		return mapper.seoulShopListData(map);
	}
	
	public int seoulLocationTotalPage()
	{
		return mapper.seoulLocationTotalPage();
	}

	public int seoulNatureTotalPage()
	{
		return mapper.seoulNatureTotalPage();
	}

	public int seoulShopTotalPage()
	{
		return mapper.seoulShopTotalPage();
	}
}
