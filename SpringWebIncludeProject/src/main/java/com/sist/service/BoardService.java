package com.sist.service;
import java.util.*;
import com.sist.vo.*;
/*
	Controller ===> Service ===> Repository ===> Oracle
	                             -----------------------
	                             수정
	Service 존재 목적 : 유지 보수를 더 편리하게 하기 위하여
 */
public interface BoardService {

	public List<ReplyBoardVO> boardListData(int start,int end);
	public int boardRowCount();
	public void boardInsert(ReplyBoardVO vo);
	public ReplyBoardVO boardDetailData(int no);
	public ReplyBoardVO boardUpdateData(int no);
	public String boardUpdate(ReplyBoardVO vo);
}
