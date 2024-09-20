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
	width: 960px;
}
p{
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
.link{
	cursor: pointer;
}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div class="container">
	
	</div>
	<script>
	/*
		(Ajax 방식)
		$.ajax({
			type:'get',
			url:'',
			data:{},
			success:function(res)
			{
				
			}
		})
	*/
		let recipeApp=Vue.createApp({
			mounted(){
				axios.get('http://localhost:8080/web/recipe/list_vue.do',{ // get : type 부분 / http:// ~ : url 부분 
					params:{ // params : data 부분
						page:1
					}
				}).then(response=>{ // ''.then(response=>' : success 부분
					// 결과값 받는 곳 => response.data
				})
			}
		}).mount('.container')
	</script>
</body>
</html>