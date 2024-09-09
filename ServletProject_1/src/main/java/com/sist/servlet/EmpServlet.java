package com.sist.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet("/EmpServlet") // => 스프링에는 존재하지 X
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		// web.xml에 등록된 <init-param>
		// config.getInitParameter(param-name) => 생성자 역할 (초기화 담당)
		String path=config.getInitParameter("contextConfigLocation");
		System.out.println(path);
	}

	public void destroy() {
		// TODO Auto-generated method stub
		// 브라우저 종료 / 화면 이동 / 새로 고침
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 사용자 요청에 의한 화면에 데이터 전송 및 화면 변경
		System.out.println("화면 요청");

	}

}
