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
ȸ�� ��ȣ : 1
�̸� : ȫ�浿
���� : ����
�ּ� : ����
��ȣ : 010-1111-1111
ȸ�� ��ȣ : 2
�̸� : ��û��
���� : ����
�ּ� : ���
��ȣ : 010-2222-2222
ȸ�� ��ȣ : 3
�̸� : �ڹ���
���� : ����
�ּ� : �λ�
��ȣ : 010-3333-3333
ȸ�� ��ȣ : 4
�̸� : ������
���� : ����
�ּ� : ����
��ȣ : 010-4444-4444
 */
	}

}
