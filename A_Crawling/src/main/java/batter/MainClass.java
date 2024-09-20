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
            for (int i = 10400; i <= 10600; i++) {
                try {
                    Document doc = Jsoup.connect("https://statiz.sporki.com/player/?m=playerinfo&p_no=" + i).get();

                    // '베스트'가 있는 행을 선택
                    Element bestRow = doc.select("tr:contains(베스트)").first();
                    if (bestRow != null) {
                        Elements tds = bestRow.select("td");

                        String name = doc.selectFirst("div.name").text();
                        String team = tds.get(2).text(); // 팀명
                        int age = Integer.parseInt(tds.get(3).text()); // 나이
                        String position = tds.get(4).text(); // 포지션
                        int game = Integer.parseInt(tds.get(7).text()); // 출장
                        int h1 = Integer.parseInt(tds.get(11).text()); // 안타
                        int h2 = Integer.parseInt(tds.get(12).text()); // 2루타
                        int h3 = Integer.parseInt(tds.get(13).text()); // 3루타
                        int homerun = Integer.parseInt(tds.get(14).text()); // 홈런
                        int rbi = Integer.parseInt(tds.get(16).text()); // 타점
                        int run = Integer.parseInt(tds.get(17).text()); // 도루
                        int ball = Integer.parseInt(tds.get(19).text()); // 4구
                        int strikeout = Integer.parseInt(tds.get(21).text()); // 삼진
                        double war = Double.parseDouble(tds.get(33).text()); // WAR
                        int tasoo = Integer.parseInt(tds.get(25).text()); // 타수

                        // 데이터 저장
                        BatterVO vo = new BatterVO();
                        vo.setBno(k++);
                        vo.setName(name);
                        vo.setTeam(team);
                        vo.setAge(age);
                        vo.setPosition(position);
                        vo.setGame(game);
                        vo.setH1(h1);
                        vo.setH2(h2);
                        vo.setH3(h3);
                        vo.setHomerun(homerun);
                        vo.setRbi(rbi);
                        vo.setRun(run);
                        vo.setBall(ball);
                        vo.setStrikeout(strikeout);
                        vo.setWar(war);
                        vo.setTasoo(tasoo);

                        dao.batterInsert(vo);

                        System.out.println("번호: " + k);
                        System.out.println("이름: " + name);
                        System.out.println("팀: " + team);
                        System.out.println("나이: " + age);
                        System.out.println("포지션: " + position);
                        System.out.println("출장: " + game);
                        System.out.println("안타: " + h1);
                        System.out.println("2루타: " + h2);
                        System.out.println("3루타: " + h3);
                        System.out.println("홈런: " + homerun);
                        System.out.println("타점: " + rbi);
                        System.out.println("도루: " + run);
                        System.out.println("4구: " + ball);
                        System.out.println("삼진: " + strikeout);
                        System.out.println("WAR: " + war);
                        System.out.println("타수: " + tasoo);
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
