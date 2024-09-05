<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<table class="table">
				<tr>
					<td colspan="4">
						<img src="${vo.goods_poster }" style="width:800px;height:580px">
					</td>
				</tr>
				<tr>
					<td width="20%" class="text-center">이름</td>
					<th width="30%" class="text-center">${vo.goods_name }</th>
					<td width="20%" class="text-center">가격</td>
					<th width="30%" class="text-center">${vo.goods_price }</th>
				</tr>
				<tr>
					<td width="20%" class="text-center">할인율</td>
					<th width="30%" class="text-center">${vo.goods_discount }%</th>
					<td width="20%" class="text-center">원가</td>
					<th width="30%" class="text-center">${vo.goods_first_price }</th>
				</tr>
				<tr>
					<td width="20%" class="text-center">배송 여부</td>
					<th width="30%" class="text-center">${vo.goods_delivery }</th>
					<td width="20%" class="text-center">조회수</td>
					<th width="30%" class="text-center">${vo.hit }</th>
				</tr>
			</table>
			<table class="table">
				<tr>
<p>
${vo.goods_sub }					
</p>
				</tr>
			</table>			
		</div>
		<div class="row">
			<tr>
				<td class="text-right">
					<a href="../goods/list.do" class="btn-sm btn-info">목록</a>
				</td>
			</tr>
		</div>
	</div>
</body>
</html>