package com.sist.service;
import java.util.*;
import com.sist.vo.*;

public interface ScheduleService {

	public List<ScheduleVO> scheduleListData(int month,int day);
	public int scheduleTotalPage(int month, int day);
}
