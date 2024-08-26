package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 	���̺귯�� vs �����ӿ�ũ
 * 
 * 	=> ���̺귯�� (�ڹ�, Jsoup...)
 * 	: ���� ���Ǵ� ����� ��Ƽ� �̸� ������ �� Ŭ������ ����
 * 	  �����Ӱ� ����� �� �ִ�
 * 	=> �����ӿ�ũ
 * 	: ���߿� �ʿ��� ����� �̸� ������ �� Ŭ������ ����
 * 	  => �⺻ Ʋ�� ������� �ִ� (Ʋ �ȿ����� ��� ����)
 * 	=> ��ǥ���� �����ӿ�ũ
 * 	1. MyBatis
 * 	2. Ajax, Vue, React => �̹� ������ ������� �ִ�
 * 	3. Spring, Spring-Boot
 * 	=> ����
 * 		= �⺻ Ʋ(����)�� ������� �ֱ� ������ ǥ��ȭ�� �Ǿ� �ִ�
 * 			=> ���� �������� ���� : �ѹ� �ͼ������� ����� ���ϴ�
 *                           ===================
 *                           �������� �ÿ� �������� ���� ����
 *      = ���� �Ⱓ�� ����
 *      = ���� ���谡 �ܼ��ϴ�
 *	=> ����
 *		= ����� ���� (��ü�� ����ϱ� ��ƴ�)
 *			String-Boot
 *			String Framework
 *			String Security
 *			String Betch
 *			String Data
 *			String Cloud
 *			=================
 *		= ���̴� (���� �ӵ��� ������)
 *		= �н��ؾߵǴ� ���̺귯���� ���� ����
 *		======================== ���� (�ڹ�, JSP, DB)
 *	Spring���� ���Ǵ� ��� �غ�
 *	1) Database
 *		JDBC / ORM
 *	           === ������ �����ͺ��̽� : MyBatis / JPA / Hibernate
 *                               ==============
 *	2) Web : MVC => Controller�� �̹� ����
 *	3) Core
 *		=> Container : Ŭ������ ��Ƽ� ���� (�������� Ŭ���� ������ : �����̳�)
 *			������ ��� (Ŭ����)
 *	        ========
 *          �������� ���Ŀ� �°� ��� (���� ����)
 *          = Ŭ���� ���
 *          	= XML�� �̿� => Spring 4 / Spring 5 => �ڹ� �̿�
 *          		<bean id="aa" class="com.sist.main.AA">
 *          			map.put("aa",new AA())
 *          			AA a=map.get("aa")
 *          		=========================== �ǹ����� ���� ���
 *          	= @Bean("aa")
 *          		public AA aa()
 *          		{
 *          			return new AA()
 *          		}
 *          	= ������̼� �̿�
 *          		@Component("a")
 *                                    === id
 *                  class A
 *                  {
 *                  }
 *			XML / Annotation�� �о Container�� ����
 *         ==============================
 *          | => Spring
 *         ����� Ŭ�������� ����
 *         
 *         # Container�� ����
 *         ============= Ŭ������ �޸� �Ҵ� (��ü ����)
 *         								��ü ã�� => getBean("id")
 *         								��ü �Ҹ�
 *         				BeanFactory : Core => DI (��ü ���� / �Ҹ� / �ʱ�ȭ)
 *         				|
 *         				ApplicationContext : Core / AOP
 *         				| ============= WebApplicationContext : Core / AOP / MVC
 *         --------------------------------------------------
 *         |															|
 *         AnnotationConfigApplicationContext          GenericXmlApplicationContext
 *         : Core / AOP / Annotation                       : Core / AOP / CLOSE
 *         
 *		1. �Ϲ� ������ => ApplicationContext
 *		2. �� => WebApplicationContext
 *		3. ������̼� => AnnotationConfigApplicationContext
 *		====================================
 *		=> Ŭ���� ��� => �ʿ� �ø��� ��ϵ� Ŭ������ ã�Ƽ� ��� => �ʿ䰡 ���� ��쿡�� �Ҹ� : System.gc()
 *
 *		=> DI => Setter/Constructor/Method
 *			�������� ���Ͽ� => ��� ������ �ʱ�ȭ
 *		=> AOP => ���� ��� (���������� ����ϴ� ����� ��Ƽ� �ڵ� ȣ��)
 *
 *		class A
 *		{
 *		}
 *		class B
 *		{
 *		}
 *		class C
 *		{
 *		}
 *
 *		<bean id="a" class="A">
 *		<bean id="b" class="B">
 *		<bean id="c" class="C">
 *      
 *      �����̳�
 *		=====================
 *		id                 class
 *		=====================
 *		a                  new A()
 *		=====================
 *		b                  new B()
 *		=====================
 *		c                  new C()
 *		=====================
 *
 *		A aa = �����̳�.getBean("a")
 *		                                === id��
 *		=> System.gc() => �޸� ����
 *		
 *		���� �ֱ�
 *		1. class �б�
 *		2. Ŭ���� �޸� �Ҵ�
 *		3. setter�� �̿��Ͽ� �ʱ�ȭ
 *		==================== Spring
 *		4. ������ ��� : ��� Ŭ���� ã��
 *		==================== ������
 *		5. ��� �� Ŭ���� �޸� ����
 *		==================== Spring
 *
 *		class Board
 *		{
 *			public void insert(){}
 *			public void list(){}
 *			public void detail(){}
 *			public void update(){}
 *			public void delete(){}
 *		}
 *
 *		DI : ��� Ŭ������ ����
 *			�ʱ�ȭ
 *			= setter DI
 *			= ������ DI
 *			= method DI => ��ü ���� �� : init-method / ��ü �Ҹ� �� : destroy-method
 *		AOP : Transaction / Security
 *		ORM : �����ͺ��̽� ���� (MyBatis)
 *		MVC : Web ���� 
 */
public class MainClass_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. �����̳ʿ� XML �Ľ� ��û
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app1.xml");
		// 2. �ʿ��� ��ü�� ��û
		Board b=(Board)app.getBean("board");
			System.out.println("b="+b); // b=com.sist.main.Board@7f3b84b8
		b.list(); // �Խ��� ��� ���
		b.Insert(); // �Խù� �߰�
		
		Board b1=app.getBean("board",Board.class); // ���׸� => �ڵ� ����ȯ
			System.out.println("b1="+b1); // b1=com.sist.main.Board@7f3b84b8
		// 3. �ʿ信 ���� �޼ҵ� ȣ�� �Ŀ� ��� : �̱��� = �Ѱ��� �޸� �ּҸ� �̿��Ͽ� ����
		b1.list(); // �Խ��� ��� ���
		b1.Insert(); // �Խù� �߰�
	}

}
