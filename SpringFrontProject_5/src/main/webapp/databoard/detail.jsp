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
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
</head>
<body>
	<div class="container">
		<h3 class="text-center">내용 보기</h3>
		<div class="row">
			<table class="table">
				<tr>
					<th width="20%" class="text-center">번호</th>
					<td width="30%" class="text-center">{{vo.no}}</td>
					<th width="20%" class="text-center">작성일</th>
					<td width="30%" class="text-center">{{vo.dbday}}</td>
				</tr>
				<tr>
					<th width="20%" class="text-center">이름</th>
					<td width="30%" class="text-center">{{vo.name}}</td>
					<th width="20%" class="text-center">조회수</th>
					<td width="30%" class="text-center">{{vo.hit}}</td>
				</tr>
				<tr>
					<th width="20%" class="text-center">제목</th>
					<td colspan="3">{{vo.subject}}</td>
				</tr>
				<tr v-show="vo.filecount!==0">
					<th width="20%" class="text-center">첨부 파일</th>
					<td colspan="3">
						<ul>
							<li v-for="(fn,index) in filename">
								<a :href="'download.do?fn='+fn">{{fn}}</a>({{filesize[index]}}bytes)
							</li>
						</ul>
					</td>
				</tr>
				<tr>
					<td colspan="4" class="text-left" valign="top" height="200">
						<pre style="white-space:pre-wrap;background-color:white;border:none">{{vo.content}}</pre>
					</td>
				</tr>
				<tr>
					<td colspan="4" class="text-right">
						<a href="#" class="btn btn-xs btn-warning">수정</a>
						<input type="button" class="btn btn-xs btn-info" value="삭제" @click="del" ref="delBtn">
						<a href="list.do" class="btn btn-xs btn-success">목록</a>
					</td>
				</tr>
				<tr v-show="isShow">
					<td colspan="4" class="text-right">
						비밀 번호 : <input type="password" v-model="pwd" ref="pwd" class="input-sm" size="15">
						<input type="button" value="삭제" class="btn-sm btn-danger" ref="deleteBtn" v-on:click="databoardDelete()">
					</td>
				</tr>
			</table>
		</div>
	</div>
	<script>
		let detailApp=Vue.createApp({
			data(){
				return{
					vo:{},
					no:${no},
					filename:[],
					filesize:[],
					isShow:false,
					pwd:''
				}
			},
			mounted(){
				axios.get('detail_vue.do',{
					params:{
						no:this.no
					}
				}).then(response=>{
					// JSON을 받는 위치 => return
					this.vo=response.data
					let count=response.data.filecount
					if(count>0)
					{
						this.filename=response.data.filename.split(",")
						this.filesize=response.data.filesize.split(",")
					}
				}).catch(error=>{
					console.log(error.response)
				})
			},
			methods:{
				del(){
					if(this.isShow===false)
					{
						this.isShow=true
						this.$refs.delBtn.value="취소"
					}
					else
					{
						this.isShow=false
						this.$refs.delBtn.value="수정"
					}
				},
				databoardDelete(){ // 삭제 요청
					if(this.pwd==="")
					{
						alert("비밀 번호를 입력하세요")
						this.$refs.pwd.focus()
						return
					}
				}
			}
		}).mount('.container')
	</script>
</body>
</html>