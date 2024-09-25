package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;

public interface FoodMapper {

	@Select("SELECT fno,poster,type,name,num "
			+ "FROM (SELECT fno,poster,type,name,rownum as num "
			+ "FROM (SELECT fno,poster,type,name "
			+ "FROM project_food_house "
			+ "WHERE type LIKE '%'||#{type}||'%' ORDER BY fno)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodTypeListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM project_food_house "
			+ "WHERE type LIKE '%'||#{type}||'%'")
	public int foodTypeTotalPage(String type);
	
	// 상세 보기
	@Update("UPDATE project_food_house SET "
			+ "hit=hit+1 "
			+ "WHERE fno=#{fno}")
	public void foodHitIncrement(int fno);
	
	@Select("SELECT fno,name,type,phone,address,theme,poster,images,time,parking,content,score "
			+ "FROM project_food_house "
			+ "WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
}
