package com.sist.mapper;
import java.util.*;
import com.sist.vo.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BoardMapper {
	  @Select("SELECT no, id, subject, name, TO_CHAR(regdate,'yyyy-mm-dd') as dbday,hit,num "
			 +"FROM (SELECT no, id, subject, name, regdate,hit,rownum as num "
			 +"FROM (SELECT no, id, subject, name, regdate, hit "
			 +"FROM kboard ORDER BY no DESC)) "
			 +"WHERE num BETWEEN #{start} AND #{end}")
	  public List<BoardVO> boardListData(@Param("start") int start,@Param("end") int end);
	  
	  @Select("SELECT COUNT(*) FROM kboard")
	  public int boardCount();

	  
	  
	  @Insert("INSERT INTO kboard VALUES("
				 +"kb_no_seq.nextval,#{id},#{name},#{subject}, #{content},  "
				 +"SYSDATE,0)")
	  public void boardInsert(BoardVO vo);

	  
	  
	  @Update("UPDATE kboard SET "
			 +"hit=hit+1 "
			 +"WHERE no=#{no}")
	  public void hitIncrement(int no);

	  
	  
	  @Select("SELECT no, id, name, subject, content, TO_CHAR(regdate,'yyyy-mm-dd hh24:mi:ss') as dbday, hit "
			 +"FROM kboard "
			 +"WHERE no=#{no}")
	  public BoardVO boardDetailData(int no);
	  


	  @Delete("DELETE FROM kboard "
			 +"WHERE no=#{no}")
	  public void boardDelete(int no);
	  

	  
	  @Select("SELECT no,subject,content FROM kboard "
				 +"WHERE no=#{no}")
	  public BoardVO boardUpdateData(int no);
	  
	  @Update("UPDATE kboard SET "
			 +"subject=#{subject}, "
			 +"content=#{content} "
			 +"WHERE no=#{no}")
	  public void boardUpdate(BoardVO vo);
	    
}