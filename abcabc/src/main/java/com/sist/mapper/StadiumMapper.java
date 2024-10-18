package com.sist.mapper;

import java.util.*;
import com.sist.vo.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface StadiumMapper {
	  @Select("SELECT no,name,seat,inwon,poster,content,location,address,hometeam,openyear,num "
			 +"FROM (SELECT no,name,seat,inwon,poster,content,location,address,hometeam,openyear,rownum as num "
			 +"FROM (SELECT no,name,seat,inwon,poster,content,location,address,hometeam,openyear "
			 +"FROM stadium ORDER BY no ASC)) "
			 +"WHERE num BETWEEN #{start} AND #{end}")
	  public List<StadiumVO> stadiumListData(@Param("start") int start,@Param("end") int end);
	  // 총페이지
	  @Select("SELECT CEIL(COUNT(*)/9.0) FROM stadium")
	  public int stadiumTotalPage();
	  // 상세보기
	  @Select("SELECT * FROM stadium "
			  +"WHERE no=#{no}")
	  public StadiumVO stadiumDetailData(int no);
}
