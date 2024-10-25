package com.sist.service;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlayerCommentServiceImpl implements PlayerCommentService {

	@Autowired
	private PlayerCommentDAO pDao;

	@Override
	public List<BatterCommentVO> batterCommentListData(Map map) {
		// TODO Auto-generated method stub
		return pDao.batterCommentListData(map);
	}

	@Override
	public int batterCommentTotalPage(Map map) {
		// TODO Auto-generated method stub
		return pDao.batterCommentTotalPage(map);
	}

	@Override
	public void batterCommentInsert(BatterCommentVO vo) {
		// TODO Auto-generated method stub
		pDao.batterCommentInsert(vo);
	}

	@Override
	public void batterCommentReplyReplyInsert(int cno, BatterCommentVO vo) {
		// TODO Auto-generated method stub
		pDao.batterCommentReplyReplyInsert(cno, vo);
	}

	@Override
	public BatterCommentVO batterCommentDeleteInfoData(int cno) {
		// TODO Auto-generated method stub
		return pDao.batterCommentDeleteInfoData(cno);
	}

	@Override
	public void batterCommentDelete(Map map) {
		// TODO Auto-generated method stub
		pDao.batterCommentDelete(map);
	}

	@Override
	public void batterReplyDecrement(int bno) {
		// TODO Auto-generated method stub
		pDao.batterReplyDecrement(bno);
	}

	@Override
	public void batterCommentUpdate(BatterCommentVO vo) {
		// TODO Auto-generated method stub
		pDao.batterCommentUpdate(vo);
	}

	@Override
	public List<PitcherCommentVO> pitcherCommentListData(Map map) {
		// TODO Auto-generated method stub
		return pDao.pitcherCommentListData(map);
	}

	@Override
	public int pitcherCommentTotalPage(Map map) {
		// TODO Auto-generated method stub
		return pDao.batterCommentTotalPage(map);
	}

	@Override
	public void pitcherCommentInsert(PitcherCommentVO vo) {
		// TODO Auto-generated method stub
		pDao.pitcherCommentInsert(vo);
	}

	@Override
	public void pitcherCommentReplyReplyInsert(int cno, PitcherCommentVO vo) {
		// TODO Auto-generated method stub
		pDao.pitcherCommentReplyReplyInsert(cno, vo);
	}

	@Override
	public PitcherCommentVO pitcherCommentDeleteInfoData(int cno) {
		// TODO Auto-generated method stub
		return pDao.pitcherCommentDeleteInfoData(cno);
	}

	@Override
	public void pitcherCommentDelete(Map map) {
		// TODO Auto-generated method stub
		pDao.pitcherCommentDelete(map);
	}

	@Override
	public void pitcherReplyDecrement(int pno) {
		// TODO Auto-generated method stub
		pDao.pitcherReplyDecrement(pno);
	}

	@Override
	public void pitcherCommentUpdate(PitcherCommentVO vo) {
		// TODO Auto-generated method stub
		pDao.pitcherCommentUpdate(vo);
	}
	
	
}
