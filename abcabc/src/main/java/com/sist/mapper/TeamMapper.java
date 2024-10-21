package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.sist.vo.*;

public interface TeamMapper {

	@Select("SELECT name,syear,home,logo "
			+ "FROM teamdetail "
			+ "ORDER BY name ASC")
	public List<TeamDetailVO> teamListData();
	
//	@Select("SELECT * FROM teamdetail "
//			+ "WHERE name=#{name}")
//	public TeamDetailVO teamDetailData(String name);
/*
CREATE OR REPLACE PROCEDURE teamDetailData(
    pName IN VARCHAR2,
    pResult OUT SYS_REFCURSOR
) AS
BEGIN
    OPEN pResult FOR
    SELECT name, syear, content, winyear, home, dyear, oldteam, logo, rno, mascot, mimage, star
    FROM teamdetail
    WHERE name = pName;
END;
/
 */
	
	
	@Select("SELECT * FROM teamdetail "
			+ "WHERE name=#{name}")
	public TeamDetailVO teamDetailData(String name);
	
	@Select("SELECT * FROM team ORDER BY no ASC")
	public List<TeamVO> teamRankingData();
/*
@Results({
	   @Result(property = "no",column = "no"),
	   @Result(property = "title",column = "title"),
	   @Result(property = "poster",column = "poster"),
	   @Result(property = "address",column = "address"),
	   @Result(property = "msg",column = "msg")
   })
   @Select(value="{CALL seoulShopDetailData(#{pNo,javaType=java.lang.Integer,mode=IN},"
                +"#{pResult,mode=OUT,jdbcType=CURSOR,resultMap=seoulMap})}")
   @Options(statementType = StatementType.CALLABLE)
   public SeoulVO seoulShopDetailData(Map map);
   
   SELECT no,title,poster,address,msg
		    FROM project_seoul_shop
 */
	
	@Select("SELECT ranking,team,win,draw,lose,cha,winper,logo "
			+ "FROM team "
			+ "WHERE year='2024' "
			+ "ORDER BY no ASC")
	public List<TeamVO> teamRankingMainData();
}