package com.sist.mapper;
import java.util.*;
import com.sist.vo.*;

import org.apache.ibatis.annotations.Select;

public interface FoodMapper {

	@Select("SELECT fno,name,type,address,time,parking,theme "
			+"FROM project_food_house "
			+"WHERE ${column} LIKE '%'||#{fd}||'%'")
	public List<FoodVO> foodFindData(Map map);
}
