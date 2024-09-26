package result;
import java.util.*;

import lombok.Data;

@Data
public class ScheduleVO {

	private int sno,homescore,awayscore;
	private String game_date,game_time,home,away,stadium;
}
