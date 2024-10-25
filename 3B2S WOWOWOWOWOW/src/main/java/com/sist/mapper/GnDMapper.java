package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.sist.vo.*;

public interface GnDMapper {
	/*
   @Select("SELECT ino,image,content,team,num "
         + "  FROM (SELECT ino,image,content,team,rownum as num "
         + "          FROM (SELECT ino,image,content,team "
         + "                  FROM gnd ORDER BY ino asc )) "
         + "  WHERE num BETWEEN #{start} AND #{end}")
   public List<GnDVO> gndListData(@Param("start") int start , @Param("end") int end);
   
   @Select("SELECT CEIL(COUNT(*)/10) FROM gnd ")
   public int gndTotalPage();
   */
   
   
	@Results({
		   @Result(property="ino",column="ino"),
		   @Result(property="image",column="image"),
		   @Result(property="content",column="content"),
		   @Result(property="team",column="team")
		})
		@Select(value="{CALL gndListData(#{pStart,mode=IN,javaType=java.lang.Integer},"
		        + "#{pEnd,mode=IN,javaType=java.lang.Integer},"
		        + "#{pResult,mode=OUT,jdbcType=CURSOR,resultMap=gndMap})}")
		@Options(statementType = StatementType.CALLABLE)
		public List<GnDVO> gndListData(Map map);
   
   @Results({
	   @Result(property="ino",column="ino"),
	   @Result(property="image",column="image"),
	   @Result(property="content",column="content"),
	   @Result(property="team",column="team")
   })
   @Select(value = "{CALL gndTeamListData("
	        + "#{pTeam, mode=IN, javaType=java.lang.String},"
	        + "#{pStart, mode=IN, javaType=java.lang.Integer},"
	        + "#{pEnd, mode=IN, javaType=java.lang.Integer},"
	        + "#{pResult, mode=OUT, jdbcType=CURSOR, resultMap=gndMap})}")
	@Options(statementType = StatementType.CALLABLE)
	public List<GnDVO> gndTeamListData(Map<String, Object> map);
   
   public int gndTotalPage();
   public int gndTeamTotalPage(String team);
   
   
   
   
}
