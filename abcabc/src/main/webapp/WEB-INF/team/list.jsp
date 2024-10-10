<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.card {
	display: grid;
	place-items: center;
}
</style>
</head>
<body>
	<div class="container">
	    <!-- 고정 이미지 -->
	    <div class="text-center" style="text-align: center;">
	        <img src="../player/m1.jpg" style="width:1200px;height:720px">
	        <div class="carousel-caption">
	            <div class="col-lg-7 col-md-7 col-sm-12 col-xs-12"></div>
	            <div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
	                <div class="slider-contant" data-animation="animated fadeInRight">
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
	<section id="newScreenApp" class="contant main-heading team">
         <div class="row">
         	<div class="container">
         	<c:forEach var="vo" items="${list }">
               <div class="col-md-3 column">
                  <div class="card">
                     <img class="img-responsive" src="${vo.logo }" style="width:160px;height:160px">
                     <div class="">
                        <h4>${vo.name }</h4>
                        <p class="title">창단연도&nbsp;:&nbsp;${vo.syear }년</p>
                        <p class="title">연고지&nbsp;:&nbsp;${vo.home }</p>
                        <p>
                        	<div class="center"><button class="button" @click="openNewWindow">
                        	  Learn More</button></div>
                        </p>
                     </div>
                  </div>
               </div>
           </c:forEach>
       </div>
   </div>
</section>
	<script>
        let NewScreenApp = Vue.createApp({
            data(){
                return{
                    // 필요한 데이터 속성을 추가할 수 있습니다.
                }
            },
            mounted(){
                // 컴포넌트가 마운트된 후 실행할 코드를 여기에 추가할 수 있습니다.
                console.log("앱이 마운트되었습니다.");
            },
            methods:{
                openNewWindow(){
                    window.open('../team/detail.do?name=${vo.name}','winname','width=500,height=700,scrollbars=yes');
                }
            }
        }).mount('#newScreenApp')
    </script>
</body>
</html>