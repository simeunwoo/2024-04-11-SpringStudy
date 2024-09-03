package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
/*
 * 	1. ~DAO : 데이터베이스 연동
 * 	2. ~Service : DAO 여러개를 한개로 통합, 결합성이 낮은 프로그램
 * 	3. ~Manager : Open API
 * 	4. ~Controller : Model
 * 	5. ~RestController : 자바스크립트, 코틀린, 플러터
 *	   =============== JSON
 *	6. ~ControllerAdvice : 통합 예외 처리
 *	   ================= 스프링에서 관리 (생성 ~ 소멸)
 *	
 *	~VO : 사용자 데이터형
 *	~Mapper : 관리할 수 없다 (인터페이스)
 *	============================== 개발자 관리
 */
@Repository // DAO 메모리 할당 요청 => 관리 => 싱글턴으로 생성
public class BoardDAO {

	// 필요한 객체를 스프링으로부터 얻어 온다 => 주입 (DI) => 자동 주입 : @Autowired
	@Autowired
	private BoardMapper mapper; // 구현된 클래스의 주소값을 설정
	// 메소드 안에서는 어노테이션 사용 불가
	/*
	 * 	==============> 어노테이션 아래/옆에 있는 것을 제어
	 * 	1. class 위 => TYPE (클래스 구분자)
	 * 	2. 메소드 위 => METHOD (메소드 구분자)
	 * 	3. 멤버 변수 위 => FIELD (멤버 변수 구분자)
	 * 	4. 매개 변수 옆 => PARAMETER (매개 변수 구분자)
	 * 	5. 생성자 위 => CONSTRUCTOR (생성자 구분자)
	 */
	
	public List<BoardVO> boardListData(int start,int end)
	{
		return mapper.boardListData(start, end);
	}
	
	public void boardInsert(BoardVO vo)
	{
		mapper.boardInsert(vo); // 리턴형이 없다 / commit도 설정 => session.close()
	}
	
	public int boardRowCount()
	{
		return mapper.boardRowCount();
	}
	
	public BoardVO boardDetailData(int no)
	{
		mapper.hitIncrement(no);
		return mapper.boardDetailData(no);
	}

	public BoardVO boardUpdateData(int no)
	{
		return mapper.boardDetailData(no);
	}
	
	
	public boolean boardUpdate(BoardVO vo)
	{
		boolean bCheck=false;
		String db_pwd=mapper.boardGetPassword(vo.getNo());
		if(db_pwd.equals(vo.getPwd()))
		{
			bCheck=true;
			
			// 수정
			mapper.boardUpdate(vo);
		}
		
		return bCheck;
	}
	
}
