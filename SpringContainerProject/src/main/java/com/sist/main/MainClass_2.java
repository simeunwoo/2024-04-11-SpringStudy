package com.sist.main;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		<bean id="board" class="com.sist.main.Board"
			init-method="init"
			destroy-method="destroy"
		/>
		 */
		GenericXmlApplicationContext app=
				new GenericXmlApplicationContext("app2.xml"); // ��ü ����
		Board b=(Board)app.getBean("board"); // �ʿ��� ��� ȣ��
		// init() �޼ҵ� �ڵ� ȣ��
		b.list();
		b.Insert();
		app.close(); // ��ü �Ҹ� : destroy() �޼ҵ� �ڵ� ȣ��
		// �����̳ʴ� ��ü�� ��Ƽ� ����
		// ��ü ���� = setter = ������ ��� = ��ü �Ҹ�
		// ---------------------                     ------------
		// --- : ������ ��� ����
	}

}
