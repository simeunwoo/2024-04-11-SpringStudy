package com.sist.vo;

import java.util.Date;
import lombok.Data;

@Data
public class ReserveVO {
	private int rno,hno,isreserve;
	private String id,rroom,rprice,dbday,rday;
	private Date regdate;
	private HotelVO hvo = new HotelVO();
	private MemberVO mvo = new MemberVO();
}
