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
		dao.list(); ===> �޸� �Ҵ翡 ���� => ���� ����� ���� ���� �� ������ �� ����
		*/
		
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		BoardDAO dao=(BoardDAO)app.getBean("dao");
		dao.list();
		
		BoardManager bm=(BoardManager)app.getBean("bm");
		bm.manager();
	
		// ���̵� ������ �ȵ� ���� => �ڵ� ���� (Ŭ���� �̸��� ���̵�� => ��, ù �ڴ� �ҹ���
		BoardModel model=(BoardModel)app.getBean("boardModel");
		model.model();
	}
	

}
