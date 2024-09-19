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
            for (int i = 10000; i <= 20000; i++) {
                try {
                    Document doc = Jsoup.connect("https://statiz.sporki.com/player/?m=playerinfo&p_no=" + i).get();

                    // 투수 정보가 포함된 경우 크롤링 중지
                    Element pitcherCheck = doc.selectFirst("div.pitcherInfo");
                    if (pitcherCheck != null) {
                        System.out.println("투수 정보가 포함되어 있어 크롤링을 중지합니다.");
                        continue; // 다음 URL로 넘어갑니다.
                    }

                    // 데이터 추출
                    Element nameElement = doc.selectFirst("div.playerName");
                    String name = (nameElement != null) ? nameElement.text() : "해당 사항 없음";
                    
                    // 다른 데이터 추출 (예: 나이, 팀, 포지션 등)
                    Element ageElement = doc.selectFirst("div.age");
                    String age = (ageElement != null) ? ageElement.text() : "해당 사항 없음";

                    Element gameElement = doc.selectFirst("div.game");
                    String game = (gameElement != null) ? gameElement.text() : "해당 사항 없음";

                    Element h1Element = doc.selectFirst("div.h1");
                    String h1 = (h1Element != null) ? h1Element.text() : "해당 사항 없음";

                    Element h2Element = doc.selectFirst("div.h2");
                    String h2 = (h2Element != null) ? h2Element.text() : "해당 사항 없음";

                    Element h3Element = doc.selectFirst("div.h3");
                    String h3 = (h3Element != null) ? h3Element.text() : "해당 사항 없음";

                    Element homerunElement = doc.selectFirst("div.homerun");
                    String homerun = (homerunElement != null) ? homerunElement.text() : "해당 사항 없음";

                    Element rbiElement = doc.selectFirst("div.rbi");
                    String rbi = (rbiElement != null) ? rbiElement.text() : "해당 사항 없음";

                    Element runElement = doc.selectFirst("div.run");
                    String run = (runElement != null) ? runElement.text() : "해당 사항 없음";

                    Element ballElement = doc.selectFirst("div.ball");
                    String ball = (ballElement != null) ? ballElement.text() : "해당 사항 없음";

                    Element strikeoutElement = doc.selectFirst("div.strikeout");
                    String strikeout = (strikeoutElement != null) ? strikeoutElement.text() : "해당 사항 없음";

                    Element warElement = doc.selectFirst("div.war");
                    String war = (warElement != null) ? warElement.text() : "해당 사항 없음";

                    Element teamElement = doc.selectFirst("div.team");
                    String team = (teamElement != null) ? teamElement.text() : "해당 사항 없음";

                    Element positionElement = doc.selectFirst("div.position");
                    String position = (positionElement != null) ? positionElement.text() : "해당 사항 없음";

                    Element tasooElement = doc.selectFirst("div.tasoo");
                    String tasoo = (tasooElement != null) ? tasooElement.text() : "해당 사항 없음";

                    // 데이터베이스에 저장
                    BatterVO vo = new BatterVO();
                    vo.setBno(k++);
                    vo.setAge(age);
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
                    vo.setName(name);
                    vo.setTeam(team);
                    vo.setPosition(position);
                    vo.setTasoo(tasoo);

                    dao.batterInsert(vo);

                    System.out.println("번호: " + k);
                    System.out.println("이름: " + name);
                    System.out.println("나이: " + age);
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
                    System.out.println("팀: " + team);
                    System.out.println("포지션: " + position);
                    System.out.println("타수: " + tasoo);
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
}
