package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
/*
	Spring의 CRUD 제작 방법
		
		1. POM.xml => 라이브러리 첨부
		
		2. 버전 : 1.8 이상
		
		3. web.xml
			Controller 등록
			한글 변환
		
		4. 패키지
			com.sist.vo : 사용자 정의 데이터형
			com.sist.dao : 데이터 연결
			com.sist.mapper : SQL 문장 저장
			com.sist.aop : 공통 기반 설정 => 시간 체크 (로그 파일)
			com.sist.commons : 공통 기반의 예외 처리
			com.sist.manager : Open API (크롤링), JSON
			com.sist.service : DAO 여러개를 통합 
			com.sist.chat : webSocket
			com.sist.intercept : 자동 로그인, 알림
			com.sist.security : 보안 (자동 로그인, 권한 부여)
			
		5. 해당 클래스 제작
		
		6. Spring에 등록
			application-context.xml : 사용자 정의 클래스 등록
			application-datasource.xml : 데이터베이스 관련
			~~~~~~~~~~~~~~~~~~~~~~~~~~ 변경
		
		7. JSP 출력
 */
/*
	Spring => 우리나라 웹 개발의 80% 정도
	= 게임 개발
	= AI
	= 기판 / C언어
	= 학교 전산실
	= 웹 개발 (******* 가장 가기 쉬움)
	= 웹 기획
 */
/*
 * 	<a> 태그 => @GetMapping
 *  <form> 태그 => @PostMapping
 */

public interface BoardMapper {

	// 목록 = 페이지 나누기
	@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
			+ "FROM (SELECT no,subject,name,regdate,hit,rownum as num "
			+ "FROM (SELECT no,subject,name,regdate,hit "
			+ "FROM spring_board ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{s} AND #{e}")
	public List<BoardVO> boardListData(@Param("s") int start,@Param("e") int end);
	// boardList(1,10) => 구분자 전송 => @Param => 매개 변수를 여러개 사용 가능
	// Map => 1개 이용 시에는, VO
	@Select("SELECT COUNT(*) FROM spring_board")
	public int boardRowCount();
	
	// 추가
	@Insert("INSERT INTO spring_board(no,name,subject,content,pwd) "
			+ "VALUES(sb_no_seq.nextval,#{name},#{subject},#{content},#{pwd})")
	public void boardInsert(BoardVO vo);
	
	// 상세 보기
	@Update("UPDATE spring_board SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public void hitIncrement(int no);
	
	@Select("SELECT no,name,subject,content,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday,hit "
			+ "FROM spring_board "
			+ "WHERE no=#{no}")
	public BoardVO boardDetailData(int no); // 비밀 번호 가지고 오기
	
	// 수정
	@Select("SELECT pwd FROM spring_board WHERE no=#{no}")
	public String boardGetPassword(int no);
	
	@Update("UPDATE spring_board SET name=#{name},subject=#{subject},content=#{content} "
			+ "WHERE no=#{no}")
	public void boardUpdate(BoardVO vo);
	
	// 삭제
	@Delete("DELETE FROM spring_board WHERE no=#{no}")
	public void boardDelete(int no);
	
	// 검색
}
