package com.sist.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.vo.*;
import com.sist.dao.*;

@Service
public class FreeBoardServiceImpl implements FreeBoardService {

	@Autowired
	private FreeBoardDAO fbDAO;
	
	@Override
	public List<FreeBoardVO> freeboardListData(int start, int end) {
		// TODO Auto-generated method stub
		return fbDAO.freeboardListData(start, end);
	}

	@Override
	public int freeboardRowCount() {
		// TODO Auto-generated method stub
		return fbDAO.freeboardRowCount();
	}

	@Override
	public void freeboardInsert(FreeBoardVO vo) {
		// TODO Auto-generated method stub
		fbDAO.freeboardInsert(vo);
	}

	@Override
	public FreeBoardVO freeboardDetailData(int no) {
		// TODO Auto-generated method stub
		return fbDAO.freeboardDetailData(no);
	}

	@Override
	public void freeboardDelete(int no) {
		// TODO Auto-generated method stub
		fbDAO.freeboardDelete(no);
	}

	@Override
	public FreeBoardVO freeboardUpdateData(int no) {
		// TODO Auto-generated method stub
		return fbDAO.freeboardUpdateData(no);
	}

	@Override
	public void freeboardUpdate(FreeBoardVO vo) {
		// TODO Auto-generated method stub
		fbDAO.freeboardUpdate(vo);
	}

	/*
	 * 	JSP => .do
	 * 	|
	 * 	Controller
	 * 	|
	 * 	Mapper
	 * 	|
	 * 	DAO
	 * 	|
	 * 	Service
	 * 	|
	 * 	ServiceImpl
	 */
}
