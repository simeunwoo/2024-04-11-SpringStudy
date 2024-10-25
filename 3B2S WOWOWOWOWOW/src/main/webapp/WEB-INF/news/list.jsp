<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.news-post-widget {
    display: flex;
    margin-bottom: 20px;
    border: none;
    border-bottom: 1px solid #ccc;
    box-shadow: none; 
}
.news-post-widget img {
    width: 250px; 
    height: 150px;
    object-fit: cover;    
}
.news-post-detail .time {
    display: block; 
    margin-bottom: 10px; 
}
.clamp-text-one-line {
    display: -webkit-box;
    -webkit-line-clamp: 1;
    -webkit-box-orient: vertical;
    overflow: hidden;
    text-overflow: ellipsis; 
    white-space: nowrap; 
}
.clamp-text {
    display: -webkit-box;
    -webkit-line-clamp: 3; 
    -webkit-box-orient: vertical;
    overflow: hidden;
    text-overflow: ellipsis; 
    max-height: 3em; 
    line-height: 1.5em; 
}
.pagination-area {
    display: flex;
    justify-content: center; 
    align-items: center;
}
.pagination {
    display: flex;
    justify-content: center;
}
.pagination .page-link {
    background-color: white;
    color: #333;
    border-color: #ccc; 
    border: none !important;
}
.pagination:hover{
   cursor:pointer;
}
.pagination .page-item.active .page-link {
    background-color: #003366; 
    border-color: #003366; 
    color: white; 
    border: none !important;
}

.pagination .page-link:hover {
    background-color: #aaa; 
    
}
.news-sidebar {
     float: left;
     width: 100%;
     background: #fff;
     padding: 20px 20px 0 20px;
     border: solid #e1e1e1 1px;
     margin-bottom: 25px;
}
 .search-bar-news {
     float: left;
     width: 100%;
     padding: 0;
}
 .search-bar-news form {
     float: left;
     width: 100%;
     padding-bottom: 15px;
}
 .search-bar-news form input {
     float: left;
     width: 177px;
     padding: 4px 15px;
     border: none;
     font-size: 15px;
     background: #f0f0f0;
}
 .search-bar-news form button {
     background: #003366;
     border: none;
     padding: 4px 11px;
     float: right;
     color: #fff;
}
</style>
</head>
<body>
  <section>
    <div class="news-page-banner">
        <div class="container">
        </div>
     </div>
     <div class="inner-information-text">
        <div class="container">
           <h3>News</h3>
           <ul class="breadcrumb">
              <li><a href="../main/main.do">Home</a></li>
              <li class="active"><a href="../news/list.do">News</a></li>
           </ul>
        </div>
     </div>
  </section>
   <section class="contant" id="listApp" style="margin-top: 40px;">
     <div class="container">
        <div class="row">
           <div class="col-lg-9 col-sm-12 col-xs-12">
			    <div class="news-post-holder">
			        <div class="news-post-list" v-for="vo in news_list">
			            <div class="news-post-widget" data-wow-delay="0.1s" style="display: flex; margin-bottom: 20px;">
			                <a :href="'../news/detail.do?nno='+vo.nno"><img :src="vo.poster"></a>
			                <div class="news-post-detail">
			                    <span class="time">{{vo.ftime}}</span>
			                    <h2 class="clamp-text-one-line">
								  <a :href="'../news/detail.do?nno='+vo.nno">{{ truncateText(vo.title, 40) }}</a>
								</h2>
			                    <p class="clamp-text">{{vo.content}}</p>
			                </div>
			            </div>
			        </div>
			    </div>
		   </div>
           <div class="col-lg-3 col-sm-6 col-xs-12">
              <div class="news-sidebar">
                  <div class="search-bar-news">
                      <form @submit.prevent="newsFind"> 
						  <input type="text" ref="nd" v-model="nd" placeholder="search">
						  <button type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
					  </form>
                   </div>
               </div>
              <div class="content-widget top-story">
                 <div class="top-stroy-header">
                    <h2>실시간 인기 뉴스 <a href="#" class="fa fa-fa fa-angle-right"></a></h2>
                    <span class="date">
				        <%
				            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				            String today = sdf.format(new Date());
				            out.print(today);
				        %>
				    </span>
                    <!-- <h2>Other Headlines</h2> -->
                 </div>
                 <ul class="other-stroies">
                   <c:forEach var="vo" items="${nList }">
                     <li>
                       <a href="../news/detail.do?nno=+${vo.nno }">
                         <c:choose>
                           <c:when test="${fn:length(vo.title)>17 }">
                            ${fn:substring(vo.title,0,15)}...
                           </c:when>
                         </c:choose>
                       </a>
                     </li>
                   </c:forEach>
                 </ul>
              </div>
              <aside id="sidebar" class="left-bar">
                     <div class="banner-sidebar">
                        <img class="img-responsive" src="../images/match-banner2.png" alt="#">
                        <h3> | 삼성 라이온즈 vs 기아 타이거즈 | </h3>
                     </div>
                  </aside>
                  <aside id="sidebar" class="left-bar">
                     <div class="feature-matchs">
                        <table class="table table-bordered table-hover">
                           <thead>
                              <tr>
                                 <th class="text-center">순위</th>
                                 <th class="text-center">구단</th>
                                 <th class="text-center">승</th>
                                 <th class="text-center">무</th>
                                 <th class="text-center">패</th>
                              </tr>
                           </thead>
                           <tbody>
                              <tr>
                                 <td class="text-center">1</td>
                                 <td><img src="../images/logo/kia.png" alt="" style="width: 25px; height: auto;">기아</td>
                                 <td class="text-center">87</td>
                                 <td class="text-center">2</td>
                                 <td class="text-center">55</td>
                              </tr>
                              <tr>
                                 <td class="text-center">2</td>
                                 <td><img src="../images/logo/samsung.png" alt="" style="width: 25px; height: auto;">삼성</td>
                                 <td class="text-center">78</td>
                                 <td class="text-center">2</td>
                                 <td class="text-center">64</td>
                              </tr>
                              <tr>
                                 <td class="text-center">3</td>
                                 <td><img src="../images/logo/LG.png" alt="" style="width: 25px; height: auto;">LG</td>
                                 <td class="text-center">76</td>
                                 <td class="text-center">2</td>
                                 <td class="text-center">66</td>
                              </tr>
                              <tr>
                                 <td class="text-center">4</td>
                                 <td><img src="../images/logo/doosan.png" alt="" style="width: 25px; height: auto;">두산</td>
                                 <td class="text-center">74</td>
                                 <td class="text-center">2</td>
                                 <td class="text-center">68</td>
                              </tr>
                              <tr>
                                 <td class="text-center">5</td>
                                 <td><img src="../images/logo/kt.png" alt="" style="width: 25px; height: auto;">KT</td>
                                 <td class="text-center">72</td>
                                 <td class="text-center">2</td>
                                 <td class="text-center">70</td>
                              </tr>
                           </tbody>
                        </table>
                     </div>
                  </aside>
                 
	              <aside id="sidebar" class="right-bar">
	                 <div class="banner">
	                    <img class="img-responsive" src="../images/news-ad.gif" alt="#">
	                 </div>
	              </aside>
	              
           </div>
        </div>
     </div>
     <div class="col-12" style="margin-bottom: 20px;">
	    <div class="pagination-area d-sm-flex mt-15" style="margin-left: -250px;"> 
	        <nav aria-label="#" style="width: 100%;">
	            <ul class="pagination">
	                <li class="page-item" v-if="startPage>1">
	                    <a class="page-link" @click="prev()">
	                        <i class="fa fa-angle-double-left" aria-hidden="true"></i>
	                    </a>
	                </li>
	                
	                <li :class="i === curpage ? 'page-item active' : 'page-item'" v-for="i in range(startPage, endPage)">
	                    <a class="page-link" @click="pageChange(i)">{{i}}</a>
	                </li>
	                
	                <li class="page-item" v-if="endPage<totalpage">
	                    <a class="page-link" @click="next()"> 
	                        <i class="fa fa-angle-double-right" aria-hidden="true"></i>
	                    </a>
	                </li>
	            </ul>
	        </nav>
	    </div>
	 </div>
   </section>
  <script>
     let listApp=Vue.createApp({
    	 data(){
    		 return {
    			 news_list:[],
    			 curpage:1,
    			 totalpage:0,
    			 startPage:0,
    			 endPage:0,
    			 nd:''
    		 }
    	 },
    	 mounted(){
    		 this.dataRecv()
    	 },
    	 methods:{
    		 newsFind(){
    			if(this.nd==="")
    			{
    				this.$refs.nd.focus()
    				return 
    			}
    			this.curpage=1
    			this.dataRecv()
    		 },
    		 prev(){
    			 this.curpage=this.startPage-1
    			 this.dataRecv()
    		 },
    		 next(){
    			 this.curpage=this.endPage+1
    			 this.dataRecv()
    		 },
    		 pageChange(page){
    			 this.curpage=page
    			 this.dataRecv()
    		 },
    		 range(start,end){
    			 let arr=[]
    			 let len=end-start
    			 for(let i=0;i<=len;i++)
    			 {
    				 arr[i]=start
    				 start++
    			 }
    			 return arr
    		 },
    		 
    		 // 공통으로 사용되는 함수 => 서버연결후에 데이터 읽기
    		 dataRecv(){
    			 axios.get('../news/list_vue.do',{
    				 params:{
    					 page:this.curpage,
    					 nd:this.nd
    				 }
    			 }).then(response=>{
    				 // 정상 수행시 => 데이터를 읽어온다 
    				 console.log(response.data)
    				 this.news_list=response.data.list
    				 this.curpage=response.data.curpage
    				 this.totalpage=response.data.totalpage
    				 this.startPage=response.data.startPage
    				 this.endPage=response.data.endPage
    			 }).catch(error=>{
    				 // 서버에서 에러 발생
    				 alert(error.response)
    				 console.log(error.response)
    			 })
    		 },
   		     truncateText(text, maxLength) {
 	            return text.length > maxLength ? text.slice(0, maxLength) + "..." : text;
 	         }
    	 }
     }).mount('#listApp')
    </script>
</body>
</html>