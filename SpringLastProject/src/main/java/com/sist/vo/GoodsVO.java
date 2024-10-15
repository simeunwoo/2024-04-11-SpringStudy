package com.sist.vo;

import lombok.Data;
/*
NO                NOT NULL NUMBER(38)     
GOODS_NAME                 VARCHAR2(4000) 
GOODS_SUB                  VARCHAR2(4000) 
GOODS_PRICE                VARCHAR2(26)   
GOODS_DISCOUNT             NUMBER(38)     
GOODS_FIRST_PRICE          VARCHAR2(26)   
GOODS_DELIVERY             VARCHAR2(26)   
GOODS_POSTER               VARCHAR2(4000) 
HIT                        NUMBER(38)
 */
@Data
public class GoodsVO {

	private int no,goods_discount,hit;
	private String goods_name,goods_sub,goods_price,goods_first_price,goods_delivery,goods_poster;
	
	private int price; // goods_price가 문자열 => int형으로 바꾸기 위해 (가격에 ,가 포함되었기 때문)
}
