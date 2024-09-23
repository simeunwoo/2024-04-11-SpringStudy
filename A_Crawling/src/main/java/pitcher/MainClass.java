package pitcher;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class MainClass {

    public static void main(String[] args) {
        MainClass mc = new MainClass();
        mc.pitcherData();
    }

    public void pitcherData() {
        PitcherDAO dao = PitcherDAO.newInstance();
        try {
            int k = 1;
            for (int i = 13001; i <= 14000; i++) { // pitcher 번호 범위
                try {
                    Document doc = Jsoup.connect("https://statiz.sporki.com/player/?m=playerinfo&p_no=" + i).get();

                    // 'P'인지 확인
                    Element positionElement = doc.select("div.con span").get(1);
                    if (positionElement != null && positionElement.text().equals("P")) {
                        // '베스트'가 있는 행을 선택
                        Element bestRow = doc.select("tr:contains(베스트)").first();
                        if (bestRow != null) {
                            Elements tds = bestRow.select("td");

                            // 데이터 추출
                            String name = safeGetText(doc.selectFirst("div.name")); // 이름
                            String team = safeGetText(tds.get(2)); // 팀
                            int age = safeGetInt(tds, 3); // 나이
                            int game = safeGetInt(tds, 5); // 출장 수 (앞의 값)
                            int win = safeGetInt(tds, 11); // 승리
                            int lose = safeGetInt(tds, 12); // 패배
                            int hit = safeGetInt(tds, 20); // 피안타
                            int strikeout = safeGetInt(tds, 27); // 삼진
                            int ball = safeGetInt(tds, 24); // 볼넷
                            double era = safeGetDouble(tds, 29); // ERA
                            double war = safeGetDouble(tds, 31); // WAR
                            double inning = safeGetDouble(tds, 15); // 이닝
                            int save = safeGetInt(tds, 13); // 세이브 (두 번째 0)
                            int hold = safeGetInt(tds, 14); // 홀드 (세 번째 0)

                            // 데이터 저장
                            PitcherVO vo = new PitcherVO();
                            vo.setPno(k++); // 자동 증가 번호
                            vo.setName(name); // 이름
                            vo.setTeam(team); // 팀
                            vo.setAge(age); // 나이
                            vo.setGame(game); // 출장 수
                            vo.setWin(win); // 승리
                            vo.setLose(lose); // 패배
                            vo.setHit(hit); // 피안타
                            vo.setStrikeout(strikeout); // 삼진
                            vo.setBall(ball); // 볼넷
                            vo.setEra(era); // ERA
                            vo.setWar(war); // WAR
                            vo.setInning(inning); // 이닝
                            vo.setSave(save); // 세이브
                            vo.setHold(hold); // 홀드

                            dao.pitcherInsert(vo);

                            // 데이터 출력
                            printPitcherInfo(k, name, team, age, game, win, lose, hit, strikeout, ball, era, war, inning, save, hold);
                        } else {
                            System.out.println("베스트 기록이 없습니다.");
                        }
                    } else {
                        System.out.println("투수가 아닙니다: " + i);
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

    private String safeGetText(Element element) {
        return (element != null) ? element.text() : "";
    }

    private int safeGetInt(Elements tds, int index) {
        try {
            return Integer.parseInt(tds.get(index).text());
        } catch (Exception e) {
            return 0; // 기본값 설정
        }
    }

    private double safeGetDouble(Elements tds, int index) {
        try {
            return Double.parseDouble(tds.get(index).text());
        } catch (Exception e) {
            return 0.0; // 기본값 설정
        }
    }

    private void printPitcherInfo(int k, String name, String team, int age, int game, int win, int lose, int hit, int strikeout, int ball, double era, double war, double inning, int save, int hold) {
        System.out.println("번호: " + k);
        System.out.println("이름: " + name);
        System.out.println("팀: " + team);
        System.out.println("나이: " + age);
        System.out.println("출장: " + game);
        System.out.println("승: " + win);
        System.out.println("패: " + lose);
        System.out.println("피안타: " + hit);
        System.out.println("삼진: " + strikeout);
        System.out.println("볼넷: " + ball);
        System.out.println("ERA: " + era);
        System.out.println("WAR: " + war);
        System.out.println("이닝: " + inning);
        System.out.println("세이브: " + save);
        System.out.println("홀드: " + hold);
        System.out.println("==============================================");
    }
}
