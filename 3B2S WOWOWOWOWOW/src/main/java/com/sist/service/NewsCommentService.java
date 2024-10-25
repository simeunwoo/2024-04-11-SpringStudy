package com.sist.service;
import java.util.*;
import com.sist.vo.*;
public interface NewsCommentService {
	public List<NewsCommentVO> newsCommentListData(Map map);
	public int newsCommentTotalPage(Map map);
	public void newsCommentInsert(NewsCommentVO vo);
	public void newsCommentReplyReplyInsert(int cno,NewsCommentVO vo);
	public NewsCommentVO newsCommentDeleteInfoData(int cno);
	public void newsCommentDelete(Map map);
	//public void newsReplyIncrement(int nno);
	public void newsReplyDecrement(int nno);
	public void newsCommentUpdate(NewsCommentVO vo);
}
