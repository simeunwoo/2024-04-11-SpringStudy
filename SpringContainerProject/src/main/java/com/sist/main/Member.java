package com.sist.main;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/*
 * 	1. 객체 생성 => 관리
 * 	2. 멤버 변수의 초기화 후에 객체 생성 => 관리
 * 		= setXxx() => setter DI
 * 		= 생성자 => constructor DI
 * 
 * 	<bean id="mem" class="com.sist.main.Member">
 * 		=> new Member() => default 호출
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
 * 	A a=new A(); => 오류 (위에 public A 생성자에는 매개 변수가 있는데 여기엔 매개 변수가 없으므로)
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
		System.out.println("회원 번호 : "+mno);
		System.out.println("이름 : "+name);
		System.out.println("성별 : "+sex);
		System.out.println("주소 : "+address);
		System.out.println("번호 : "+phone);
	}
}
