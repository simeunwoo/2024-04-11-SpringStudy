<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3"></script>
<script src="http://code.jquery.com/jquery.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
google.charts.load('current', {packages: ['corechart', 'bar']});
</script>
<style>
.container{
	text-align: center;
}
#chart_div,#chart2_div{
	display: block;
	margin: 0 auto;
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
	<div class="breadcumb-area" style="background-image: url(../img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
                        <h2></h2>
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
    <section class="single_blog_area section_padding_80">
        <div class="container" id="chartApp">
            <div class="row justify-content-center">
                <div class="col-12 col-lg-8">
                    <div class="row no-gutters">

                        <!-- Single Post -->
                        <div class="col-12 col-sm-12">
                            
                            <!-- Related Post Area -->
                            <div class="related-post-area section_padding_50">
                              
                                <div class="related-post-slider owl-carousel">
                                    <!-- Single Related Post-->
	                                    <div class="single-post">
	                                        <!-- Post Thumb -->
	                                        <div class="post-thumb">
	                                            <img src="#" alt="">
	                                        </div>
	                                    </div>
                                </div>
                            </div>
         </div>
         <div class="container">                   
        <div class="header-top">
            <div class="row">
                <h4>Points Table</h4>
                <aside id="sidebar" class="left-bar">
                    <div class="feature-matchs text-center" style="text-align: center;">
                        <table class="table table-bordered table-hover" style="font-size:16px;margin:0 auto">
                            <tr>
                            	<td colspan="6" class="text-center">
   									<img src="https://statiz.sporki.com${pvo.image }" style="width:101px;height:134px">
   									&nbsp;&nbsp;<h3>${pvo.name }</h3>
   									&nbsp;<img src="${pvo.logo }" style="width:130px;height:130px">
   									&nbsp;<h3>${pvo.team }</h3>
                            	</td>
                            </tr>
                            <tr>
                                <th width="20%" class="text-center">나이</th>
                                <td width="13%" class="text-center">${pvo.age }</td>
                                <th width="20%" class="text-center">경기</th>
                                <td width="13%" class="text-center">${pvo.game }</td>
                                <th width="20%" class="text-center">이닝</th>
                                <td width="14%" class="text-center">${pvo.inning }</td>
                            </tr>
                            <tr>
                                <th width="20%" class="text-center">승</th>
                                <td width="13%" class="text-center">${pvo.win }</td>
                                <th width="20%" class="text-center">패</th>
                                <td width="13%" class="text-center">${pvo.lose }</td>
                                <th width="20%" class="text-center" style="color:red">평균자책점(ERA)</th>
                                <td width="14%" class="text-center" style="color:red">${pvo.era }</td>
                            </tr>
                            <tr>
                                <th width="20%" class="text-center">피안타</th>
                                <td width="13%" class="text-center">${pvo.hit }</td>
                                <th width="20%" class="text-center">탈삼진</th>
                                <td width="13%" class="text-center">${pvo.strikeout }</td>
                                <th width="20%" class="text-center">볼넷</th>
                                <td width="14%" class="text-center">${pvo.ball }</td>
                            </tr>
                            <tr>
                                <th width="20%" class="text-center">세이브</th>
                                <td width="13%" class="text-center">${pvo.save }</td>
                                <th width="20%" class="text-center">홀드</th>
                                <td width="13%" class="text-center">${pvo.hold }</td>
                                <th width="20%" class="text-center" style="color:red">WAR</th>
                                <td width="14%" class="text-center" style="color:red">${pvo.war }</td>
                            </tr>
                        </table></div></aside></div></div></div></div></div>
                        	
                        </div>
                        	<div style="height:50px"></div>
                        	<div id="chart_div" style="width: 900px; height: 500px;"></div>
                        	<div style="height:80px"></div>
                        	<div id="chart2_div" style="width: 900px; height: 500px;"></div>
                        	<div style="height:80px"></div>
                        </div>
   		<div class="comment_area section_padding_50 clearfix" id="replyApp">
   			<div class="col-12 col-lg-4"></div>
   			<div class="col-12 col-lg-5">
                                <h4 class="mb-30">댓글</h4>

                                <ol>
                                    <!-- Single Comment Area -->
                                    <li class="single_comment_area" v-for="vo in reply_list">
                                        <div class="comment-wrapper d-flex" v-if="vo.group_tab===0">
                                            <!-- Comment Meta -->
                                            <div class="comment-author">
                                                <img :src="vo.sex==='남자'?'../player/man.png':'../player/woman.png'" alt="">
                                            </div>
                                            <!-- Comment Content -->
                                            <div class="comment-content">
                                                <span class="comment-date text-muted">{{vo.dbday}}</span>
                                                <h5>{{vo.name}}</h5>
                                                <p>{{vo.msg}}</p>
                                                <button v-if="sessionId===vo.id" class="btn-xs btn-danger update" style="margin-left:2px"
                                                  @click="replyUpdateForm(vo.cno)" :id="'u'+vo.cno">Update</button>
                                                <button v-if="sessionId===vo.id" class="btn-xs btn-info" style="margin-left:2px"
                                                  @click="replyDelete(vo.cno)">Delete</button>
                                                <button class="active insert" v-if="sessionId!=''" style="margin-left:2px"
                                                  @click="replyForm(vo.cno)" :id="'i'+vo.cno">Reply</button>
                                                <button v-if="sessionId!==vo.id && sessionId!==''" style="margin-left:2px">Like</button>
                                                <table class="table ins" style="display: none" :id="'in'+vo.cno">
			                                     <tr>
			                                      <td>
			                                       <textarea rows="4" cols="60" style="float:left" :id="'msg'+vo.cno" ></textarea>
			                                       <input type=button value="댓글" style="float:left;background-color:blue;color:white;width:80px;height:94px"
			                                         @click="replyReplyInsert(vo.cno)"
			                                       >
			                                       </td>
			                                    </tr>
			                                   </table>
			                                   <table class="table ups" style="display:none" :id="'up'+vo.cno">
			                                    <tr>
			                                      <td>
			                                       <textarea rows="4" cols="60" style="float:left" :id="'umsg'+vo.cno">{{vo.msg}}</textarea>
			                                       <input type=button value="수정" style="float:left;background-color:blue;color:white;width:80px;height:94px"
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
                                                    </div>
                                                    <!-- Comment Content -->
                                                    <div class="comment-content">
                                                        <span class="comment-date text-muted">{{vo.dbday}}</span>
                                                        <h5>{{vo.name}}</h5>
                                                        <p>{{vo.msg}}</p>
                                                        <button v-if="sessionId===vo.id" class="btn-xs btn-danger" style="margin-left:2px"
                                                          @click="replyUpdateForm(vo.cno)" :id="'u'+vo.cno">Update</button>
		                                                <button v-if="sessionId===vo.id" class="btn-xs btn-info" style="margin-left:2px"
		                                                  @click="replyDelete(vo.cno)">Delete</button>
                                                        <button v-if="sessionId!==vo.id && sessionId!==''" style="margin-left:2px">Like</button>
                                                        <table class="table ups" style="display:none" :id="'up'+vo.cno">
					                                    <tr>
					                                      <td>
					                                       <textarea rows="4" cols="45" style="float: left" :id="'umsg'+vo.cno">{{vo.msg}}</textarea>
					                                       <input type=button value="수정" style="float: left;background-color: blue;color: white;width: 80px;height:94px"
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
                                <!-- Leave A Comment 문제 X -->
                            <c:if test="${sessionScope.userId!=null }">
	                            <div class="leave-comment-area section_padding_50 clearfix">
	                                <div class="comment-form">
	                                   <table class="table">
	                                    <tr>
	                                      <td>
	                                       <textarea rows="4" cols="70" style="float: left" ref="msg" v-model="msg"></textarea>
	                                       <input type=button value="댓글" style="float: left;background-color: blue;color: white;width: 80px;height:94px"
	                                         @click="replyInsert()"
	                                       >
	                                       
	                                      </td>
	                                    </tr>
	                                   </table>
	                                </div>
	                            </div>
                            </c:if></div>
                            <div class="col-12 col-lg-3"></div>
                            </div>
                            
   	</section>
   	<script>
	let chartApp=Vue.createApp({
   	 data(){
   		 return {
   			vo:{},
			pno:${pno}
   		 }
   	 },
   	 mounted(){
   		axios.get('../player/pitcher_detail_vue.do',{
			params:{
				pno:this.pno
			}
		}).then(response=>{
			console.log(response.data)
			this.vo=response.data
			
			this.drawDetailChart()
			this.drawImportantChart()
		}).catch(error=>{
			console.log(error.response)
		})
   	 },
   	methods:{
		drawDetailChart() {
		      var data = google.visualization.arrayToDataTable([
		        ['', '류현진 (Hyun-Jin Ryu)', this.vo.name],
		        ['경기수', 25, this.vo.game],
		        ['승', 16, this.vo.win],
		        ['패', 4, this.vo.lose],
		        ['피안타', 149, this.vo.hit],
		        ['삼진', 187, this.vo.strikeout],
		        ['볼넷', 45, this.vo.ball],
		        ['세이브', 0, this.vo.save],
		        ['홀드', 0, this.vo.hold],
		        ['이닝', 192.2, this.vo.inning]
		      ]);

		      var materialOptions = {
		        chart: {
		          title: this.vo.name+'와(과) 류현진 (Hyun-Jin Ryu)의 세부 기록 비교 차트',
		          subtitle: '비교 항목 : 경기수, 승, 패, 피안타, 삼진, 볼넷, 세이브, 홀드, 이닝'
		        },
		        hAxis: {
		          title: '',
		          minValue: 0,
		        },
		        vAxis: {
		          title: 'City'
		        },
		        bars: 'horizontal'
		      };
		      var materialChart = new google.charts.Bar(document.getElementById('chart_div'));
		      materialChart.draw(data, materialOptions);
		    },
	
		drawImportantChart() {
		      var data = google.visualization.arrayToDataTable([
		        ['', '류현진 (Hyun-Jin Ryu)', this.vo.name],
		        ['WAR(승리기여도)', 9.34, this.vo.war],
		        ['ERA(평균자책점)', 1.82, this.vo.era]
		      ]);

		      var materialOptions = {
		        chart: {
		          title: this.vo.name+'와(과) 류현진 (Hyun-Jin Ryu)의 WAR, ERA 기록 비교 차트',
		          subtitle: '비교 항목 : WAR(승리기여도), ERA(평균자책점)'
		        },
		        hAxis: {
		          title: '',
		          minValue: 0,
		        },
		        vAxis: {
		          title: 'City'
		        },
		        bars: 'horizontal'
		      };
		      var materialChart = new google.charts.Bar(document.getElementById('chart2_div'));
		      materialChart.draw(data, materialOptions);
		    }
		}
    }).mount('#chartApp')
		</script>
	<script>
	let replyApp=Vue.createApp({
   	 data(){
   		 return {
               rno:${pno},
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
   			 axios.post('../comment/pitcher_update_vue.do',null,{
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
   			axios.get('../comment/pitcher_delete_vue.do',{
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
   			 
   			 axios.post('../comment/pitcher_reply_insert_vue.do',null,{
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
   			axios.post('../comment/pitcher_insert_vue.do',null,{
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
   			 axios.get('../comment/pitcher_list_vue.do',{
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