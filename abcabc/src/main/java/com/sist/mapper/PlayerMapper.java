package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface PlayerMapper {

	@Select("SELECT * FROM batter "
			+ "WHERE bno=#{bno}")
	public BatterVO batterDetailData(int bno);
	
	@Select("SELECT * FROM pitcher "
			+ "WHERE pno=#{pno}")
	public PitcherVO pitcherDetailData(int pno);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM batter")
	public int batterTotalPage();
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM pitcher")
	public int pitcherTotalPage();
	
	@Select("SELECT bno,age,game,h1,homerun,rbi,war,name,team,position,logo,image,num "
			+ "FROM (SELECT bno,age,game,h1,homerun,rbi,war,name,team,position,logo,image,rownum as num "
			+ "FROM (SELECT bno,age,game,h1,homerun,rbi,war,name,team,position,logo,image "
			+ "FROM batter ORDER BY bno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BatterVO> batterListData(@Param("start") int start,@Param("end") int end);
	
	@Select("SELECT pno,age,game,win,lose,save,hold,era,war,name,tea,logo,image,num "
			+ "FROM (SELECT pno,age,game,win,lose,save,hold,era,war,name,tea,logo,image,rownum as num "
			+ "FROM (SELECT pno,age,game,win,lose,save,hold,era,war,name,tea,logo,image "
			+ "FROM pitcher ORDER BY pno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<PitcherVO> pitcherListData(@Param("start") int start,@Param("end") int end);
}
