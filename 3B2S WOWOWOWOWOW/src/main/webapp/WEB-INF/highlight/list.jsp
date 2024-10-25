<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="https://apis.google.com/js/api.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue@2.5.2/dist/vue.js"></script>
<script>
	
</script>
<style type="text/css">
.titlemargin{
	margin-bottom: 25px;
	margin-top: 25px;
}
</style>
</head>
<body>
<!-- 제목 -->
<div style="height: 200px;"> </div>

<div class="breadcumb-area">
    <div class="container h-100">
        <div class="row h-100 align-items-center">
            <div class="col-12">
                <div class="bradcumb-title text-center">
                    <h2>하이라이트</h2>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- ****** Archive Area Start ****** -->
<section class="archive-area section_padding_80">
    <div class="container">
        <div class="titlemargin" style="border-top: double;">
            <!-- Single Post -->
            <div v-for="vo in highlight_list" id="disp_area">
                <div class="single-post wow fadeInUp" data-wow-delay="0.1s">
					<c:forEach var="hvo" items="${hList }" varStatus="s">
					<table class="table" >
						<tr>
							 <td width="30%" class="text-center" rowspan="10" @click="">
							 	<a>
									<img src="${hvo.thumbnail}" width="200px;">
								</a>
							</td>
							<td width="70%">
								<a href="../highlight/detail.do">
					 				<h3 style="" class="text-left pop_open">${hvo.title}&nbsp;
					 					<span style="color:orange;"></span>
					 				</h3>
					 			</a>
							</td>
						</tr>
						<tr>
							<td class="text-right" style="border: none;">
								<a href="https://www.youtube.com/watch?v=${hvo.videoId }">${hvo.publishedAt}</a>
							</td> 
						</tr>
						
					</table>
					<template v-if="show">
						<table>
							<tr>
								<td width="70%" >
									<iframe id="ytplayer" type="text/html" width="720" height="405" src="https://www.youtube.com/embed/${hvo.videoId }?autoplay=1" frameborder="0" allowfullscreen></iframe>
									</br>
									<button class="text-center" style="width: 400">닫기</button>
								</td>
								<td width="30%">
									
								</td>
							</tr>
						</table>
					</template>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>            
</section>
	
<div class="col-12" v-for="vo in highlight_list">
    <div class="pagination-area d-sm-flex mt-15 text-center">
    <c:forEach var="htvo" items="${htList }" varStatus="s">
        <nav aria-label="#">
            <ul class="pagination">
                <li class="page-item" v-if="prePageToken!=null">
                <form action="../highlight/list.do">
                <input style="display: none;" type="text" name="pageToken" id="prevPageToken" value="${htvo.prevPageToken }">
                    <button type="submit" class="page-link"><i class="fa fa-angle-double-left" aria-hidden="true"></i>이전</button>
                </form>
                </li>

                
<!--                 
				<li :class="i===curpage?'page-item active':'page-item'" v-for="i in range(startPage,endPage)">
                    <a class="page-link" @click="pageChange(i)">{{i}}</a>
                </li> 
-->
                <li class="page-item" v-if="prePageToken!=null">
                <form action="../highlight/list.do">
                <input style="display: none;" type="text" name="pageToken" id="nextPageToken" value="${htvo.nextPageToken }">
                    <button type="submit" class="page-link" >다음<i class="fa fa-angle-double-right" aria-hidden="true"></i></button>
                </form>
                </li>
                
            </ul>
        </nav>
    </c:forEach>
    </div>
</div>

<div v-for="vo in highlight_list">
	<c:forEach var="htvo" items="${htList }" varStatus="s">
		<div>
			<a>${htvo.nextPageToken}</a>
		</div>
	</c:forEach>
</div>

<script>
let listApp=Vue.createApp({
	 data(){
		 return {
			 highlight_list_vue:[]
		 }
	 },
	 mounted(){
		 this.dataRecv()
	 },
	 // 사용자 정의 함수 => 이벤트 처리 , 공통으로 적용 
	 methods:{
		 Reset(){
			this.fd=''
			this.dataRecv()
		 },
		 prev(){
			 this.pageToken=this.prevPageToken
			 this.dataRecv()
		 },
		 next(){
			 this.pageToken=this.nextPageToken
			 this.dataRecv()
		 },		 
		 // 공통으로 사용되는 함수 => 서버연결후에 데이터 읽기
		 dataRecv(){
			 axios.get('../highlight/list_vue.do',{
				 params:{
					 pageToken:this.curpage,
				 }
			 }).then(response=>{
				 // 정상 수행시 => 데이터를 읽어온다 
				 console.log(response.data)
				 this.highlight_list_vue=response.data.list
				 this.curpage=response.data.curpage
				 this.totalpage=response.data.totalpage
				 this.startPage=response.data.startPage
				 this.endPage=response.data.endPage
			 }).catch(error=>{
				 // 서버에서 에러 발생
				 alert(error.response)
				 console.log(error.response)
			 })
		 }
	 }
	}).mount('#listApp')
</script>
</body>
</html>