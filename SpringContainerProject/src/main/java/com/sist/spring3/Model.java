package com.sist.spring3;
// ���� ��� => ��� Ŭ������ ������ ��� ����
public interface Model {

	public String execute();
	default public void write() {} // jdk1.8 => �߻� Ŭ���� ����� ���� �����
	// => �������̽� : �ڹٽ�ũ��Ʈ(���α׷� ��� ����)
}
