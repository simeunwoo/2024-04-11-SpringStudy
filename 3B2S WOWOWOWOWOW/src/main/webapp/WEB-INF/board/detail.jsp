<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 상세보기</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">

/* 게시판 상세보기 큰 네모 박스 */
.board-container {
   width: 100%;
   max-width: 1000px;
   margin: 0 auto;
   padding: 20px;
   border: 2px solid #003366; /* 칠판 같은 테두리 */
   border-radius: 10px;
   background-color: #fff;
   box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1); /* 그림자 효과 */
   margin-top: 50px;
}


.breadcrumb {
	background-color: transparent;
}
/* 테이블 스타일 */
.table {
   width: 100%;
   border-collapse: collapse; /* 셀 간 간격 제거 */
}

.table th, .table td {
   padding: 12px 15px;
   border-bottom: 1px solid #ddd; /* 구분선 */
   text-align: center;
}

.table th {
   background-color: #f7f7f7;
   font-weight: bold;
}

.table td {
   background-color: white;
   text-align: center;
}

/* 수정, 삭제, 목록 버튼 */
.text-right .btn {
   margin-left: 5px;
}

pre {
   white-space: pre-wrap;
   background-color: white;
   border: none;
}


.inner-page-banner {
min-height:0px;
float:none;
}

.inner-information-text {
    float: none;
}    


.comment-content {
width: 100%;
    max-width: 1000px;
    margin: 0 auto;
    padding: 20px;
    border: 2px solid #003366;
    border-radius: 10px;
    background-color: #fff;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

li { 
display:block;
}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
<section style="float: none;">
    <div class="inner-page-banner">
        <div class="container">
        </div>
    </div>
    <div class="inner-information-text">
        <div class="container">
            <h3>자유게시판</h3>
            <ul class="breadcrumb">
                <li><a href="../main/main.do">Home</a></li>
                <li class="active">board</li>
            </ul>
        </div>
    </div>
</section>

<section id="detailApp">
   <div class="container">
      <!-- 게시판 상세보기 큰 네모 박스 -->
      <div class="board-container">
         <h3 class="text-center">내용보기</h3>
         <div class="row">
            <table class="table">
               <tr>
                  <th width="20%">번호</th>
                  <td width="30%">{{ vo.no }}</td>
                  <th width="20%">작성일</th>
                  <td width="30%">{{ vo.dbday }}</td>
               </tr>
               <tr>
                  <th width="20%">이름</th>
                  <td width="30%">{{ vo.name }}</td>
                  <th width="20%">조회수</th>
                  <td width="30%">{{ vo.hit }}</td>
               </tr>
               <tr>
                  <th width="20%">제목</th>
                  <td colspan="3">{{ vo.subject }}</td>
               </tr>
               <tr>
                  <td colspan="4" class="text-left" valign="top" height="200">
                     <pre>{{ vo.content }}</pre>
                  </td>
               </tr>
               <tr>
                  <td colspan="4" class="text-right">
                     <a :href="'../board/update.do?no=' + vo.no" class="btn btn-xs" v-show="sessionId === vo.id">수정</a>
                     <button class="btn btn-xs" @click="boardDelete()" v-show="sessionId === vo.id">삭제</button>
                     <a href="../board/list.do" class="btn btn-xs">목록</a>
                  </td>
               </tr>
            </table>
         </div>
      </div>
   </div>
</section>
<section>
 <div id="replyApp">
                            <div>
                                <h4 class="mb-30">댓글</h4>

                                <ol>
                                    <!-- Single Comment Area -->
                                    <li class="single_comment_area" v-for="vo in reply_list">
                                        <div class="comment-wrapper d-flex" v-if="vo.group_tab===0">
                                            <!-- Comment Meta -->
                                            <div class="comment-author">
                                                <img :src="vo.sex==='남자'?'../img/icon/man.png':'../img/icon/woman.png'" alt="">
                                            </div>
                                            <!-- Comment Content -->
                                            <div class="comment-content">
                                                <span class="comment-date text-muted">{{vo.dbday}}</span>
                                                <h5>{{vo.userName}}</h5>
                                                <p>{{vo.msg}}</p>
                                                <button v-if="sessionId===vo.id" class="btn btn-xs" style="margin-left: 2px" @click="replyUpdateForm(vo.cno)" :id="'u'+vo.cno">Update</button>
                                                <button v-if="sessionId===vo.id" class="btn btn-xs" style="margin-left: 2px" @click="replyDelete(vo.cno)">Delete</button>
                                                <button class="active insert"  v-if="sessionId!=''" style="margin-left: 2px"  @click="replyForm(vo.cno)" :id="'i'+vo.cno">Reply</button>
                                                <button v-if="sessionId!==vo.id && sessionId!==''" style="margin-left: 2px">Like</button>
                                                <table class="table ins" style="display: none" :id="'in'+vo.cno">
                                                <!-- 대댓부분 -->
			                                     <tr>
			                                      <td>
			                                       <textarea rows="4" cols="60" style="float: left" :id="'msg'+vo.cno" ></textarea>
			                                       <input type=button value="댓글" style="float: left;background-color: #003366;color: white;width: 80px;height:85px"
			                                         @click="replyReplyInsert(vo.cno)"
			                                       >
			                                       </td>
			                                    </tr>
			                                   </table>
			                                   <table class="table ups" style="display: none" :id="'up'+vo.cno">
			                                     <tr>
			                                      <td>
			                                       <textarea rows="4" cols="60" style="float: left" :id="'umsg'+vo.cno" >{{vo.msg}}</textarea>
			                                       <input type=button value="수정" style="float: left;background-color: #003366;color: white;width: 80px;height:90px"
			                                         @click="replyUpdate(vo.cno)"
			                                       >
			                                       </td>
			                                    </tr>
			                                   </table>
			                               
                                            </div>
                                 
                                        </div>
                                        
                                        <ol class="children" v-if="vo.group_tab===1">
                                            <li class="single_comment_area">
                                                <div class="comment-wrapper d-flex">
                                                    <!-- Comment Meta -->
                                                    <div class="comment-author">
                                                        <img :src="vo.sex==='남자'?'../img/icon/man.png':'../img/icon/woman.png'" alt="">
                                                        <img :src="vo.sex==='남자'?'../img/icon/man.png':'../img/icon/woman.png'" alt="">
                                                    </div>
                                                    <!-- Comment Content -->
                                                    <!-- 대댓? -->
                                                    <div class="comment-content">
                                                        <span class="comment-date text-muted">{{vo.dbday}}</span>
                                                        <h5>{{vo.userName}}</h5>
                                                        <p>{{vo.msg}}</p>
                                                        <button v-if="sessionId===vo.id" class="btn btn-xs" style="margin-left: 2px" @click="replyUpdateForm(vo.cno)" :id="'u'+vo.cno">Update</button>
                                                        <button v-if="sessionId===vo.id" class="btn btn-xs" style="margin-left: 2px" @click="replyDelete(vo.cno)">Delete</button>
                                                        <button v-if="sessionId!==vo.id && sessionId!==''" style="margin-left: 2px">Like</button>
		                                               <table class="table ups" style="display:none " :id="'up'+vo.cno">
					                                     <tr>
					                                      <td>
					                                       <textarea rows="4" cols="45" style="float: left" :id="'umsg'+vo.cno" >{{vo.msg}}</textarea>
					                                       <input type=button value="수정" style="float: left;background-color: #003366;color: white;width: 80px; height:90px"
					                                         @click="replyUpdate(vo.cno)"
					                                       >
					                                       </td>
					                                    </tr>
					                                   </table>
                                                    </div>
                                                </div>
                                            </li>
                                        </ol>
                                    </li>
                                    
                                </ol>
                            </div>
                            <!--  페이지  -->
                            <!-- Leave A Comment -->
                            <c:if test="${sessionScope.userId!=null }">
	                            <div class="leave-comment-area section_padding_50 clearfix">
	                                <div class="comment-form">
	                                   <table class="table">
	                                    <tr class="text-center">
	                                      <td>
	                                       <textarea rows="4" cols="70" style="float: left" ref="msg" v-model="msg"></textarea>
	                                       <input type=button value="댓글" style="float: left;background-color: #003366;color: white;width: 80px;height:90px"
	                                         @click="replyInsert()"
	                                       >
	                                       
	                                      </td>
	                                    </tr>
	                                   </table>
	                                </div>
	                            </div>
                            </c:if>
                          </div>
</section>
    <script>
   let detailApp = Vue.createApp({
      data() {
         return {
            vo: {},
            no: ${no},
            sessionId: '${sessionId}'
         };
      },
      mounted() {
         axios.get('../board/detail_vue.do', {
            params: {
               no: this.no
            }
         }).then(response => {
            console.log(response.data);
            this.vo = response.data;
         }).catch(error => {
            console.log(error.response);
         });
      },
      methods: {
         boardDelete() {
            axios.get('../board/delete_vue.do', {
               params: {
                  no: this.no
               }
            }).then(response => {
               if (response.data === 'yes') {
                  location.href = "../board/list.do";
               } else {
                  alert('삭제 실패');
                  console.log(response.data);
               }
            }).catch(error => {
               console.log(error.response);
            });
         }
      }
   }).mount('#detailApp');
</script>
    <script>
     let replyApp=Vue.createApp({
    	 data(){
    		 return {
                no:${no},
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
    		 this.dataRecv()
    	 },
    	 methods:{
    		 replyUpdate(cno){
    			 let msg=$('#umsg'+cno).val()
    			 if(msg.trim()==="")
    			 {
    				 $('#umsg'+cno).focus()
    				 return
    			 }
    			 axios.post('../comment/board_update_vue.do',null,{
     				params:{
     					cno:cno,
     					no:this.no,
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
    		 replyDelete(cno){
    			axios.get('../comment/board_delete_vue.do',{
    				params:{
    					cno:cno,
    					no:this.no,
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
    		
    		 replyReplyInsert(cno){
    			 let msg=$('#msg'+cno).val()
    			 if(msg.trim()==="")
    			 {
    				 $('#msg'+cno).focus()
    				 return
    			 }
    			 
    			 axios.post('../comment/board_reply_insert_vue.do',null,{
     				params:{
     					no:this.no,
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
             replyUpdateForm(cno){
    			$('.ins').hide()
     			$('.ups').hide()
     			$('.update').text('Update')
     			$('.insert').text('Reply')
     			if(this.upReply===false)
     			{
     				this.upReply=true
     				$('#up'+cno).show()
     			    $('#u'+cno).text("Cancel")	
     			}
     			else
     			{
     				this.upReply=false
     				$('#up'+cno).hide()
     				$('#u'+cno).text("Update")	
     			}
    		 },
    		 
    		 replyForm(cno){
    			$('.ins').hide()
    			$('.ups').hide()
    			$('.update').text('Update')
    			$('.insert').text('Reply')
    			if(this.isReply===false)
    			{
    				this.isReply=true
    			    $('#in'+cno).show()
    			    $('#i'+cno).text("Cancel")
    			    
    			} 
    			else
    			{
    				this.isReply=false
    				$('#in'+cno).hide()
    			    $('#i'+cno).text("Reply")
    			}
    		 },
    		 replyInsert(){
    			if(this.msg==="")
    			{
    				this.$refs.msg.focus()
    				return
    			}
    			axios.post('../comment/board_insert_vue.do',null,{
    				params:{
    					no:this.no,
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
    		 dataRecv(){
    			 axios.get('../comment/board_list_vue.do',{
    				 params:{
    					no:this.no, 
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
     }).mount('#replyApp')
    </script>          


</body>
</html>
