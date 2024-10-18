package com.sist.dao;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class BoardDAO {
   @Autowired
   private BoardMapper mapper;

   public List<BoardVO> boardListData(int start,int end)
   {
	   return mapper.boardListData(start, end);
   }
   public int boardCount()
   {
	   return mapper.boardCount();
   }
   public void boardInsert(BoardVO vo)
   {
	   mapper.boardInsert(vo);
   }
   
   public BoardVO boardDetailData(int no)
   {
	   mapper.hitIncrement(no);
	   return mapper.boardDetailData(no);
   }
   
   public void boardDelete(int no)
   {
	   mapper.boardDelete(no);
   }
   
   
   public BoardVO boardUpdateData(int no)
   {
	   return mapper.boardUpdateData(no);
   }
   public void boardUpdate(BoardVO vo)
   {
	   mapper.boardUpdate(vo);
   }
   
   
}