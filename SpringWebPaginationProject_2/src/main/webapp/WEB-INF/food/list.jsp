<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
.a{
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>
</head>
<body>
	<div class="container">
		<h3>음식</h3>
		<div class="row">
			<c:forEach var="vo" items="${list }">
				<div class="col-md-3">
					<div class="thumbnail">
						<a href="#">
							<img src="http://menupan.com${vo.poster }" style="height:200px;width:180px" title="${vo.name }">
							<div class="caption">
					          <p>${vo.address }</p>
					        </div>
						</a>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="row">
			<div class="text-center">
				<ul class="pagination">
					<c:if test="${startPage>1 }">
						<li><a href="list.do?page=${startPage-1 }">이전</a></li>
					</c:if>
					<c:forEach var="i" begin="1" end="10">
						<li ${i==curpage?"class=active":"" }><a href="list.do?page=${i }">${i }</a></li>
					</c:forEach>
					<c:if test="${endPage<totalpage }">
						<li><a href="list.do?page=${endPage+1 }">다음</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>