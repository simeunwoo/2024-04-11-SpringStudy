package com.sist.dao;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {

	// 스프링으로부터 구현된 Mapper의 주소를 대입 => 요청
	@Autowired // 주소값 자동 주입 => @Autowired => 객체에만 적용된다
	// 스프링 => 클래스의 생명 주기 관리 => 주로 객체 주소 주입
	// @Autowired => 멤버 변수, 생성자, setXxx()
	// 어노테이션은 밑에 있는 변수/메소드/생성자 적용, 옆에 있는 내용을 제어
	private BoardMapper mapper;
	
	public List<BoardVO> boardListData(int start,int end)
	{
		return mapper.boardListData(start, end);
	}
	
	public int boardTotalPage()
	{
		return mapper.boardTotalPage();
	}
	
	public void boardInsert(BoardVO vo)
	{
		mapper.boardInsert(vo);
	}
	
	public BoardVO boardDetailData(int no)
	{
		mapper.boardHitIncrement(no);
		return mapper.boardDetailData(no);
	}
}
