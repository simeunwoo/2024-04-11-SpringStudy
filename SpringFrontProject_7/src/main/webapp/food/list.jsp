<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	자바 : 변수(데이터형), 연산자, 제어문, 배열
	
	객체 지향 프로그램
		캡슐화, 다형성(오버라이딩)
		클래스, 객체
		인터페이스 / 추상 클래스
		라이브러리 => java.lang / java.util / java.io
		
	오라클 : DML(INSERT, UPDATE, DELETE) / DQL(SELECT)=>JOIN/SUBQUERY
	
	JSP : 지시자(taglib, page), 내장 객체(request, response, session)
		cookie, EL, JSTL, MVC
	
	Spring : DI, AOP, MVC, ORM(MyBatis)
	
	===================================================================== Back-End
	
	Front : jQuery(AJAX), HTML, CSS
		Vue, React, Redux, React-Query => 우대
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top: 50px;
}
.row{
	margin: 0px auto;
	width: 960px;
}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div class="container">
		<h1 class="text-center">맛집 목록</h1>
		<div class="row">
			
		</div>
		<div style="height:10px"></div>
		<div class="row">
			
		</div>
	</div>
	<script>
		let listApp=Vue.createApp({
			// Model => 데이터 관리 => Vue/React : 상태 관리 => state
			data(){
				return{
					// 데이터 값이 변경되면 => HTML에 출력한 데이터가 변경됨
					list:[],
					curpage:1,
					totalpage:0,
					startPage:0,
					endPage:0
				}
			},
			// data에 있는 변수의 값을 변경 => 초기화
			mounted(){
				// mounted => 함수가 한개씩
				// window.onload => $(function(){}) => componentDidMount()
				//            => useEffect()
				this.dataRecv()
			},
			// 사용자 요청에 따라 변경 => 사용자 요청 => 이벤트
			// => @click="함수명", v-on:click="함수명"
			// => @change="함수명", @mouseover, @keyup, @keydown
			// => @keydown.enter, @keydown.space, @keydown.up ...
			methods:{
				// methods => 함수가 여러개씩
				// => 공통으로 사용하는 함수
				dataRecv(){
					axios.get('../food/list_vue.do',{
						page:this.curpage
					}).then(response=>{
						
					}).catch(error=>{
						
					})
				}
			}
		}).mount('.container')
	</script>
</body>
</html>