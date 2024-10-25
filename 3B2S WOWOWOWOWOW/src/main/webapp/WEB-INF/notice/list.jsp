<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.container{
	text-align: center;
}
#abc{
	margin-top: 50px;
	font-size: 40px;
	font-family: '휴먼모음T';
}
</style>
</head>
<body>
<section id="top">
         
         <div class="inner-information-text">
            <div class="container">
               <h3>Notice</h3>
               <ul class="breadcrumb">
                  <li><a href="../main/main.do">Home</a></li>
                  <li class="active">공지 사항</li>
               </ul>
            </div>
         </div>
      </section>
<div class="container text-center"> 
<div class="breadcumb-area" style="background-image: url(../img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                	<div style="height:50px"></div>
                    <div class="bradcumb-title text-center">
                        <p id="abc">공 지 사 항</p>
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
    <section class="single_blog_area section_padding_80" id="listApp">
        <div class="container">
            <div class="row justify-content-center">
                
                    <div class="row no-gutters">
			            <c:if test="${sessionScope.userId!=null }">
			            <sec:authorize access="hasRole('ROLE_ADMIN')">
			             <div>
			              <table class="table">
			                <tr>
			                 <td>
			                  
							    <a href="../notice/insert.do" class="btn btn-sm btn-primary">새 글</a>
							  
			                 </td>
			                </tr>
			              </table>
			              </div>
			             </sec:authorize>
			             </c:if>
			             <table class="table">
			              <tr>
			                <th class="text-center" width=10%>번호</th>
			                <th class="text-center" width=45%>제목</th>
			                <th class="text-center" width=15%>이름</th>
			                <th class="text-center" width=20%>작성일</th>
			                <th class="text-center" width=10%>조회수</th>
			              </tr>
			              <tr v-for="vo in board_list">
			                <td class="text-center" width=10%>{{vo.no}}</td>
			                <td width=45%>
			                 <a :href="'../notice/detail.do?no='+vo.no">{{vo.subject}}</a>
			                </td>
			                <td class="text-center" width=15%>{{vo.name}}</td>
			                <td class="text-center" width=20%>{{vo.dbday}}</td>
			                <td class="text-center" width=10%>{{vo.hit}}</td>
			              </tr>
			              <tr>
			                <td colspan="5" class="text-center">
			                 <button class="btn-sm btn-danger" v-on:click="prev()">이전</button>
			                 {{curpage}} 페이지 / {{totalpage}} 페이지
			                 <button class="btn-sm btn-danger" @click="next()">다음</button>
			                </td>
			              </tr>
			             </table>
                      </div>
                  
            </div>
         </div>
         <div style="height:50px"></div>
     </section>
     
     </div>
     <script>
       // M(데이터)V(HTML)VM(수정)  => 패턴 MVVM 
       let listApp=Vue.createApp({
    	   // Model => 데이터의 상태(변경) 관리 
    	   // List => [] , VO => {} => React
    	   data(){
    		   return {
    			   board_list:[],
    			   curpage:1,
    			   totalpage:0,
    			   count:0,
    			   today:'',
    			   authority:''
    		   }
    	   },
    	   // VM => ViewModel => 데이터값을 변경 
    	   // => window.onload 
    	   mounted(){
    		   this.dataRecv()
    	   },
    	   // 사용자 요청에 따라 데이터를 변경 
    	   methods:{
    		   prev(){
    			  this.curpage=this.curpage>1?this.curpage-1:this.curpage
    			  this.dataRecv()
    		   },
    		   next(){
    			   this.curpage=this.curpage<this.totalpage?this.curpage+1:this.curpage
    			   this.dataRecv()
    		   },
    		   dataRecv(){
    			   axios.get('../notice/list_vue.do',{
    				   params:{
    					   page:this.curpage
    				   }
    			   }).then(response=>{
    				   console.log(response.data)
    				   this.board_list=response.data.list
    				   this.curpage=response.data.curpage
    				   this.totalpage=response.data.totalpage
    				   this.count=response.data.count
    				   this.today=response.data.today
    				   this.authority=response.data.authority
    			   }).catch(error=>{
    				   console.log(error.response)
    			   })
    		   }
    	   }
       }).mount('#listApp')
     </script>
</body>
</html>