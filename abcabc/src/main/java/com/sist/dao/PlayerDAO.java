package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class PlayerDAO {

	@Autowired
	private PlayerMapper mapper;
	
	public BatterVO batterDetailData(int bno)
	{
		return mapper.batterDetailData(bno);
	}
	
	public PitcherVO pitcherDetailData(int pno)
	{
		return mapper.pitcherDetailData(pno);
	}
	
	public int batterTotalPage()
	{
		return mapper.batterTotalPage();
	}
	
	public int pitcherTotalPage()
	{
		return mapper.pitcherTotalPage();
	}
	
	public List<BatterVO> batterListData(Map map)
	{
		return mapper.batterListData(map);
	}
	
	public List<PitcherVO> pitcherListData(int start,int end)
	{
		return mapper.pitcherListData(start, end);
	}
}
