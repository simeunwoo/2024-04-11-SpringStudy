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
            for (int i = 15056; i <= 16500; i++) {
                try {
                    Document doc = Jsoup.connect("https://statiz.sporki.com/player/?m=playerinfo&p_no=" + i).get();

                    // '베스트'가 있는 행을 선택
                    Element bestRow = doc.select("tr:contains(베스트)").first();
                    if (bestRow != null) {
                        Elements tds = bestRow.select("td");

                        String name = doc.selectFirst("div.name").text();  // 이름
                        String team = tds.get(2).text();  // 팀
                        int age = Integer.parseInt(tds.get(3).text());  // 나이
                        String position = tds.get(4).text();  // 포지션
                        int game = Integer.parseInt(tds.get(7).text());  // 경기수
                        int tasoo = Integer.parseInt(tds.get(10).text());  // 타수
                        int h1 = Integer.parseInt(tds.get(11).text());  // 안타
                        int h2 = Integer.parseInt(tds.get(12).text());  // 2루타
                        int h3 = Integer.parseInt(tds.get(13).text());  // 3루타
                        int homerun = Integer.parseInt(tds.get(14).text());  // 홈런
                        int rbi = Integer.parseInt(tds.get(16).text());  // 타점
                        int run = Integer.parseInt(tds.get(17).text());  // 도루 (Run)
                        int ball = Integer.parseInt(tds.get(19).text());  // 볼넷 (Ball)
                        int strikeout = Integer.parseInt(tds.get(21).text());  // 삼진 (Strikeout)
                        double war = Double.parseDouble(tds.get(33).text());  // WAR

                        // 데이터 저장
                        BatterVO vo = new BatterVO();
                        vo.setBno(k++);  // 고유 번호
                        vo.setName(name);
                        vo.setTeam(team);
                        vo.setAge(age);
                        vo.setPosition(position);
                        vo.setGame(game);
                        vo.setTasoo(tasoo);  // 타수
                        vo.setH1(h1);  // 안타
                        vo.setH2(h2);  // 2루타
                        vo.setH3(h3);  // 3루타
                        vo.setHomerun(homerun);  // 홈런
                        vo.setRbi(rbi);  // 타점
                        vo.setRun(run);  // 도루
                        vo.setBall(ball);  // 볼넷
                        vo.setStrikeout(strikeout);  // 삼진
                        vo.setWar(war);  // WAR

                        dao.batterInsert(vo);  // 데이터베이스에 저장

                        // 출력 (테스트용)
                        System.out.println("번호: " + k);
                        System.out.println("이름: " + name);
                        System.out.println("팀: " + team);
                        System.out.println("나이: " + age);
                        System.out.println("포지션: " + position);
                        System.out.println("출장: " + game);
                        System.out.println("타수: " + tasoo);
                        System.out.println("안타: " + h1);
                        System.out.println("2루타: " + h2);
                        System.out.println("3루타: " + h3);
                        System.out.println("홈런: " + homerun);
                        System.out.println("타점: " + rbi);
                        System.out.println("도루: " + run);
                        System.out.println("볼넷: " + ball);
                        System.out.println("삼진: " + strikeout);
                        System.out.println("WAR: " + war);
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
