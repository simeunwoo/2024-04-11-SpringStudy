package com.sist.service;
import com.sist.vo.*;
import java.util.*;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface PlayerCommentService {

	public List<BatterCommentVO> batterCommentListData(Map map);
	public int batterCommentTotalPage(Map map);
	public void batterCommentInsert(BatterCommentVO vo);
	public void batterCommentReplyReplyInsert(int cno,BatterCommentVO vo);
	public BatterCommentVO batterCommentDeleteInfoData(int cno);
	public void batterCommentDelete(Map map);
	public void batterReplyDecrement(int bno);
	public void batterCommentUpdate(BatterCommentVO vo);
	public List<PitcherCommentVO> pitcherCommentListData(Map map);
	public int pitcherCommentTotalPage(Map map);
	public void pitcherCommentInsert(PitcherCommentVO vo);
	public void pitcherCommentReplyReplyInsert(int cno,PitcherCommentVO vo);
	public PitcherCommentVO pitcherCommentDeleteInfoData(int cno);
	public void pitcherCommentDelete(Map map);
	public void pitcherReplyDecrement(int pno);
	public void pitcherCommentUpdate(PitcherCommentVO vo);
}
