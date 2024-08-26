package com.sist.main_2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
// ȯ�� ���� => XML ���
@Configuration
public class MemberConfig {
	/*
	 * 	<bean id="mem" class="com.sist.main_2.Member"
	 * 		p:mno="1"
	 * 		p:name="ȫ�浿"
	 * 		p:sex="����"
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
	 *	=> �Ѱ��� ���� ��� (�ڹٷθ� �ڵ� in 5 ����)
	 *		XML => Annotation���� ����
	 */
	@Bean("mem")
	@Scope("prototype")
	public Member member() {
		
		Member m=new Member();
		m.setMno(1);
		m.setName("ȫ�浿");
		m.setSex("����");
		
		return m;
	}
}
