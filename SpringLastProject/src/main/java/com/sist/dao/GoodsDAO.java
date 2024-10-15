package com.sist.dao;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsDAO {

	@Autowired
	private GoodsMapper mapper;
	
	public List<GoodsVO> goodsListData(Map map)
	{
		return mapper.goodsListData(map);
	}
	
	public int goodsTotalPage()
	{
		return mapper.goodsTotalPage();
	}
	
	public void goodsHitIncrement(int no)
	{
		mapper.goodsHitIncrement(no);
	}
	
	public GoodsVO goodsDetailData(int no)
	{
		return mapper.goodsDetailData(no);
	}
	
	public MemberVO memberinfoData(String userId)
	{
		return mapper.memberinfoData(userId);
	}
}
