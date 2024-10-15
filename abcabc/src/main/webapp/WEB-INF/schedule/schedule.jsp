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
  <div>
    <h2>{{ selectedDate.month }}월 {{ selectedDate.day }}일 경기 결과</h2>
    <div v-if="games.length > 0">
      <div v-for="vo in games" :key="vo.sno">
        <p>
          {{ vo.away }} {{ vo.awayscore }} - {{ vo.homescore }} {{ vo.home }}
        </p>
      </div>
    </div>
    <div v-else>
      <p>경기가 없습니다.</p>
    </div>
  </div>
</div>
<div>
	<div class="pagination-area d-sm-flex mt-15">
		<ul class="pagination">
			<li class="page-item" v-if="startPage>1">
		      <a class="page-link" @click="prev()"><i class="fa fa-angle-double-left" aria-hidden="true"></i> 이전</a>
		    </li>
		    <li :class="i===curpage?'page-item active':'page-item'" v-for="i in range(startPage,endPage)" :key="i">
		      <a class="page-link" @click="pageChange(i)">{{formatDate(dates[i-1])}}</a>
		    </li>
		    <li class="page-item" v-if="endPage<totalpage">
		      <a class="page-link" @click="next()">다음 <i class="fa fa-angle-double-right" aria-hidden="true"></i></a>
		    </li>
		    <!-- 
			<button v-for="(date.index) in dates" :key="index" @click="updateDate(date.month,date.day)">
				{{date.month}}월 {{date.day}}일
			</button>
			 -->
		</ul>
	</div>
</div>
</div>
<script>
    let scheduleApp = Vue.createApp({
        data() {
            return {
                games:[],
                //month:3,  // 초기값, 필요에 따라 변경 가능
                //day:23,   // 초기값, 필요에 따라 변경 가능
                dates:[],
                curpage:1,
                totalpage:0,
                startPage:1,
                endPage:5,
                selectedDate:{month:3,day:23}
            }
        },
        mounted() {
        	this.dataDates()
        	this.loadGames()
            this.dataRecv()
        },
        methods: {
            dataRecv() {
                axios.get('../schedule/schedule_vue.do', {
                    params: {
                        month:this.selectedDate.month,
                        day:this.selectedDate.day,
                        page:this.curpage
                    }
                }).then(response => {
                    console.log(response.data)
                    this.games = response.data.games
                    this.curpage=response.data.curpage
                    this.totalpage=response.data.totalpage
                    this.startPage=response.data.startPage
                    this.endPage=response.data.endPage
                }).catch(error => {
                    console.log(error.response)
                })
            },
            updateDate(newMonth, newDay) {
                this.month = newMonth
                this.day = newDay
               this.dataRecv()
            },
            dataDates(){
            	let startDate=new Date(2024,2,23)
            	let endDate=new Date(2024,9,1)
            	this.dates=[]
            	
            	while(startDate<=endDate){
            		this.dates.push(new Date(startDate))
            		startDate.setDate(startDate.getDate()+1)
            	}
            	this.totalpage=this.dates.length
            },
            loadGames(){
            	let date=this.dates[this.curpage-1]
            	this.selectedDate={
            			month:date.getMonth()+1,
            			day:date.getDate()
            	}
            	this.dataRecv()
            },
            prev(){
            	if(this.curpage>1)
            	{
            		this.pageChange(this.curpage-1)
            	}
            },
            next(){
            	if(this.curpage<this.totalpage)
            	{
            		this.pageChange(this.curpage+1)
            	}
            },
            pageChange(page){
            	this.curpage=page
            	this.loadGames()
            },
            range(start,end){
            	return Array.from({length:end-start+1},(v,k)=>k+start)
            },
            formatDate(date){
            	let month=date.getMonth()+1
            	let day=date.getDate()
            	return `${month}월 ${day}일`
            }
        }
    }).mount('#gameApp')
</script>


<style scoped>
h2 {
  color: #333;
}
</style>

	
</body>
</html>



















