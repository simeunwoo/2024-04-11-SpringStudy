package com.sist.web;
import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/*
### SQL 관련 - 프로시저 ###

-- Shop => 프로시저 => ERP (반복) => 반복 제거
-- 리턴형이 없다 => Call By Reference : 매개 변수로 값을 받는다
	> 매개 변수
		IN => ? (SQL 문장을 실행하기 위하여 첨부하는 데이터)
			WHERE no=?
		OUT => 실행 결과를 가지고 올 때 사용
		매개 변수
		1) 일반 변수 => %TYPE (실제 테이블 컬럼의 데이터형)
			pNo board.no%TYPE
		2) RECORD 단위 => List / VO
		 	CURSOR => SYS_REFCURSOR
	> 생성 형식
		CREATE [OR REPLACE] PROCEDURE proc_name(매개 변수)
		IS | AS
		BEGIN
			SQL 제어
		END;
		/
	> 삭제
		DROP PROCEDURE proc_name
-- 목록 출력
-- 총 페이지
	CREATE OR REPLACE PROCEDURE seoulShopTotalPage(
	    pTotal OUT NUMBER
	)
	IS
	BEGIN
	    SELECT CEIL(COUNT(*)/12.0) INTO pTotal
	    FROM project_seoul_shop;
	END;
	/
-- 상세 보기
	CREATE OR REPLACE PROCEDURE seoulShopDetailData(
	    pNo project_seoul_shop.no%TYPE,
	    pResult OUT SYS_REFCURSOR
	)
	IS
	BEGIN
	    OPEN pResult FOR
	    SELECT no,title,poster,address,msg
	    FROM project_seoul_shop
	    WHERE no=pNo;
	END;
	/
-- 댓글 : 프로시저 (함수 => 기능 => CRUD)
 */
@RestController
public class SeoulRestController {

	@Autowired
	private SeoulService sService;
	
	@GetMapping(value="seoul/location_vue.do",produces="text/plain;charset=UTF-8")
	public String seoul_location(int page) throws Exception
	{
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		List<SeoulVO> list=sService.seoulLocationListData(map);
		int totalpage=sService.seoulLocationTotalPage();
		
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		map=new HashMap();
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
	
	@GetMapping(value="seoul/nature_vue.do",produces="text/plain;charset=UTF-8")
	public String seoul_nature(int page) throws Exception
	{
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		List<SeoulVO> list=sService.seoulNatureListData(map);
		int totalpage=sService.seoulNatureTotalPage();
		
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		map=new HashMap();
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
	
/*	@GetMapping(value="seoul/shop_vue.do",produces="text/plain;charset=UTF-8")
	public String seoul_shop(int page) throws Exception
	{
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		List<SeoulVO> list=sService.seoulShopListData(map);
		int totalpage=sService.seoulShopTotalPage();
		
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		map=new HashMap();
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	} */
	
	@GetMapping(value = "seoul/location_detail_vue.do", produces = "text/plain;charset=UTF-8")
	public String location_detail(int no) throws Exception {
		SeoulVO vo = sService.seoulLocationDetailData(no);

		// 04340 서울 용산구 남산공원길 105 (용산동2가, YTN서울타워)
		String addr1 = vo.getAddress();
		addr1 = addr1.substring(addr1.indexOf(" ") + 1);
		String addr2 = addr1.trim();
		addr2=addr2.substring(addr2.indexOf(" ")+1);
		String addr3=addr2.trim();
		addr3=addr3.substring(0, addr3.indexOf(" "));
		vo.setAddr(addr3.trim());
		System.out.println("주소 : "+vo.getAddr());
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(vo);
		
		return json;
	}
	
	@GetMapping(value="seoul/nature_detail_vue.do",produces="text/plain;charset=UTF-8")
	public String nature_detail(int no) throws Exception
	{
		SeoulVO vo=sService.seoulNatureDetailData(no);
		
		// 04340 서울 용산구 남산공원길 105 (용산동2가, YTN서울타워)
		String addr1=vo.getAddress();
		addr1=addr1.substring(addr1.indexOf(" ")+1);
		String addr2=addr1.trim();
		addr2=addr2.substring(addr2.indexOf(" ")+1);
		String addr3=addr2.trim();
		addr3=addr3.substring(0, addr3.indexOf(" "));
		vo.setAddr(addr3.trim());
		System.out.println("주소 : "+vo.getAddr());
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(vo);
		
		return json;
	}
	
/*	@GetMapping(value="seoul/shop_detail_vue.do",produces="text/plain;charset=UTF-8")
	public String shop_detail(int no) throws Exception
	{
		SeoulVO vo=sService.seoulShopDetailData(no);
		
		// 04340 서울 용산구 남산공원길 105 (용산동2가, YTN서울타워)
		String addr1=vo.getAddress();
		addr1=addr1.substring(addr1.indexOf(" ")+1);
		String addr2=addr1.trim();
		addr2=addr2.substring(addr2.indexOf(" ")+1);
		String addr3=addr2.trim();
		addr3=addr3.substring(0, addr3.indexOf(" "));
		vo.setAddr(addr3.trim());
		System.out.println("주소 : "+vo.getAddr());
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(vo);
		
		return json;
	} */
}
