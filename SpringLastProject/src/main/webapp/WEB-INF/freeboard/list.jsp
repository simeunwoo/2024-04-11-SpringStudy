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
	<!-- ****** Breadcumb Area Start ****** -->
    <div class="breadcumb-area" style="background-image: url(../img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
                        <h2>자유 게시판</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="breadcumb-nav">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"></li>
                            <li class="breadcrumb-item active" aria-current="page"></li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ****** Breadcumb Area End ****** -->

    <!-- ****** Archive Area Start ****** -->
    <section class="archive-area section_padding_80" id="listApp">
        <div class="container">
            <div class="row">
            	<c:if test="${sessionScope.userId=!null }">
	            	<table class="table">
	            		<tr>
	            			<td>
	            				<a href="../freeboard/insert.do" class="btn-primary btn-sm btn">새 글</a>
	            			</td>
	            		</tr>
	            	</table>
            	</c:if>
            	<table class="table">
            		<tr>
            			<th class="text-center" width="10%">번호</th>
            			<th class="text-center" width="45%">제목</th>
            			<th class="text-center" width="15%">이름</th>
            			<th class="text-center" width="20%">작성일</th>
            			<th class="text-center" width="10%">조회수</th>
            		</tr>
            	</table>
            </div>
		</div>
	</section>
	<script>
		// MVVM => M(데이터)V(HTML)VM(수정)
		let ListApp=createApp({
			// Model => 데이터의 상태(변경) 관리
			// List => [], VO => {} ~~~~~~~~~~~~~~> React까지 동일
			data(){
				return{
					board_list:[],
					curpage:1,
					totalpage:0,
					count:0
				}
			},
			// VM => ViewModel => 데이터 값을 변경 (시작하자마자)
			// => window.onload
			mounted(){
				
			},
			// 사용자 요청에 따라 데이터 변경
			methods:{
				// 1) 공통으로 적용되는 기능을 설정 => 목록 읽기
				// 2) CRUD
			}
		}).mount('#listApp')
	</script>
</body>
</html>