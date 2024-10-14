package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
	
	// 마이 페이지 출력
	@Results({
		@Result(property="fvo.poster",column="poster"),
		@Result(property="fvo.name",column="name")
	})
	@Select("SELECT rno,sr.fno,poster,name,rday,rtime,rinwon,TO_CHAR(regdate,'YYYY-MM-DD') as dbday "
			+ "FROM spring_reserve sr,project_food_house pf "
			+ "WHERE sr.fno=pf.fno "
			+ "AND id=#{id} "
			+ "ORDER BY rno DESC")
	public List<ReserveVO> reserveMyPageListData(String id);
	
	// 관리자 페이지 출력
	@Results({
		@Result(property="fvo.poster",column="poster"),
		@Result(property="fvo.name",column="name")
	})
	@Select("SELECT rno,sr.fno,id,poster,name,rday,rtime,rinwon,TO_CHAR(regdate,'YYYY-MM-DD') as dbday "
			+ "FROM spring_reserve sr,project_food_house pf "
			+ "WHERE sr.fno=pf.fno "
			+ "ORDER BY rno DESC") // 관리자는 id가 따로 필요 없다
	public List<ReserveVO> reserveAdminListData();
	
	@Update("UPDATE spring_reserve SET "
			+ "isReserve=1 "
			+ "WHERE rno=#{rno}")
	public void reserveOk(int rno); 
}
