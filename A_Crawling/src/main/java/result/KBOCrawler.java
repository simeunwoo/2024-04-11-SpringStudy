package result;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import result.GameScheduleDAO;
import result.GameScheduleVO;

public class KBOCrawler {
    private final String BASE_URL = "https://statiz.sporki.com/schedule/?year=2024&month=";

    public void crawlSchedule(int month) {
        // month 값이 3부터 10까지인지 확인
        if (month < 3 || month > 10) {
            System.out.println("월은 3에서 10 사이의 값이어야 합니다.");
            return; // 잘못된 월일 경우 종료
        }

        try {
            Document doc = Jsoup.connect(BASE_URL + month).get();
            Elements days = doc.select("td > div.inner > div.games > ul > li");

            for (Element day : days) {
                GameScheduleVO vo = new GameScheduleVO();

                // Extracting game details from the day element
                int sno = Integer.parseInt(day.select("a").attr("href").split("s_no=")[1]);
                String gameDate = day.select("span.day").text();  // Assuming day is the game date
                String gameTime = "N/A";  // You might need to extract this if it's present
                String home = day.select("span.team").first().text();
                String away = day.select("span.team").last().text();
                String stadium = "N/A";  // You may need to extract stadium info if available
                int homeScore = Integer.parseInt(day.select("span.score.lead").text());
                int awayScore = Integer.parseInt(day.select("span.score").text());

                // Setting values
                vo.setSno(sno);
                vo.setGameDate(gameDate);
                vo.setGameTime(gameTime);
                vo.setHome(home);
                vo.setAway(away);
                vo.setStadium(stadium);
                vo.setHomeScore(homeScore);
                vo.setAwayScore(awayScore);

                // Inserting into the database
                GameScheduleDAO dao = GameScheduleDAO.newInstance();
                dao.insertGameSchedule(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
