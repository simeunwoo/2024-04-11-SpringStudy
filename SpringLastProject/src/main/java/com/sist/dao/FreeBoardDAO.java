package com.sist.dao;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// 형식 동일 => 마이 페이지, 관리자 페이지에서 여러개를 동시에 삭제
@Repository
public class FreeBoardDAO {

	@Autowired
	private FreeBoardMapper mapper;
	
	public List<FreeBoardVO> freeboardListData(int start,int end)
	{
		return mapper.freeboardListData(start, end);
	}
	
	public int freeboardRowCount()
	{
		return mapper.freeboardRowCount();
	}
	
	public void freeboardInsert(FreeBoardVO vo)
	{
		mapper.freeboardInsert(vo);
	}
	
	public FreeBoardVO freeboardDetailData(int no)
	{
		mapper.freeboardHitIncrement(no);
		return mapper.freeboardDetailData(no);
	}
}
