<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.container{
	text-align: center;
}
</style>
</head>
<body>
<div class="container">
    <!-- 고정 이미지 -->
    <div class="text-center" style="text-align: center;">
        <img src="m1.jpg" style="width:1200px;height:720px">
        <div class="carousel-caption">
            <div class="col-lg-7 col-md-7 col-sm-12 col-xs-12"></div>
            <div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
                <div class="slider-contant" data-animation="animated fadeInRight">
                </div>
            </div>
        </div>
    </div>
</div>
<div style="height:80px"></div>
<div class="container text-center"> 
<!-- ****** Breadcumb Area Start ****** -->
    <div class="breadcumb-area" style="background-image: url(../img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
                        <h1>글 쓰기</h1>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="breadcumb-nav">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    
                </div>
            </div>
        </div>
    </div>
    
        <div class="container" id="insertApp">
            <div class="row justify-content-center">
            	<div class="col-12 col-lg-2">
            	</div>
                <div class="col-12 col-lg-8">
                    <div class="row no-gutters">
                     <table class="table">
                       <tr>
                         <th class="text-right" width=35%>제목&nbsp;&nbsp;</th>
                         <td class="text-left" width=65%>
                          <input type=text size=51 class="input-sm"
                            ref="subject" v-model="subject">
                         </td>
                       </tr>
                       <tr>
                         <th class="text-right" width=35%>내용&nbsp;&nbsp;</th>
                         <td class="text-left" width=65%>
                          <textarea rows="10" cols="48" ref="content"
                            v-model="content"
                          ></textarea>
                         </td>
                       </tr>
                       <tr>
                         <td colspan="2" class="text-center">
                           <button class="btn-sm btn-success" @click="boardInsert()">작성</button>
                           <input type=button class="btn-sm btn-success"
                            value="취소" onclick="javascript:history.back()">
                         </td>
                       </tr>
                     </table>
                    </div>
                </div>
                <div class="col-12 col-lg-2">
                </div>
            </div>
         </div>
    
    <div style="height:50px"></div>
    </div>
    <script>
     let insertApp=Vue.createApp({
    	 data(){
    		 return{
    			 subject:'',
    			 content:''
    		 }
    	 },
    	 methods:{
    		 boardInsert(){
    			 axios.post('../notice/insert_vue.do',null,{
    				 params:{
    					 subject:this.subject,
    					 content:this.content
    				 }
    			 }).then(response=>{
    				 if(response.data==='yes')
    				 {
    					 
    					 location.href='../notice/list.do' 
    				 }
    				 else
    				 {
    					 alert(response.data)
    				 }
    			 }).catch(error=>{
    				 console.log(error.response)
    			 })
    		 }
    	 }
     }).mount('#insertApp')
    </script>
</body>
</html>