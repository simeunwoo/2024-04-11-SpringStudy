<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${bCheck==false }">
	<script>
		alert("비밀 번호가 잘못됐습니다.\n다시 하세요.")
		history.back();
	</script>
</c:if>
<c:if test="${bCheck==true }">
	<c:redirect url="detail.do?no=${no }"/>
</c:if>