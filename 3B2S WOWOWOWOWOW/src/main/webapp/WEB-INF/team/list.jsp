<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Team List</title>
<script src="https://cdn.jsdelivr.net/npm/vue@3"></script>
<style>
.card {
	display: grid;
	place-items: center;
}
#newScreenApp {
    margin-top: 50px;
}
</style>
</head>
<body>
<section id="top">
         
         <div class="inner-information-text">
            <div class="container">
               <h3>Team</h3>
               <ul class="breadcrumb">
                  <li><a href="../main/main.do">Home</a></li>
                  <li class="active">팀</li>
               </ul>
            </div>
         </div>
      </section>
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
                        	<div class="center">
                            	<button class="button" @click="openNewWindow('${vo.name}')">Learn More</button>
                        	</div>
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
            data() {
                return {
                }
            },
            mounted() {
                console.log("앱이 마운트되었습니다.");
            },
            methods: {
                openNewWindow(teamName) {
                    window.open('../team/detail.do?name=' + encodeURIComponent(teamName), 'winname', 'width=700,height=900,scrollbars=yes,resizable=no');
                }
            }
        }).mount('#newScreenApp');
    </script>
</body>
</html>