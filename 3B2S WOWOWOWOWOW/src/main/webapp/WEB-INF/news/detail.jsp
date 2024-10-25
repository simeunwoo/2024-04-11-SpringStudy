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
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<style type="text/css">
.listBtn {
    display: flex;
    justify-content: center; 
    margin-top: 30px; 
    margin-bottom: -30px; 
}
.listBtn .btn {
    padding: 10px 20px;
    background-color: #003366;
    text-decoration: none;
    transition: background-color 0.3s ease;
}

.listBtn .btn:hover {
    background-color: #000;
}
.news-poster {
        margin-bottom: 20px; 
}
.styled-btn {
    background-color: #003366;
    color: white;               
    border-radius: 5px;       
    border: none;              
    transition: background-color 0.3s ease;
}
.styled-btn:hover {
    background-color: #000; 
}
.post-people {
    margin-bottom: 20px; 
}
.comment-content {
    padding: 10px 15px;
    border-radius: 5px; 
}
.post-info {
    display: flex;  
    align-items: start;
}

.post-info img {
    width: 70px;
    height: auto;
    margin-top: -10px;
    margin-right: 15px;
}
.children{
	margin-left: 100px;
}
p {
    font-size: 15px;
    text-align: left;
    color: #333;
    line-height: 28px;
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
     <section id="detailApp" style="margin-top: 40px;">
        <div class="row">
           <div class="container">
              <div class="col-md-9">
                 <div class="news-poster">
                    <div class="news-poster">
                       <img :src="vo.poster" class="img-responsive" alt="#" style="width: 1100px;" />
                    </div>
                    <div class="news-cont">
                       <div class="post-people">
                          <div class="left-profile">
                             <div class="post-info" style="margin-top: 10px;margin-bottom: -10px;">
                                <img src="../images/news-profile.png" alt="#" />
                                <span>
                                   <h2>{{vo.author}}</h2>
                                   <h5>{{vo.ftime}}</h5>
                                </span>
                             </div>
                             <span class="share"></span>
                          </div>
                       </div>
                       <div class="post-heading" style="margin-bottom: 30px;">
                          <h2>{{vo.title}}</h2>
                          <p>{{vo.content}}</p>
                          <div class="listBtn">
                             <a class="btn" href="../news/list.do">목록</a>
                          </div>
                       </div>
                     </div>
                      <div class="feature-cont">
                       <h2>댓글</h2>
                       <hr>
                       <div>
                        <div class="post-people" v-for="vo in reply_list">
                           <div class="left-profile" v-if="vo.group_tab===0">
							  <div class="post-info">
							    <img src="../images/news-profile.png" alt="" style="width: 70px; height: auto;margin-top: 10px;">
							    <div class="comment-content">
							      <h4>{{vo.name}}</h4>
							      <h5>{{vo.dbday}}</h5>
							      <p>{{vo.msg}}</p>
							      
							      <div>
									    <button v-if="sessionId === vo.id" class="btn-xs update styled-btn" style="margin-left: 2px" @click="replyUpdateForm(vo.cno)" :id="'u' + vo.cno">Update</button>
									    <button v-if="sessionId === vo.id" class="btn-xs styled-btn" style="margin-left: 2px" @click="replyDelete(vo.cno)">Delete</button>
									    <button v-if="sessionId !== ''" class="btn-xs active insert styled-btn" style="margin-left: 2px" @click="replyForm(vo.cno)" :id="'i' + vo.cno">Reply</button>
									    <button v-if="sessionId !== vo.id && sessionId !== ''" class="btn-xs styled-btn" style="margin-left: 2px">Like</button>
									</div>
							      
							      <!-- 댓글 입력 -->
							      <table class="table ins" style="display:none" :id="'in'+vo.cno">
							        <tr>
							          <td>
							            <textarea rows="3" cols="60" style="float: left" :id="'msg'+vo.cno"></textarea>
							            <input type="button" value="댓글" style="float: left; background-color: #003366; color: white; width: 80px; height:65px" @click="replyReplyInsert(vo.cno)">
							          </td>
							        </tr>
							      </table>
							
							      <!-- 댓글 수정 -->
							      <table class="table ups" style="display: none" :id="'up'+vo.cno">
							        <tr>
							          <td>
							            <textarea rows="3" cols="60" style="float: left" :id="'umsg'+vo.cno">{{vo.msg}}</textarea>
							            <input type="button" value="수정" style="float: left; background-color: #003366; color: white; width: 75px; height:66px" @click="replyUpdate(vo.cno)">
							          </td>
							        </tr>
							      </table>
							    </div>
							  </div>
							  <span class="share"></span>
							</div>
                          <div class="children" v-if="vo.group_tab===1">
                           <div class="post-people">
                            <div class="left-profile" style="margin-bottom: -23px">
                              <div class="post-info">
                                 <img src="../images/news-profile.png" alt="" style="width: 70px; height: auto;margin-top: 10px;">
                                <div class="comment-content">
                                    <h4>{{vo.name}}</h4>
                                    <h5>{{vo.dbday}}</h5>
                                    <p>{{vo.msg}}</p>
                                    <div>
									    <button v-if="sessionId === vo.id" class="btn-xs update styled-btn" @click="replyUpdateForm(vo.cno)" :id="'u' + vo.cno">Update</button>
									    <button v-if="sessionId === vo.id" class="btn-xs styled-btn" @click="replyDelete(vo.cno)">Delete</button>
									    <button v-if="sessionId !== vo.id && sessionId !== ''" class="btn-xs styled-btn">Like</button>
									</div>
                                   <table class="table ups" style="display: none" :id="'up'+vo.cno">
                                     <tr>
                                      <td>
                                       <textarea rows="3" cols="60" style="float: left" :id="'umsg'+vo.cno" >{{vo.msg}}</textarea>
                                       <input type=button value="수정" style="float: left;background-color: #003366;color: white;width: 75px;height:66px" @click="replyUpdate(vo.cno)">
                                       </td>
                                    </tr>
                                   </table>
                                </div>
                              </div>
                              <span class="share"></span>
                           </div>
                           </div>
                          </div>  
                        </div>
                       </div>
                       
                       <c:if test="${sessionScope.userId!=null }">
                         <div class="feature-cont">
                             <div class="comment-form">
                                <table class="table">
                                 <tr>
                                   <td>
                                    <textarea rows="4" cols="70" style="float: left" ref="msg" v-model="msg"></textarea>
                                    <input type=button value="댓글" style="float: left;background-color: #003366;color: white;width: 85px;height:87px"
                                      @click="replyInsert()">
                                   </td>
                                 </tr>
                                </table>
                             </div>
                           </div>
                        </c:if>
                    </div>
                 </div>
              </div>
              <div class="col-md-3">
                 <!-- <div class="news-sidebar">
                  <div class="search-bar-news">
                      <form @submit.prevent="newsFind"> 
						  <input type="text" ref="nd" v-model="nd" placeholder="search">
						  <button type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
					  </form>
                   </div>
                 </div> -->
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
	                           <c:when test="${fn:length(vo.title)>16 }">
	                            ${fn:substring(vo.title,0,14)}...
	                           </c:when>
	                         </c:choose>
	                       </a>
	                     </li>
	                   </c:forEach>
	                 </ul>
	             </div>
                 <!-- <div class="blog-sidebar">
                     <h4 class="heading">Top Categories</h4>
                     <div class="category-menu">
                        <ul>
                           <li><a href="#">Cricket</a></li>
                           <li><a href="#">Football</a></li>
                           <li><a href="#">Hockey</a></li>
                           <li><a href="#">Tennis</a></li>
                           <li><a href="#">Basketball</a></li>
                           <li><a href="#">Golf</a></li>
                           <li><a href="#">Cycling</a></li>
                           <li><a href="#">Motorsports</a></li>
                        </ul>
                     </div>
                  </div> 
                 <div class="blog-sidebar">
                     <h4 class="heading">Popular News</h4>
                     <div class="category-menu">
                        <ul>
                           <li>
                              <span><img src="../images/profile-img2.png" alt="#"></span>
                              <span>
                                 <p>Two touch penalties, imaginary cards</p>
                                 <p class="date">22 Feb, 2016</p>
                              </span>
                           </li>
                        </ul>
                     </div>
                  </div>-->
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
	                    <img class="img-responsive" src="../images/news-img1.png" alt="#">
	                 </div>
	              </aside>
	              <!-- <aside id="sidebar" class="right-bar">
	                 <div class="banner">
	                    <img class="img-responsive" src="../images/img-03.jpg" alt="#">
	                 </div>
	              </aside> -->
              </div>
           </div>
        </div>
     </section>
    <script>
    let detailApp=Vue.createApp({
    	data(){
    		return {
    			vo:{},
    			nno:${nno},
    			news_list:[],
    			
    			rno:${nno},
                reply_list:[],
                curpage:1,
                totalpage:0,
                endPage:0,
                startPage:0,
                type:1,
                sessionId:'${sessionId}',
                msg:'',
                isReply:false,
                upReply:false
    		}
    	},
    	mounted(){
    		axios.get('../news/detail_vue.do',{
    			params:{
    				nno:this.nno
    			}
    		}).then(response=>{
    			console.log(response.data)
    			this.vo=response.data
    		}).catch(error=>{
    			console.log(error.response)
    		})
    		
    		this.dataRecv()
    	  },
    	  methods:{
    		  replyUpdate(cno){
                  let msg=$('#umsg'+cno).val()
                  if(msg.trim()===""){
                      $('#umsg'+cno).focus()
                      return
                  }
                  axios.post('../comment/update_vue.do',null,{
                      params:{
                          cno:cno,
                          nno:this.nno,
                          type:this.type,
                          msg:msg
                      }
                  }).then(response=>{
                      console.log(response.data)
                      this.reply_list=response.data.list
                      this.curpage=response.data.curpage
                      this.totalpage=response.data.totalpage
                      this.startPage=response.data.startPage
                      this.endPage=response.data.endPage
                      $('#umsg'+cno).val("")
                      $('#up'+cno).hide()
                      $('#u'+cno).text("Update")
                  }).catch(error=>{
                      console.log(error.response)
                  })
              },
              // 댓글 삭제
              replyDelete(cno){
                  axios.get('../comment/delete_vue.do',{
                      params:{
                          cno:cno,
                          nno:this.nno,
                          type:this.type
                      }
                  }).then(response=>{
                      console.log(response.data)
                      this.reply_list=response.data.list
                      this.curpage=response.data.curpage
                      this.totalpage=response.data.totalpage
                      this.startPage=response.data.startPage
                      this.endPage=response.data.endPage
                  }).catch(error=>{
                      console.log(error.response)
                  })
              },
              // 대댓글 삽입
              replyReplyInsert(cno){
                  let msg=$('#msg'+cno).val()
                  if(msg.trim()===""){
                      $('#msg'+cno).focus()
                      return
                  }
                  axios.post('../comment/reply_insert_vue.do',null,{
                      params:{
                          nno:this.nno,
                          type:this.type,
                          msg:msg,
                          cno:cno
                      }
                  }).then(response=>{
                      console.log(response.data)
                      this.reply_list=response.data.list
                      this.curpage=response.data.curpage
                      this.totalpage=response.data.totalpage
                      this.startPage=response.data.startPage
                      this.endPage=response.data.endPage
                      $('#msg'+cno).val('')
                      $('#in'+cno).hide()
                      $('#i'+cno).text("Reply")
                  }).catch(error=>{
                      console.log(error.response)
                  })
              },
              // 댓글 업데이트 폼
              replyUpdateForm(cno){
                  $('.ins').hide()
                  $('.ups').hide()
                  $('.update').text('Update')
                  $('.insert').text('Reply')
                  if(this.upReply===false){
                      this.upReply=true
                      $('#up'+cno).show()
                      $('#u'+cno).text("Cancel")    
                  }
                  else{
                      this.upReply=false
                      $('#up'+cno).hide()
                      $('#u'+cno).text("Update")    
                  }
              },
              // 댓글 입력 폼
              replyForm(cno){
                  $('.ins').hide()
                  $('.ups').hide()
                  $('.update').text('Update')
                  $('.insert').text('Reply')
                  if(this.isReply===false){
                      this.isReply=true
                      $('#in'+cno).show()
                      $('#i'+cno).text("Cancel")
                  } 
                  else{
                      this.isReply=false
                      $('#in'+cno).hide()
                      $('#i'+cno).text("Reply")
                  }
              },
              // 댓글 삽입
              replyInsert(){
                  if(this.msg===""){
                      this.$refs.msg.focus()
                      return
                  }
                  axios.post('../comment/insert_vue.do',null,{
                      params:{
                          nno:this.nno,
                          type:this.type,
                          msg:this.msg
                      }
                  }).then(response=>{
                      console.log(response.data)
                      this.reply_list=response.data.list
                      this.curpage=response.data.curpage
                      this.totalpage=response.data.totalpage
                      this.startPage=response.data.startPage
                      this.endPage=response.data.endPage
                      this.msg=''
                  }).catch(error=>{
                      console.log(error.response)
                  })
              },
              // 댓글 데이터 받기
              dataRecv(){
                  axios.get('../comment/list_vue.do',{
                      params:{
                          nno:this.nno, 
                          type:this.type,
                          page:this.curpage
                      }
                  }).then(response=>{
                      console.log(response.data)
                      this.reply_list=response.data.list
                      this.curpage=response.data.curpage
                      this.totalpage=response.data.totalpage
                      this.startPage=response.data.startPage
                      this.endPage=response.data.endPage
                  }).catch(error=>{
                      console.log(error.response)
                  })
              }
    	  }
    	}).mount('#detailApp')
    </script>
</body>
</html>