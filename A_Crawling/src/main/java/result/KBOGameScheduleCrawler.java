package result;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class KBOGameScheduleCrawler {

    public static void main(String[] args) {
        KBOGameScheduleCrawler crawler = new KBOGameScheduleCrawler();
        crawler.crawlGameSchedule();
    }

    public void crawlGameSchedule() {
        GameScheduleDAO dao = GameScheduleDAO.newInstance();
        try {
            for (int month = 3; month <= 10; month++) {
                String url = "https://statiz.sporki.com/schedule/?year=2024&month=" + month;
                Document doc = Jsoup.connect(url).get();
                
                Elements rows = doc.select("table tbody tr");
                
                for (Element row : rows) {
                    Elements tds = row.select("td");
                    if (tds.size() > 0) {
                        // 데이터 추출
                        String gameDate = tds.get(0).text(); // 경기 날짜
                        String home = tds.get(1).text();     // 홈팀
                        String away = tds.get(2).text();     // 원정팀
                        int homeScore = Integer.parseInt(tds.get(3).text()); // 홈팀 점수
                        int awayScore = Integer.parseInt(tds.get(4).text()); // 원정팀 점수
                        
                        // GameScheduleVO 객체 생성 및 데이터 설정
                        GameScheduleVO vo = new GameScheduleVO();
                        vo.setGamedate(gameDate);
                        vo.setHome(home);
                        vo.setAway(away);
                        vo.setHomescore(homeScore);
                        vo.setAwayscore(awayScore);
                        
                        // 데이터베이스에 삽입
                        dao.insertGameSchedule(vo);
                        
                        // 출력
                        System.out.printf("경기 날짜: %s, 홈팀: %s, 원정팀: %s, 홈팀 점수: %d, 원정팀 점수: %d%n",
                                gameDate, home, away, homeScore, awayScore);
                    }
                }
            }
            System.out.println("모든 경기 일정 저장 완료!!");
        } catch (IOException e) {
            System.err.println("IO 오류: " + e.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
