package com.sist.spring1;
/*
 * 	C/S
 * 	client / server
 * 	|        |
 * 	Front    Back
 *           ���� ���� => Ŭ���̾�Ʈ���� ���� �߻�
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hello hello=new Hello(); // ���õ� ����� ��Ƽ� ����
		hello.sayhello("ȫ�浿"); // �Ѱ��� ����� ������ �ִ�
		/*
		 * 	���ռ��� ���� ���α׷�
		 * 	���� �� => �ٸ� Ŭ������ ����
		 * 	�������̸� new�� ������� �ʴ´� (new => ���ռ��� ���� ���α׷����� ����)
		 */
	}

}
