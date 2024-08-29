package com.sist.main;
import java.util.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sist.config.DataBaseConfig;
import com.sist.config.MusicConfig;
import com.sist.dao.*;
import com.sist.vo.*;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class[] cls= {MusicConfig.class,DataBaseConfig.class};
		AnnotationConfigApplicationContext app=
				new AnnotationConfigApplicationContext(cls);
		MusicDAO dao=(MusicDAO)app.getBean("dao");
		List<MusicVO> list=dao.musicListData();
		for(MusicVO vo:list)
		{
			System.out.println(
					vo.getMno()+"."+vo.getTitle()
					);
		}
	}

}
