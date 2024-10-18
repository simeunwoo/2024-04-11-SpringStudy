package com.sist.service;
import java.util.*;

import org.springframework.stereotype.Service;

import com.sist.vo.*;


public interface BoardService {
	public List<BoardVO> boardListData(int start,int end);
	public int boardCount();
	public void boardInsert(BoardVO vo);
	public BoardVO boardDetailData(int no);
	public void boardDelete(int no);
	public BoardVO boardUpdateData(int no);
	public void boardUpdate(BoardVO vo);
}
