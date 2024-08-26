package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 	라이브러리 vs 프레임워크
 * 
 * 	=> 라이브러리 (자바, Jsoup...)
 * 	: 자주 사용되는 기능을 모아서 미리 구현해 둔 클래스의 집합
 * 	  자유롭게 사용할 수 있다
 * 	=> 프레임워크
 * 	: 개발에 필요한 기능을 미리 구현해 둔 클래스의 집합
 * 	  => 기본 틀이 만들어져 있다 (틀 안에서만 사용 가능)
 * 	=> 대표적인 프레임워크
 * 	1. MyBatis
 * 	2. Ajax, Vue, React => 이미 사용법이 만들어져 있다
 * 	3. Spring, Spring-Boot
 * 	=> 장점
 * 		= 기본 틀(형식)이 만들어져 있기 때문에 표준화가 되어 있다
 * 			=> 같은 형식으로 제작 : 한번 익숙해지면 사용이 편리하다
 *                           ===================
 *                           유지보수 시에 교육없이 투입 가능
 *      = 개발 기간이 단축
 *      = 연결 관계가 단순하다
 *	=> 단점
 *		= 기능이 많다 (전체를 사용하기 어렵다)
 *			String-Boot
 *			String Framework
 *			String Security
 *			String Betch
 *			String Data
 *			String Cloud
 *			=================
 *		= 무겁다 (실행 속도가 느리다)
 *		= 학습해야되는 라이브러리가 많이 존재
 *		======================== 통합 (자바, JSP, DB)
 *	Spring에서 사용되는 기능 준비
 *	1) Database
 *		JDBC / ORM
 *	           === 관계형 데이터베이스 : MyBatis / JPA / Hibernate
 *                               ==============
 *	2) Web : MVC => Controller가 이미 제작
 *	3) Core
 *		=> Container : 클래스를 모아서 관리 (스프링은 클래스 관리자 : 컨테이너)
 *			개발자 등록 (클래스)
 *	        ========
 *          스프링은 형식에 맞게 사용 (지정 형식)
 *          = 클래스 등록
 *          	= XML을 이용 => Spring 4 / Spring 5 => 자바 이용
 *          		<bean id="aa" class="com.sist.main.AA">
 *          			map.put("aa",new AA())
 *          			AA a=map.get("aa")
 *          		=========================== 실무에서 많이 사용
 *          	= @Bean("aa")
 *          		public AA aa()
 *          		{
 *          			return new AA()
 *          		}
 *          	= 어노테이션 이용
 *          		@Component("a")
 *                                    === id
 *                  class A
 *                  {
 *                  }
 *			XML / Annotation을 읽어서 Container에 저장
 *         ==============================
 *          | => Spring
 *         사용자 클래스에서 연결
 *         
 *         # Container의 종류
 *         ============= 클래스의 메모리 할당 (객체 생성)
 *         								객체 찾기 => getBean("id")
 *         								객체 소멸
 *         				BeanFactory : Core => DI (객체 생성 / 소멸 / 초기화)
 *         				|
 *         				ApplicationContext : Core / AOP
 *         				| ============= WebApplicationContext : Core / AOP / MVC
 *         --------------------------------------------------
 *         |															|
 *         AnnotationConfigApplicationContext          GenericXmlApplicationContext
 *         : Core / AOP / Annotation                       : Core / AOP / CLOSE
 *         
 *		1. 일반 스프링 => ApplicationContext
 *		2. 웹 => WebApplicationContext
 *		3. 어노테이션 => AnnotationConfigApplicationContext
 *		====================================
 *		=> 클래스 등록 => 필요 시마다 등록된 클래스를 찾아서 사용 => 필요가 없는 경우에는 소멸 : System.gc()
 *
 *		=> DI => Setter/Constructor/Method
 *			스프링을 통하여 => 멤버 변수의 초기화
 *		=> AOP => 공통 모듈 (공통적으로 사용하는 기능을 모아서 자동 호출)
 *
 *		class A
 *		{
 *		}
 *		class B
 *		{
 *		}
 *		class C
 *		{
 *		}
 *
 *		<bean id="a" class="A">
 *		<bean id="b" class="B">
 *		<bean id="c" class="C">
 *      
 *      컨테이너
 *		=====================
 *		id                 class
 *		=====================
 *		a                  new A()
 *		=====================
 *		b                  new B()
 *		=====================
 *		c                  new C()
 *		=====================
 *
 *		A aa = 컨테이너.getBean("a")
 *		                                === id명
 *		=> System.gc() => 메모리 해제
 *		
 *		생명 주기
 *		1. class 읽기
 *		2. 클래스 메모리 할당
 *		3. setter를 이용하여 초기화
 *		==================== Spring
 *		4. 개발자 사용 : 등록 클래스 찾기
 *		==================== 개발자
 *		5. 사용 후 클래스 메모리 해제
 *		==================== Spring
 *
 *		class Board
 *		{
 *			public void insert(){}
 *			public void list(){}
 *			public void detail(){}
 *			public void update(){}
 *			public void delete(){}
 *		}
 *
 *		DI : 모든 클래스에 적용
 *			초기화
 *			= setter DI
 *			= 생성자 DI
 *			= method DI => 객체 생성 시 : init-method / 객체 소멸 시 : destroy-method
 *		AOP : Transaction / Security
 *		ORM : 데이터베이스 연동 (MyBatis)
 *		MVC : Web 관련 
 */
public class MainClass_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 컨테이너에 XML 파싱 요청
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app1.xml");
		// 2. 필요한 객체를 요청
		Board b=(Board)app.getBean("board");
			System.out.println("b="+b); // b=com.sist.main.Board@7f3b84b8
		b.list(); // 게시판 목록 출력
		b.Insert(); // 게시물 추가
		
		Board b1=app.getBean("board",Board.class); // 제네릭 => 자동 형변환
			System.out.println("b1="+b1); // b1=com.sist.main.Board@7f3b84b8
		// 3. 필요에 따라 메소드 호출 후에 사용 : 싱글턴 = 한개의 메모리 주소를 이용하여 재사용
		b1.list(); // 게시판 목록 출력
		b1.Insert(); // 게시물 추가
	}

}
