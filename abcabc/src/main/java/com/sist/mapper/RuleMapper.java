package com.sist.mapper;
import java.util.*;
import com.sist.vo.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface RuleMapper {
	  @Select("SELECT no, subject, content, TO_CHAR(regdate,'yyyy-mm-dd') as dbday,hit,num "
			 +"FROM (SELECT no, subject, content, regdate,hit,rownum as num "
			 +"FROM (SELECT no, subject, content, regdate, hit "
			 +"FROM rule ORDER BY no DESC)) "
			 +"WHERE num BETWEEN #{start} AND #{end}")
	  public List<RuleVO> ruleListData(@Param("start") int start,@Param("end") int end);
	  
	  @Select("SELECT COUNT(*) FROM rule")
	  public int ruleCount();

	  
	  @Update("UPDATE rule SET "
			 +"hit=hit+1 "
			 +"WHERE no=#{no}")
	  public void hitIncrement(int no);

	  
	  @Select("SELECT no, subject, content, hit, num "
				 +"FROM (SELECT no, subject, content, hit, rownum as num "
				 +"FROM (SELECT no, subject, content, hit "
				 +"FROM rule "
				 +"WHERE subject LIKE '%'||#{rs}||'%' "
				 +"ORDER BY no ASC)) "
				 +"WHERE num BETWEEN #{start} AND #{end}")
	  public List<RuleVO> ruleFind(Map map);
	  
	  
	  @Select("SELECT no, subject, content, TO_CHAR(regdate,'yyyy-mm-dd hh24:mi:ss') as dbday, hit "
			 +"FROM rule "
			 +"WHERE no=#{no}")
	  public RuleVO ruleDetailData(int no);
	  

	  /*
	  @Insert("INSERT INTO kboard VALUES("
			  +"kb_no_seq.nextval,#{id},#{subject},#{name}, #{content},"
			  +"SYSDATE,0)")
	  public void boardInsert(BoardVO vo);

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
	  */
}