package com.sist.web;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
import com.sist.vo.*;

import java.io.File;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

// Vue와 연결
@RestController
public class DataBoardRestController {

	@Autowired
	private DataBoardDAO dao;
	
	@GetMapping("databoard/list_vue.do")
	public String databoard_list(int page) throws Exception
	{
		int rowSize=10;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		
		List<DataBoardVO> list=dao.databoardListData(start, end);
		int count=dao.databoardCount();
		int totalpage=(int)(Math.ceil(count/10.0));
		count=count-((rowSize*page)-rowSize);
		
		// Vue로 데이터 전송
		Map map=new HashMap();
		map.put("list", list);
		map.put("count", count);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		
		// 자바스크립트 연결 => Map을 JSON으로 => Kotlin, Flutter
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		
		return json;
	}
	
	// Path => C:\springDev\springStudy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringFrontProject_5\
	// => C:\\springDev\\springStudy\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\SpringFrontProject_5\\
	
	@PostMapping(value="databoard/insert_vue.do",produces="text/plain;charset=UTF-8")
	public String databoard_insert(DataBoardVO vo,HttpServletRequest request)
	{
	/*	System.out.println(vo.getName());
		System.out.println(vo.getSubject());
		System.out.println(vo.getContent());
		System.out.println(vo.getPwd());
		System.out.println(vo.getFiles().size());

		if(vo.getFiles().size()>0)
		{
			for(int i=0;i<vo.getFiles().size();i++)
			{
				System.out.println(vo.getFiles().get(i).getOriginalFilename());
			}
		} */
		
		String result="";
		
		try
		{
			String path=request.getSession().getServletContext().getRealPath("/")+"upload\\";
			File dir=new File(path);
			if(!dir.exists())
			{
				dir.mkdir();
			}
			path=path.replace("\\", File.separator); // => (맥, 리눅스 : / 윈도우 : \\)
			// System.out.println(path);
			
			List<MultipartFile> list=vo.getFiles();
			if(list==null) // 업로드가 없는 경우
			{
				vo.setFilename("");
				vo.setFilesize("");
				vo.setFilecount(0);
			}
			else // 업로드가 있는 경우
			{
				String filename="";
				String filesize="";
				
				for(MultipartFile mf:list)
				{
					String name=mf.getOriginalFilename();
					File file=new File(path+name);
					mf.transferTo(file); // 업로드
					filename+=name+",";
					filesize+=file.length()+",";
				}
				
				filename=filename.substring(0,filename.lastIndexOf(","));
				filesize=filesize.substring(0,filesize.lastIndexOf(","));
				
				vo.setFilename(filename);
				vo.setFilesize(filesize);
				vo.setFilecount(list.size());
			}
			
			dao.databoardInsert(vo);
			
			result="yes";
		}catch(Exception ex)
		{
			result=ex.getMessage();
		}
		
		return result;
	}
}
