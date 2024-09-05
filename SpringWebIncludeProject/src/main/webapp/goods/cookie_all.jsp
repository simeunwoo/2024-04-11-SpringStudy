<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<c:if test="${size==0 }">
			<h3 class="text-center">방문한 레시피가 없습니다</h3>
		</c:if>
		<c:if test="${size>0 }">
			<c:forEach var="vo" items="${cList }">
				<div class="col-md-3">
				    <div class="thumbnail">
				      <a href="../goods/detail.do?no=${vo.no }">
				        <img src="${vo.goods_poster }" title="${vo.goods_name }" style="width:230px;height:150px">
				      </a>
				    </div>
				 </div>
			</c:forEach>
		</c:if>
	</div>
	<div style="height:10px"/>
	<div class="row">
		<div class="text-right">
			<a href="../goods/cookie_delete.do" class="btn btn-sm btn-danger">삭제</a>
		</div>
	</div>
</body>
</html>