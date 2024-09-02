package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface FoodMapper {

	@Select("SELECT fno,name,poster,name,num "
			+ "FROM (SELECT fno,name,poster,name,rownum as num "
			+ "FROM (SELECT fno,name,poster,name "
			+ "FROM project_food_house ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} #{end}")
	public List<FoodVO> foodListData(@Param("start") int start, @Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM project_food_house")
	public int foodTotalPage();
}
