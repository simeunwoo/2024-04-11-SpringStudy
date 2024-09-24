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
					<td width="30%" class="text-center"></td>
					<th width="20%" class="text-center">작성일</th>
					<td width="30%" class="text-center"></td>
				</tr>
				<tr>
					<th width="20%" class="text-center">이름</th>
					<td width="30%" class="text-center"></td>
					<th width="20%" class="text-center">조회수</th>
					<td width="30%" class="text-center"></td>
				</tr>
				<tr>
					<th width="20%" class="text-center">제목</th>
					<td colspan="3"></td>
				</tr>
				<tr>
					<td colspan="4" class="text-left" valign="top" height="200">
						<pre style="white-space:pre-wrap;background-color:white;border:none"></pre>
					</td>
				</tr>
				<tr>
					<td colspan="4" class="text-right">
						<a href="#" class="btn btn-xs btn-warning">수정</a>
						<input type="button" class="btn btn-xs btn-info" value="삭제">
						<a href="list.do" class="btn btn-xs btn-success">목록</a>
					</td>
				</tr>
				<tr v-show="isShow">
				</tr>
			</table>
		</div>
	</div>
</body>
</html>