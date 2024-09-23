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
<!--
	ES 5 => type="text/javascript"
	ES 6 => type="text/babel" or 생략
-->
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
					<th width="20%" class="text-right">비밀 번호</th>
					<td width="80%">
						<input type="password" size="10" v-model="pwd" ref="pwd" class="input-sm">
					</td>
				</tr>
				<tr>
					<td colspan="2" class="text-center">
						<input type="button" class="btn btn-sm btn-info" value="글 쓰기"
						  @click="boardInsert()">
						<input type="button" class="btn btn-sm btn-warning" value="취소"
						  onclick="javascript:history.back()">
					</td>
				</tr>
			</table>
		</div>
	</div>
	<script>
		let insertApp=Vue.createApp({
			data(){
				return{
					name:'',
					subject:'',
					content:'',
					pwd:''
				}
			},
			methods:{
				boardInsert(){
					if(this.name==="")
					{
						this.$refs.name.focus()
						return
					}
					if(this.subject==="")
					{
						this.$refs.subject.focus()
						return
					}
					if(this.content==="")
					{
						this.$refs.content.focus()
						return
					}
					if(this.pwd==="")
					{
						this.$refs.pwd.focus()
						return
					}
					// Spring에서 데이터가 POST 방식일 경우 => 3번째 매개 변수를 데이터로 인식
					axios.post('http://localhost:8080/web/board/insert_vue.do',null,{
						params:{
							name:this.name,
							subject:this.subject,
							content:this.content,
							pwd:this.pwd
						}
					}).then(response=>{
						if(response.data==="yes")
						{
							location.href="list.do"
						}
						else
						{
							alert("error 발생")
						}
					}).catch(error=>{ // Ajax의 error 느낌
						console.log(error.response)
					})
				}
			}
		}).mount('.container')
	</script>
</body>
</html>