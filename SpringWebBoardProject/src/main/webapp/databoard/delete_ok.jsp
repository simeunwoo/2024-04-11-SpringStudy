<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${bCheck==true }">
	<c:redirect url="list.do"/>
</c:if>
<c:if test="${bCheck==false }">
	<script>
		alert("잘못된 비밀 번호입니다");
		history.back();
	</script>
</c:if>