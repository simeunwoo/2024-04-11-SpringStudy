package com.sist.dao;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
/*
 * 	스프링에서 메모리 할당 ===> @Autowired
 *         ---------
 *         1) @Component : 일반 클래스 (추천 = 네이버 API, 뉴스 읽기, 다른 프로그램 연동 ...)
 *         2) @Repository : DAO (데이터베이스 연결)
 *         3) @Service : DAO 여러개 연동
 *         		=> Food / Reply
 *         4) @Controller : DispatcherServlet와 연결 => 사이트 페이지 이동
 *         		=> 1. forward : request를 JSP로 전송
 *         			=> 최근 : request => Model (전송 객체)
 *         			=> return "경로명/JSP명";
 *         		=> 2. redirect : 이미 만들어진 메소드 호출 시에 사용
 *         			=> _ok
 *         			=> return "redirect:~.do"
 *         5) *** @RestController : DispatcherServlet와 연결 => 다른 프로그램과 연동
 *         		모든 프로그램 언어 (파이썬, 자바스크립트, 코틀린)
 *         		====================================
 *         		| XML, JSON
 *         		=> 데이터만 전송
 *         6) @ControllerAdvice, @RestControllerAdvice : 예외 처리
 *         		=> 메모리 할당 (X)
 *         			=> @CrossOrigin : 포트 번호가 틀린 경우 => 허용
 *         			=> @Aspect : 공통 모듈
 *         			=> @RequestMapping : 공통 경로
 *         			=> @Async : 비동기
 *         => 메소드 위에 : @GetMapping, @PostMapping
 *         	  --------
 *            멤버 변수 : @Autowired
 *            => 구분자 : 어노테이션에 따라 주소 대입, 메소드 호출
 *         => MVC
 *         		클라이언트 : <a>, <form>, javascript
 *         		요청 => .do => 화면 요청 / 저장 / 수정 / 삭제 ...
 *         		|
 *         		DispatcherServlet : .do 자동 호출
 *         		| 요청 처리 => 사용자 정의 (Model) => Controller
 *         		  -------
 *         		   찾기 => 구분 (GetMapping, PostMapping)
 *                 --- HandlerMapping
 *                 | model, request 값을 전송
 *                 ViewResolver
 *                 |
 *                 JSP를 찾아서 요청 결과 출력
 *              ===> Model (Controller, RestController)
 *                    | Controller, DAO, Service, VO
 *                    ===> 원래 Model은 Controller 그 자체
 *                    ===> 그러나, Controller 한 곳에서 하면 수정이 어려우므로 => 각각의 클래스로 나눠준다
 *                    ===> 기능별로 분리 목적 : 재사용, 편리한 수정, 에러 처리
 *              ===> JSP
 *
 *	=> 실무에서의 핵심 : @RestController
 *
 * 	*** 유지 보수 : 스프링 프레임워크 => 1년차
 * 			AJAX => Vue / React
 * 		=> 전자 정부 프레임워크 (공기업) => 관리자 모드
 * 	*** 개발 : 스프링 부트 => 2년차
 *           =========
 *           JSP가 존재 X
 *           ===> HTML만으로도 출력 가능
 *                ----
 *                => 타임리프 / Front를 별도로 작성
 *                           ----------------
 *                           연결 => MSA
 *
 *	파이썬 서버 (장고) === React
 *	스프링 부트 === React-Query, Redux
 *	   | MySql / MariaDB
 *			NVL => isnull
 *			TO_CHAR => dateformat
 *	   | MyBatis / JPA
 *                 ---- JOIN / SubQuery
 *			SELECT * FROM emp => findAll()
 *			SELECT * FROM emp WHERE empno=1 => findByEmpno(int empno)
 *	   | Vue + React => NextJS
 * 
 */
@Repository
public class CommentDAO {

	@Autowired
	private CommentMapper mapper;
	
	public List<CommentVO> commentListData(Map map)
	{
		return mapper.commentListData(map);
	}
	
	public int commentTotalPage(Map map)
	{
		return mapper.commentTotalPage(map);
	}
	
	public void commentInsert(CommentVO vo)
	{
		mapper.commentInsert(vo);
	}
	
	// 일괄 처리
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void commentReplyReplyInsert(int cno,CommentVO vo)
	{
		CommentVO pvo=mapper.commentParentInfoData(cno);
		vo.setGroup_id(pvo.getGroup_id());
		vo.setGroup_step(pvo.getGroup_step()+1);
		vo.setGroup_tab(pvo.getGroup_tab()+1);
		
		mapper.commentGroupStepIncrement(pvo);
		mapper.commentReplyReplyInsert(vo);
		mapper.commentDepthIncrement(cno);
	}
}
