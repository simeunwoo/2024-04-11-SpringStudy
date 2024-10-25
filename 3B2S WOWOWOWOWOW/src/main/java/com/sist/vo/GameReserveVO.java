package com.sist.vo;

import java.util.Date;
import lombok.Data;

/*
 * RNO	NUMBER
TNO	NUMBER
ID	VARCHAR2(100 BYTE)
RDAY	VARCHAR2(100 BYTE)
RSEAT	VARCHAR2(100 BYTE)
RPRICE	NUMBER
REGDATE	DATE
ISRESERVE	NUMBER
 */
@Data
public class GameReserveVO {
	private int rno,tno,rprice,isreserve;
	private String id,rday,rseat,dbday,rtype;
	private Date regdate;
	private GameVO gvo = new GameVO();
	private MemberVO mvo = new MemberVO();
	
}
