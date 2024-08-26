package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass_Sawon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 클래스 등록 (컨테이너)
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app3.xml");
		// classpath : 자동 인식하는 위치 => src/main/java
		Sawon sa1=(Sawon)app.getBean("sa1");
			System.out.println("sa1="+sa1);
		Sawon sa2=(Sawon)app.getBean("sa2");
			System.out.println("sa2="+sa2);
		Sawon sa3=(Sawon)app.getBean("sa3");
			System.out.println("sa3="+sa3);
		/*
		sa1=Sawon(sabun=1, pay=3000, name=홍길동, sex=남자, dept=개발부, job=사원, loc=서울)
		sa2=Sawon(sabun=2, pay=3500, name=심청이, sex=여자, dept=기획부, job=대리, loc=고양)
		sa3=Sawon(sabun=3, pay=8000, name=박문수, sex=남자, dept=개발부, job=부장, loc=부산)
		 */
		sa1.print();
		System.out.println("================");
		sa2.print();
		System.out.println("================");
		sa3.print();
		/*
사번=1
급여=3000
이름=홍길동
성별=남자
부서=개발부
직위=사원
근무지=서울
================
사번=2
급여=3500
이름=심청이
성별=여자
부서=기획부
직위=대리
근무지=고양
================
사번=3
급여=8000
이름=박문수
성별=남자
부서=개발부
직위=부장
근무지=부산
		 */
		/*
		 * 	==================
		 * 	id          객체
		 * 	==================
		 * 	sa1
		 * 	==================
		 * 	sa2
		 * 	==================
		 * 	sa3
		 * 	==================
		 */
	}

}
