package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
// VO => Mapper => DAO => Controller => JSP
/*
 * 	SELECT : 데이터 검색
 * 	1) 컬럼 대신 사용
 * 		=> SELECT ~ (SELECT ~) => 스칼라 서브쿼리
 * 	2) 테이블 대신 사용
 * 		=> FROM (SELECT ~) => 인라인뷰 (페이징)
 * 	3) 조건문에서 처리 가능
 * 		=> WHERE 컬럼명 (SELECT ~) => 서브쿼리
 * 
 * 	INDEX
 * 	=> 정렬 시 속도에 최적화
 * 	=> 자동 생성 : PK, UK
 * 	=> 단점
 * 		CRUD가 많은 경우 => 속도 저하 (게시판, 댓글 등에 부적합)
 * 			=> 크롤링해서 저장된 경우 => 데이터를 갱신하지 않는다 (적합)
 */
public interface BoardMapper {

	// 자동 구현 => 리턴형 / 매개 변수
	// => 매개 변수 : #{}, ${} => WHERE 문장이 있는 경우
	// 리턴형 => 실행 후 : ROW가 여러개인 경우 => List / ROW가 한개인 경우 => VO, 일반 데이터형
	@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
			+ "FROM (SELECT no,subject,name,regdate,hit,rownum as num "
			+ "FROM (SELECT no,subject,name,regdate,hit "
			+ "FROM vue_board ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(@Param("start") int start,@Param("end") int end);
	
	@Select("SELECT COUNT(*) FROM vue_board") // 게시판, 댓글 등은 CEIL보다는 COUNT가 더 좋다
	public int boardTotalPage();
	
	// 글 쓰기
	@Insert("INSERT INTO vue_board(no,name,subject,content,pwd) "
			+ "VALUES(vb_no_seq.nextval,#{name},#{subject},#{content},#{pwd})")
	public void boardInsert(BoardVO vo);
	
	// 내용 보기
	@Update("UPDATE vue_board SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public void boardHitIncrement(int no);
	
	@Select("SELECT no,name,subject,content,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday,hit "
			+ "FROM vue_board "
			+ "WHERE no=#{no}")
	public BoardVO boardDetailData(int no);
	
	// 삭제
	
	// 비밀 번호 검색
	@Select("SELECT pwd FROM vue_board "
			+ "WHERE no=#{no}")
	public String boardGetPassword(int no);
	
	// 실제 삭제
	@Delete("DELETE FROM vue_board "
			+ "WHERE no=#{no}")
	public void boardDelete(int no);
}
