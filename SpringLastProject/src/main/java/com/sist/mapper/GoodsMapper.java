package com.sist.mapper;
import java.util.*;
import com.sist.vo.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface GoodsMapper {

	@Select("SELECT no,goods_price,goods_poster,goods_name,goods_delivery,hit,num "
			+ "FROM (SELECT no,goods_price,goods_poster,goods_name,goods_delivery,hit,rownum as num "
			+ "FROM (SELECT no,goods_price,goods_poster,goods_name,goods_delivery,hit "
			+ "FROM goods_all ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM goods_all")
	public int goodsTotalPage();
	
	@Update("UPDATE goods_all SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public void goodsHitIncrement(int no);

	@Select("SELECT * FROM goods_all "
			+ "WHERE no=#{no}")
	public GoodsVO goodsDetailData(int no);
	
	@Select("SELECT userId,userName,sex,post,addr1,addr2,phone,email "
			+ "FROM spring_member "
			+ "WHERE userId=#{userId}")
	public MemberVO memberinfoData(String userId);
}
