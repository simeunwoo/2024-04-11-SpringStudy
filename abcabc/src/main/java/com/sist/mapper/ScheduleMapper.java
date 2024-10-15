package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface ScheduleMapper {

	@Select("SELECT * FROM schedule "
			+ "WHERE month=#{month} AND day=#{day}")
	public List<ScheduleVO> scheduleListData(@Param("month") int month, @Param("day") int day);

	@Select("SELECT CEIL(COUNT(*)/10.0) FROM schedule "
			+ "WHERE month=#{month} AND day=#{day}")
	public int scheduleTotalPage(@Param("month") int month, @Param("day") int day);
}
