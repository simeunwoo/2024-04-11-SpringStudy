package com.sist.vo;

import lombok.Data;
/*
SNO       NOT NULL NUMBER       
DAY                NUMBER 
HOME               VARCHAR2(50) 
AWAY               VARCHAR2(50) 
HOMESCORE          VARCHAR2(10) 
AWAYSCORE          VARCHAR2(10) 
MONTH              NUMBER 
 */
@Data
public class ScheduleVO {

	private int sno,month,day;
	private String home,away,homescore,awayscore;
}
