package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.sist.vo.*;

public interface PlayerMapper {

	@Select("SELECT * FROM batter "
			+ "WHERE bno=#{bno}")
	public BatterVO batterDetailData(int bno);
	
	@Select("SELECT * FROM pitcher "
			+ "WHERE pno=#{pno}")
	public PitcherVO pitcherDetailData(int pno);
	
	public int batterTotalPage(String fd);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM pitcher "
			+ "WHERE name LIKE '%'||#{fd}||'%'")
	public int pitcherTotalPage(String fd);
	
/*	@Select("SELECT bno,age,game,h1,homerun,rbi,war,name,team,position,logo,image,avg,num "
			+ "FROM (SELECT bno,age,game,h1,homerun,rbi,war,name,team,position,logo,image,avg,rownum as num "
			+ "FROM (SELECT bno,age,game,h1,homerun,rbi,war,name,team,position,logo,image,avg "
			+ "FROM batter "
			+ "WHERE name LIKE '%'||#{fd}||'%' "
			+ "ORDER BY bno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BatterVO> batterListData(Map map); */
/*
CREATE OR REPLACE PROCEDURE batterListData(
    pFd IN VARCHAR2,
    pStart IN NUMBER,
    pEnd IN NUMBER,
    pResult OUT SYS_REFCURSOR
) AS
BEGIN
    OPEN pResult FOR
    SELECT bno, age, game, h1, homerun, rbi, war, name, team, position, logo, image, avg, rownum as num
    FROM (SELECT bno, age, game, h1, homerun, rbi, war, name, team, position, logo, image, avg
          FROM batter
          WHERE name LIKE '%' || pFd || '%'
          ORDER BY bno ASC)
    WHERE rownum BETWEEN pStart AND pEnd;
END;
/
 */
	@Results({
		@Result(property="bno",column="bno"),
		@Result(property="age",column="age"),
		@Result(property="game",column="game"),
		@Result(property="h1",column="h1"),
		@Result(property="homerun",column="homerun"),
		@Result(property="rbi",column="rbi"),
		@Result(property="war",column="war"),
		@Result(property="name",column="name"),
		@Result(property="team",column="team"),
		@Result(property="position",column="position"),
		@Result(property="logo",column="logo"),
		@Result(property="image",column="image"),
		@Result(property="avg",column="avg")
	})
	@Select(value="{CALL batterListData"
			+ "(#{pFd,mode=IN,javaType=java.lang.String},"
			+ "#{pStart,mode=IN,javaType=java.lang.Integer},"
			+ "#{pEnd,mode=IN,javaType=java.lang.Integer},"
			+ "#{pResult,mode=OUT,jdbcType=CURSOR,resultMap=batterMap})}")
	@Options(statementType=StatementType.CALLABLE)
	public List<BatterVO> batterListData(Map map);

	
	@Select("SELECT pno,age,game,win,lose,save,hold,era,war,name,team,logo,image,num "
			+ "FROM (SELECT pno,age,game,win,lose,save,hold,era,war,name,team,logo,image,rownum as num "
			+ "FROM (SELECT pno,age,game,win,lose,save,hold,era,war,name,team,logo,image "
			+ "FROM pitcher "
			+ "WHERE name LIKE '%'||#{fd}||'%' "
			+ "ORDER BY pno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<PitcherVO> pitcherListData(Map map);
	
	@Select("SELECT bno,name,avg,war FROM batter")
	public List<BatterVO> batterChartData();

	@Select("SELECT pno,name,era,war FROM pitcher")
	public List<PitcherVO> pitcherChartData();
	
	@Select("Select bno,image,team,name,position "
			+ "FROM batter "
			+ "WHERE bno>=57 AND bno<=60")
	public List<BatterVO> batterListMainData();
}