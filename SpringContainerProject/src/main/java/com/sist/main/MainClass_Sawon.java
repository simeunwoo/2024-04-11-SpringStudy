package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass_Sawon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Ŭ���� ��� (�����̳�)
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app3.xml");
		// classpath : �ڵ� �ν��ϴ� ��ġ => src/main/java
		Sawon sa1=(Sawon)app.getBean("sa1");
			System.out.println("sa1="+sa1);
		Sawon sa2=(Sawon)app.getBean("sa2");
			System.out.println("sa2="+sa2);
		Sawon sa3=(Sawon)app.getBean("sa3");
			System.out.println("sa3="+sa3);
		/*
		sa1=Sawon(sabun=1, pay=3000, name=ȫ�浿, sex=����, dept=���ߺ�, job=���, loc=����)
		sa2=Sawon(sabun=2, pay=3500, name=��û��, sex=����, dept=��ȹ��, job=�븮, loc=���)
		sa3=Sawon(sabun=3, pay=8000, name=�ڹ���, sex=����, dept=���ߺ�, job=����, loc=�λ�)
		 */
		sa1.print();
		System.out.println("================");
		sa2.print();
		System.out.println("================");
		sa3.print();
		/*
���=1
�޿�=3000
�̸�=ȫ�浿
����=����
�μ�=���ߺ�
����=���
�ٹ���=����
================
���=2
�޿�=3500
�̸�=��û��
����=����
�μ�=��ȹ��
����=�븮
�ٹ���=���
================
���=3
�޿�=8000
�̸�=�ڹ���
����=����
�μ�=���ߺ�
����=����
�ٹ���=�λ�
		 */
		/*
		 * 	==================
		 * 	id          ��ü
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
