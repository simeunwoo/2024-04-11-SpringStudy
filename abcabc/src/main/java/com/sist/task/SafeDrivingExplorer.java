package com.sist.task;

import java.io.InputStreamReader;
import java.util.*;
import com.sist.vo.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.BufferedReader;
import java.io.IOException;

public class SafeDrivingExplorer {

    private static double[] lngs= {0.0,127.07,126.87,127.69,127.01,127.43,128.68,128.58,129.06,126.89};
    private static double[] lats= {0.0,37.51,37.50,37.44,37.30,36.32,35.84,35.22,35.19,35.17};

    public static List<SafeDrivingVO> safeDrivingData(int no) throws IOException {
        double lng = lngs[no];
        double lat = lats[no];
        double minX = lng - 1;
        double maxX = lng + 1;
        double minY = lat - 1;
        double maxY = lat + 1;

        StringBuilder urlBuilder = new StringBuilder("https://openapi.its.go.kr:9443/posIncidentInfo"); // URL
        urlBuilder.append("?" + URLEncoder.encode("apiKey", "UTF-8") + "=" + URLEncoder.encode("2052e1a7edbe45b185faaec832aa0625", "UTF-8")); /*공개키*/
        urlBuilder.append("&" + URLEncoder.encode("minX","UTF-8") + "=" + URLEncoder.encode("126.800000", "UTF-8")); /*최소경도영역*/
        urlBuilder.append("&" + URLEncoder.encode("maxX","UTF-8") + "=" + URLEncoder.encode("127.890000", "UTF-8")); /*최대경도영역*/
        urlBuilder.append("&" + URLEncoder.encode("minY","UTF-8") + "=" + URLEncoder.encode("34.900000", "UTF-8")); /*최소위도영역*/
        urlBuilder.append("&" + URLEncoder.encode("maxY","UTF-8") + "=" + URLEncoder.encode("35.100000", "UTF-8")); /*최대위도영역*/
        urlBuilder.append("&" + URLEncoder.encode("getType","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*출력타입*/
        
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "text/xml;charset=UTF-8");

        System.out.println("Response code: " + conn.getResponseCode());

        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        // Jsoup을 사용하여 XML 파싱
        Document doc = Jsoup.parse(sb.toString());
        Elements ot = doc.select("outbrkType");
        Elements rn = doc.select("routeNo");
        Elements rr = doc.select("revRouteName");
        Elements ms = doc.select("message");

        List<SafeDrivingVO> safe_list = new ArrayList<SafeDrivingVO>();

        for (int i = 0; i < ot.size(); i++) {
            System.out.println(ot.get(i).text() + " "
                    + rn.get(i).text() + " "
                    + rr.get(i).text() + " "
                    + ms.get(i).text());

            SafeDrivingVO vo = new SafeDrivingVO();
            vo.setOutbrkType(ot.get(i).text());
            vo.setRevRouteName(rn.get(i).text());
            vo.setRouteNo(rr.get(i).text());
            vo.setMessage(ms.get(i).text());
            safe_list.add(vo);
        }

        return safe_list;
    }

    // Main 메소드 추가
    public static void main(String[] args) {
        try {
            List<SafeDrivingVO> safe_data = safeDrivingData(1);
            for (SafeDrivingVO vo : safe_data) {
            	System.out.println("Outbreak Type: " + vo.getOutbrkType());
                System.out.println("Route Number: " + vo.getRouteNo());
                System.out.println("RevRoute Name: " + vo.getRevRouteName());
                System.out.println("Message: " + vo.getMessage());
                System.out.println("------------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
