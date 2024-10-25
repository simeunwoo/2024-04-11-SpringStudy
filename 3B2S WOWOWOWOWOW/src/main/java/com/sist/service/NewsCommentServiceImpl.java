package com.sist.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Service
public class NewsCommentServiceImpl implements NewsCommentService{
    @Autowired
    private NewsCommentDAO nDao;

	@Override
	public List<NewsCommentVO> newsCommentListData(Map map) {
		// TODO Auto-generated method stub
		return nDao.newsCommentListData(map);
	}

	@Override
	public int newsCommentTotalPage(Map map) {
		// TODO Auto-generated method stub
		return nDao.newsCommentTotalPage(map);
	}

	@Override
	public void newsCommentInsert(NewsCommentVO vo) {
		// TODO Auto-generated method stub
		nDao.newsCommentInsert(vo);
	}

	@Override
	public void newsCommentReplyReplyInsert(int cno, NewsCommentVO vo) {
		// TODO Auto-generated method stub
		nDao.newsCommentReplyReplyInsert(cno, vo);
	}

	@Override
	public NewsCommentVO newsCommentDeleteInfoData(int cno) {
		// TODO Auto-generated method stub
		return nDao.newsCommentDeleteInfoData(cno);
	}

	@Override
	public void newsCommentDelete(Map map) {
		// TODO Auto-generated method stub
		nDao.newsCommentDelete(map);
	}

	@Override
	public void newsReplyDecrement(int nno) {
		// TODO Auto-generated method stub
		nDao.newsReplyDecrement(nno);
	}

	@Override
	public void newsCommentUpdate(NewsCommentVO vo) {
		// TODO Auto-generated method stub
		nDao.newsCommentUpdate(vo);
	}
    
}
