package com.sist.dao;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {

	@Autowired
	private BoardMapper mapper;
	
	public List<ReplyBoardVO> boardListData(int start,int end)
	{
		return mapper.boardListData(start, end);
	}
	
	public int boardRowCount()
	{
		return mapper.boardRowCount();
	}
	
	public void boardInsert(ReplyBoardVO vo)
	{
		mapper.boardInsert(vo);
	}
}
