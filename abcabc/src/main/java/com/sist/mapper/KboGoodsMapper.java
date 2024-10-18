package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface KboGoodsMapper {
	//굿즈 리스트
	@Select("SELECT gno, name, price, delivery, content, poster, num "
			+ "FROM (SELECT gno, name, price, delivery, content, poster, rownum as num "
			+ "FROM (SELECT gno, name, price, delivery, content, poster "
			+ "FROM kbo_goods "
			+ "ORDER BY gno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<KboGoodsVO> kboGoodsListData(@Param("start") int start,@Param("end") int end);
	
	@Select("SELECT gno, name, price, delivery, content, poster, num "
			+ "FROM (SELECT gno, name, price, delivery, content, poster, rownum as num "
			+ "FROM (SELECT gno, name, price, delivery, content, poster "
			+ "FROM kbo_goods "
			+ "WHERE name LIKE '%'||#{fd}||'%' "
			+ "ORDER BY gno DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<KboGoodsVO> kboGoodsFindListData(Map map);
		
	//상세보기
	@Select("SELECT * FROM kbo_goods "
			+"WHERE gno=#{gno}")
	public KboGoodsVO kboGoodsDetailData(int gno);
	
	//총 페이지
	@Select("SELECT CEIL(COUNT(*)/15.0) FROM project_food_house")
	public int kboGoodsTotalPage();
	
	@Select("SELECT CEIL(COUNT(*)/15.0) FROM kbo_goods "
			+"WHERE name LIKE '%'||#{fd}||'%'")
	public int kboGoodsFindTotalPage(Map map);
	
}
