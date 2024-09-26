package result;

import lombok.Data;
/*
SNO       NOT NULL NUMBER       
GAMEDATE           VARCHAR2(20) 
HOME               VARCHAR2(50) 
AWAY               VARCHAR2(50) 
HOMESCORE          NUMBER       
AWAYSCORE          NUMBER  
 */
@Data
public class GameScheduleVO {
    private int sno,homescore,awayscore;
    private String gamedate,home,away;
}
