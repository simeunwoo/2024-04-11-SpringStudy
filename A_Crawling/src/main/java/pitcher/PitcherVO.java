package pitcher;

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
CAREER             VARCHAR2(200) 
AGE                NUMBER
INNING             NUMBER        
SAVE               NUMBER        
HOLD               NUMBER  
 */
@Data
public class PitcherVO {

	private int pno,game,win,lose,hit,strikeout,ball,age,inning,save,hold;
	private double era,war;
	private String name,team,logo,career;
}
