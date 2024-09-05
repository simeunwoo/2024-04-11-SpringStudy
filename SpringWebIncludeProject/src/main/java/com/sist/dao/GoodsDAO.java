package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

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
	
	public GoodsVO goodsDetailData(int no)
	{
		mapper.goodsHitIncrement(no);
		return mapper.goodsDetailData(no);
	}
	
	public GoodsVO goodsCookieData(int no)
	{
		return mapper.goodsCookieData(no);
	}
}
