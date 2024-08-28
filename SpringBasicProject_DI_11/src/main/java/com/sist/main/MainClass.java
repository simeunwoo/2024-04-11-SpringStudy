package com.sist.main;
/*
 * 	maven => ant
 * 	|
 * 	1) 라이브러리 관리 : pom.xml
 * 	2) 프로젝트 관리 => 버전 관리
 * 	3) 배포 관리 => 자동으로 war(웹)
 *                                   ====== war => 원격 AWS 운영 체제로 전송 => tomcat
 *		AWS : 운영 체제를 빌려서 사용
 *		        ======= 리눅스 설치 : 각자 IP가 따로 생성
 *	스프링 : DI / AOP (개념 파악) / MVC / MyBatis (ORM) => security / websocket
 *		=> MVC : 인터셉트
 *		=> MyBatis : Transaction
 *	==================================================== Base : DI (스프링의 기본/본체)
 *	=> DI
 *		클래스 등록
 *		= <bean id="" class=""> : 한개의 클래스 등록
 *		= *** <context:component-scan basepackage=""> : 여러개의 클래스를 동시에 메모리 할당
 *			반드시 메모리를 할당할 클래스를 구분
 *			class 위에 어노테이션을 이용하여 구분
 *			=> 클래스를 유형별로 구분
 *			=> 일반 클래스 : @Component => MainClass ... ~Manager
 *			=> 데이터베이스 연동 : @Repository => ~DAO
 *			=> 관련된 DAO를 통합 : @Service
 *			=> Model 클래스 : @Controller / @RestController
 *				=> @Controller : 일반 JSP 제어 => forward / redirect
 *				=> @RestController : 화면 제어가 아니라 => 자바스크립트, 코틀린 연동 => JSON / RestFul
 *					=> RestFul : 다른 언어와 연동 : CRUD (GET / POST / PUT / DELETE) =같은 느낌= (SELECT / INSERT / UPDATE / DELETE)
 *			=> 통합 예외 처리 : @ControllerAdvice
 *		= XML없이 사용
 *			=> @Bean : 자바로만 코딩하는 방식
 *
 *	*** 스프링은 컨테이너(Container)이다
 *		=> Container : 클래스를 모아서 관리 => 객체 생성 ~ 소멸 (객체의 생명 주기를 담당)
 *			=> 클래스 관리자 => MVC는 스프링의 일부 라이브러리 (주력)
 *			=> 객체 생성 : 멤버 변수 초기화 => DI
 *				1. setter : setXxx (주입)
 *					p:name => setName()
 *				2. 생성자 이용
 *					c:name => 생성자(String name)
 *				-----------------------------------------
 *				=> 사용자 정의 클래스에서는 사용 빈도가 거의 없다
 *				=> 데이터베이스 연동 : 오라클 정보를 시작과 동시에 전송
 *
 *	*** 개발자가 문제 제기
 *		=============
 *		1) 언어를 통합 : 한가지 언어로 사용 : XML + Java => Java
 *		2) 보안 유지가 어렵다
 *			=> XML은 노출이 있다 (X) => Java : 컴파일 .class
 *		------------------------------------------------------------------> 스프링 5 버전에서 변경
 *		=> 이전 프로그램이 존재 : 호환성
 *			=> 스프링 6은 호환 불가 => javax~>jakarata 때문에
 *
 *	MyBatis : @Select ...
 *		매개 변수는 반드시 1개
 *		-------------------------- 여러개 사용도 가능 (사용법에 유의)
 *		복잡한 SQL 문장 => 동적 쿼리
 *		----------------------------------
 *		=> XML => 어노테이션으로 변경
 *		=> PROCEDURE / TRIGGER => 고급 SQL
 */
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
import com.sist.vo.*;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		EmpDAO2 dao=(EmpDAO2)app.getBean("dao");
		List<EmpVO> list=dao.empListData();
		for(EmpVO vo:list)
		{
			System.out.println(
					vo.getEmpno()+" "
					+vo.getEname()+" "
					+vo.getJob()+" "
					+vo.getDbday()+" "
					+vo.getSal()
					);
			
		}
	}

}
