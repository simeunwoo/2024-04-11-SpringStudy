package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Service
public class HotelCommentServiceImpl implements HotelCommentService{
     @Autowired
     private HotelCommentDAO cDao;

	@Override
	public List<HotelCommentVO> commentListData(Map map) {
		// TODO Auto-generated method stub
		return cDao.commentListData(map);
	}
	
	@Override
	public int commentTotalPage(Map map) {
		// TODO Auto-generated method stub
		return cDao.commentTotalPage(map);
	}

	@Override
	public void commentInsert(HotelCommentVO vo) {
		// TODO Auto-generated method stub
		cDao.commentInsert(vo);
	}
    
	@Override
	public void commentReplyReplyInsert(int cno, HotelCommentVO vo) {
		// TODO Auto-generated method stub
		cDao.commentReplyReplyInsert(cno, vo);
	}

	@Override
	public HotelCommentVO commentDeleteInfoData(int cno) {
		// TODO Auto-generated method stub
		return cDao.commentDeleteInfoData(cno);
	}

	@Override
	public void commentDelete(Map map) {
		// TODO Auto-generated method stub
		cDao.commentDelete(map);
	}

	@Override
	public void hotelReplyDecrement(int hno) {
		// TODO Auto-generated method stub
		cDao.hotelReplyDecrement(hno);
	}

	@Override
	public void commentUpdate(HotelCommentVO vo) {
		// TODO Auto-generated method stub
		cDao.commentUpdate(vo);
	}
	  
  
}
