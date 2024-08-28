package com.sist.mapper;
import java.util.*;
import com.sist.vo.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface GoodsMapper {

	@Select("SELECT no,goods_name,goods_price,goods_delivery,num "
			+ "FROM (SELECT no,goods_name,goods_price,goods_delivery,rownum as num "
			+ "FROM (SELECT no,goods_name,goods_price,goods_delivery "
			+ "FROM goods_all "
			+ "ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsListData(@Param("start") int start,@Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/8.0) FROM goods_all")
	public int goodsTotalPage();
	
	@Select("SELECT no,goods_name,goods_sub,goods_price,goods_discount,goods_first_price,goods_delivery "
			+ "FROM goods_all "
			+ "WHERE no=#{no}")
	public GoodsVO goodsDetailData(int no);
}
