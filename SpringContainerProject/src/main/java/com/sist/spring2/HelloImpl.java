package com.sist.spring2;

public class HelloImpl implements Hello {

	@Override
	public void sayHello(String name) {
		System.out.println(name+"님 로그인되었습니다");
	}
}
