package com.sist.temp;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputVO ivo=new InputVO();
		ivo.setNo(13);
		ivo.setGno(30);
		ivo.setPrice(50000);
		
		StoreVO svo=new StoreVO();
		svo.setNo(5);
		svo.setGno(10);
		svo.setPrice(20000);
		
		GoodsDAO dao=new GoodsDAO();
		dao.insert(ivo, svo);
		System.out.println("정상");
	}

}
