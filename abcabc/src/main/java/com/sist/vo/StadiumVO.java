package com.sist.vo;

import lombok.Data;

/*
 *  NO       NOT NULL NUMBER         
	NAME     NOT NULL VARCHAR2(1000) 
	POSTER            VARCHAR2(4000) 
	SEAT              NUMBER         
	INWON             NUMBER         
	LOCATION          VARCHAR2(1000) 
	HOMETEAM          VARCHAR2(1000) 
	CONTENT           VARCHAR2(4000) 
	OPENYEAR          VARCHAR2(1000) 
 */
@Data
public class StadiumVO {
   private int no,seat,inwon;
   private String name,poster,location,address,hometeam,content,openyear;
}
