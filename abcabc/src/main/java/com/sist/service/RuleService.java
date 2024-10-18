package com.sist.service;
import java.util.*;

import org.springframework.stereotype.Service;

import com.sist.vo.*;


public interface RuleService {
	public List<RuleVO> ruleListData(int start,int end);
	public int ruleCount();
	public RuleVO ruleDetailData(int no);
	public List<RuleVO> ruleFind(Map map);
	/*
	public void ruleDelete(int no);
	public void ruleInsert(BoardVO vo);
	public RuleVO ruleUpdateData(int no);
	public void ruleUpdate(BoardVO vo);
	*/
}
