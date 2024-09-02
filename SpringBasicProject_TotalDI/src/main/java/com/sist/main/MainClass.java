package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.MyDAO;

/*
 * 	1. DI => 클래스와 클래스 연관 관계 : 메뉴얼 (동작) => 클래스 설정에 대한 정의
 * 		1) XML 기반 : Spring 4 => 전자정부프레임워크 (실무)
 * 		2) Annotation 기반 : 라이브러리 클래스 등록 시에 상속을 받아서 처리
 * 		3) XML + Annotation
 * 		   ================= XML : 라이브러리 등록 시 (MyBatis, 보안)
 * 			사용자 정의는 어노테이션으로 설정
 * 			=> 프로젝트에서 공통 사용 => XML
 * 			=> 개발자마다 => 어노테이션으로 설정
 * 		~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 여기까지 Spring 4
 * 		4) 순수 자바만 이용 => Spring 5
 * 		   ============
 * 			XML : 스프링은 클래스 관리자 (생성~소멸)
 * 			= 한개의 클래스를 등록
 * 				<bean id="" class="" scope="">
 * 					id : 구분자 (중복할 수 없다, 클래스 객체를 찾을 경우에 사용)
 * 					class : 메모리를 할당할 클래스 설정 (반드시 패키지부터)
 * 					scope : 싱글턴 (한개의 객체를 이용하는 방법) => prototype
 * 				=> 자바 변경
 * 					@Bean("id")
 * 		 	= 패키지 단위 등록
 * 				<context:component-scan base-package="패키지명">
 * 				=> 자바 변경
 * 					@ComponentScan(basePackage={""})
 * 				=> <mybatis-spring base-package="">
 * 					=> 자바 변경
 * 						@MapperScan(basePackage={""})
 * 				=> Spring-Boot : Framework가 포함
 * 					=> application.properties
 * 						server.port=80
 * 					=> application.yml
 * 						server:
 * 							port:80
 * 				=> 선택적인 메모리 할당
 * 					클래스 위에
 * 					@Component : 일반 클래스
 * 					@Repository : DAO
 * 					@Service : DAO 여러개 통합 : BI
 * 					@Controller : Model => 클래스 위에서 생략되면 웹 처리가 안된다
 * 						= forward
 * 						= redirect
 * 						= 화면 변경 제어
 * 					@RestController : Model => 화면 변경이 아니다
 * 						= JSON 전송 => 자바스크립트 연결
 * 						=> GET => SELECT
 * 						=> POST => UPDATE
 * 						=> PUT => INSERT
 * 						=> DELETE => DELETE
 * 					@ControllerAdvice : 공통적으로 예외 처리
 * 					=========================================== 웹에서만 호출 가능
 * 					*** 스프링에 등록된 객체 찾기 => getBean("id명")
 * 					*** 스프링에서 등록된 클래스를 관리 : 컨테이너
 * 		BeanFactory
 * 		|
 * 		ApplicationContext
 * 		|
 * 		------------------------------------------------
 * 		|                                              |
 * 		AnnotationConfigApplicationContext             WebApplicationContext(MVC)
 * 
 * 	2. AOP => 공통으로 사용되는 클래스의 기능을 모아서 처리 => 자동 호출
 *     --- Aspect : 공통으로 사용되는 기능을 모아서 관리 : 공통 모듈
 *         ------
 *         1) PointCut : 어떤 메소드에 적용
 *         2) JoinPoint : 어떤 위치에 적용
 *         3) Advice : PointCut + JoinPoint
 *         4) Weaving : 소스를 통합하는 역할
 *     --- 인터셉트 : 자동 로그인 / 보안
 *     
 *		=> JoinPoint
 *		public void display()
 *		{
 *			***** before : 드라이버 등록
 *			try
 *			{
 *				***** setAutoCommit(false)
 *				처리 부분							===> Around : setAutoCommit(false) + commit()
 *				***** commit() : 트랜잭션, 로그 파일
 *			}catch(Exception ex)
 *			{
 *				***** after-throwing : catch 수행
 *			}
 *			finally
 *			{
 *				***** after
 *			}
 *			***** after-returning
 *		}
 *		
 * 
 * 	3. MVC => 웹
 * 
 * 	4. ORM => MyBatis
 * 		*** DI, AOP, MVC 동작
 * 
 * 	==================== Basic
 * 
 * 	5. 인터셉트
 * 
 * 	6. 공통 예외 처리
 * 	7. 보안
 * 	8. 웹 채팅
 * 	====================
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		MyDAO dao=(MyDAO)app.getBean("dao");
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
		String s=dao.find("Hello");
		// System.out.println(s);
	}

}
