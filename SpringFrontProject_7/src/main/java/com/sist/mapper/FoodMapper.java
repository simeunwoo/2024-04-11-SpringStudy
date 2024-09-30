package com.sist.mapper;
import java.util.*;
import com.sist.vo.*;
import org.apache.ibatis.annotations.*;

public interface FoodMapper {

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
	
	// 로그인
	@Select("SELECT COUNT(*) FROM project_member "
			+ "WHERE id=#{id}")
	public int memberIdCheck(String id);
	
	@Select("SELECT id,name,sex,pwd "
			+ "FROM project_member "
			+ "WHERE id=#{id}")
	public MemberVO memberGetInfoData(String id);
}