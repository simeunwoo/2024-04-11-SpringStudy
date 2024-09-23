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
                        int game = Integer.parseInt(tds.get(8).text());     // 출장
                        int h1 = Integer.parseInt(tds.get(11).text());      // 안타
                        int h2 = Integer.parseInt(tds.get(12).text());      // 2루타
                        int h3 = Integer.parseInt(tds.get(13).text());      // 3루타
                        int homerun = Integer.parseInt(tds.get(14).text()); // 홈런
                        int rbi = Integer.parseInt(tds.get(16).text());     // 타점
                        int ball = Integer.parseInt(tds.get(19).text());    // 4구 (볼넷)
                        int strikeout = Integer.parseInt(tds.get(24).text());// 삼진
                        double war = Double.parseDouble(tds.get(31).text());// WAR

                        // 데이터 저장
                        BatterVO vo = new BatterVO();
                        vo.setBno(k++);
                        vo.setName(name);
                        vo.setTeam(team);
                        vo.setAge(age);
                        vo.setGame(game);
                        vo.setH1(h1);
                        vo.setH2(h2);
                        vo.setH3(h3);
                        vo.setHomerun(homerun);
                        vo.setRbi(rbi);
                        vo.setBall(ball);
                        vo.setStrikeout(strikeout);
                        vo.setWar(war);

                        dao.batterInsert(vo);

                        // 출력
                        System.out.printf("번호: %d%n", k - 1); // 번호 수정
                        System.out.printf("이름: %s%n", name);
                        System.out.printf("팀: %s%n", team);
                        System.out.printf("나이: %d%n", age);
                        System.out.printf("출장: %d%n", game);
                        System.out.printf("안타: %d%n", h1);
                        System.out.printf("2루타: %d%n", h2);
                        System.out.printf("3루타: %d%n", h3);
                        System.out.printf("홈런: %d%n", homerun);
                        System.out.printf("타점: %d%n", rbi);
                        System.out.printf("4구: %d%n", ball);
                        System.out.printf("삼진: %d%n", strikeout);
                        System.out.printf("WAR: %.2f%n", war);
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
