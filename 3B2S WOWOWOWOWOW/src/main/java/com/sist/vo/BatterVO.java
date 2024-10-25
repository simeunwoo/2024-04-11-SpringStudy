package com.sist.vo;

import lombok.Data;
/*
BNO       NOT NULL NUMBER         
AGE       NOT NULL NUMBER         
GAME               NUMBER         
H1                 NUMBER         
H2                 NUMBER         
H3                 NUMBER         
HOMERUN            NUMBER         
RBI                NUMBER         
BALL               NUMBER         
STRIKEOUT          NUMBER         
WAR                NUMBER(5,2)    
NAME               VARCHAR2(50)   
TEAM               VARCHAR2(30)   
POSITION           VARCHAR2(10)   
LOGO               VARCHAR2(255)  
STEEL              NUMBER         
TASOO              NUMBER         
IMAGE              VARCHAR2(4000)
AVG                NUMBER(4,3)
 */
@Data
public class BatterVO {

	private int bno,age,game,h1,h2,h3,homerun,rbi,ball,strikeout,steel,tasoo;
	private double war,avg;
	private String name,team,position,logo,image;
}
