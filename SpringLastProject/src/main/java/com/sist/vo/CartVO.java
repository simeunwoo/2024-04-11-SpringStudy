package com.sist.vo;
import java.util.*;

import lombok.Data;
/*
CNO     NOT NULL NUMBER       
GNO              NUMBER       
ID               VARCHAR2(20) 
ACCOUNT          NUMBER       
ISBUY            NUMBER       
REGDATE          DATE 
 */
@Data
public class CartVO {

	private int cno,gno,account,isbuy;
	private String id,dbday;
	private Date regdate;
	
	private MemberVO mvo=new MemberVO(); // JOIN
	private GoodsVO gvo=new GoodsVO(); // JOIN
}
