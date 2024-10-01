package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.sist.vo.*;

public interface ReplyMapper {

	@Select("SELECT rno,fno,id,name,msg,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday "
			+ "FROM spring_reply "
			+ "WHERE fno=#{fno} ORDER BY rno DESC")
	public List<ReplyVO> replyListData(int fno);
	
	// 추가
	@SelectKey(keyProperty="rno",resultType=int.class,before=true,
			statement="SELECT NVL(MAX(rno)+1,1) as rno FROM spring_reply")
	@Insert("INSERT INTO spring_reply "
			+ "VALUES(#{rno},#{fno},#{id},#{name},#{msg},SYSDATE)")
	public void replyInsert(ReplyVO vo);
	
	// 수정
	
	// 삭제
}
