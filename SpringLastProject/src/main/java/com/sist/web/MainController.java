package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 * 	정리
 * 	스프링
 * 		= DI : 스프링은 클래스를 관리하는 영역
 * 			클래스를 관리하기 위하여 => 객체 생성/소멸
 * 			객체 생성 시에 멤버 변수의 초기화가 필요 시 사용
 * 			변수의 초기화
 * 				= setterDI => p:
 * 				= 생성자 DI => c:
 * 		= AOP : 공통 모듈 : 실행 시마다 호출하는 기능이 있는 경우에 자동 호출이 가능
 * 			사용자 정의보다는 트랜잭션/보안/로그
 * 		= MVC : 웹 => 라이브러리
 * 		= 라이브러리 : 있는 그대로 사용 => 사용법 / 어떤 기능 / 찾기
 * 			수정하지 않고 사용 (ORM => MyBatis)
 * 	-------------------------------------------------------------------
 * 	프레임워크 : 기본 동작을 위한 틀이 만들어져 있다
 * 		=> 형식에 맞게 세팅하여 사용 => xml / 어노테이션
 * 		라이브러리 추가 : pom.xml / gradle 
 * 	-------------------------------------------------------------------
 * 	클래스 관리
 * 	1) 클래스 한개 : Component
 * 	2) 클래스 여러개 관리 : Container
 * 		스프링은 컨테이너이다 (클래스로 제작됨 : 경량 컨테이너)
 * 	-------------------------------------------------------------------
 * 	MVC
 * 	= Model
 * 		@Controller / @RestController
 * 		===> 사용자의 요청을 받아서 처리 결과를 JSP로 전송하는 역할
 * 		===> (JSP ~> @Controller / JavaScript => @RestController)
 * 		관리 : HandleMapping => 해당 메소드를 찾기
 * 	= View : JSP (HTML)
 * 		ViewResolver : JSP를 찾아서 request를 전송
 * 	= Controller : 사용자 요청을 받는 클래스 (이미 스프링에서 제공)
 * 		DispatcherServlet : 메뉴얼만 제작
 * 		web.xml
 * 	-------------------------------------------------------------------
 * 	WebApplicationContext : 사용자 정의 클래스를 관리
 * 		클래스를 등록
 * 		= application-context.xml
 * 		= application-datasource.xml
 * 		= application-security.xml
 * 		넘겨주는 방법
 * 			<init-param>
				<param-name>contextConfigLocation</param-name>
				<param-value>/WEB-INF/config/application-*.xml</param-value>
			</init-param>
	
	사용자 요청 => DispatcherServlet => HandleMapping => Model 처리 => ViewResolver => JSP
	
	요청하는 메소드 찾기
	= @GetMapping(URI)
	= @PostMapping(URI)
	= @RequestMapping(URI)
	
	ViewResolver
	= p:prefix => 경로명
	= p:suffix => 확장자
	
	Model 처리 ===request===> ViewResolver ===request===> JSP
	
	요청에 대한 처리
	============
	1) 데이터베이스 (MyBatis) => DAO / Service
		DAO => 테이블 1개
		Service => 관련된 DAO 여러개를 묶어서
	2) 외부 API (날씨, 뉴스, 메일)
	3) 전송
		redirect : 기존에 있는 메소드를 재호출 => _ok (DML => insert/update/delete)
		forward : 해당 데이터 전송
	
	화면 출력
	=======
	1) JSP => EL / JSTL
	2) 자바스크립트 : Ajax / VueJS / ReactJS
		List => [] (JSON)
		VO => {} (JSON)
		일반 데이터형 => 정수 / 실수 / 논리 / 문자
		
	=> 기본 동작
	=> 설정 : xml 파일
	=> Model / DAO / Service / JSP
 */
// jsp 연동
@Controller
@RequestMapping("main/")
public class MainController {

	// 필요한 클래스 => 스프링에서 가져 온다 (객체 주소)
	// 사용자 요청에 따라 => 처리
	@GetMapping("main.do")
	public String main_main(Model model)
	{
		return "main";
	}
}
