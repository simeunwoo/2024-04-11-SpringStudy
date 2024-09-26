package result;

import lombok.Data;
/*
SNO       NOT NULL NUMBER       
GAMEDATE           VARCHAR2(20) 
HOME               VARCHAR2(50) 
AWAY               VARCHAR2(50) 
HOMESCORE          VARCHAR2(10)       
AWAYSCORE          VARCHAR2(10)  
 */
@Data
public class GameScheduleVO {
    private int sno;
    private String gamedate,home,away,homescore,awayscore;
}
