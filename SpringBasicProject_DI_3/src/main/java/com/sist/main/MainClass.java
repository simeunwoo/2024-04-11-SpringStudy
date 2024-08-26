package com.sist.main;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="C:\\springDev\\springStudy\\SpringBasicProject_DI_3\\src\\main\\java\\app.xml";
		ApplicationContext app=new ApplicationContext(path);
		
		Sawon sa1=(Sawon)app.getBean("sa1");
			System.out.println(sa1); // com.sist.main.Sawon@2a3046da
		
		Sawon sa2=(Sawon)app.getBean("sa2");
			System.out.println(sa2); // com.sist.main.Sawon@2a098129
		
		Sawon sa3=(Sawon)app.getBean("sa3");
			System.out.println(sa3); // com.sist.main.Sawon@198e2867
	}
	
}
