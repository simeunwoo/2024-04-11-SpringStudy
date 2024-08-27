package com.sist.main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
import com.sist.manager.BoardManager;
import com.sist.model.BoardModel;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		BoardDAO dao=new BoardDAO();
		dao.list(); ===> 메모리 할당에 문제 => 많은 사용자 동시 접속 시 무너질 수 있음
		*/
		
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		BoardDAO dao=(BoardDAO)app.getBean("dao");
		dao.list();
		
		BoardManager bm=(BoardManager)app.getBean("bm");
		bm.manager();
	
		// 아이디가 지정이 안된 상태 => 자동 지정 (클래스 이름이 아이디로 => 단, 첫 자는 소문자
		BoardModel model=(BoardModel)app.getBean("boardModel");
		model.model();
	}
	

}
