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
	public List<ScheduleVO> scheduleListData(Map map) {
		// TODO Auto-generated method stub
		return sDao.scheduleListData(map);
	}

	@Override
	public List<ScheduleVO> scheduleListMainData() {
		// TODO Auto-generated method stub
		return sDao.scheduleListMainData();
	}
}
