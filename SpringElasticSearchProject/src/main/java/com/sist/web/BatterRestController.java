package com.sist.web;
import java.util.*;
import java.io.*;
import java.net.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatterRestController {

	@GetMapping(value="batter/find_vue.do",produces="text/plain;charset=UTF-8")
	public String batter_find(String name) throws Exception
	{
		String strUrl="http://localhost:9200/batter/_search?q=name="
						+URLEncoder.encode(name,"UTF-8");
		// http://localhost:9200/batter/_search?q=name=%EC%B6%94%EC%8B%A0%EC%88%98
		
		URL url=new URL(strUrl);
		// url 연결
		HttpURLConnection conn=(HttpURLConnection)url.openConnection();
		StringBuffer sb=new StringBuffer(); // 데이터를 모아둔다	
		if(conn!=null) // 사이트에 연결이 된 경우
		{
			BufferedReader in=new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			while(true)
			{
				String data=in.readLine();
				if(data==null)
					break;
				sb.append(data);
			}
			in.close();
		}
		
		return sb.toString();
	}
}
