package com.sist.dao;
import com.sist.vo.*;
import com.sist.mapper.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PlayerCommentDAO {

	@Autowired
	private PlayerCommentMapper cMapper;
	
	public List<BatterCommentVO> batterCommentListData(Map map)
	{
		return cMapper.batterCommentListData(map);
	}
	
	public int batterCommentTotalPage(Map map)
	{
		return cMapper.batterCommentTotalPage(map);
	}
	
	public void batterCommentInsert(BatterCommentVO vo)
	{
		cMapper.batterReplyIncrement(vo.getRno());
		cMapper.batterCommentInsert(vo);
	}
	
	// 일괄 처리
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void batterCommentReplyReplyInsert(int cno,BatterCommentVO vo)
	{
		cMapper.batterReplyIncrement(vo.getRno());
		
		BatterCommentVO bvo=cMapper.batterCommentParentInfoData(cno);
		vo.setGroup_id(bvo.getGroup_id());
		vo.setGroup_step(bvo.getGroup_step()+1);
		vo.setGroup_tab(bvo.getGroup_tab()+1);
		
		cMapper.batterCommentGroupStepIncrement(bvo);
		cMapper.batterCommentReplyReplyInsert(vo);
		cMapper.batterCommentDepthIncrement(cno);
	}
	
	/*
	 * 	MyBatis
	 *	CRUD => INSERT / UPDATE / DELETE / SELECT => 1차 프로젝트
	 *
	 *	Spring 내의 MyBatis
	 *	CRUD는 기본
	 *	+ JOIN / 동적 쿼리 / Transaction
	 */
	public BatterCommentVO batterCommentDeleteInfoData(int cno)
	{
		return cMapper.batterCommentDeleteInfoData(cno);
	}
	
	public void batterCommentDelete(Map map)
	{
		cMapper.batterCommentDelete(map);
	}
	
	public void batterReplyDecrement(int bno)
	{
		cMapper.batterReplyDecrement(bno);
	}
	
	public void batterCommentUpdate(BatterCommentVO vo)
	{
		cMapper.batterCommentUpdate(vo);
	}
	
	///////////////////////////////////////////////////////////////
	
	public List<PitcherCommentVO> pitcherCommentListData(Map map)
	{
		return cMapper.pitcherCommentListData(map);
	}
	
	public int pitcherCommentTotalPage(Map map)
	{
		return cMapper.pitcherCommentTotalPage(map);
	}
	
	public void pitcherCommentInsert(PitcherCommentVO vo)
	{
		cMapper.pitcherReplyIncrement(vo.getRno());
		cMapper.pitcherCommentInsert(vo);
	}
	
	// 일괄 처리
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void pitcherCommentReplyReplyInsert(int cno,PitcherCommentVO vo)
	{
		cMapper.pitcherReplyIncrement(vo.getRno());
		
		PitcherCommentVO pvo=cMapper.pitcherCommentParentInfoData(cno);
		vo.setGroup_id(pvo.getGroup_id());
		vo.setGroup_step(pvo.getGroup_step()+1);
		vo.setGroup_tab(pvo.getGroup_tab()+1);
		
		cMapper.pitcherCommentGroupStepIncrement(pvo);
		cMapper.pitcherCommentReplyReplyInsert(vo);
		cMapper.batterCommentDepthIncrement(cno);
	}
	
	/*
	 * 	MyBatis
	 *	CRUD => INSERT / UPDATE / DELETE / SELECT => 1차 프로젝트
	 *
	 *	Spring 내의 MyBatis
	 *	CRUD는 기본
	 *	+ JOIN / 동적 쿼리 / Transaction
	 */
	public PitcherCommentVO pitcherCommentDeleteInfoData(int cno)
	{
		return cMapper.pitcherCommentDeleteInfoData(cno);
	}
	
	public void pitcherCommentDelete(Map map)
	{
		cMapper.pitcherCommentDelete(map);
	}
	
	public void pitcherReplyDecrement(int pno)
	{
		cMapper.pitcherReplyDecrement(pno);
	}
	
	public void pitcherCommentUpdate(PitcherCommentVO vo)
	{
		cMapper.pitcherCommentUpdate(vo);
	}
}
