package com.sist.commons;
import java.util.*;

public class CommonsPage {

	public static Map pageConfig(String page,int rowSize)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		// rowSize 개수 설정은 X => 언제든지 바뀔 수 있으므로
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		map.put("start", start);
		map.put("end", end);
		
		return map;
	}
}
