package com.sist.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.*;
/*
 * 	@Component => @Target(value={TYPE})
 *                          =============== class ������
 *  @Repository => @Target(value={TYPE})
 *  
 *	@Autowired => @Target(value={CONSTRUCTOR, METHOD, PARAMETER, FIELD, ANNOTATION_TYPE})
 *
 *	@Qualifier => @Target(value={FIELD, METHOD, PARAMETER, TYPE, ANNOTATION_TYPE})
 *
 *	class A
 *	{
 *		@Autowired
 *		private B b; => FIELD (��� ����)
 *
 *		@Autowired
 *		public A(B b) => CONSTRUCTOR (������)
 *		{
 *			this.b=b;
 *		}
 *
 *		@Autowired => ANNOTATION_TYPE
 *		@Qualifier("")
 *		public void setB(@Autowired B b) => METHOD (�޼ҵ�)
 *		{                    -------------- => PARAMETER (�Ű� ����)
 *			this.b=b;
 *		}
 *	}
 *
 *	������̼�
 *	= ������ (�ε���)
 *	= Ŭ���� : TYPE
 *	= �Ű� ���� : PARAMETER
 *	= ������ : CONSTRUCTOR
 *	= �޼ҵ� : METHOD
 *
 *	Ŭ���� ���
 *	========
 *	XML�� �̿�
 *	ANNOTATION�� �̿�
 *	XML+ANNOTATION �̿� (���� ���� ���Ǵ� ����)
 *
 *	XML : ���̺귯�� Ŭ���� ��� => ��� ���α׷��� �������� ���
 *	ANNOTATION : ����� ���� Ŭ���� ���
 *		@Component : MainClass, ~Manager
 *		@Repository : DAO
 *		@Service : DAO ������
 *			�Խ��� + ���
 *			Emp + Dept
 *		=========================
 *		@Controller
 *		@RestController
 *		@ControllerAdvice
 */
@Component("mc")
public class MainClass_2 {
	@Autowired // �ڵ����� �������� ���� ��ü�� ã�Ƽ� �ּҰ� ����
	@Qualifier("oracle") // ���� ("oracle" or "mysql") => ��ü ���� (������ �ִ� ��� �Ѱ� ���� => @Qualifier)
	// @Resource(name="oracle") => @Autowired + @Qualifier
	private MyDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=
				new ClassPathXmlApplicationContext("application-*.xml");
		MainClass_2 mc=(MainClass_2)app.getBean("mc");
		mc.dao.connection();
	}

}
