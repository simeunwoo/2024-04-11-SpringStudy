package com.sist.main;

import lombok.Data;
/*
 * 	1. setter DI => setXXX()�� �̿��Ͽ� ��� ���� �ʱ�ȭ
 * 	2. �����ڸ� �̿��ϴ� ���
 */
@Data
public class Sawon {
	private int sabun,pay;
	private String name,sex,dept,job,loc;
	
	public void print()
	{
		System.out.println("���="+sabun);
		System.out.println("�޿�="+pay);
		System.out.println("�̸�="+name);
		System.out.println("����="+sex);
		System.out.println("�μ�="+dept);
		System.out.println("����="+job);
		System.out.println("�ٹ���="+loc);
	}
}
