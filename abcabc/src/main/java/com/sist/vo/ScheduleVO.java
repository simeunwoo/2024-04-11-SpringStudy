package com.sist.vo;

import lombok.Data;
/*
SNO       NOT NULL NUMBER       
DAY                VARCHAR2(20) 
HOME               VARCHAR2(50) 
AWAY               VARCHAR2(50) 
HOMESCORE          VARCHAR2(10) 
AWAYSCORE          VARCHAR2(10) 
MONTH              NUMBER 
 */
@Data
public class ScheduleVO {

	private int sno,month;
	private String day,home,away,homescore,awayscore;
}
