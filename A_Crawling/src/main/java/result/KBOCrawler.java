package result;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KBOCrawler {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
        String dbUser = "hr2";
        String dbPassword = "happy";

        try {
            Connection conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
            ScheduleDAO scheduleDAO = new ScheduleDAO(conn);

            String url = "https://www.koreabaseball.com/Schedule/LeagueSchedule.aspx";  // 실제 일정 URL로 변경
            Document doc = Jsoup.connect(url).get();
            Elements scheduleTable = doc.select("table.tbl_schedule");

            for (Element row : scheduleTable.select("tr")) {
                Elements columns = row.select("td");

                if (!columns.isEmpty()) {
                    String game_date = columns.get(0).text();
                    String game_time = columns.get(1).text();
                    String home = columns.get(2).text();
                    String away = columns.get(3).text();
                    String stadium = columns.get(4).text();
                    String score = columns.get(5).text();  // 경기 결과

                    // 결과를 파싱하여 홈 팀과 원정 팀의 득점 분리
                    Integer homescore = null;
                    Integer awayscore = null;
                    if (score.contains(":")) {
                        String[] scores = score.split(":");
                        homescore = Integer.parseInt(scores[0].trim());
                        awayscore = Integer.parseInt(scores[1].trim());
                    }

                    ScheduleVO scheduleVO = new ScheduleVO();
                    scheduleVO.setGame_date(game_date);
                    scheduleVO.setGame_time(game_time);
                    scheduleVO.setHome(home);
                    scheduleVO.setAway(away);
                    scheduleVO.setStadium(stadium);
                    scheduleVO.setHomescore(homescore);
                    scheduleVO.setAwayscore(awayscore);

                    scheduleDAO.insertSchedule(scheduleVO);
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
