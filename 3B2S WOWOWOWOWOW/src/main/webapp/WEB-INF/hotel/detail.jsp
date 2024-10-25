<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://dapi.kakao.com/v2/maps/sdk.js?appkey=7afa4d414b029c6c74c3e45d6d3e8214&libraries=services"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<style type="text/css">
h2{
	font-size: ;
	font:bolder;
}
li{
	display:block;
	margin-bottom:15px;
}
.btnloc{
	float:right;
	padding:15px;
	margin:2px;
}
#replyApp{
	float:left;
}
.children{
	 margin-left: 100px; 
}

</style>
</head>
<body>
   <section id="top">
   
         <div class="inner-information-text">
            <div class="container">
               <h3>Contact</h3>
               <ul class="breadcrumb">
                  <li><a href="index.html">Home</a></li>
                  <li class="active">Contact</li>
               </ul>
            </div>
         </div>
      </section>
      <section id="contant hoteldetail" class="contant main-heading team">
         <div class="row">
            <div class="container">
               <div class="contact">
                  <div class="col-md-12">
                  
                     <div class="contact-info">
                        <div class="kode-section-title">
                           	<span style="padding:15px;color:red; font-size: xx-large;font:bolder;">${vo.name }</span>
                           	<span style="color:orange; font-size: x-large;">${vo.score }</span>
                           	<span style="color:black; float:right;font:bolder; font-size: x-large;">${price }원</span>
                        </div>
                        <div class="kode-forminfo">
	                        <div class="col-md-6">
		                        <img  src="${vo.poster }" style="width:490px;height:490px;">
	                        </div>
	                        <div class="col-md-6">
		                        <c:forEach var="images" items="${vo.imagesList}" varStatus="hvo">
		                        	<div class="col-md-6">
		                        	<div class="col-md-6" style="margin:.5px;">
		                        	
									    <img src="${images}" style="width:244px;height:244px;"/>
		                        	</div>
		                        	</div>
								</c:forEach>
	                        </div>
                        
                        	<div width="20px"></div>
	                           <ul class="kode-form-list detaildata text-left" style="padding:15px;">
	                              <li>
	                                 <p><strong>■&nbsp;주소 : ${vo.address }</strong></p>
	                              </li>
	                              <li>
	                                 <p><strong>■&nbsp;기본 정보</strong> </p>
	                              </li>
	                              <li>
	                                 <p><strong>1.&nbsp;체크인(Check-in):&nbsp;&nbsp;${vo.checkin }&nbsp;&nbsp;체크아웃(Check-out):&nbsp;&nbsp;${vo.checkout }</p>
	                                 <p><strong>2.&nbsp;와이파이 무료 이용</strong> </p>
	                                 <p><strong>3.&nbsp;애완동물 동반 불가능</strong> </p>
	                                 <p><strong>4.&nbsp;차/커피 메이커</strong> </p>
	                              </li>
	                              <li>
	                                 <p><strong>■&nbsp;편의시설</strong> </p>
	                              </li>
	                              <li>
	                                 <p> <strong>1.&nbsp;피트니스센터</strong></p>
	                                 <p> <strong>2.&nbsp;무료주차</strong></p>
	                                 <p> <strong>3.&nbsp;비즈니스 센터</strong></p>
	                              </li>
	                           </ul>
                        </div>
                        <div class="btnloc">
                              <a  class="btn btn-sm btn-primary" href="../hotel/list.do">목록</a>
                              <c:if test="${sessionScope.userId != null}">
							    <button class="btn btn-sm" 
							            v-bind:class="isJjim ? 'btn-default' : 'btn-aaa'"
							            v-bind:style="isJjim ? 'background-color:gray;' : 'background-color:#003366;'"
							            @click="isJjim ? deljjim() : jjim()">
							        {{ isJjim ? '찜삭제' : '찜하기' }}
							    </button>
							    <a class="btn" href="../hotel/reserve.do?hno=${hno}">예약하기</a>
							</c:if>

                        </div>
                     <table class="table">
                        <tr>
                             <td>
                                <div id="map" style="width:100%;height:235px"></div>
                             </td>
                          </tr>
                     </table>
                     <script>
                            var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
                        mapOption = {
                            center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
                            level: 3 // 지도의 확대 레벨
                              };  

                          // 지도를 생성합니다    
                          var map = new kakao.maps.Map(mapContainer, mapOption); 
              
                          // 주소-좌표 변환 객체를 생성합니다
                          var geocoder = new kakao.maps.services.Geocoder();
              
                          // 주소로 좌표를 검색합니다
                          geocoder.addressSearch('${vo.address}', function(result, status) {
                                               
                              // 정상적으로 검색이 완료됐으면 
                               if (status === kakao.maps.services.Status.OK) {
              
                                  var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
              
                                  // 결과값으로 받은 위치를 마커로 표시합니다
                                  var marker = new kakao.maps.Marker({
                                      map: map,
                                      position: coords
                                  });
              
                                  // 인포윈도우로 장소에 대한 설명을 표시합니다
                                  var infowindow = new kakao.maps.InfoWindow({
                                      content: '<div style="width:150px;text-align:center;padding:6px 0;">${vo.name }</div>'
                                  });
                                  infowindow.open(map, marker);
              
                                  // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
                                  map.setCenter(coords);
                              } 
                          });  
                            </script>
                  </div>
                 
                 <div id="replyApp" class="col-md-12">
                            <div class="comment_area section_padding_50 clearfix">
                                <h4 class="mb-30">댓글</h4>
                                <ol>
                                    <!-- Single Comment Area -->
                                    <li class="single_comment_area text-left" v-for="vo in reply_list" style="background-color: #f0f0f0; padding: 10px; margin-bottom: 10px;">
                                        <div class="comment-wrapper d-flex" v-if="vo.group_tab===0">
                                            <!-- Comment Meta -->
                                            <div class="comment-author">
                                                
                                                <img :src="vo.sex==='남자'?'../images/man.png':'../images/woman.png'" style="width:100px;height:100px;">
                                            </div>
                                            <!-- Comment Content -->
                                            <div class="comment-content">
                                                <span class="comment-date text-muted">{{vo.dbday}}</span>
                                                <h5>{{vo.name}}</h5>
                                                <p class="text-left">{{vo.msg}}</p>
                                                <button v-if="sessionId===vo.id" class="btn-xs btn-danger update" style="margin-left: 2px" @click="replyUpdateForm(vo.cno)" :id="'u'+vo.cno">댓글수정</button>
                                                <button v-if="sessionId===vo.id" class="btn-xs btn-info" style="margin-left: 2px" @click="replyDelete(vo.cno)">삭제</button>
                                                <button class="active insert btn-xs btn-warning" v-if="sessionId!=''" style="margin-left: 2px"  @click="replyForm(vo.cno)" :id="'i'+vo.cno">답글</button>
                                                <table class="table ins" style="display: none" :id="'in'+vo.cno">
			                                     <tr>
			                                      <td>
			                                       <textarea rows="4" cols="60" style="float: left" :id="'msg'+vo.cno" ></textarea>
			                                       <input type=button value="댓글" style="float: left;background-color: blue;color: white;width: 80px;height:94px"
			                                         @click="replyReplyInsert(vo.cno)"
			                                       >
			                                       </td>
			                                    </tr>
			                                   </table>
			                                   <table class="table ups" style="display: none" :id="'up'+vo.cno">
			                                     <tr>
			                                      <td>
			                                       <textarea rows="4" cols="60" style="float: left" :id="'umsg'+vo.cno" >{{vo.msg}}</textarea>
			                                       <input type=button value="수정" style="float: left;background-color: blue;color: white;width: 80px;height:94px"
			                                         @click="replyUpdate(vo.cno)"
			                                       >
			                                       </td>
			                                    </tr>
			                                   </table>
                                            </div>
                                        </div>
                                        
                                        <ol  v-if="vo.group_tab===1">
                                            <li class="single_comment_area text-left" >
                                                <div class="comment-wrapper d-flex">
                                                    <!-- Comment Meta -->
                                                    
                                                    <div class="comment-author">
                                                    <img src="../images/reply.png" style="width:100px;height:100px;">
                                                        <img :src="vo.sex==='남자'?'../images/man.png':'../images/woman.png'" style="width:100px;height:100px;">
                                                    </div>
                                                    <!-- Comment Content -->
                                                    <div class="comment-content children">
                                                        <span class="comment-date text-muted">{{vo.dbday}}</span>
                                                        <h5>{{vo.name}}</h5>
                                                        <p class="text-left">{{vo.msg}}</p>
                                                        <button v-if="sessionId===vo.id" class="btn-xs btn-danger" style="margin-left: 2px" @click="replyUpdateForm(vo.cno)" :id="'u'+vo.cno">수정</button>
                                                        <button v-if="sessionId===vo.id" class="btn-xs btn-info" style="margin-left: 2px" @click="replyDelete(vo.cno)">삭제</button>
		                                               <table class="table ups" style="display:none " :id="'up'+vo.cno">
					                                     <tr>
					                                      <td>
					                                       <textarea rows="4" cols="45" style="float: left" :id="'umsg'+vo.cno" >{{vo.msg}}</textarea>
					                                       <input type=button value="수정" style="float: left;background-color: #003366;color: white;width: 120px;height:94px"
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
                            
                             <!-- Leave A Comment 문제 X -->
                            <c:if test="${sessionScope.userId!=null }">
	                            <div class="leave-comment-area section_padding_50 clearfix">
	                                <div class="comment-form">
	                                   <table class="table">
	                                    <tr>
	                                      <td>
	                                       <textarea rows="4" cols="102"  style="float: left" ref="msg" v-model="msg" ></textarea>
	                                       <input type=button value="댓글" style="float: left;background-color: #003366;color: white;width: 120px;height:92px"
	                                         @click="replyInsert()"
	                                       >
	                                      </td>
	                                    </tr>
	                                   </table>
	                                </div>
	                            </div>
                            </c:if>
                          </div>
               </div>
            </div>
         </div>
         </div>
      </section>
      <script>
     let hoteldetail = Vue.createApp({
    	 data() {
             return {
                 hno: ${hno},
                 rno:${hno},
                 reply_list:[],
                 curpage:1,
                 totalpage:0,
                 endPage:0,
                 startPage:0,
                 type:1,
                 sessionId:'${sessionId}',
                 msg:'',
                 isReply:false,
                 isJjim :${check},
                 upReply:false
             }
         },
         methods: {
             jjim() {
                 console.log("찜하기 클릭", this.hno); 
                 axios.post('../hotel/jjim_vue.do',null,{
       				params:{
       					hno:this.hno
       				}
       			}).then(response=>{
    	   				 console.log("yes")
    	   			this.isJjim = true;
    			   }).catch(error=>{
    				     console.log(error.response)
    			   }) 
             },
             deljjim() {
                 console.log("찜 삭제 클릭", this.hno);
                 axios.post('../hotel/del_jjim_vue.do',null,{
      				params:{
      					hno:this.hno
      				}
      			}).then(response=>{
   	   				 console.log("yes")
   	   				this.isJjim = false;
   			   }).catch(error=>{
   				     console.log(error.response)
   			   }) 
             }
            
         }
     }).mount('.btnloc')
     
     let replyApp=Vue.createApp({
    	 data(){
    		 return {
                rno:${hno},
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
    			 axios.post('../comment/h_update_vue.do',null,{
     				params:{
     					cno:cno,
     					rno:this.rno,
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
    			axios.get('../comment/h_delete_vue.do',{
    				params:{
    					cno:cno,
    					rno:this.rno,
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
    			 
    			 axios.post('../comment/h_reply_insert_vue.do',null,{
     				params:{
     					rno:this.rno,
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
    			axios.post('../comment/h_insert_vue.do',null,{
    				params:{
    					rno:this.rno,
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
    			 axios.get('../comment/h_list_vue.do',{
    				 params:{
    					rno:this.rno, 
    					type:this.type,
    					page:this.curpage,
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