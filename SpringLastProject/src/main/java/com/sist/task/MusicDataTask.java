package com.sist.task;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MusicDataTask {

	@Scheduled(fixedRate = 10000)
	public void musicAllData()
	{
		List<String> list=new ArrayList<String>();		
		try
		{
			Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
			Elements title=doc.select("div.music-list-wrap table.list-wrap a.title");
			for(int i=0;i<title.size();i++)
			{
				// System.out.println((i+1)+"."+title.get(i).text());
				list.add(title.get(i).text());
			}
			Collections.shuffle(list);
			for(int i=0;i<list.size();i++)
			{
				System.out.println((i+1)+"."+list.get(i));
			}
			System.out.println("=====================================");
		}catch(Exception ex) {}
	}
/*
1.Small girl (Feat. 도경수 (D.O.))
2.슬픈 초대장
3.Armageddon
4.SPOT! (Feat. JENNIE)
5.예뻤어
6.소나기
7.사건의 지평선
8.헤어지자 말해요
9.내게 사랑이 뭐냐고 물어본다면
10.나는 아픈 건 딱 질색이니까
11.Sticky
12.사랑은 늘 도망가
13.클락션 (Klaxon)
14.Supernatural
15.UP (KARINA Solo)
16.Mantra
17.연애편지
18.천상연
19.이제 나만 믿어요
20.모래 알갱이
21.인생찬가
22.내 이름 맑음
23.Love wins all
24.무지개
25.I AM
26.비의 랩소디
27.우리들의 블루스
28.보금자리
29.HAPPY
30.Cruel Summer
31.어떻게 이별까지 사랑하겠어, 널 사랑하는 거지
32.Magnetic
33.온기
34.Home
35.녹아내려요
36.고민중독
37.한 페이지가 될 수 있게
38.Supernova
39.Do or Die
40.Supersonic
41.London Boy
42.Polaroid
43.Welcome to the Show
44.해야 (HEYA)
45.다정히 내 이름을 부르면
46.첫 만남은 계획대로 되지 않아
47.그대만 있다면 (여름날 우리 X 너드커넥션 (Nerd Connection))
48.다시 만날 수 있을까
49.에피소드
50.How Sweet
=====================================
 */
}

