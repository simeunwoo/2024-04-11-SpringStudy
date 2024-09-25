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
input[type="button"]{
	margin-left: 5px;
}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="text-center">
				<input type="button" class="btn-sm btn-danger" value="한식">
				<input type="button" class="btn-sm btn-danger" value="중식">
				<input type="button" class="btn-sm btn-danger" value="일식">
				<input type="button" class="btn-sm btn-danger" value="양식">
				<input type="button" class="btn-sm btn-danger" value="분식">
			</div>
		</div>
		<div class="row">
			
		</div>
	</div>
	<script>
		let listApp=Vue.createApp({
			data(){
				return{
					
				}
			},
			mounted(){
				
			},
			methods:{
				
			}
		}).mount('.container')
	</script>
</body>
</html>