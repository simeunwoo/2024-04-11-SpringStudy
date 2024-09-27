package com.sist.vo;

import lombok.Data;
/*
NO      NOT NULL NUMBER         
TEAM    NOT NULL VARCHAR2(20)   
GAME             NUMBER         
WIN              NUMBER         
DRAW             NUMBER         
LOSE             NUMBER         
CHA              NUMBER(3,1)    
WINPER           NUMBER(4,3)    
RANKING          NUMBER         
LOGO             VARCHAR2(1000) 
YEAR             VARCHAR2(255)
 */
@Data
public class RankVO {

	private int no,game,win,draw,lose,ranking;
	private double cha,winper;
	private String team,logo,year;
}
