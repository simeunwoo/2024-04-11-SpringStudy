<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container-fluid{
	margin-top: 50px;
}
.row{
	margin: 0px auto;
	width: 960px;
}
.nav-link{
	cursor: pointer;
}
p{
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="image.js"></script>
<script src="page.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<poster-card></poster-card>
		</div>
		<div style="height:10px"></div>
		<div class="row">
			<div class="text-center">
				<page-card></page-card>
			</div>
		</div>
	</div>
	<script src="vue_list.js"></script>
</body>
</html>