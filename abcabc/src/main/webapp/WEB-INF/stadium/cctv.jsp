<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
<div class="container">
  <div id="myApp">
   <table class="table">
    <tr>
      <td class="text-center">
       <button class="btn-sm" style="background-color:#131230;color:white" @click="cctvView(1)">잠실 구장 (두산,LG)</button>
       &nbsp;<button class="btn-sm btn-success" style="background-color:purple" @click="cctvView(2)">고척 스카이돔 (키움)</button>
       &nbsp;<button class="btn-sm btn-info" style="background-color:red" @click="cctvView(3)">인천 SSG 랜더스필드 (SSG)</button>
       &nbsp;<button class="btn-sm btn-warning" style="background-color:black" @click="cctvView(4)">수원 케이티 위즈 파크 (KT)</button>
       &nbsp;<button class="btn-sm btn-primary" style="background-color:orange" @click="cctvView(5)">베이스볼 드림파크 (한화)</button>
       &nbsp;<button class="btn-sm btn-danger" style="background-color:blue" @click="cctvView(6)">대구 삼성 라이온즈 파크 (대구)</button>
       &nbsp;<button class="btn-sm btn-success" style="background-color:#315288;color:lightgray" @click="cctvView(7)">창원 NC 파크 (창원)</button>
       &nbsp;<button class="btn-sm btn-warning" style="background-color:black;color:orange" @click="cctvView(8)">사직 구장 (롯데)</button>
       &nbsp;<button class="btn-sm btn-info" style="background-color:#EA0029" @click="cctvView(9)">광주-기아 챔피언스 필드 (KIA)</button>
      </td>
    </tr>
   </table>
   <table class="table" v-show="isShow">
     <tr>
       <td class="text-center" colspan="5">
         <h4>교통 돌발 상황</h4>
       </td>
     </tr>
     <tr>
       <th class="text-center">돌발상황</th>
       <th class="text-center">공사일</th>
       <th class="text-center">도로위치</th>
       <th class="text-center">도로차단</th>
       <th class="text-center">사유</th>
     </tr>
     <tr v-for="vo in state_list">
       <td class="text-center">{{vo.eventType}}</td>
       <td class="text-center">{{vo.startDate}}</td>
       <td>{{vo.roadName}}</td>
       <td class="text-center">{{vo.lanesBlocked}}</td>
       <td>{{vo.message}}</td>
     </tr>
   </table>
  </div>
  </div>
  <script>
  let app=Vue.createApp({
	  data(){
		return {
			 no:0,
		     state_list:[],
		     isShow:false
		}
	  },
	  methods:{
		  cctvView(no){
			  this.isShow=true
			  this.no=no
			  window.open(`http://cctv-url-for-stadium${no}`, '_blank', 'width=800,height=600');
			  axios.get('http://127.0.0.1:8000/web/food/',{
				  params:{
					  no:this.no
				  }
			  }).then(response=>{
				  alert("정상수행:"+response.data)
			  }).catch(error=>{
				  console.log(error.response)
			  })
			  
			  axios.get('../stadium/cctv_vue.do',{
				  params:{
					  no:this.no
				  }
			  }).then(response=>{
				  this.state_list=response.data
			  }).catch(error=>{
				  console.log(error.response)
			  })
		  }
	  }
  }).mount("#myApp")
  </script>
</body>
</html>