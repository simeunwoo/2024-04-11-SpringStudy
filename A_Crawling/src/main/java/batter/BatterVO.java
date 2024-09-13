package batter;

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
SB                 NUMBER        
BALL               NUMBER        
STRIKEOUT          NUMBER        
WAR                NUMBER(5,2)   
NAME               VARCHAR2(20)  
TEAM               VARCHAR2(30)  
POSITION           VARCHAR2(10)  
CAREER             VARCHAR2(100) 
LOGO               VARCHAR2(255)
 */
@Data
public class BatterVO {

	private int bno,age,game,h1,h2,h3,homerun,rbi,sb,ball,strikeout;
	private double war;
	private String name,team,position,career,logo;
}
