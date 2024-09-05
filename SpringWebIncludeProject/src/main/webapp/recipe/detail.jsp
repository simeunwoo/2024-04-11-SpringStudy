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
		<table class="table">
			<tr>
				<td class="text-center" colspan="3">
					<img src="${vo.poster }" style="width:800px;height:200px">
				</td>
			</tr>
			<tr>
				<td class="text-center" colspan="3">
					<h3>${vo.title }</h3>
				</td>
			</tr>
			<tr>
				<td class="text-center" colspan="3">${vo.content }</td>
			</tr>
			<tr>
				<td class="text-center"><img src="../recipe/images/google.png"></td>
				<td class="text-center"><img src="../recipe/images/new.gif"></td>
				<td class="text-center"><img src="../recipe/images/oh.png"></td>
			</tr>
			<tr>
				<td class="text-center">${vo.info1 }</td>
				<td class="text-center">${vo.info2 }</td>
				<td class="text-center">${vo.info3 }</td>
			</tr>
		</table>
		<h3>[재료]</h3>
		<table>
			<tr>
				<td>
					<ul>
						<c:forTokens items="${vo.data }" delims="," var="s">
							<li>${s }</li>
						</c:forTokens>
					</ul>
				</td>
			</tr>
		</table>
		<h3>[조리 순서]</h3>
		<table class="table">
			<c:forEach var="m" items="${mList }" varStatus="s">
				<tr>
					<td class="text-left"><b>${m }</b></td>
					<td class="text-right">
						<img src="${iList[s.index] }" style="width:180px;height:80px" class="img-rounded">
					</td>
				</tr>
			</c:forEach>
		</table>
		<h3>[레시피 작성자]</h3>
		<table>
			<tr>
				<td class="text-center" rowspan="2" width="15%">
					<img src="${vo.chef_poster }" style="width:100px;height:100px" class="img-circle">
				</td>
				<td width="85%"><h4>${vo.chef }</h4></td>
			</tr>
			<tr>
				<td width="85%">${vo.chef_profile }</td>
			</tr>			
		</table>
		<table class="table">
			<tr>
				<td class="text-right">
					<input type="button" class="btn-sm btn-warning" value="굿">
					<input type="button" class="btn-sm btn-success" value="찜">
					<input type="button" class="btn-sm btn-info" value="이전" onclick="javascript:history.go(-1)">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>