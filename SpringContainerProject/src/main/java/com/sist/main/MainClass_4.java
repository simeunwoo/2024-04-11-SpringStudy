package com.sist.main;
class Reply
{
	private int rno;
	private String id;
	private String name;
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Reply(int rno, String id, String name) {
		this.rno = rno;
		this.id = id;
		this.name = name;
	}
	
	public void print()
	{
		System.out.println("��ȣ : "+rno);
		System.out.println("���̵� : "+id);
		System.out.println("�̸� : "+name);
	}
}
public class MainClass_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Ŭ������ �޸𸮿� ���� => ������ �����ں��� (setter���� �켱 ����)
		/*
		<bean id="board_1" class="com.sist.main.Board_1"
			c:bno="1"
			c:name="ȫ�浿"
			c:subject="�Խñ��̴�"
			
			p:bno="2"
			p:name="��û��"
			p:subject="�Խñ�2"
		/>
		 */
		Reply r=new Reply(1, "hong", "ȫ�浿");
		r.print();
/*
��ȣ : 1
���̵� : hong
�̸� : ȫ�浿
 */
		r.setRno(2);
		r.setId("sim");
		r.setName("��û��");
		r.print();
/*
��ȣ : 2
���̵� : sim
�̸� : ��û��
 */
	}
}