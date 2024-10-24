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
	
	public int batterTotalPage(String fd)
	{
		return mapper.batterTotalPage(fd);
	}
	
	public int pitcherTotalPage(String fd)
	{
		return mapper.pitcherTotalPage(fd);
	}
	
	public List<BatterVO> batterListData(Map map)
	{
		mapper.batterListData(map);
		return (List<BatterVO>)map.get("pResult");
	}
	
	public List<PitcherVO> pitcherListData(Map map)
	{
		return mapper.pitcherListData(map);
	}
	
	public List<BatterVO> batterChartData()
	{
		return mapper.batterChartData();
	}
	
	public List<PitcherVO> pitcherChartData()
	{
		return mapper.pitcherChartData();
	}
}
