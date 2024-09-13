package teamdetail;

import lombok.Data;
/*
NO         NUMBER      
WAR        NUMBER(4,2) 
GAME       NUMBER      
BAT        NUMBER      
RUNS       NUMBER      
H1         NUMBER      
H2         NUMBER      
H3         NUMBER      
HOMERUN    NUMBER      
BALL       NUMBER      
STRIKE     NUMBER      
AVG        NUMBER(4,3)
 */
@Data
public class TeamDetailVO {

	private int no,game,bat,runs,h1,h2,h3,homerun,ball,strike;
	private double war,avg;
}
