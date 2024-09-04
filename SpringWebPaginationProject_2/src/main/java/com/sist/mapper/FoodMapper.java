package com.sist.mapper;
import java.util.*;
import com.sist.vo.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface FoodMapper {

	@Select("SELECT fno,name,poster,address,num "
			+ "FROM (SELECT fno,name,poster,address,rownum as num "
			+ "FROM (SELECT /*+INDEX_ASC(project_food_house fh_fno_pk) */fno,name,poster,address "
			+ "FROM project_food_house))"
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodListData(@Param("start") int start,@Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/16.0) FROM project_food_house")
	public int foodTotalPage();
	
	@Select("SELECT fno,name,type,phone,address,score,theme,poster,time,parking,content "
			+ "FROM project_food_house WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
}
