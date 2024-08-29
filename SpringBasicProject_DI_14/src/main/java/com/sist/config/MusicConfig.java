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
@Configuration
@ComponentScan(basePackages = {"com.sist.*"}) // <context:component-scan base-package="com.sist.*"/>�� ����
public class MusicConfig {

}
