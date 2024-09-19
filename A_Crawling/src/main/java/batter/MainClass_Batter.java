package batter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class MainClass_Batter {

    public static void main(String[] args) {
        // MainClass 인스턴스 생성 및 메서드 호출
        MainClass_Batter mc = new MainClass_Batter();
        mc.batterData();
    }
    
    public void batterData() {
        BatterDAO dao = BatterDAO.newInstance();
        try {
            int k = 1;
            for (int i = 15056; i <= 20000; i++) {
                try {
                    Document doc = Jsoup.connect("https://statiz.sporki.com/player/?m=playerinfo&p_no=" + i).get();

                    // 투수 정보가 포함된 경우 크롤링 중지
                    Element pitcherCheck = doc.selectFirst("div.pitcherInfo");
                    if (pitcherCheck != null) {
                        System.out.println("투수 정보가 포함되어 있어 크롤링을 중지합니다.");
                        continue;
                    }

                    // 데이터 추출
                    String name = getTextOrDefault(doc, "div.playerName", "해당 사항 없음");
                    String age = getTextOrDefault(doc, "div.age", "0");
                    String game = getTextOrDefault(doc, "div.game", "0");
                    String h1 = getTextOrDefault(doc, "div.h1", "0");
                    String h2 = getTextOrDefault(doc, "div.h2", "0");
                    String h3 = getTextOrDefault(doc, "div.h3", "0");
                    String homerun = getTextOrDefault(doc, "div.homerun", "0");
                    String rbi = getTextOrDefault(doc, "div.rbi", "0");
                    String run = getTextOrDefault(doc, "div.run", "0");
                    String ball = getTextOrDefault(doc, "div.ball", "0");
                    String strikeout = getTextOrDefault(doc, "div.strikeout", "0");
                    String war = getTextOrDefault(doc, "div.war", "0.0");
                    String team = getTextOrDefault(doc, "div.team", "해당 사항 없음");
                    String position = getTextOrDefault(doc, "div.position", "해당 사항 없음");
                    String tasoo = getTextOrDefault(doc, "div.tasoo", "0");

                    // 데이터베이스에 저장
                    BatterVO vo = new BatterVO();
                    vo.setBno(k++);
                    vo.setAge(Integer.parseInt(age));
                    vo.setGame(Integer.parseInt(game));
                    vo.setH1(Integer.parseInt(h1));
                    vo.setH2(Integer.parseInt(h2));
                    vo.setH3(Integer.parseInt(h3));
                    vo.setHomerun(Integer.parseInt(homerun));
                    vo.setRbi(Integer.parseInt(rbi));
                    vo.setRun(Integer.parseInt(run));
                    vo.setBall(Integer.parseInt(ball));
                    vo.setStrikeout(Integer.parseInt(strikeout));
                    vo.setWar(Double.parseDouble(war));
                    vo.setName(name);
                    vo.setTeam(team);
                    vo.setPosition(position);
                    vo.setTasoo(Integer.parseInt(tasoo));

                    dao.batterInsert(vo);

                    System.out.println("번호: " + k);
                    System.out.println("이름: " + name);
                    System.out.println("나이: " + age);
                    System.out.println("==============================================");

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

    // 유틸리티 메서드: 값을 추출하거나 기본값을 반환
    private String getTextOrDefault(Document doc, String selector, String defaultValue) {
        Element element = doc.selectFirst(selector);
        return (element != null) ? element.text().replace(",", "").trim() : defaultValue;
    }

}
