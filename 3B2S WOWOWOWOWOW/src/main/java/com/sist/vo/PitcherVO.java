package com.sist.vo;

import lombok.Data;
/*
PNO       NOT NULL NUMBER         
NAME               VARCHAR2(30)   
GAME               NUMBER         
WIN                NUMBER         
LOSE               NUMBER         
HIT                NUMBER         
STRIKEOUT          NUMBER         
BALL               NUMBER         
ERA                NUMBER(4,2)    
WAR                NUMBER(4,2)    
TEAM               VARCHAR2(20)   
LOGO               VARCHAR2(200)  
AGE                NUMBER         
INNING             NUMBER(5,1)    
SAVE               NUMBER         
HOLD               NUMBER         
IMAGE              VARCHAR2(4000) 
 */
@Data
public class PitcherVO {

	private int pno,game,win,lose,hit,strikeout,ball,age,save,hold;
	private double era,war,inning;
	private String name,team,logo,image;
}
