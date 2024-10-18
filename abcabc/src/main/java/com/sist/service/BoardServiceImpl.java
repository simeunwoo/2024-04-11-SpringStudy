package com.sist.service;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO bDao;

	@Override
	public List<BoardVO> boardListData(int start, int end) {
		// TODO Auto-generated method stub
		return bDao.boardListData(start, end);
	}

	@Override
	public int boardCount() {
		// TODO Auto-generated method stub
		return bDao.boardCount();
	}

	@Override
	public void boardInsert(BoardVO vo) {
		// TODO Auto-generated method stub
		bDao.boardInsert(vo);
	}

	@Override
	public BoardVO boardDetailData(int no) {
		// TODO Auto-generated method stub
		return bDao.boardDetailData(no);
	}

	@Override
	public void boardDelete(int no) {
		// TODO Auto-generated method stub
		bDao.boardDelete(no);
	}

	@Override
	public BoardVO boardUpdateData(int no) {
		// TODO Auto-generated method stub
		return bDao.boardUpdateData(no);
	}

	@Override
	public void boardUpdate(BoardVO vo) {
		// TODO Auto-generated method stub
		bDao.boardUpdate(vo);
	}

	
}
