package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;

public interface NewsCommentMapper {
	@Select("SELECT cno,nno,type,id,name,msg,sex,group_tab,likecount,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday,num "
			 +"FROM (SELECT cno,nno,type,id,name,msg,sex,group_tab,likecount,regdate,rownum as num "
			 +"FROM (SELECT cno,nno,type,id,name,msg,sex,group_tab,likecount,regdate "
			 +"FROM news_comment WHERE nno=#{nno} AND type=#{type} "
			 +"ORDER BY group_id DESC , group_step ASC)) "
			 +"WHERE num BETWEEN #{start} AND #{end}")
	  public List<NewsCommentVO> newsCommentListData(Map map);
	  
	  @Select("SELECT CEIL(COUNT(*)/10.0) FROM news_comment "
			 +"WHERE nno=#{nno} AND type=#{type}")
	  public int newsCommentTotalPage(Map map);
	  
	  // 댓글 입력 
	  @Insert("INSERT INTO news_comment(cno,nno,id,name,sex,msg,group_id,type) "
			 +"VALUES(nc_cno_seq.nextval,#{nno},#{id},#{name},#{sex},#{msg},"
			 +"(SELECT NVL(MAX(group_id)+1,1) FROM news_comment),#{type})")
	  public void newsCommentInsert(NewsCommentVO vo);
	  
	  @Select("SELECT group_id,group_step,group_tab "
			 +"FROM news_comment "
			 +"WHERE cno=#{cno}")
	  public NewsCommentVO newsCommentParentInfoData(int cno);
	  
	  @Update("UPDATE news_comment SET "
			 +"group_step=group_step+1 "
			 +"WHERE group_id=#{group_id} AND group_step>#{group_step}")
	  public void newsCommentGroupStepIncrement(NewsCommentVO vo);
	  
	  @Insert("INSERT INTO news_comment(cno,nno,id,name,sex,msg,group_id,"
			 +"group_step,group_tab,root,type) "
		     +"VALUES(nc_cno_seq.nextval,#{nno},#{id},#{name},#{sex},"
			 +"#{msg},#{group_id},#{group_step},#{group_tab},#{root},#{type})")
	  public void newsCommentReplyReplyInsert(NewsCommentVO vo);
	  
	  @Update("UPDATE news_comment SET "
			 +"depth=depth+1 "
			 +"WHERE cno=#{cno}")
	  public void newsCommentDepthIncrement(int cno);
	  
	  // 삭제하기 
	  @Select("SELECT group_id,group_step FROM news_comment "
			 +"WHERE cno=#{cno}")
	  public NewsCommentVO newsCommentDeleteInfoData(int cno);
	  // 동적 쿼리 => 여러개의 SQL문장을 사용자 요청에 따라 한개의 SQL문장으로 처리
	  // 삭제 / 검색 => 관리자 모드 : 삭제 / 수정 => 체크박스 
	  //              => 등급 => 동적쿼리 
	  @Delete("<script>"
			 +"DELETE FROM news_comment "
			 +"WHERE "
			 +"<if test=\"group_step==0\">"
			 +"group_id=#{group_id}"
			 +"</if> "
			 +"<if test=\"group_step!=0\">"
			 +"cno=#{cno} "
			 +"</if>"
			 +"</script>"
			 )
	  public void newsCommentDelete(Map map);
	  
	  @Update("UPDATE news SET "
			 +"replycount=replycount+1 "
			 +"WHERE nno=#{nno}")
	  public void newsReplyIncrement(int nno);
	  
	  @Update("UPDATE news SET "
			 +"replycount=replycount-1 "
		     +"WHERE nno=#{nno}")
	  public void newsReplyDecrement(int nno);
	  
	  // 수정 
	  @Update("UPDATE news_comment SET "
			 +"msg=#{msg} "
			 +"WHERE cno=#{cno}")
	  public void newsCommentUpdate(NewsCommentVO vo);
}
