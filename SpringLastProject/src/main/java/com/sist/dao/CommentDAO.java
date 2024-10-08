package com.sist.dao;

import org.springframework.stereotype.Repository;
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

}
