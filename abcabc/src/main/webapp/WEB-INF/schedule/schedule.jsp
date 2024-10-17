<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
<div class="container" id="gameApp">
    <div class="row">

    <h2>{{month}}월 {{day}}일 경기 결과</h2>
    <div v-if="games.length > 0">
      <div v-for="vo in games" :key="vo.sno">
      	<div>
      	
	        <p>
	          {{ vo.away }} {{ vo.awayscore }} - {{ vo.homescore }} {{ vo.home }}
	        </p>
        </div>
      </div>
    </div>
    <div v-else>
      <p>경기가 없습니다.</p>
    </div>

</div>
<div>
	<div class="pagination-area d-sm-flex mt-15">
		<ul class="pagination">
			<li class="page-item" v-if="startPage>1">
		      <a class="page-link" @click="prev()"><i class="fa fa-angle-double-left" aria-hidden="true"></i> 이전</a>
		    </li>
		    <li :class="page===curpage?'page-item active':'page-item'" v-for="i in range(startPage,endPage)" :key="page">
		      <a class="page-link" @click="pageChange(page)">{{month}}월 {{day}}일</a>
		    </li>
		    <li class="page-item" v-if="endPage<totalpage">
		      <a class="page-link" @click="next()">다음 <i class="fa fa-angle-double-right" aria-hidden="true"></i></a>
		    </li>
		</ul>
	</div>
</div>
</div>
<script>
    let scheduleApp = Vue.createApp({
        data() {
            return {
                games:[],
                curpage:1,
                totalpage:0,
                startPage:0,
                endPage:0,
                month:3,
                day:23
            }
        },
        mounted() {
            this.dataRecv()
        },
        methods: {
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
            }
            dataRecv() {
                axios.get('../schedule/schedule_vue.do', {
                    params: {
                        month:this.month,
                        day:this.day,
                        page:this.curpage
                    }
                }).then(response => {
                    console.log(response.data)
                    this.games=response.data.games
                    this.curpage=response.data.curpage
                    this.totalpage=response.data.totalpage
                    this.startPage=response.data.startPage
                    this.endPage=response.data.endPage
                    this.month=response.data.month
                    this.day=response.data.day
                }).catch(error => {
                    console.log(error.response)
                })
            }
        }
    }).mount('#gameApp')
</script>
</body>
</html>



