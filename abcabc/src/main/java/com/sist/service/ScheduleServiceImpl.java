package com.sist.service;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private ScheduleDAO sDao;

	@Override
	public List<ScheduleVO> scheduleListData(int month, int day) {
		// TODO Auto-generated method stub
		return sDao.scheduleListData(month, day);
	}

	@Override
	public int scheduleTotalPage(int month, int day) {
		// TODO Auto-generated method stub
		return sDao.scheduleTotalPage(month, day);
	}
}
