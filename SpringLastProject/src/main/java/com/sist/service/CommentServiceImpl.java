package com.sist.service;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO cDao;
	
	@Override
	public List<CommentVO> commentListData(Map map) {
		// TODO Auto-generated method stub
		return cDao.commentListData(map);
	}

	@Override
	public int commentTotalPage(Map map) {
		// TODO Auto-generated method stub
		return cDao.commentTotalPage(map);
	}

	@Override
	public void commentInsert(CommentVO vo) {
		// TODO Auto-generated method stub
		cDao.commentInsert(vo);
	}

	@Override
	public void commentReplyReplyInsert(int cno, CommentVO vo) {
		// TODO Auto-generated method stub
		cDao.commentReplyReplyInsert(cno, vo);
	}

	@Override
	public CommentVO commentDeleteInfoData(int cno) {
		// TODO Auto-generated method stub
		return cDao.commentDeleteInfoData(cno);
	}

	@Override
	public void commentDelete(Map map) {
		// TODO Auto-generated method stub
		cDao.commentDelete(map);
	}

}
