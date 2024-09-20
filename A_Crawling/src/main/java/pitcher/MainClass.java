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
            for (int i = 11001; i <= 11200; i++) { // pitcher 번호 범위
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
                            String name = safeGetText(doc.selectFirst("div.name"));
                            String team = safeGetText(tds.get(2));
                            int age = safeGetInt(tds, 3);
                            int game = safeGetInt(tds, 7);
                            int win = safeGetInt(tds, 8);
                            int lose = safeGetInt(tds, 9);
                            int hit = safeGetInt(tds, 10);
                            int strikeout = safeGetInt(tds, 11);
                            int ball = safeGetInt(tds, 12);
                            double era = safeGetDouble(tds, 13);
                            double war = safeGetDouble(tds, 14);
                            int inning = safeGetInt(tds, 15);
                            int save = safeGetInt(tds, 16);
                            int hold = safeGetInt(tds, 17);

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

    private void printPitcherInfo(int k, String name, String team, int age, int game, int win, int lose, int hit, int strikeout, int ball, double era, double war, int inning, int save, int hold) {
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
