<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	width: 800px;
}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div class="container">
		<h3 class="text-center">자료실</h3>
		<div class="row">
			<table class="table">
				<tr>
					<td>
						<a href="insert.do" class="btn btn-sm btn-info">등록</a>
					</td>
				</tr>
			</table>
			<table class="table">
				<thead>
					<tr>
						<th width="10%" class="text-center">번호</th>
						<th width="45%" class="text-center">제목</th>
						<th width="15%" class="text-center">이름</th>
						<th width="20%" class="text-center">작성일</th>
						<th width="10%" class="text-center">조회수</th>
					</tr>
				</thead>
				<%--
					디렉티브
					v-for
					v-if ~ v-else
					v-on:click => @click, v-on:change => @change, v-on:keydown => @keydown
					v-model => 사용자 입력과 Vue의 멤버 변수 연결
					v-bind => 생략이 가능
						<img v-bind:src=""> = <img :src="">
							Vue의 변수를 속성에 설정 => :속성
						<태그>{{}}</태그> => <태그>{}</태그>(React)
						     ==== 형식을 변경할 수 있다 ex) [[]]
							파이썬 : {{}}
					id/class => ref
					기반 => 자바스크립트 이용
				--%>
				<tbody>
					<tr>
						<td width="10%" class="text-center"></td>
						<td width="45%"></td>
						<td width="15%" class="text-center"></td>
						<td width="20%" class="text-center"></td>
						<td width="10%" class="text-center"></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="5" class="text-center">
							<input type="button" value="이전" class="btn-sm btn-primary">
								{{curpage}} page / {{totalpage}} pages
							<input type="button" value="다음" class="btn-sm btn-success">						
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
	</div>
	<script>
		let dataApp=Vue.createApp({
			// 변수 설정 => state
			data(){
				return{
					list:[],
					curpage:1,
					totalpage:0,
					count:0
				}
			},
			// 생명 주기 함수 => onload (시작과 동시에 값 가져 오기)
			// => 브라우저 출력 전에 서버로부터 데이터를 받는 경우
			mounted(){
				// dataRecv() => 오류
				this.dataRecv() // => this를 붙여야 한다
			},
			// 멤버 변수의 값이 변경된 경우 => Component 제작
			// Callback => Vue에 의하여 자동 호출되는 함수
			update(){
				
			},
			// 사용자 정의 메소드 => 이벤트 => 멤버 메소드
			methods:{
				// 서버에서 데이터를 읽어 온다 => 이전/다음/시작 => 반복 제거의 방법 : 메소드
				dataRecv(){
					alert("dataRecv() Call")
					axios.get('http://localhost:8080/web/databoard/list.do',{
						params:{
							page:this.curpage
						}
					}).then(response=>{
						console.log(response.data)
						this.list=response.data.list
						this.curpage=response.data.curpage
						this.totalpage=response.data.totalpage
						this.count=response.data.count
					}).catch(error=>{
						console.log(error.response)
					})
				}
			}
			// components / filter / computed
		}).mount('.container')
	</script>
</body>
</html>