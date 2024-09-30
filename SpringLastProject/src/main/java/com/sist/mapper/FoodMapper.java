package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;

public interface FoodMapper {

	@Select("SELECT fno,name,poster,address,rownum "
			+ "FROM (SELECT fno,name,poster,address "
			+ "FROM project_food_house ORDER BY hit DESC) "
			+ "WHERE rownum<=5")
	public List<FoodVO> foodHitTop5();
	
	// *** 목록
	@Select("SELECT fno,name,poster,score,type,hit,num "
			+ "FROM (SELECT fno,name,poster,score,type,hit,rownum as num "
			+ "FROM (SELECT fno,name,poster,score,type,hit "
			+ "FROM project_food_house ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start") int start,@Param("end") int end);
	
	// 총 페이지
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM project_food_house")
	public int foodTotalPage();
	
	// 상세 보기 => Cookie
	@Update("UPDATE project_food_house SET "
			+ "hit=hit+1 "
			+ "WHERE fno=#{fno}")
	public void foodHitIncrement(int fno);
	
	@Select("SELECT * FROM project_food_house "
			+ "WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
	
	// *** 예약
	@Select("SELECT fno,name,poster "
			+ "FROM project_food_house "
			+ "WHERE type LIKE '%'||#{type}||'%'")
	public List<FoodVO> foodTypeData(String type);
	
	// 추천 => 네이버 카페
	// 검색
	@Select("SELECT fno,name,poster,score,type,hit,num "
			+ "FROM (SELECT fno,name,poster,score,type,hit,rownum as num "
			+ "FROM (SELECT fno,name,poster,score,type,hit "
			+ "FROM project_food_house "
			+ "WHERE address LIKE '%'||#{fd}||'%' "
			+ "ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodFindListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM project_food_house "
			+ "WHERE address LIKE '%'||#{fd}||'%'")
	public int foodFindTotalPage(Map map);
}
