package com.sist.main_2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
// 환경 설정 => XML 대신
@Configuration
public class MemberConfig {
	/*
	 * 	<bean id="mem" class="com.sist.main_2.Member"
	 * 		p:mno="1"
	 * 		p:name="홍길동"
	 * 		p:sex="남자"
	 * 		scope="prototype"
	 * 	/>
	 * 
	 * 	id="mem"
	 * 		===> @Bean("mem")
	 *                        ====== id
	 *                        
	 *	class="com.sist.main_2.member"
	 *	        =================
	 *	         Member m=new Member();
	 *	
	 *	p:mno="1"
	 *		===> m.setMno(1)
	 *
	 *	=> 한개의 언어로 사용 (자바로만 코딩 in 5 버전)
	 *		XML => Annotation으로 변경
	 */
	@Bean("mem")
	@Scope("prototype")
	public Member member() {
		
		Member m=new Member();
		m.setMno(1);
		m.setName("홍길동");
		m.setSex("남자");
		
		return m;
	}
}
