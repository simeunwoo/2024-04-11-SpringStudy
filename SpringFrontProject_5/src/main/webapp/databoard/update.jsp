<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
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
		<h3 class="text-center">수정하기</h3>
		<div class="row">
			<form @submit.prevent="submitForm()">
			<%--
				기능 수행 (이벤트 방지) : defaultPrevent()
				FormData
			--%>
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
							<input type="submit" class="btn btn-sm btn-info" value="수정">
							<input type="button" class="btn btn-sm btn-warning" value="취소"
							  onclick="javascript:history.back()">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<%--
		CRUD
		=> 1. 게시판
		=> 2. 파일 업로드/다운로드
		=> 3. 댓글
		=> 4. 예약 / 장바구니 / 결제
	--%>
	<script>
		let updateApp=Vue.createApp({
			data(){
				return{
					name:'',
					subject:'',
					content:'',
					pwd:'',
					no:${no},
					upfiles:''
				}
			},
			mounted(){
				axios.get('update_vue.do',{
					params:{
						no:this.no
					}
				}).then(response=>{
					this.name=response.data.name // HTML에 시작하자마자 바로 출력
					this.subject=response.data.subject // HTML에 시작하자마자 바로 출력
					this.content=response.data.content // HTML에 시작하자마자 바로 출력
				}).catch(error=>{
					console.log(error.response)
				})
			},
			updated(){
				
			},
			methods:{
				submitForm(){
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
					
					let formData=new FormData()
					formData.append("name",this.name)
					formData.append("subject",this.subject)
					formData.append("content",this.content)
					formData.append("pwd",this.pwd)
					formData.append("no",this.no)
					
					let len=this.$refs.upfiles.files.length
					if(len>0)
					{
						for(let i=0;i<len;i++)
						{
							formData.append("files["+i+"]",this.$refs.upfiles.files[i])
						}
					}
					
					axios.post('update_ok_vue.do',formData,{
						header:{
							'Content-Type':'multipart/form-data'
						}
					}).then(response=>{
						if(response.data==='yes')
						{
							location.href='detail.do?no='+this.no
						}
						else
						{
							alert("잘못된 비밀 번호입니다")
							this.pwd=""
							this.$refs.pwd.focus()
						}
					}).catch(error=>{
						console.log(error.response)
					})
				}
			},
			components:{
				
			}
		}).mount('.container')
	</script>
</body>
</html>