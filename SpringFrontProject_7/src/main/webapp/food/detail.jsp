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
		<h3 class="text-center">상세 보기</h3>
		<div class="row">
			
		</div>
		<hr>
		<div class="row">
			
		</div>
	</div>
	<script>
		let detailApp=Vue.createApp({
			data(){
				return{
					vo:{},
					fno:${fno},
					sessionId:'${sessionId}',
					reply_list:[]
				}
			},
			mounted(){
				axios.get('../food/detail.vue.do',{
					params:{
						fno:this.fno
					}
				}).then(response=>{
					console.log(response.data)
				}).catch(error=>{
					console.log(error.response)
				})
				// axios => 댓글
			},
			// 댓글 처리 => SELECT / INSERT / UPDATE / DELETE
			methods:{
				
			}
		}).mount('.container')
	</script>
</body>
</html>