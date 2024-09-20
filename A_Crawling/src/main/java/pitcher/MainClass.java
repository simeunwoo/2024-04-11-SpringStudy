package pitcher;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainClass {

    public static void main(String[] args) {
        // MainClass 인스턴스 생성 및 메서드 호출
        MainClass mc = new MainClass();
        mc.pitcherData();
    }

    public void pitcherData() {
        PitcherDAO dao = PitcherDAO.newInstance();
        try {
            int pno = 1;  // pno 값 1부터 시작

            // 크롤링할 페이지 반복
            for (int i = 10000; i <= 20000; i++) {
                // 각 선수의 정보를 가져올 URL
                Document doc = Jsoup.connect("https://statiz.sporki.com/player/?m=playerinfo&p_no=" + i).get();
                
                // 원하는 데이터 추출
                // 선수 이름
                Element nameElement = doc.selectFirst("div.subject a");
                String name = (nameElement != null) ? nameElement.text() : "Unknown";
                
                // 게임, 승리, 패배, 안타, 삼진, 볼넷, ERA, WAR 등의 통계 데이터
                Elements statsElements = doc.select("td");
                int game = Integer.parseInt(statsElements.get(4).text());
                int win = Integer.parseInt(statsElements.get(7).text());
                int lose = Integer.parseInt(statsElements.get(8).text());
                int hit = Integer.parseInt(statsElements.get(18).text());
                int strikeout = Integer.parseInt(statsElements.get(23).text());
                int ball = Integer.parseInt(statsElements.get(21).text());
                double era = Double.parseDouble(statsElements.get(29).text());
                double war = Double.parseDouble(statsElements.get(3).text());

                // 팀명과 로고
                Element teamElement = doc.selectFirst("div.teams img");
                String team = (teamElement != null) ? teamElement.attr("alt") : "Unknown";
                String logo = (teamElement != null) ? teamElement.attr("src") : "Unknown";

                // 경력 (별도의 페이지에서 크롤링 필요할 수 있음)
                String career = "Unknown";  // 경력을 추가로 수집할 수 있음

                // 나이 (해당 정보도 다른 페이지에서 얻어올 수 있음)
                int age = 0;  // 추가로 나이 정보를 얻어올 수 있으면 이곳에 저장

                // PitcherVO 객체에 데이터 설정
                PitcherVO vo = new PitcherVO();
                vo.setPno(pno++);
                vo.setName(name);
                vo.setGame(game);
                vo.setWin(win);
                vo.setLose(lose);
                vo.setHit(hit);
                vo.setStrikeout(strikeout);
                vo.setBall(ball);
                vo.setEra(era);
                vo.setWar(war);
                vo.setTeam(team);
                vo.setLogo(logo);
                vo.setCareer(career);
                vo.setAge(age);

                // 데이터베이스에 저장
                dao.pitcherInsert(vo);
            }
            System.out.println("크롤링 및 저장 완료!!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
