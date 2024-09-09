package com.sist.dao;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	
	public ReplyBoardVO boardDetailData(int no)
	{
		mapper.boardHitIncrement(no);
		return mapper.boardDetailData(no);
	}

	public ReplyBoardVO boardUpdateData(int no)
	{
		return mapper.boardDetailData(no);
	}
	
	/*
	@Select("SELECT pwd FROM spring_replyboard "
			+ "WHERE no=#{no}")
	public String boardGetPassword(int no);
	
	@Update("UPDATE spring_replyboard SET "
			+ "name=#{name},subject=#{subject},content=#{content} "
			+ "WHERE no=#{no}")
	public void boardUpdate(ReplyBoardVO vo);
	 */
	public String boardUpdate(ReplyBoardVO vo)
	{
		String result="no";
		
		String db_pwd=mapper.boardGetPassword(vo.getNo());
		if(db_pwd.equals(vo.getPwd()))
		{
			result="yes";
			mapper.boardUpdate(vo);
		}
		
		return result;
	}
	
	/*
	@Select("SELECT group_id,group_step,group_tab "
			+ "FROM spring_replyboard "
			+ "WHERE no=#{no}")
	public ReplyBoardVO boardGroupData(int no);
	
	@Update("UPDATE spring_replyboard SET "
			+ "group_step=group_step+1 "
			+ "WHERE group_id=#{group_id} "
			+ "AND group_step>#{group_step}")
	public void boardGroupStepIncrement(ReplyBoardVO vo);
	
	@Insert("INSERT INTO spring_replyboard(no,name,subject,content,pwd,"
			+ "group_id,group_step,group_tab,root) "
			+ "VALUES(srb_no_seq.nextval,#{name},#{subject},#{content},#{pwd},"
			+ "#{group_id},#{group_step},#{group_tab},#{root}")
	public void boardReplyInsert(ReplyBoardVO vo);
	
	@Update("UPDATE spring_replyboard SET "
			+ "depth=depth+1 "
			+ "WHERE no=#{no}")
	public void boardDepthIncrement(int no);
	 */
	/*	                    no   group_id  group_step  group_tab   root   depth
		AAAAA               1       1          0           0         0      2
		    => BBBBB        4       1          1           1         1      1
		        => CCCCC    5       1          2           2         4      0
		    => FFFFF        6       1          1           1         1      0
		DDDDD               2       2          0           0         0      0
		EEEEE               3       3          0           0         0      0
		
		group_id : 답변끼리 모아준다
		group_step : 답변 내 출력 순서
		group_tab : 답변 이미지 위치 지정
	 */
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class) // 트랜잭션
	// => SQL 일괄 처리
	// => before, around 등을 생략할 수 있게 해준다
	// 금융권 => 카드 결제, 포인트 등록
	// => SQL 문장의 핵심
	// DML(INSERT, UPDATE, DELETE) 여러개가 동시에 수행
	// AOP 기반으로 만들어져 있다
	// Transaction / Security => AOP가 포함
	public void boardReplyInsert(int pno,ReplyBoardVO vo)
	{
	//	try
	//	{
	//		conn.setAutoCommit(false); // around
			ReplyBoardVO pvo=mapper.boardGroupData(pno);
			mapper.boardGroupStepIncrement(pvo);
			vo.setGroup_id(pvo.getGroup_id());
			vo.setGroup_step(pvo.getGroup_step()+1);
			vo.setGroup_tab(pvo.getGroup_tab()+1);
			vo.setRoot(pno);
			mapper.boardReplyInsert(vo);
			mapper.boardDepthIncrement(pno);
	//		conn.commit();
	/*	}catch(Exception ex)
		{
			conn.rollback(); // after-throwing
		}
		finally
		{
			conn.setAutoCommit(true); // after
		} */
	}
}
