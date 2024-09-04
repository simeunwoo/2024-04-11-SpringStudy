package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.mapper.*;
import com.sist.vo.*;

public interface DataBoardMapper {

	@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
			+ "FROM (SELECT no,subject,name,regdate,hit,rownum as num "
			+ "FROM (SELECT no,subject,name,regdate,hit "
			+ "FROM spring_databoard ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{s} AND #{e}")
	public List<DataBoardVO> dataBoardListData(@Param("s") int start,@Param("e") int end);
	
	@Select("SELECT COUNT(*) FROM spring_databoard")
	public int dataBoardRowCount();
	
	@Insert("INSERT INTO spring_databoard(no,name,subject,content,pwd,"
			+ "filename,filesize,filecount) VALUES("
			+ "sd_no_seq.nextval,#{name},#{subject},#{content},#{pwd},#{filename},#{filesize},#{filecount}")
	public void dataBoardInsert(DataBoardVO vo);
	
	// 상세 보기
	@Update("UPDATE spring_databoard SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public void hitIncrement(int no);
	
	@Select("SELECT no,name,subject,content,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday,hit,"
			+ "filename,filesize,filecount "
			+ "FROM spring_databoard "
			+ "WHERE no=#{no}")
	public DataBoardVO dataBoardDetailData(int no);
	
	// 삭제하기 => 비교 (암호화 vs 실제 데이터) => match
	@Select("SELECT filename,filecount FROM spring_databoard "
			+ "WHERE no=#{no}")
	public DataBoardVO dataBoardFileInfoData(int no);
	
	@Select("SELECT pwd FROM spring_databoard "
			+ "WHERE no=#{no}")
	public String dataBoardGetPassword(int no);
	
	@Delete("DELETE FROM spring_databoard "
			+ "WHERE no=#{no}")
	public void dataBoardDelete(int no);
	
}
