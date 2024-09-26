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
            ScheduleDAO scheduleDAO = new ScheduleDAO();

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
/*
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
        KBOCrawler kc = new KBOCrawler();
        kc.scheduleData();
    }

    public void scheduleData() {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
        String dbUser = "hr2";
        String dbPassword = "happy";
        
        try {
            Connection conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
            ScheduleDAO scheduleDAO = new ScheduleDAO(conn);

            String url = "https://www.koreabaseball.com/Schedule/LeagueSchedule.aspx";  // 실제 일정 URL로 변경
            Document doc = Jsoup.connect(url).get();
            Elements scheduleTable = doc.select("table.tbl_schedule");

            int k = 1;
            for (Element row : scheduleTable.select("tr")) {
                Elements columns = row.select("td");

                if (!columns.isEmpty()) {
                    // 경기 날짜, 시간, 팀 정보 및 경기장 정보 파싱
                    String game_date = columns.get(0).text();
                    String game_time = columns.get(1).text();
                    String home = columns.get(2).text();
                    String away = columns.get(3).text();
                    String stadium = columns.get(4).text();
                    String score = columns.get(5).text();  // 경기 결과

                    // 경기 결과 파싱
                    Integer homescore = null;
                    Integer awayscore = null;
                    if (score.contains(":")) {
                        String[] scores = score.split(":");
                        homescore = Integer.parseInt(scores[0].trim());
                        awayscore = Integer.parseInt(scores[1].trim());
                    }

                    // ScheduleVO 객체에 값 설정
                    ScheduleVO scheduleVO = new ScheduleVO();
                    scheduleVO.setGame_no(k++);
                    scheduleVO.setGame_date(game_date);
                    scheduleVO.setGame_time(game_time);
                    scheduleVO.setHome(home);
                    scheduleVO.setAway(away);
                    scheduleVO.setStadium(stadium);
                    scheduleVO.setHomescore(homescore);
                    scheduleVO.setAwayscore(awayscore);

                    // DAO를 통해 데이터베이스에 삽입
                    scheduleDAO.insertSchedule(scheduleVO);

                    // 출력
                    System.out.printf("게임 번호: %d%n", k - 1);
                    System.out.printf("날짜: %s%n", game_date);
                    System.out.printf("시간: %s%n", game_time);
                    System.out.printf("홈팀: %s%n", home);
                    System.out.printf("원정팀: %s%n", away);
                    System.out.printf("경기장: %s%n", stadium);
                    System.out.printf("홈팀 점수: %s%n", homescore);
                    System.out.printf("원정팀 점수: %s%n", awayscore);
                    System.out.println("==============================================");
                }
            }
            System.out.println("저장 완료!!");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}

 */
*/