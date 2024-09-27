package com.sist.vo;

import lombok.Data;
/*
NAME    NOT NULL VARCHAR2(1000) 
SYEAR            NUMBER(38,2)   
CONTENT          VARCHAR2(4000) 
WINYEAR          VARCHAR2(1000) 
HOME             VARCHAR2(100)  
DYEAR            NUMBER         
OLDTEAM          VARCHAR2(4000) 
LOGO             VARCHAR2(4000)
 */
@Data
public class TeamVO {

	private int dyear;
	private double syear;
	private String name,content,winyear,home,oldteam,logo;
}
