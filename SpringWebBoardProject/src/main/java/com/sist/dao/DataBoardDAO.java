package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository
public class DataBoardDAO {

	@Autowired
	private DataBoardMapper mapper;
	
	/*
	@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
			+ "FROM (SELECT no,subject,name,regdate,hit,rownum as num "
			+ "FROM (SELECT no,subject,name,regdate,hit "
			+ "FROM spring_board ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{s} AND #{e}")
	public List<DataBoardVO> dataBoardListData(@Param("s") int start,@Param("e") int end);
	
	@Select("SELECT COUNT(*) FROM spring_databoard")
	public int dataBoardRowCount();
	
	@Insert("INSERT INTO spring_databoard(no,name,subject,content,pwd,"
			+ "filename,filesize,filecount) VALUES("
			+ "sd_no_seq.nextval,#{name},#{subject},#{content},#{pwd},#{filename},#{filesize},#{filecount}")
	public void dataBoardInsert(DataBoardVO vo);
	 */
	public List<DataBoardVO> dataBoardListData(int start,int end)
	{
		return mapper.dataBoardListData(start, end);
	}
	public int dataBoardRowCount()
	{
		return mapper.dataBoardRowCount();
	}
	
	public void dataBoardInsert(DataBoardVO vo)
	{
		mapper.dataBoardInsert(vo);
	}
	
	/*
	@Update("UPDATE spring_databoard SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public void hitIncrement(int no);
	
	@Select("SELECT no,name,subject,content,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday,hit,"
			+ "filename,filesize,filecount "
			+ "FROM spring_databoard "
			+ "WHERE no=#{no}")
	public DataBoardVO dataBoardDetailData(int no);
	 */
	public DataBoardVO dataBoardDetailData(int no)
	{
		mapper.hitIncrement(no);
		return mapper.dataBoardDetailData(no);
	}
	
	/*
	@Select("SELECT filename,filecount FROM spring_databoard "
			+ "WHERE no=#{no}")
	public DataBoardVO dataBoardFileInfoData(int no);
	
	@Select("SELECT pwd FROM spring_databoard "
			+ "WHERE no=#{no}")
	public String dataBoardGetPassword(int no);
	
	@Delete("DELETE FROM spring_databoard "
			+ "WHERE no=#{no}")
	public void dataBoardDelete(int no);
	 */
	public DataBoardVO dataBoardFileInfoData(int no)
	{
		return mapper.dataBoardFileInfoData(no);
	}
	public boolean databoardDelete(int no,String pwd) // no : 사용자가 보내준 값, pwd : DB에 있는 값
	{
		boolean bCheck=false;
		String db_pwd=mapper.dataBoardGetPassword(no);
		
		// 복호화 => 원상 복귀
		
		return bCheck;
	}
}
