package com.sist.mapper;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface ScheduleMapper {
/*
	@Select("SELECT sno,day,home,away,homescore,awayscore,month,rownum as num "
			+ "FROM (SELECT sno,day,home,away,homescore,awayscore,month "
			+ "FROM schedule "
			+ "WHERE month=#{month} AND day=#{day} "
			+ "ORDER BY sno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<ScheduleVO> scheduleListData(Map map); */
	@Select("SELECT * "
			+"FROM(SELECT sno,day,home,away,homescore,awayscore,month,homeimage,awayimage,"
				+"rownum as num "
			+"FROM(SELECT sno,day,home,away,homescore,awayscore,month,homeimage,awayimage " 
			+"FROM schedule " 
			+"WHERE month=#{month} AND day=#{day} "
			+"ORDER BY sno) "
			+"WHERE ROWNUM <= #{end}) "
			+"WHERE num >= #{start}")
	public List<ScheduleVO> scheduleListData(Map map);

	@Select("SELECT COUNT(*) FROM schedule "
			+ "WHERE month=#{month} AND day=#{day}")
	public int scheduleRowCount(Map map);
}
