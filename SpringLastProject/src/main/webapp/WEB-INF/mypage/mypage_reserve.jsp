<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="mypageApp">
		<table class="table">
			<tr>
				<th class="text-center">번호</th>
				<th class="text-center"></th>
				<th class="text-center">업체명</th>
				<th class="text-center">예약일</th>
				<th class="text-center">시간</th>
				<th class="text-center">인원</th>
				<th class="text-center">등록일</th>
				<th class="text-center">비고</th>
			</tr>
			<tr v-for="vo in reserve_list">
				<td class="text-center">{{vo.rno}}</td>
				<td class="text-center">
					<img :src="'http://menupan.com'+vo.fvo.poster" style="width:30px;height:30px">
				</td>
				<td class="text-center">{{vo.fvo.name}}</td>
				<td class="text-center">{{vo.rday}}</td>
				<td class="text-center">{{vo.rtime}}</td>
				<td class="text-center">{{vo.rinwon}}</td>
				<td class="text-center">{{vo.dbday}}</td>
				<td class="text-center">
					<button class="btn-xs btn-success" v-if="vo.isReserve===1" @click="foodInfo(vo.fno,vo.rno)">예약 완료</button>
					<button class="btn-xs btn-danger" v-else>예약 대기</button>
				</td>
			</tr>
		</table>
	</div>
	<script>
		let mypageApp=Vue.createApp({
			data(){
				return{
					reserve_list:[],
					rno:0,
					reserve_info:{}
				}
			},
			mounted(){
				// 서버로 전송할 데이터가 없는 경우 => params 안 써도 됨
				// params => '?'와 관련
				axios.get('../mypage/mypage_reserve_vue.do')
				.then(response=>{
					console.log(response.data)
					this.reserve_list=response.data
				}).catch(error=>{
					console.log(error.response)
				})
			},
			methods:{
				foodInfo(fno,rno){
					axios.get('../mypage/mypage_reserve_info_vue.do',{
						params:{
							fno:fno,
							rno:rno
						}
					}).then(response=>{
						console.log(response.data)
					}).catch(error=>{
						console.log(error.response)
					})
				}
			}
		}).mount('#mypageApp')
	</script>
</body>
</html>