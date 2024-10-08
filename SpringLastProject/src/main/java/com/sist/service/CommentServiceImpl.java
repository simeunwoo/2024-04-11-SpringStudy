package com.sist.service;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.vo.CommentVO;

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
	public int commentTotalPage(int rno) {
		// TODO Auto-generated method stub
		return cDao.commentTotalPage(rno);
	}

}
