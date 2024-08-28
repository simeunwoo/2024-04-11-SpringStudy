package com.sist.main;
import java.util.*;
import com.sist.vo.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		GoodsDAO dao=(GoodsDAO)app.getBean("dao");
		
		Scanner scan=new Scanner(System.in);
		System.out.print("������ �Է� : ");
		
		int curpage=scan.nextInt();
		int rowSize=8;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		int totalpage=dao.goodsTotalPage();
		
		List<GoodsVO> list=dao.goodsListData(start, end);
		for(GoodsVO vo:list)
		{
			System.out.println("��ȣ : "+vo.getNo());
			System.out.println("��ǰ�� : "+vo.getGoods_name());
			System.out.println("���� : "+vo.getGoods_price());
			System.out.println("��� : "+vo.getGoods_delivery());
			System.out.println("========================");
		}
		
		System.out.println("===== "+curpage+" page / "+totalpage+" pages =====");
		System.out.print("��ȣ �Է� : ");
		
		int no=scan.nextInt();
		GoodsVO vo=dao.goodsDetailData(no);
		System.out.println("=== "+no+"���� ��ǰ ===");
		System.out.println("��ȣ : "+vo.getNo());
		System.out.println("��ǰ�� : "+vo.getGoods_name());
		System.out.println("���� : "+vo.getGoods_sub());
		System.out.println("���� : "+vo.getGoods_price());
		System.out.println("������ : "+vo.getGoods_discount());
		System.out.println("���� : "+vo.getGoods_first_price());
		System.out.println("��� : "+vo.getGoods_delivery());
	}

}
