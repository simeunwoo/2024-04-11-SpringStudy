package com.sist.dao;
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
	
	public List<ScheduleVO> scheduleListData(int month, int day)
	{
		return mapper.scheduleListData(month,day);
	}
	
	public int scheduleTotalPage(int month, int day)
	{
		return mapper.scheduleTotalPage(month, day);
	}
}
