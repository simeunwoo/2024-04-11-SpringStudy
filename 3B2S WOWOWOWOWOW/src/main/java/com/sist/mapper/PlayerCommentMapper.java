package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;

public interface PlayerCommentMapper {

	@Select("SELECT cno,rno,type,id,name,msg,sex,group_tab,likecount,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday,num "
			+ "FROM (SELECT cno,rno,type,id,name,msg,sex,group_tab,likecount,regdate,rownum as num "
			+ "FROM (SELECT cno,rno,type,id,name,msg,sex,group_tab,likecount,regdate "
			+ "FROM batter_comment WHERE rno=#{rno} AND type=#{type} "
			+ "ORDER BY group_id DESC,group_step ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BatterCommentVO> batterCommentListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM batter_comment "
			+ "WHERE rno=#{rno} AND type=#{type}")
	public int batterCommentTotalPage(Map map);
	
	// 댓글 입력
	@Insert("INSERT INTO batter_comment(cno,rno,id,name,sex,msg,group_id,type) "
			+ "VALUES(bc_cno_seq.nextval,#{rno},#{id},#{name},#{sex},#{msg},"
			+ "(SELECT NVL(MAX(group_id)+1,1) FROM batter_comment),#{type})")
	public void batterCommentInsert(BatterCommentVO vo);
	
	// 대댓글
	@Select("SELECT group_id,group_step,group_tab "
			+ "FROM batter_comment "
			+ "WHERE cno=#{cno}")
	public BatterCommentVO batterCommentParentInfoData(int cno);
	
	@Update("UPDATE batter_comment SET "
			+ "group_step=group_step+1 "
			+ "WHERE group_id=#{group_id} AND group_step>#{group_step}")
	public void batterCommentGroupStepIncrement(BatterCommentVO vo);
	
	@Insert("INSERT INTO batter_comment(cno,rno,id,name,sex,msg,group_id,"
			+ "group_step,group_tab,root,type) "
			+ "VALUES(bc_cno_seq.nextval,#{rno},#{id},#{name},#{sex},#{msg},"
			+ "#{group_id},#{group_step},#{group_tab},#{root},#{type})")
	public void batterCommentReplyReplyInsert(BatterCommentVO vo);
	
	@Update("UPDATE batter_comment SET "
			+ "depth=depth+1 "
			+ "WHERE cno=#{cno}")
	public void batterCommentDepthIncrement(int cno);
	
	// 삭제
	@Select("SELECT group_id,group_step "
			+ "FROM batter_comment "
			+ "WHERE cno=#{cno}")
	public BatterCommentVO batterCommentDeleteInfoData(int cno);
	
	// 동적 쿼리 => 여러개의 SQL 문장을 사용자 요청에 따라 한개의 SQL 문장으로 처리
	// 삭제 / 검색 => 관리자 모드 : 삭제 / 수정 => 체크 박스
	//             => 등급 => 동적 쿼리
	@Delete("<script>"
			+ "DELETE FROM batter_comment "
			+ "WHERE "
			+ "<if test=\"group_step==0\">"
			+ "group_id=#{group_id}"
			+ "</if> "
			+ "<if test=\"group_step!=0\">"
			+ "cno=#{cno} "
			+ "</if>"
			+ "</script>")
	public void batterCommentDelete(Map map);
	
	@Update("UPDATE batter SET "
			+ "replycount=replycount+1 "
			+ "WHERE bno=#{bno}")
	public void batterReplyIncrement(int bno);
	
	@Update("UPDATE batter SET "
			+ "replycount=replycount-1 "
			+ "WHERE bno=#{bno}")
	public void batterReplyDecrement(int bno);
	
	// 수정
	@Update("UPDATE batter_comment SET "
			+ "msg=#{msg} "
			+ "WHERE cno=#{cno}")
	public void batterCommentUpdate(BatterCommentVO vo);
	
	//////////////////////////////////////////////////////////
	
	@Select("SELECT cno,rno,type,id,name,msg,sex,group_tab,likecount,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday,num "
			+ "FROM (SELECT cno,rno,type,id,name,msg,sex,group_tab,likecount,regdate,rownum as num "
			+ "FROM (SELECT cno,rno,type,id,name,msg,sex,group_tab,likecount,regdate "
			+ "FROM pitcher_comment WHERE rno=#{rno} AND type=#{type} "
			+ "ORDER BY group_id DESC,group_step ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<PitcherCommentVO> pitcherCommentListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM pitcher_comment "
			+ "WHERE rno=#{rno} AND type=#{type}")
	public int pitcherCommentTotalPage(Map map);
	
	// 댓글 입력
	@Insert("INSERT INTO pitcher_comment(cno,rno,id,name,sex,msg,group_id,type) "
			+ "VALUES(pc2_cno_seq.nextval,#{rno},#{id},#{name},#{sex},#{msg},"
			+ "(SELECT NVL(MAX(group_id)+1,1) FROM pitcher_comment),#{type})")
	public void pitcherCommentInsert(PitcherCommentVO vo);
	
	// 대댓글
	@Select("SELECT group_id,group_step,group_tab "
			+ "FROM pitcher_comment "
			+ "WHERE cno=#{cno}")
	public PitcherCommentVO pitcherCommentParentInfoData(int cno);
	
	@Update("UPDATE pitcher_comment SET "
			+ "group_step=group_step+1 "
			+ "WHERE group_id=#{group_id} AND group_step>#{group_step}")
	public void pitcherCommentGroupStepIncrement(PitcherCommentVO vo);
	
	@Insert("INSERT INTO pitcher_comment(cno,rno,id,name,sex,msg,group_id,"
			+ "group_step,group_tab,root,type) "
			+ "VALUES(pc2_cno_seq.nextval,#{rno},#{id},#{name},#{sex},#{msg},"
			+ "#{group_id},#{group_step},#{group_tab},#{root},#{type})")
	public void pitcherCommentReplyReplyInsert(PitcherCommentVO vo);
	
	@Update("UPDATE pitcher_comment SET "
			+ "depth=depth+1 "
			+ "WHERE cno=#{cno}")
	public void pitcherCommentDepthIncrement(int cno);
	
	// 삭제
	@Select("SELECT group_id,group_step "
			+ "FROM pitcher_comment "
			+ "WHERE cno=#{cno}")
	public PitcherCommentVO pitcherCommentDeleteInfoData(int cno);
	
	// 동적 쿼리 => 여러개의 SQL 문장을 사용자 요청에 따라 한개의 SQL 문장으로 처리
	// 삭제 / 검색 => 관리자 모드 : 삭제 / 수정 => 체크 박스
	//             => 등급 => 동적 쿼리
	@Delete("<script>"
			+ "DELETE FROM pitcher_comment "
			+ "WHERE "
			+ "<if test=\"group_step==0\">"
			+ "group_id=#{group_id}"
			+ "</if> "
			+ "<if test=\"group_step!=0\">"
			+ "cno=#{cno} "
			+ "</if>"
			+ "</script>")
	public void pitcherCommentDelete(Map map);
	
	@Update("UPDATE pitcher SET "
			+ "replycount=replycount+1 "
			+ "WHERE pno=#{pno}")
	public void pitcherReplyIncrement(int pno);
	
	@Update("UPDATE pitcher SET "
			+ "replycount=replycount-1 "
			+ "WHERE pno=#{pno}")
	public void pitcherReplyDecrement(int pno);
	
	// 수정
	@Update("UPDATE pitcher_comment SET "
			+ "msg=#{msg} "
			+ "WHERE cno=#{cno}")
	public void pitcherCommentUpdate(PitcherCommentVO vo);
}
