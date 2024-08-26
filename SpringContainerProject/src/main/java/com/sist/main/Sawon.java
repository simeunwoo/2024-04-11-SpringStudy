package com.sist.main;

import lombok.Data;
/*
 * 	1. setter DI => setXXX()를 이용하여 멤버 변수 초기화
 * 	2. 생성자를 이용하는 방식
 */
@Data
public class Sawon {
	private int sabun,pay;
	private String name,sex,dept,job,loc;
	
	public void print()
	{
		System.out.println("사번="+sabun);
		System.out.println("급여="+pay);
		System.out.println("이름="+name);
		System.out.println("성별="+sex);
		System.out.println("부서="+dept);
		System.out.println("직위="+job);
		System.out.println("근무지="+loc);
	}
}
