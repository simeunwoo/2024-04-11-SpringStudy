package com.sist.temp;

import java.util.*;

public class MainClass {
	public static void main(String[] args) {
		
		List<SawonVO> list = new ArrayList<SawonVO>();
		SawonVO hong = SawonVO.newInstance();
		System.out.println("hong="+hong);
		hong.setName("홍길동");
		hong.setDept("개발부");
		list.add(hong);
		
		SawonVO sim = SawonVO.newInstance();
		System.out.println("sim="+sim);
		sim.setName("심청이");
		sim.setDept("기획부");
		list.add(sim);
		
		SawonVO park = SawonVO.newInstance();
		System.out.println("park="+park);
		park.setName("박문수");
		park.setDept("영업부");
		list.add(park);
		
		for (SawonVO vo : list) {
			System.out.println(vo.getName()+" "+vo.getDept());
		}
	}
}