package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass_3 {

	public static void main(String[] args) {
		
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app5.xml");
		Board b=(Board)app.getBean("board");
		b.print();
	}
}
