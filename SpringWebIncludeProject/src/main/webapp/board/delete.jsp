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
	width: 300px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#delBtn').click(function(){
		
	})
})
</script>
</head>
<body>
	<div class="container">
		<h3 class="text-center">삭제하기</h3>
		<div class="row">
				<table class="table">
					<tr>
						<td class="text-center">
							비밀 번호 : <input type="password" id="pwd" size="15" class="input-sm" required>
							<input type="hidden" id="no" value="${no }">
						</td>
					</tr>
					<tr>
						<td class="text-center">
							<input type="button" class="btn-sm btn-success" value="삭제" id="delBtn">
							<input type="button" class="btn-sm btn-warning" value="취소" onclick="javascript:history.go(-1)">
						</td>
					</tr>				
				</table>
		</div>
		<div style="height:300px"/>
	</div>
</body>
</html>