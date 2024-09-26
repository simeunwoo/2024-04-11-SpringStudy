package result;

import lombok.Data;

@Data
public class GameScheduleVO {
    private int sno;
    private String gameDate;
    private String gameTime;
    private String home;
    private String away;
    private String stadium; // 만약 필요하다면, 경기장도 추가
    private int homeScore;
    private int awayScore;

    // 생성자, getter, setter 생략
}
