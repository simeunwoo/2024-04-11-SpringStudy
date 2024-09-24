package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
// FormData
public interface DataBoardMapper {

	@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
			+ "FROM (SELECT no,subject,name,regdate,hit,rownum as num "
			+ "FROM (SELECT no,subject,name,regdate,hit "
			+ "FROM vue_databoard ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<DataBoardVO> databoardListData(@Param("start") int start,@Param("end") int end);
	
	@Select("SELECT COUNT(*) FROM vue_databoard") // 게시판, 댓글 등은 CEIL보다는 COUNT가 더 좋다
	public int databoardCount();
	
	// MyBatis에서 sequence
	@SelectKey(keyProperty="no",resultType=int.class,before=true,
			statement="SELECT NVL(MAX(no)+1,1) as no FROM vue_databoard")
	@Insert("INSERT INTO vue_databoard(no,name,subject,content,pwd,filename,filesize,filecount) "
			+ "VALUES(#{no},#{name},#{subject},#{content},#{pwd},#{filename},#{filesize},#{filecount})")
	public void databoardInsert(DataBoardVO vo);
	
	// 상세 보기
	
	// 조회수 증가
	@Update("UPDATE vue_databoard SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public void databoardHitIncrement(int no);
	
	// 게시물의 모든 데이터를 읽기
	@Select("SELECT no,name,subject,content,TO_CHAR(regdate,'yyyy-mm-dd hh24:mi:ss') as dbday,hit,filename,filesize,filecount "
			+ "FROM vue_databoard "
			+ "WHERE no=#{no}")
	public DataBoardVO databoardDetailData(int no);
}
