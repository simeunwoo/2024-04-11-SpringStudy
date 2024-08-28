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
		System.out.print("페이지 입력 : ");
		
		int curpage=scan.nextInt();
		int rowSize=8;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		int totalpage=dao.goodsTotalPage();
		
		List<GoodsVO> list=dao.goodsListData(start, end);
		for(GoodsVO vo:list)
		{
			System.out.println("번호 : "+vo.getNo());
			System.out.println("제품명 : "+vo.getGoods_name());
			System.out.println("가격 : "+vo.getGoods_price());
			System.out.println("배달 : "+vo.getGoods_delivery());
			System.out.println("========================");
		}
		
		System.out.println("===== "+curpage+" page / "+totalpage+" pages =====");
		System.out.print("번호 입력 : ");
		
		int no=scan.nextInt();
		GoodsVO vo=dao.goodsDetailData(no);
		System.out.println("=== "+no+"번의 제품 ===");
		System.out.println("번호 : "+vo.getNo());
		System.out.println("제품명 : "+vo.getGoods_name());
		System.out.println("설명 : "+vo.getGoods_sub());
		System.out.println("가격 : "+vo.getGoods_price());
		System.out.println("할인율 : "+vo.getGoods_discount());
		System.out.println("원가 : "+vo.getGoods_first_price());
		System.out.println("배달 : "+vo.getGoods_delivery());
	}

}
