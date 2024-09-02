package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.MyDAO;

/*
 * 	1. DI => Ŭ������ Ŭ���� ���� ���� : �޴��� (����) => Ŭ���� ������ ���� ����
 * 		1) XML ��� : Spring 4 => �������������ӿ�ũ (�ǹ�)
 * 		2) Annotation ��� : ���̺귯�� Ŭ���� ��� �ÿ� ����� �޾Ƽ� ó��
 * 		3) XML + Annotation
 * 		   ================= XML : ���̺귯�� ��� �� (MyBatis, ����)
 * 			����� ���Ǵ� ������̼����� ����
 * 			=> ������Ʈ���� ���� ��� => XML
 * 			=> �����ڸ��� => ������̼����� ����
 * 		~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ������� Spring 4
 * 		4) ���� �ڹٸ� �̿� => Spring 5
 * 		   ============
 * 			XML : �������� Ŭ���� ������ (����~�Ҹ�)
 * 			= �Ѱ��� Ŭ������ ���
 * 				<bean id="" class="" scope="">
 * 					id : ������ (�ߺ��� �� ����, Ŭ���� ��ü�� ã�� ��쿡 ���)
 * 					class : �޸𸮸� �Ҵ��� Ŭ���� ���� (�ݵ�� ��Ű������)
 * 					scope : �̱��� (�Ѱ��� ��ü�� �̿��ϴ� ���) => prototype
 * 				=> �ڹ� ����
 * 					@Bean("id")
 * 		 	= ��Ű�� ���� ���
 * 				<context:component-scan base-package="��Ű����">
 * 				=> �ڹ� ����
 * 					@ComponentScan(basePackage={""})
 * 				=> <mybatis-spring base-package="">
 * 					=> �ڹ� ����
 * 						@MapperScan(basePackage={""})
 * 				=> Spring-Boot : Framework�� ����
 * 					=> application.properties
 * 						server.port=80
 * 					=> application.yml
 * 						server:
 * 							port:80
 * 				=> �������� �޸� �Ҵ�
 * 					Ŭ���� ����
 * 					@Component : �Ϲ� Ŭ����
 * 					@Repository : DAO
 * 					@Service : DAO ������ ���� : BI
 * 					@Controller : Model => Ŭ���� ������ �����Ǹ� �� ó���� �ȵȴ�
 * 						= forward
 * 						= redirect
 * 						= ȭ�� ���� ����
 * 					@RestController : Model => ȭ�� ������ �ƴϴ�
 * 						= JSON ���� => �ڹٽ�ũ��Ʈ ����
 * 						=> GET => SELECT
 * 						=> POST => UPDATE
 * 						=> PUT => INSERT
 * 						=> DELETE => DELETE
 * 					@ControllerAdvice : ���������� ���� ó��
 * 					=========================================== �������� ȣ�� ����
 * 					*** �������� ��ϵ� ��ü ã�� => getBean("id��")
 * 					*** ���������� ��ϵ� Ŭ������ ���� : �����̳�
 * 		BeanFactory
 * 		|
 * 		ApplicationContext
 * 		|
 * 		------------------------------------------------
 * 		|                                              |
 * 		AnnotationConfigApplicationContext             WebApplicationContext(MVC)
 * 
 * 	2. AOP => �������� ���Ǵ� Ŭ������ ����� ��Ƽ� ó�� => �ڵ� ȣ��
 *     --- Aspect : �������� ���Ǵ� ����� ��Ƽ� ���� : ���� ���
 *         ------
 *         1) PointCut : � �޼ҵ忡 ����
 *         2) JoinPoint : � ��ġ�� ����
 *         3) Advice : PointCut + JoinPoint
 *         4) Weaving : �ҽ��� �����ϴ� ����
 *     --- ���ͼ�Ʈ : �ڵ� �α��� / ����
 *     
 *		=> JoinPoint
 *		public void display()
 *		{
 *			***** before : ����̹� ���
 *			try
 *			{
 *				***** setAutoCommit(false)
 *				ó�� �κ�							===> Around : setAutoCommit(false) + commit()
 *				***** commit() : Ʈ�����, �α� ����
 *			}catch(Exception ex)
 *			{
 *				***** after-throwing : catch ����
 *			}
 *			finally
 *			{
 *				***** after
 *			}
 *			***** after-returning
 *		}
 *		
 * 
 * 	3. MVC => ��
 * 
 * 	4. ORM => MyBatis
 * 		*** DI, AOP, MVC ����
 * 
 * 	==================== Basic
 * 
 * 	5. ���ͼ�Ʈ
 * 
 * 	6. ���� ���� ó��
 * 	7. ����
 * 	8. �� ä��
 * 	====================
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		MyDAO dao=(MyDAO)app.getBean("dao");
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
		String s=dao.find("Hello");
		// System.out.println(s);
	}

}
