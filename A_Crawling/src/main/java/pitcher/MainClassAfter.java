package pitcher;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class MainClassAfter {

    public static void main(String[] args) {
        MainClassAfter mc = new MainClassAfter();
        mc.pitcherData();
    }

    public void pitcherData() {
        PitcherDAO dao = PitcherDAO.newInstance();
        try {
            int k = 1;
            for (int i = 10001; i <= 15000
            		; i++) { // pitcher 번호 범위
                try {
                    Document doc = Jsoup.connect("https://statiz.sporki.com/player/?m=playerinfo&p_no=" + i).get();

                    // '베스트'가 있는 행을 선택
                    Element bestRow = doc.select("tr:contains(베스트)").first();
                    if (bestRow != null) {
                        Elements tds = bestRow.select("td");

                        // 이름은 div.name에서 추출
                        String name = doc.selectFirst("div.name").text(); // 이름
                        String team = tds.get(2).text();                   // 팀명
                        String position = tds.get(4).text();               // 포지션

                        // 투수인 경우에만 크롤링
                        if (!"P".equals(position)) {
                            System.out.println("투수가 아닙니다. 스킵합니다.");
                            continue;
                        }

                        int age = Integer.parseInt(tds.get(3).text());      // 나이
                        int game = Integer.parseInt(tds.get(5).text());     // 출장 수
                        int win = Integer.parseInt(tds.get(11).text());      // 승리
                        int lose = Integer.parseInt(tds.get(12).text());     // 패배
                        int hit = Integer.parseInt(tds.get(20).text());      // 피안타
                        int strikeout = Integer.parseInt(tds.get(27).text());// 삼진
                        int ball = Integer.parseInt(tds.get(24).text());    // 볼넷
                        double era = Double.parseDouble(tds.get(31).text()); // ERA
                        double war = Double.parseDouble(tds.get(37).text()); // WAR
                        double inning = Double.parseDouble(tds.get(15).text()); // 이닝
                        int save = Integer.parseInt(tds.get(13).text());     // 세이브
                        int hold = Integer.parseInt(tds.get(14).text());     // 홀드
                        
                     // 프로필 이미지 URL 추출
                        Element profileImg = doc.selectFirst("div.profile_img02 img");
                        String image = profileImg != null ? profileImg.attr("src") : null;

                        // 데이터 저장
                        PitcherVO vo = new PitcherVO();
                        vo.setPno(k++);
                        vo.setName(name);
                        vo.setTeam(team);
                        vo.setAge(age);
                        vo.setGame(game);
                        vo.setWin(win);
                        vo.setLose(lose);
                        vo.setHit(hit);
                        vo.setStrikeout(strikeout);
                        vo.setBall(ball);
                        vo.setEra(era);
                        vo.setWar(war);
                        vo.setInning(inning);
                        vo.setSave(save);
                        vo.setHold(hold);
                        vo.setImage(image);

                        dao.pitcherInsert(vo);

                        // 출력
                        System.out.printf("번호: %d%n", k - 1); // 번호 수정
                        System.out.printf("이름: %s%n", name);
                        System.out.printf("팀: %s%n", team);
                        System.out.printf("나이: %d%n", age);
                        System.out.printf("출장: %d%n", game);
                        System.out.printf("승: %d%n", win);
                        System.out.printf("패: %d%n", lose);
                        System.out.printf("피안타: %d%n", hit);
                        System.out.printf("삼진: %d%n", strikeout);
                        System.out.printf("볼넷: %d%n", ball);
                        System.out.printf("ERA: %.2f%n", era);
                        System.out.printf("WAR: %.2f%n", war);
                        System.out.printf("이닝: %.2f%n", inning);
                        System.out.printf("세이브: %d%n", save);
                        System.out.printf("홀드: %d%n", hold);
                        System.out.printf("프로필 이미지 URL: %s%n", image);
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
