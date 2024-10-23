package com.sist.dao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ScheduleDAO {

	@Autowired
	private ScheduleMapper mapper;
	
	public List<ScheduleVO> scheduleListData(Map map)
	{
		return mapper.scheduleListData(map);
	}
	
	
	
	public List<ScheduleVO> scheduleListMainData()
	{
		return mapper.scheduleListMainData();
	}
}