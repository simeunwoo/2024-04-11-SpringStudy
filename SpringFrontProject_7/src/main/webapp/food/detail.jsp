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
		<h3 class="text-center">상세 보기</h3>
		<div class="row">
			<table class="table">
				<tr>
					<td class="text-center" rowspan="7" width="30%">
						<img :src="'http://www.menupan.com'+vo.poster" style="width:240px;height:180px">
					</td>
					<td colspan="2">
						<h3>{{vo.name}}&nbsp;<span style="color:orange">{{vo.score}}</span></h3>
					</td>
				</tr>
				<tr>
					<td style="color:gray" width="20%">음식 종류</td>
					<td width="50%">{{vo.type}}</td>
				</tr>
				<tr>
					<td style="color:gray" width="20%">주소</td>
					<td width="50%">{{vo.address}}</td>
				</tr>
				<tr>
					<td style="color:gray" width="20%">☎</td>
					<td width="50%">{{vo.phone}}</td>
				</tr>
				<tr>
					<td style="color:gray" width="20%">영업 시간</td>
					<td width="50%">{{vo.time}}</td>
				</tr>
				<tr>
					<td style="color:gray" width="20%">주차</td>
					<td width="50%">{{vo.parking}}</td>
				</tr>
				<tr>
					<td style="color:gray" width="20%">테마</td>
					<td width="50%">{{vo.theme}}</td>
				</tr>
			</table>
			<table>
				<tr>
					<td>{{vo.content}}</td>
				</tr>
			</table>
		</div>
		<hr>
		<div class="row">
			<table class="table">
				<tr>
					<td>
						<table class="table" v-for="rvo in reply_list">
							<tr>
								<td width="80%" class="text-left">
									◑{{rvo.name}}({{rvo.dbday}})
								</td>
								<td width="20%" class="text-right">
									<span v-if="rvo.id===sessionId">
										<input type="button" class="btn btn-xs btn-success ups" value="수정" :data-rno="rvo.rno">&nbsp;
										<input type="button" class="btn btn-xs btn-info" value="삭제" @click="replyDelete(rvo.rno)">
									</span>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<pre style="white-space:prewrap;background-color:white;border:none">{{rvo.msg}}</pre>
								</td>
							</tr>
							<tr class="updates" style="display:none" :id="'u'+rvo.rno">
								<td colspan="2">
									<textarea rows="3" cols="80" style="float:left" ref="msg">{{rvo.msg}}</textarea>
									<input type="button" value="댓글 수정" style="float:left;width:80px;height:67px;background-color:orange"
									  @click="replyUpdate(rvo.rno)">
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<table class="table">
				<tr>
					<td>
						<textarea rows="3" cols="80" style="float:left" ref="msg" v-model="msg"></textarea>
						<input type="button" value="댓글 쓰기" style="float:left;width:80px;height:67px;background-color:orange"
						  @click="replyInsert()">
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
					fno:${fno},
					sessionId:'${sessionId}',
					reply_list:[],
					msg:'',
					isUps:false
				}
			},
			mounted(){
				// jQuery 설정 => $(function(){})
				$('.ups').click(function(){
					let rno=$(this).attr("data-no")
					if(this.isUps===false)
					{
						this.isUps=true
						$(this).val('취소')
						$('u'+rno).show()
					}
					else
					{
						this.isUps=false
						$(this).val('수정')
						$('u'+rno).hide()
					}
				})
				axios.get('../food/detail.vue.do',{
					params:{
						fno:this.fno
					}
				}).then(response=>{
					console.log(response.data)
					this.vo=response.data
				}).catch(error=>{
					console.log(error.response)
				})
				// axios => 댓글
				axios.get('../food/reply_list_vue.do',{
					params:{
						fno:this.fno
					}
				}).then(response=>{
					console.log(response.data)
					this.reply_list=response.data
				}).catch(error=>{
					console.log(error.response)
				})
			},
			// 댓글 처리 => SELECT / INSERT / UPDATE / DELETE
			methods:{
				replyInsert(){
					if(this.id==="")
					{
						this.$refs.id.focus()
						return
					}
					if(this.pwd==="")
					{
						this.$refs.pwd.focus()
						return
					}
					axios.post('../food/reply_insert_vue.do',null,{
						params:{
							fno:this.fno,
							msg:this.msg
						}
					}).then(response=>{
						console.log(response.data)
						this.reply_list=response.data
						this.msg=''
						this.$refs.msg.focus()
					}).catch(error=>{
						console.log(error.response)
					})
				},
				replyDelete(rno){
					axios.get('../food/reply_delete_vue.do',{
						params:{
							rno:rno,
							fno:this.fno
						}
					}).then(response=>{
						console.log(response.data)
						this.reply_list=response.data
					}).catch(error=>{
						console.log(error.response)
					})
				}
			}
		}).mount('.container')
	</script>
</body>
</html>