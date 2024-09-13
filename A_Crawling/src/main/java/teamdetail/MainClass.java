package Team;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        // MainClass 인스턴스 생성 및 메서드 호출
        MainClass mc = new MainClass();
        mc.teamData();
    }
    
    // https://statiz.sporki.com/season/?m=teamoverall&year=2024
    
    // https://statiz.sporki.com/stats/?m=team&m2=all
    // https://statiz.sporki.com/stats/?m=team&m2=all&year=2023

    public void teamData() {
        TeamDAO dao = TeamDAO.newInstance();
        try {
            int k = 1;
            for (int i = 1; i <= 200; i++) {
            //  Document doc = Jsoup.connect("https://www.5gcamp.com/?c=camp&p=" + i).get();
                Document doc = Jsoup.connect("https://statiz.sporki.com/season/?m=teamoverall&year="+i).get();
                Elements link = doc.select("div.contright div.subject a");

                //for (int j = 0; j < link.size(); j++)
                for(int j=2024;j>=1982;j--)
                {
                    try {
                        System.out.println("번호:" + k++);
                        String url = link.get(j).attr("href");
                        if (!url.contains("http")) {
                            url = "http://www.5gcamp.com" + link.get(j).attr("href");
                        }
                        Document doc2 = Jsoup.connect(url).get();

                        // 캠핑장 이름
                        Element camp_name = doc2.selectFirst("div#contents div#campcontents div.viewheader h3.camp_subject");
                        String campNameText = (camp_name != null) ? camp_name.text() : "해당 사항 없음";
                        System.out.println("캠핑장 이름: " + campNameText);

                        // 주소
                        Element camp_addr = doc2.selectFirst("div.tse-scroll-content div.tse-content div.content h4.chead a.clipboardCopy");
                        String campAddrText = (camp_addr != null) ? camp_addr.text() : "해당 사항 없음";
                        System.out.println("주소: " + campAddrText);

                        // 전화번호
                        Element camp_phone = doc2.selectFirst("div.tse-scroll-content div#camping_view div#vContent h4:matches(\\d{3}-\\d{4}-\\d{4})");
                        String campPhoneText = (camp_phone != null) ? camp_phone.text() : "해당 사항 없음";
                        System.out.println("전화번호: " + campPhoneText);

                        // 가장 싼 가격
                        Elements priceElements = doc2.select("table.pricetable tbody tr:contains('주말') td.td3");
                        List<Integer> prices = new ArrayList<>();

                        for (Element priceElement : priceElements) {
                            try {
                                int price = Integer.parseInt(priceElement.text().replace(",", ""));
                                if (price > 0 && price < 1000000) {
                                    prices.add(price);
                                }
                            } catch (NumberFormatException e) {
                                System.err.println("가격 변환 오류: " + priceElement.text());
                            }
                        }

                        Integer campPriceValue = null;
                        if (!prices.isEmpty()) {
                            prices.sort(Integer::compareTo);
                            int minPrice = prices.get(0);
                            campPriceValue = (minPrice == 0 && prices.size() > 1) ? prices.get(1) : minPrice;
                        }

                        String priceText = (campPriceValue != null) ? Integer.toString(campPriceValue) : "해당 사항 없음";
                        System.out.println("가장 싼 가격: " + priceText);

                        // 상세 내용
                        Element camp_content = doc2.selectFirst("div.short_cont");
                        String campContentText = (camp_content != null) ? camp_content.text() : "해당 사항 없음";
                        System.out.println("상세 내용: " + campContentText);
                        
                        // 캠핑장 이미지: 첫 번째 이미지 링크만 추출
                        Element firstImageElement = doc2.selectFirst("div.photos div.timg a");
                        String camp_image = (firstImageElement != null) ? firstImageElement.attr("href") : "해당 사항 없음";
                        System.out.println("캠핑장 이미지: " + camp_image);

                        // 와이파이 여부
                        Element wifiElement = doc2.selectFirst("p.f_name:contains(와이파이)");
                        String camp_wifi = (wifiElement != null && wifiElement.hasClass("no")) ? "n" : "y";
                        System.out.println("와이파이 여부: " + camp_wifi);

                        // 매점 여부
                        Element storeElement = doc2.selectFirst("p.f_name:contains(매점)");
                        String camp_store = (storeElement != null && storeElement.hasClass("no")) ? "n" : "y";
                        System.out.println("매점 여부: " + camp_store);

                        // 반려동물 동반 여부
                        Element animalElement = doc2.selectFirst("p.f_name:contains(반려동물 동반)");
                        String camp_animal = (animalElement != null && animalElement.hasClass("no")) ? "n" : "y";
                        System.out.println("반려동물 동반 여부: " + camp_animal);

                        System.out.println("==============================================");

                        // 데이터베이스에 저장
                        CampaVO vo = new CampaVO();
                        vo.setCamp_name(campNameText);
                        vo.setCamp_addr(campAddrText);
                        vo.setCamp_phone(campPhoneText);
                        vo.setCamp_price((campPriceValue != null) ? campPriceValue : 0);  // null이면 0으로 저장
                        vo.setCamp_content(campContentText);
                        vo.setCamp_image(camp_image);
                        vo.setCamp_wifi(camp_wifi);
                        vo.setCamp_store(camp_store);
                        vo.setCamp_animal(camp_animal);
                        dao.campInsert(vo);
                        /*
                  		   ps.setInt(1, vo.getCamp_no());
						   ps.setInt(2, vo.getCamp_price());  // 0으로 처리된 campPriceValue를 저장
						   ps.setString(3, vo.getCamp_name());
						   ps.setString(4, vo.getCamp_addr());
						   ps.setString(5, vo.getCamp_phone());
						   ps.setString(6, vo.getCamp_content());
						   ps.setString(7, "http://www.5gcamp.com"+vo.getCamp_image());
						   ps.setString(8, vo.getCamp_wifi());
						   ps.setString(9, vo.getCamp_store());
						   ps.setString(10, vo.getCamp_animal());
                         */

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
            System.out.println("저장 완료!!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
