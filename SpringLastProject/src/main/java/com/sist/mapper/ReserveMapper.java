package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface ReserveMapper {

	@Select("SELECT fno,poster,name,num "
			+ "FROM (SELECT fno,poster,name,rownum as num "
			+ "FROM (SELECT /*+ INDEX_ASC(project_food_house fh_fno_pk)*/fno,poster,name "
			+ "FROM project_food_house WHERE type LIKE '%'||#{type}||'%')) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> reserveFoodInfoData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/30.0) FROM project_food_house "
			+ "WHERE type LIKE '%'||#{type}||'%'")
	public int reserveFoodTotalPage(String type);
	
	@Insert("INSERT INTO spring_reserve(rno,fno,id,rday,rtime,rinwon) "
			+ "VALUES(sr2_rno_seq.nextval,#{fno},#{id},#{rday},#{rtime},#{rinwon})")
	public void reserveInsert(ReserveVO vo);
}
