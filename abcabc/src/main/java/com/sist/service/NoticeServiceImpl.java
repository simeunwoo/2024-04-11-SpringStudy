package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;
@Service
public class NoticeServiceImpl implements NoticeService{
    @Autowired
    private NoticeDAO nDao;

	@Override
	public List<NoticeVO> noticeListData(int start, int end) {
		// TODO Auto-generated method stub
		return nDao.noticeListData(start, end);
	}
	
	@Override
	public int noticeRowCount() {
		// TODO Auto-generated method stub
		return nDao.noticeRowCount();
	}
	
	@Override
	public void noticeInsert(NoticeVO vo) {
		// TODO Auto-generated method stub
		nDao.noticeInsert(vo);
	}

	@Override
	public NoticeVO noticeDetailData(int no) {
		// TODO Auto-generated method stub
		return nDao.noticeDetailData(no);
	}

	@Override
	public void noticeDelete(int no) {
		// TODO Auto-generated method stub
		nDao.noticeDelete(no);
	}

	@Override
	public NoticeVO noticeUpdateData(int no) {
		// TODO Auto-generated method stub
		return nDao.noticeUpdateData(no);
	}

	@Override
	public void noticeUpdate(NoticeVO vo) {
		// TODO Auto-generated method stub
		nDao.noticeUpdate(vo);
	}
   
    /*
     *   JSP => .do
     *    |
     *   Controller 
     *    |
     *   Mapper
     *    | 
     *   DAO
     *    |
     *   Service 
     *    |
     *   ServiceImpl
     */
}