/*
 * goodstype 
	 * 의류 : 1
	 * 모자 : 2
	 * 잡화 : 3
	 * 응원용품 : 4
	 * 야구용품 : 5 
 * 
 * 	teamtype
	 * LG 트윈스 : 1
	 * KT 위즈 : 2
	 * SSG랜더스 : 3
	 * NC다이노스 : 4
	 * 두산베어스 : 5
	 * KIA타이거즈 : 6
	 * 롯데자이언츠 : 7
	 * 삼성라이온즈 : 8
	 * 한화이글스 : 9
	 * 키움히어로즈 : 10
 */


package com.sist.vo;

import lombok.Data;

@Data
public class KboGoodsVO {
	private int gno;
	private String name, price, delivery, content, poster; 
}
