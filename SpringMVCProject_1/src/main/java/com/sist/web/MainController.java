package com.sist.web;
/*
            .do                      매개 변수
	브라우저 ======= DispatcherServlet ======= Model => Model 관리자 : HandlerMapping
	                  Controller             처리
	                                      =============
	                                          |
	                                      =============
	                                         JSP 관리 => JSP를 찾아서 request 전송 : ViewResolver
	                                      =============
	                                          |
	                                        JSP로 전송 (View)
	
	1. DispatcherServlet : 사용자의 요청을 받아서
		처리할 데이터를 넘겨주는 역할
	2. HandlerMapping : DispatcherServlet으로부터 받은 데이터를 받아서 처리
		처리 => request에 담아서 전송
		=> Model
		=> @Controller : DispatcherServlet => 위임을 받아서 처리
		=> 기능을 수행하는 메소드 찾기
			구분자 => @GetMapping / @PostMapping / @RequestMapping
	3. ViewResolver : request를 받아서 JSP를 찾아 전송
		=> JSP의 경로명 지정 : prefix=""
		=> 확장자 : suffix="확장자" => 스프링은 자바 전용이 아니다
			ASPX
	4. View (JSP) : 화면 출력 (개발자 담당)
	
	=====================================================================
	
	개발자 담당
	= Model (@Controller) => Model : DAO, Service, VO, Manager ...
	= JSP
	
	스프링
	= DI
		=> 개발자가 만든 클래스 / 라이브러리 클래스를 제어
		클래스 : 멤버 변수에 대한 초기화
			명시적 초기화 : 개발자
			class A
			{
				int a=10;
			}
			= 생성자 => c:
			= setter => p:
			반복 => AOP를 이용하여 자동 호출
			핵심 => 직접 코딩을 한다
	= AOP : 공통적으로 사용하는 기능을 자동으로 호출 가능 => 공통 모듈
		메소드 위치
		public void dbInsert()
		{
			try
			{
				(= : 코딩할 때마다 반복 구문 => AOP를 이용하여 자동 호출 처리)
				= getConnection() => BEFORE
				~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				= conn.setAutoCommit(false) => AROUND
				insert => 핵심 코딩
				insert => 핵심 코딩
				= conn.commit() => AROUND
				~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			}catch(Exception ex)
			{
				= ex.printStackTrace() => AFTER-THROWING
				= conn.rollback()
			}
			finally
			{
				= conn.setAutoCommit(true) => AFTER
				= disConnection()
			}
			return => 정상 수행 => AFTER-RETURNING
		}
	= MVC : 분리해서 작업
		Front = Back(Model=DAO)
			=> Front : view단
			=> Model : server단
			=> DAO : db단
	= Interceptor
	
	사용 요청 ======= DispatcherServlet ======= HandlerMapping
	                                                | => 인터셉트
	                                         ===============
	                                           개발자 : Model
	                                         ===============
	                                                | => 인터셉트
                                               ViewResolver
                                                    | => 인터셉트
                                             ===============
                                                개발자 : JSP
                                             ===============
	------------------------------------------------------------- SpringFramework
	= security
	= batch
	= data
 */
public class MainController {

}
