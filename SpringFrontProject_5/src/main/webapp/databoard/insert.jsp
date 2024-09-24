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
	width: 600px;
}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div class="container">
		<h3 class="text-center">글 쓰기</h3>
		<div class="row">
			<table class="table">
				<tr>
					<th width="20%" class="text-right">이름</th>
					<td width="80%">
						<input type="text" size="15" v-model="name" ref="name" class="input-sm">
					</td>
				</tr>
				<tr>
					<th width="20%" class="text-right">제목</th>
					<td width="80%">
						<input type="text" size="50" v-model="subject" ref="subject" class="input-sm">
					</td>
				</tr>
				<tr>
					<th width="20%" class="text-right">내용</th>
					<td width="80%">
						<textarea rows="10" cols="52" v-model="content" ref="content"></textarea>
					</td>
				</tr>
				<tr>
					<th width="20%" class="text-right">첨부 파일</th>
					<td width="80%">
						<input type="file" ref="upfiles" class="input-sm"
						  v-model="upfiles"
						  multiple="multiple"
						  accept="upload/*"
						  >
					</td>
				</tr>
				<tr>
					<th width="20%" class="text-right">비밀 번호</th>
					<td width="80%">
						<input type="password" size="10" v-model="pwd" ref="pwd" class="input-sm">
					</td>
				</tr>
				<tr>
					<td colspan="2" class="text-center">
						<input type="submit" class="btn btn-sm btn-info" value="글 쓰기">
						<input type="button" class="btn btn-sm btn-warning" value="취소"
						  onclick="javascript:history.back()">
					</td>
				</tr>
			</table>
		</div>
	</div>
	<script>
		let insertApp=Vue.createApp({
			data(){ // Model => 데이터 관리 => 변수 설정
				return{ // v-model과 관련
					name:'',
					subject:'',
					content:'',
					pwd:'',
					upfiles:''
				}
			},
			mounted() // VM => 데이터를 변경하여 View(HTML)로 전송
					// Callback => 자동 호출 => 생명 주기 함수
					// init() 느낌 => 변수의 초기화
			{
				
			},
			updated(){ // 데이터값이 변경되면 자동 호출
				
			},
			methods:{ // 사용자 정의 함수 : 멤버 함수
				
			}
			// 그 외 => components: / computed: / filter: / watch: ...
		}).mount('.container')
	</script>
</body>
</html>