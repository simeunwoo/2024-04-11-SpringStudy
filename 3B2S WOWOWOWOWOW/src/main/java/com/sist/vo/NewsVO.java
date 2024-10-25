package com.sist.vo;
/*
 *  NNO       NOT NULL NUMBER        
	TITLE     NOT NULL VARCHAR2(255) 
	TIME      NOT NULL TIMESTAMP(6)  
	AUTHOR    NOT NULL VARCHAR2(100) 
	POSTER    NOT NULL VARCHAR2(500) 
	CONTENT   NOT NULL CLOB          
	LIKECOUNT          NUMBER        
	HIT                NUMBER   
 */
import java.sql.*;

import lombok.Data;
@Data
public class NewsVO {
   private int nno,likecount,hit;
   private String title,author,poster,content,ftime;
   private Timestamp time;
}
