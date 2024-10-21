package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
public interface NoticeMapper {
  @Results({
	  @Result(property="avo.authority",column="authority")
  })
  @Select("SELECT no,subject,id,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,authority,num "
		 +"FROM (SELECT no,subject,id,name,regdate,hit,authority,rownum as num "
		 +"FROM (SELECT no,subject,id,name,regdate,hit,authority "
		 +"FROM notice_board nb,authority au "
		 +"WHERE nb.id=au.userId "
		 +"ORDER BY no DESC)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<NoticeVO> noticeListData(@Param("start") int start,@Param("end") int end);
  
  @Select("SELECT COUNT(*) FROM notice_board")
  public int noticeRowCount();
  
  // 수정 / 삭제 / 추가 / 상세보기 => 여러개를 동시에 처리 방법 
  @Insert("INSERT INTO notice_board VALUES("
		 +"sf_no_seq.nextval,'hong','홍길동',#{subject},#{content},"
		 +"SYSDATE,0)")
  public void noticeInsert(NoticeVO vo);
  
  // 상세 보기 
  @Update("UPDATE notice_board SET "
		 +"hit=hit+1 "
		 +"WHERE no=#{no}")
  public void hitIncrement(int no);
  
  @Select("SELECT no,id,name,subject,content,"
		 +"TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday,hit "
		 +"FROM notice_board "
		 +"WHERE no=#{no}")
  public NoticeVO noticeDetailData(int no);
  
  // 삭제
  @Delete("DELETE FROM notice_board "
		 +"WHERE no=#{no}")
  public void noticeDelete(int no);
  
  // 수정 
  @Select("SELECT no,subject,content FROM notice_board "
		 +"WHERE no=#{no}")
  public NoticeVO noticeUpdateData(int no);
  
  @Update("UPDATE notice_board SET "
		 +"subject=#{subject},content=#{content} "
		 +"WHERE no=#{no}")
  public void noticeUpdate(NoticeVO vo);
}