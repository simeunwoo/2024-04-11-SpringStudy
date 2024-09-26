package result;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class KBOGameScheduleCrawler {
    public static void main(String[] args) {
        KBOGameScheduleCrawler crawler = new KBOGameScheduleCrawler();
        crawler.crawlGameSchedule();
    }

    public void crawlGameSchedule() {
        GameScheduleDAO dao = GameScheduleDAO.newInstance();

        try {
            for (int month = 3; month <= 10; month++) { // 3월부터 10월까지
                String url = "https://statiz.sporki.com/schedule/?year=2024&month=" + month;
                Document doc = Jsoup.connect(url).get();

                Elements tds = doc.select("td"); // 모든 td 요소 선택

                for (Element td : tds) {
                    // 경기 날짜를 가져옴
                    Element dayElement = td.selectFirst(".day");
                    if (dayElement != null) {
                        String gameDate = dayElement.text(); // 날짜

                        // 경기 정보를 가져옴
                        Elements games = td.select(".games li a");
                        for (Element game : games) {
                            String home = game.select(".team").get(1).text(); // 홈팀
                            String homeScore;
                            String awayScore;

                            // 경기 취소 확인
                            if (game.select(".weather").hasText()) {
                                homeScore = "소"; // 홈팀 점수 (취소)
                                awayScore = "취"; // 원정팀 점수 (취소)
                            } else {
                                homeScore = game.select(".score").get(1).text(); // 홈팀 점수
                                awayScore = game.select(".score").get(0).text(); // 원정팀 점수
                            }

                            String away = game.select(".team").get(0).text(); // 원정팀

                            // DB에 저장하기 위한 VO 생성
                            GameScheduleVO vo = new GameScheduleVO();
                            vo.setGamedate(gameDate);
                            vo.setHome(home);
                            vo.setAway(away);
                            vo.setHomescore(homeScore);
                            vo.setAwayscore(awayScore);

                            // DB에 삽입
                            dao.insertGameSchedule(vo);

                            // 출력
                            System.out.printf("날짜: %s, 홈팀: %s, 원정팀: %s, 홈팀 점수: %s, 원정팀 점수: %s%n", 
                                              gameDate, home, away, homeScore, awayScore);
                        }
                    }
                }
            }
            System.out.println("크롤링 및 저장 완료!!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
