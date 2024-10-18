package com.sist.service;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RuleServiceImpl implements RuleService{
	@Autowired
	private RuleDAO rDao;

	@Override
	public List<RuleVO> ruleListData(int start, int end) {
		// TODO Auto-generated method stub
		return rDao.ruleListData(start, end);
	}

	@Override
	public int ruleCount() {
		// TODO Auto-generated method stub
		return rDao.ruleCount();
	}

	@Override
	public RuleVO ruleDetailData(int no) {
		// TODO Auto-generated method stub
		return rDao.ruleDetailData(no);
	}

	@Override
	public List<RuleVO> ruleFind(Map map) {
		// TODO Auto-generated method stub
		return rDao.ruleFind(map);
	}

	
	
}
