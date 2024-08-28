package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;

@Repository("dao") // 메모리 할당
public class GoodsDAO {
	@Autowired
	private GoodsMapper mapper;
	
	/*
	@Select("SELECT no,goods_name,goods_price,goods_delivery,num "
			+ "FROM (SELECT no,goods_name,goods_price,goods_delivery,rownum as num "
			+ "FROM (SELECT no,goods_name,goods_price,goods_delivery "
			+ "FROM goods_all"
			+ "ORDER BY no ASC))"
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsListData(@Param("start") int start,@Param("end") int end);
	*/
	public List<GoodsVO> goodsListData(int start,int end)
	{
		return mapper.goodsListData(start, end);
	}
	
	/*
	@Select("SELECT CEIL(COUNT(*)/8.0) FROM goods_all")
	public int goodsTotalPage();
	*/
	public int goodsTotalPage()
	{
		return mapper.goodsTotalPage();
	}
	
	/*
	@Select("SELECT no,goods_name,goods_sub,goods_price,goods_discount,goods_first_price,goods_delivery "
			+ "FROM goods_all "
			+ "WHERE no=#{no}")
	public GoodsVO goodsDetailData(int no);
	 */
	public GoodsVO goodsDetailData(int no)
	{
		return mapper.goodsDetailData(no);
	}
	
}
