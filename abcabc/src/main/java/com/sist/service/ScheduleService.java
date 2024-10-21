package com.sist.service;
import java.util.*;
import com.sist.vo.*;

public interface ScheduleService {

	public List<ScheduleVO> scheduleListData(Map map);
	public int scheduleRowCount(Map map);
	public List<ScheduleVO> scheduleListMainData();
}
