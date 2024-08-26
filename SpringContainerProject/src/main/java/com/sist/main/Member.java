package com.sist.main;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/*
 * 	1. ��ü ���� => ����
 * 	2. ��� ������ �ʱ�ȭ �Ŀ� ��ü ���� => ����
 * 		= setXxx() => setter DI
 * 		= ������ => constructor DI
 * 
 * 	<bean id="mem" class="com.sist.main.Member">
 * 		=> new Member() => default ȣ��
 * 	
 * 	class A
 * 	{
 * 		private int a,b;
 * 		public A(int a,int b)
 * 		{
 * 			this.a=a;
 * 			this.b=b;
 * 		}
 * 	}
 * 	A a=new A(); => ���� (���� public A �����ڿ��� �Ű� ������ �ִµ� ���⿣ �Ű� ������ �����Ƿ�)
 */
// @Getter
// @Setter
// @AllArgsConstructor

public class Member {

	public Member(int mno, String name, String sex, String address, String phone) {
		this.mno = mno;
		this.name = name;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
	}

	private int mno;
	private String name;
	private String sex;
	private String address;
	private String phone;
	
	public void print()
	{
		System.out.println("ȸ�� ��ȣ : "+mno);
		System.out.println("�̸� : "+name);
		System.out.println("���� : "+sex);
		System.out.println("�ּ� : "+address);
		System.out.println("��ȣ : "+phone);
	}
}
