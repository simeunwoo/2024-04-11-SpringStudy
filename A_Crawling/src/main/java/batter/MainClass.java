package batter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class MainClass {

    public static void main(String[] args) {
        MainClass mc = new MainClass();
        mc.batterData();
    }

    public void batterData() {
        BatterDAO dao = BatterDAO.newInstance();
        try {
            int k = 1;
            for (int i = 10000; i <= 12000; i++) {
                try {
                    Document doc = Jsoup.connect("https://statiz.sporki.com/player/?m=playerinfo&p_no=" + i).get();

                    // '베스트'가 있는 행을 선택
                    Element bestRow = doc.select("tr:contains(베스트)").first();
                    if (bestRow != null) {
                        Elements tds = bestRow.select("td");

                        // 이름은 div.name에서 추출
                        String name = doc.selectFirst("div.name").text();  // 이름
                        String team = tds.get(2).text();                   // 팀명
                        int age = Integer.parseInt(tds.get(3).text());      // 나이
                        int game = Integer.parseInt(tds.get(7).text());     // 출장 (G)
                        int rbi = Integer.parseInt(tds.get(16).text());     // 타점 (RBI)
                        int ball = Integer.parseInt(tds.get(20).text());    // 4구 (볼넷, BB)
                        int strikeout = Integer.parseInt(tds.get(24).text());// 삼진 (SO)
                        double war = Double.parseDouble(tds.get(31).text());// WAR
                        int run = Integer.parseInt(tds.get(11).text());     // 득점 (R)
                        int tasoo = Integer.parseInt(tds.get(9).text());    // 타수 (AB)

                        // 데이터 저장
                        BatterVO vo = new BatterVO();
                        vo.setBno(k++);
                        vo.setName(name);
                        vo.setTeam(team);
                        vo.setAge(age);
                        vo.setGame(game);
                        vo.setRbi(rbi);
                        vo.setBall(ball);
                        vo.setStrikeout(strikeout);
                        vo.setWar(war);
                        vo.setRun(run);
                        vo.setTasoo(tasoo);

                        dao.batterInsert(vo);

                        // 출력
                        System.out.printf("번호: %d%n", k - 1); // 번호 수정
                        System.out.printf("이름: %s%n", name);
                        System.out.printf("팀: %s%n", team);
                        System.out.printf("나이: %d%n", age);
                        System.out.printf("출장: %d%n", game);
                        System.out.printf("타점: %d%n", rbi);
                        System.out.printf("4구: %d%n", ball);
                        System.out.printf("삼진: %d%n", strikeout);
                        System.out.printf("WAR: %.2f%n", war);
                        System.out.printf("득점: %d%n", run);
                        System.out.printf("타수: %d%n", tasoo);
                        System.out.println("==============================================");
                    } else {
                        System.out.println("베스트 기록이 없습니다.");
                    }
                } catch (IOException e) {
                    System.err.println("IO 오류: " + e.getMessage());
                } catch (Exception e) {
                    System.err.println("일반 오류: " + e.getMessage());
                }
            }
            System.out.println("저장 완료!!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
