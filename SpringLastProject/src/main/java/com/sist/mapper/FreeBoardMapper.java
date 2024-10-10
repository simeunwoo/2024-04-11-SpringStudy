package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface FreeBoardMapper {

	@Select("SELECT no,subject,id,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,num "
			+ "FROM (SELECT no,subject,id,name,regdate,rownum as num "
			+ "FROM (SELECT no,subject,id,name,regdate "
			+ "FROM spring_freeboard ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FreeBoardVO> freeboardListData(@Param("start") int start,@Param("end") int end);
	
	@Select("SELECT COUNT(*) FROM spring_freeboard")
	public int freeboardRowCount();
	
	// 수정 / 삭제 / 추가 / 상세 보기 => 여러개를 동시에 처리하는 방법
	@Insert("INSERT INTO spring_freeboard "
			+ "VALUES(sf_no_seq.nextval,#{id},#{name},#{subject},#{content},SYSDATE,0)")
	public void freeboardInsert(FreeBoardVO vo);
}
