package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;

public interface GoodsMapper {

	@Select("SELECT no,goods_name,goods_poster,num "
			+ "FROM (SELECT no,goods_name,goods_poster,rownum as num "
			+ "FROM (SELECT /*+ INDEX_ASC(goods_all goods_no_pk)*/no,goods_name,goods_poster "
			+ "FROM goods_all)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/16.0) FROM goods_all")
	public int goodsTotalPage();
	
	@Update("UPDATE goods_all SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public void goodsHitIncrement(int no);
	
	@Select("SELECT no,hit,goods_name,goods_sub,goods_price,goods_discount,"
			+ "goods_first_price,goods_delivery,goods_poster "
			+ "FROM goods_all "
			+ "WHERE no=#{no}")
	public GoodsVO goodsDetailData(int no);
	
	// 쿠키 정보 데이터
	@Select("SELECT no,goods_name,goods_poster "
			+ "FROM goods_all "
			+ "WHERE no=#{no}")
	public GoodsVO goodsCookieData(int no);
}
