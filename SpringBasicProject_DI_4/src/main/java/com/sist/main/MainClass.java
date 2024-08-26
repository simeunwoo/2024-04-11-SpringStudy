package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.model.*;
/*
 * 	Spring
 * 	===== Web ���̺귯��
 * 	|
 * 	Ŭ���� ����
 * 	=> �޸� ���� ���� (���� = �Ҹ�)
 * 	=> ���ռ��� ���� ���α׷� => �ٸ� Ŭ������ ������ ��ġ�� �ʴ´�
 *  ============================================ ���������� ����
 *  => ����� ����
 *       === ��� ������ Ŭ������ �°� �ҽ� �ڵ�
 *              ===> ������������ ��� �޴� ���� ���� �幰��
 *              ===> POJO (2.5����) => �Ϲ� �ڹ�
 *              ===> �����̳� : �淮 / Ŭ����ȭ
 *                       ======
 *                       �� ���� => �� ���� / �� ����� / ���콺 => ����
 *				�б� / ���� / ����� / ���� => ������
 *				=================== ���� ���� (������ ����)
 *
 *	1. ������Ʈ�� �´� Ŭ���� ����
 *	2. ���� => Ŭ������ Ŭ������ ���� ���踦 ���� : .xml, annotation
 *	3. �ش� ��ġ���� ���۵� �޼ҵ� ȣ��
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		
		BoardModel bModel=(BoardModel)app.getBean("board");
		bModel.list();
		
		MemberModel meModel=(MemberModel)app.getBean("member");
		meModel.list();
		
		MainModel maModel=(MainModel)app.getBean("main");
		maModel.list();
		
		FoodModel fModel=(FoodModel)app.getBean("food");
		fModel.list();
		
		RecipeModel rModel=(RecipeModel)app.getBean("recipe");
		rModel.list();
		
	}

}
