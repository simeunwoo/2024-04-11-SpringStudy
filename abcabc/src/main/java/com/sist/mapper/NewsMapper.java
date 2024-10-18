package com.sist.mapper;

import java.util.*;
import com.sist.vo.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface NewsMapper {
	 @Select("SELECT nno,title,author,poster,content,time,likecount,hit,num "
			 +"FROM (SELECT nno,title,author,poster,content,time,likecount,hit,rownum as num "
			 +"FROM (SELECT nno,title,author,poster,content,time,likecount,hit "
			 +"FROM news "
			 +"WHERE title LIKE '%'||#{nd}||'%' "
			 +"OR content LIKE '%'||#{nd}||'%' ORDER BY nno ASC)) "
			 +"WHERE num BETWEEN #{start} AND #{end}")
	  public List<NewsVO> newsListData(Map map);
	  // 총페이지
	  @Select("SELECT CEIL(COUNT(*)/12.0) FROM news "
			 +"WHERE title LIKE '%'||#{nd}||'%'")
	  public int newsTotalPage(Map map);
	  // 상세보기
	  @Update("UPDATE news SET "
			 +"hit=hit+1 "
			 +"WHERE nno=#{nno}")
	  public void hitIncrement(int nno);
	   
	  @Select("SELECT * FROM news "
			 +"WHERE nno=#{nno}")
	  public NewsVO newsDetailData(int nno);
	  
	  @Select("SELECT nno,title,rownum "
			 +"FROM (SELECT nno,title "
			 +"FROM news ORDER BY hit DESC) "
			 +"WHERE rownum<=8")
	  public List<NewsVO> newsHitTop8();
}