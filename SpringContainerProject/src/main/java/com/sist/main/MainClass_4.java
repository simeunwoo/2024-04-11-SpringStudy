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
		System.out.println("번호 : "+rno);
		System.out.println("아이디 : "+id);
		System.out.println("이름 : "+name);
	}
}
public class MainClass_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 클래스를 메모리에 저장 => 무조건 생성자부터 (setter보다 우선 순위)
		/*
		<bean id="board_1" class="com.sist.main.Board_1"
			c:bno="1"
			c:name="홍길동"
			c:subject="게시글이다"
			
			p:bno="2"
			p:name="심청이"
			p:subject="게시글2"
		/>
		 */
		Reply r=new Reply(1, "hong", "홍길동");
		r.print();
/*
번호 : 1
아이디 : hong
이름 : 홍길동
 */
		r.setRno(2);
		r.setId("sim");
		r.setName("심청이");
		r.print();
/*
번호 : 2
아이디 : sim
이름 : 심청이
 */
	}
}