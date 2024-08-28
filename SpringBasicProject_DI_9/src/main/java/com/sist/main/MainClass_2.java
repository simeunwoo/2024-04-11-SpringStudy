package com.sist.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.*;
/*
 * 	@Component => @Target(value={TYPE})
 *                          =============== class 구분자
 *  @Repository => @Target(value={TYPE})
 *  
 *	@Autowired => @Target(value={CONSTRUCTOR, METHOD, PARAMETER, FIELD, ANNOTATION_TYPE})
 *
 *	@Qualifier => @Target(value={FIELD, METHOD, PARAMETER, TYPE, ANNOTATION_TYPE})
 *
 *	class A
 *	{
 *		@Autowired
 *		private B b; => FIELD (멤버 변수)
 *
 *		@Autowired
 *		public A(B b) => CONSTRUCTOR (생성자)
 *		{
 *			this.b=b;
 *		}
 *
 *		@Autowired => ANNOTATION_TYPE
 *		@Qualifier("")
 *		public void setB(@Autowired B b) => METHOD (메소드)
 *		{                    -------------- => PARAMETER (매개 변수)
 *			this.b=b;
 *		}
 *	}
 *
 *	어노테이션
 *	= 구분자 (인덱스)
 *	= 클래스 : TYPE
 *	= 매개 변수 : PARAMETER
 *	= 생성자 : CONSTRUCTOR
 *	= 메소드 : METHOD
 *
 *	클래스 등록
 *	========
 *	XML만 이용
 *	ANNOTATION만 이용
 *	XML+ANNOTATION 이용 (가장 많이 사용되는 형식)
 *
 *	XML : 라이브러리 클래스 등록 => 모든 프로그램에 공통으로 사용
 *	ANNOTATION : 사용자 정의 클래스 등록
 *		@Component : MainClass, ~Manager
 *		@Repository : DAO
 *		@Service : DAO 여러개
 *			게시판 + 댓글
 *			Emp + Dept
 *		=========================
 *		@Controller
 *		@RestController
 *		@ControllerAdvice
 */
@Component("mc")
public class MainClass_2 {
	@Autowired // 자동으로 스프링에 같은 객체를 찾아서 주소값 대입
	@Qualifier("oracle") // 선택 ("oracle" or "mysql") => 객체 지정 (여러개 있는 경우 한개 선택 => @Qualifier)
	// @Resource(name="oracle") => @Autowired + @Qualifier
	private MyDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=
				new ClassPathXmlApplicationContext("application-*.xml");
		MainClass_2 mc=(MainClass_2)app.getBean("mc");
		mc.dao.connection();
	}

}
