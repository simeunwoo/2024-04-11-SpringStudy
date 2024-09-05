<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.col-md-3{
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<c:forEach var="vo" items="${list }">
				 <div class="col-md-3">
				    <div class="thumbnail">
				      <a href="../goods/detail_before.do?no=${vo.no }">
				        <img src="${vo.goods_poster }" title="${vo.goods_name }" style="width:200px;height:200px">
				        <div class="caption">
				          <p>${vo.goods_name }</p>
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
						<li><a href="../goods/list.do?page=${startPage-1 }">이전</a></li>
					</c:if>
					<c:forEach var="i" begin="${startPage }" end="${endPage }">
						<li ${i==curpage?"class=active":"" }>
							<a href="../goods/list.do?page=${i }">${i }</a>
						</li>
					</c:forEach>
					<c:if test="${endPage<totalpage }">
						<li><a href="../goods/list.do?page=${endPage+1 }">다음</a></li>
					</c:if>
				</ul>
			</div>
		</div>
		<h3>최근 둘러본 상품</h3>
		<a href="../goods/cookie_all.do" class="btn btn-sm btn-primary">더보기</a>
		<div class="row">
			
				<c:if test="${size==0 }">
					<h3 class="text-center">아직 본 상품이 없어요</h3>
				</c:if>
				<c:if test="${size>0 }">
					<c:forEach var="vo" items="${cList }" varStatus="s">
						<c:if test="${s.index<9 }">
							<a href="../goods/detail.do?no=${vo.no }">
								<img src="${vo.goods_poster }" style="width:100px;height:100px"
									title="${vo.goods_name }">
							</a>
						</c:if>
					</c:forEach>
				</c:if>
			
		</div>
	</div>
</body>
</html>