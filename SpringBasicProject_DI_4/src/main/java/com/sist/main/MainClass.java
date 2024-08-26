package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.model.*;

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
