package com.sist.main_2;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app1.xml");
		EmpDAO dao=app.getBean("empDAO",EmpDAO.class);
		// 제네릭스 이용
		List<EmpVO> list=dao.empListData();
		for(EmpVO vo:list)
		{
			System.out.println(
					vo.getEname()+" "
					+vo.getJob()+" "
					+vo.getDbday()
					);
		}
	}

}
