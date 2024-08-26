package com.sist.spring4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 * 	1. XML 사용법 => 등록
 * 	2. 구분 => 어노테이션
 * 	=================== 사용법
 * 	3. 기능 => Container 종류
 * 		DI
 * 		AOP
 * 		MVC
 * 		Transaction
 * 		Security
 * 		WebSocket
 * 		Betch : 스케줄러
 * 		===============
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=
				new ClassPathXmlApplicationContext("application.xml");
		Sawon sa=(Sawon)app.getBean("sa"); // setter => 초기화 (p:)
		sa.setSabun(5);
		sa.setName("강감찬");
		sa.setDept("총무부");
		sa.print();
	//	System.out.println(sa);
		Sawon sa1=(Sawon)app.getBean("sa");
		sa1.print();
	//	System.out.println(sa1);
		Sawon sa3=(Sawon)app.getBean("sa");
		sa3.print();
	//	System.out.println(sa3);
		Sawon sa4=(Sawon)app.getBean("sa");
		sa4.print();
	//	System.out.println(sa4);
	//	sa.print();
		Sawon sa2=(Sawon)app.getBean("sa2"); // 생성자 => 초기화 (c:)
		sa2.print();
	}

}
