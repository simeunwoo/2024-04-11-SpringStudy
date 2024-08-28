package com.sist.main;
/*
 * 	스프링 : 로드 존슨 제작
 * 		오픈 소스 라이브러리 => 확장성 (변경하여 사용 가능)
 *      ==============
 *      전자정부프레임워크 (공기업) ***
 *      애니프레임워크 (대기업)
 *      일반 스프링 (금융권)
 *
 *	스프링에 지원하는 라이브러리
 *	====================
 *	1. core : 객체 생성 ~ 객체 소멸, 객체 관리
 *	           ======================
 *              객체 생명 주기 => 컨테이너 (경량 컨테이너) => 클래스 관리자
 *              ========== DI
 *	2. aop : 공통 기능을 모아서 자동으로 처리
 *     === oop를 보완하는 프로그램
 *            === 객체 지향 프로그램
 *	3. Data Access : JDBC / ORM / OXM / JMS
 *		ORM : MyBatis / Hibernate / JPA
 *		OXM : XML 파싱
 *		JMS : Message Service
 *	4. WEB : MVC
 *	기타
 *		Spring Data (빅데이터 분석가)
 *		*** Spring Security
 *		Spring Cloud (MSA)
 *		Spring AI
 *		=> 엘레스틱 서치 : 검색 엔진 => 루씬 => 구글
 *
 *	# DI(클래스 관리자)는 모든 스프링의 기본 => 필수 조건
 *    == 스프링 : 클래스 관리자 (생성 ~ 소멸)
 *     		=> 프로그램에 맞게 클래스를 관리한다
 *     		=> 다른 프레임워크와 호환성이 좋다
 *     		=> 바로 걷어낼 수 있다
 *     		=> XML 기반 (Spring 4) / Annotation 기반 (순수 자바 / Spring 5)
 *     			=> Spring 5 : 보안 강조 (.class)
 *     DI => 클래스를 저장하여 관리하는 컨테이너 클래스
 *              =============================
 *              스프링에서 지원하는 컨테이너 (클래스 1개 : 컴포넌트/빈)
 *              
 *		BeanFactory : core(DI)
 *		|
 *		ApplicationContext : core(DI), AOP
 *		|
 *		WebApplicationContext : core(DI), AOP, MVC
 *
 *		*** 면접 : DI / AOP / Transaction
 *
 *		ApplicationContext
 *			=> GenericXmlApplicationContext => GC => close()
 *			=> AnnotationConfigApplicationContext => 자바로 환경 설정
 *
 *		컨테이너(스프링) : 클래스가 많은 경우 / 연결 관계가 많은 경우에 주로 사용
 *                              ============================ 웹 / 게임
 *		= XML 기반 => 공통 기반 (데이터베이스 연결)
 *		= 어노테이션 기반 => 사용자 정의 (개발자 각자)
 *
 *		스프링 프레임워크의 특징
 *		1. 경량 컨테이너 => DI + DL
 *		   ==========
 *          1) 객체 저장 => DI
 *          	<bean id="" class="">
 *          2) 객체 찾기
 *          	getBean("id") => DL
 *          3) 객체 소멸
 *		2. POJO 방식 사용 : Spring 2.5부터 사용 => Spring이 발전하기 시작
 *		   ======= 상속, 인터페이스 구현 없이 순수하게 자바로만 사용하는 일반 클래스
 *		                  =========== 자유롭게 구현 (다른 클래스에 영향이 없다)
 *			=> 여러명이 동시에 개발 시에 본인만 에러
 *			=> 특정 프레임워크 기술에 의존하지 않는다
 *			=> 결합성이 낮은 프로그램 개발
 *		3. 유지 보수가 편리 : 클래스가 독립적으로 저장
 *		4. 확장성
 *		5. 필요한 모든 라이브러리 지원
 *
 * 		DI
 * 		1) setter DI : setXxx() => 변수의 초기화
 * 		2) 생성자 DI
 * 		3) 메소드 DI
 * 			= 객체 생성 시
 * 			= 객체 소멸 시
 * 		클래스와 클래스의 연관 관계 설정 => 메뉴얼 제작 : 동작 => XML (application.xml)
 * 
 * 		1. XML 기반
 * 		2. Annotation
 * 		========== 유지 보수
 * 		3. 자바 기반 : 차세대 개발 => Spring Framework (X) => Spring-Boot
 * 
 * 		*** 스프링에서 클래스 등록
 * 		    ================ 모든 클래스 등록 (VO는 제외)
 * 		                                                            === 사용자 정의 데이터형
 * 		클래스 등록
 * 		========
 * 		1) XML
 * 			= <bean id="" class=""> : 한개의 클래스만 등록
 * 			= <context:component-scan basepackage="">
 * 				=> 선별적
 * 				=> 등록된 클래스는 반드시 어노테이션을 사용
 * 					= @Component : 일반 클래스
 * 					= @Repository : DAO (저장소)
 * 					= @Service : BI => 기능 통합
 * 					= @Controller : Model => forward / redirect
 * 					= @RestController : Model => void : ajax
 * 						JSON : 자바스크립트 연동
 * 						==== Vue, React
 * 						==== simple-json (X)
 * 						==== jackson
 * 					= @ControllerAdvice : 통합 예외 처리
 * 			= @Bean : xml없이 처리
 * 		2) DI
 * 			XML에서만 사용이 가능 : 멤버 변수의 초기화
 * 			=============== setter DI / 생성자 DI
 * 			class A
 * 			{
 * 				private int a,b;
 * 				public void setA(int a)
 * 				{
 * 					this.a=a;
 * 				}
 * 				public void setB(int b)
 * 				{
 * 					this.b=b;
 * 				}
 * 				public A(int a,int b)
 * 				{
 * 					this.a=a;
 * 					this.b=b;
 * 				}
 * 			}
 * 
 * 			<bean id="aa" class="A"
 * 				p:a="10" => setA(10)
 * 				---- setter
 * 				p:b="20" => setB(20)
 * 				c:a="100" c:b="200" => A(100,200)
 *				---- 생성자
 * 			/>
 * 
 * 			p:name="aaa" => 일반 변수
 * 			p:name-ref="id명" => 클래스 객체 => id명
 * 
 * 		1. XML을 이용하는 방식
 * 		2. 어노테이션
 * 		3. XML + 어노테이션 (가장 많이 사용)
 * 			=> 라이브러리 클래스 등록 : MyBatis, MVC, Security
 * 		         ======= 어노테이션이 없다 (XML 등록)
 * 			=> 사용자 정의는 어노테이션을 주로 사용
 */
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 컨테이너에 등록
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		EmpDAO dao=(EmpDAO)app.getBean("dao");
		List<EmpVO> list=dao.empListData();
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEmpno()+" "
					+vo.getEname()+" "
					+vo.getJob()+" "
					+vo.getDbday()+" "
					+vo.getSal());
		}
	}

}
