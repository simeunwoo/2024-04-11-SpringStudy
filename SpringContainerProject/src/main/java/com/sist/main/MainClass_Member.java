package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass_Member {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app4.xml");
		Member mem1=(Member)app.getBean("mem1");
		mem1.print();
		Member mem2=(Member)app.getBean("mem2");
		mem2.print();
		Member mem3=(Member)app.getBean("mem3");
		mem3.print();
		Member mem4=(Member)app.getBean("mem4");
		mem4.print();
/*
회원 번호 : 1
이름 : 홍길동
성별 : 남자
주소 : 서울
번호 : 010-1111-1111
회원 번호 : 2
이름 : 심청이
성별 : 여자
주소 : 고양
번호 : 010-2222-2222
회원 번호 : 3
이름 : 박문수
성별 : 남자
주소 : 부산
번호 : 010-3333-3333
회원 번호 : 4
이름 : 춘향이
성별 : 여자
주소 : 대전
번호 : 010-4444-4444
 */
	}

}
