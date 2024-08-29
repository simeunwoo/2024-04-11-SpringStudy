package com.sist.config;
/*
 * 	�ڵ��� �ܼ�
 * 	�׷���
 * 	������ ���̺귯�� ���� => XML, Annotation
 * 	�����ӿ�ũ�� �⺻ Ʋ�� ���� (Ʋ�� �°� �ҽ� �ڵ�)
 */
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
// Ŭ���� ��� ���� => application-context.xml
/*
 * 	��� ó�� Ŭ���� : �����ͺ��̽� ���� (DAO), Jsoup (Component)
 * 							Model
 * 	@Component
 * 	@Repository
 * 	@Service
 * 	==============
 * 	@Controller
 * 	@RestController
 * 	@ControllerAdvice
 * 	============== Web
 * 	=> Ŭ���� ���� ������ ���� �޸� �Ҵ� (��ü ����)
 * 		�������� �޸� �Ҵ�
 * 
 * 	�Ϲ� ������
 * 	========
 * 	1) DI : Ŭ���� ���� (���)
 * 	2) AOP : ���� ��� ���� => CommonsModel => �ڵ� ȣ�� (�ݹ�)
 * 		AOP�� ���ͼ�Ʈ�� ������
 * 	3) MVC => ORM (MyBatis)
 * 	---------------------------------------------------------------------------
 * 	1) Security
 * 	2) Batch
 * 	=======
 * 	3) Cloud => MSA
 * 	4) AI
 */
@Configuration // bean configuration file�κ��� ...
@ComponentScan(basePackages = {"com.sist.*"}) // <context:component-scan base-package="com.sist.*"/>�� ����
public class MusicConfig {

}
