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
       <button class="btn-sm" style="background-color:#131230;color:white" @click="cctvView(1)">잠실 구장 (두산, LG)</button>
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
   <div style="overflow-y:auto;height:500px">
   <table class="table" v-show="isShow">
     <tr>
       <td class="text-center" colspan="5">
         <h4>교통 돌발 상황</h4>
       </td>
     </tr>
     <tr>
       <th width="7%" class="text-center">돌발 상황</th>
       <th width="13%" class="text-center">공사일</th>
       <th width="20%" class="text-center">도로 위치</th>
       <th width="15%" class="text-center">도로 차단</th>
       <th width="45%" class="text-center">사유</th>
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
   <div style="height:80px"></div>
   <div style="overflow-y:auto;height:500px">
   <table class="table" v-show="isShow">
     <tr>
       <td class="text-center" colspan="4">
         <h4>주의 운전 구간</h4>
       </td>
     </tr>
     <tr>
       <th width="15%" class="text-center">도로명</th>
       <th width="15%" class="text-center">도로 위치</th>
       <th width="15%" class="text-center">발생 유형</th>
       <th width="55%" class="text-center">사유</th>
     </tr>
     <tr v-for="svo in safe_list">
       <td class="text-center">{{svo.routeNo}}</td>
       <td class="text-center">{{svo.revRouteName}}</td>
       <td class="text-center">{{svo.outbrkType}}</td>
       <td>{{svo.message}}</td>
     </tr>
   </table>
   <div style="overflow-y:auto;height:500px">
  </div>
  </div>
  <script>
  let myApp=Vue.createApp({
	  data(){
		return{
			 no:0,
		     state_list:[],
		     safe_list:[],
		     isShow:false,
		     cctvUrl:''
		}
	  },
	  methods:{
			cctvView(no){
		        this.isShow=true
		        let cctvUrl=''

		        switch(no){
		            case 1:
		                cctvUrl='http://cctvsec.ktict.co.kr/5730/L+6u49S0VzDxZmoHvxhZ4v1jt8qQ3+gKSpPXyY710juiqC7JnYSCuRJlhMNJMer1FWcmlpy5zqFQmFI4FoxC/w=='
		                break
		            case 2:
		                cctvUrl='http://cctvsec.ktict.co.kr/43/BfmZpJJb0e0ByFxazhMewYJqUPC1l+IrFba2y4ec3E8qEooED/1JfcYdTIDi0gNTLF9orV3yTt0u1jF0K1OweA=='
		                break
		            case 3:
		                cctvUrl='http://cctvsec.ktict.co.kr/5248/gGsFSdioKLBqlx/k4yniNBgBcNUrFvWMBSqp/WbKu7+zRk1vxnQComQdFjHOyYf0NfaAOKoattO5r0iEj6YarA=='
		                break
		            case 4:
		                cctvUrl='http://cctvsec.ktict.co.kr/3715/t9zOCr5Y5+Nqc5ilNNtwAwAl9qEcI9TJbolOBJpRiaOearveYAUDrcq6jSpXS0+HwzI1yOmsquSc71w/WUL4zw=='
		                break
		            case 5:
		                cctvUrl='http://cctvsec.ktict.co.kr/3344/t1Fz9HFiUOWiXcjvFiB4tyteVEXFbxym+tOIIyGLfQtx8VJcuWzPupjtSrId5D8oiJ+lAgQV9VUgxw3uWIHtOg=='
		                break
		            case 6:
		                cctvUrl='http://cctvsec.ktict.co.kr/5119/W3zQ1/3JVLBdcc84lp2WCfr4OscjYybiIFtkPMoEftUx7nrYshz7JaI05Dq7TKErUqyq0IMn9BiqiJKLEv4yoQ=='
		                break
		            case 7:
		                cctvUrl='http://cctvsec.ktict.co.kr/3908/5OALxtvdb1g9vnjjBJQQtIWJcwPIDmX2DOhPMqt/V3OMRbYoWZHFkNOa/BkQMaI1KrBtP2RzWqAmFQS3uFfmzw=='
		                break
		            case 8:
		                cctvUrl='http://cctvsec.ktict.co.kr/2050/cOxmh1LB2lnjAgl0DSQc4f/NyrMusoLCuFPh1fVVBF2r81iNx52sQxpovDzNip/55p9M0b+juBfGYDvuMBpTTA=='
		                break
		            case 9:
		                cctvUrl='http://cctvsec.ktict.co.kr/2326/y8Oy0cujl4sjYZIQeqMNI+WvJtET3lmSjVmKib2Yc7jVEhk0eDZW7S5yN8XojtCUc+d3JJ+j+a67emt8YxAZkg=='
		                break
		            default:
		                console.log('Invalid stadium number')
		                return
		        }

		        // 새 창으로 CCTV URL 열기
		        window.open(cctvUrl, '_blank', 'width=800,height=600')

		        // 교통 상태 API 호출
		        axios.get('../stadium/cctv_vue.do', {
		            params:{
		                no:this.no
		            }
		        }).then(response=>{
		        	console.log(response.data)
		            this.state_list=response.data.state_list
		            this.safe_list=response.data.safe_list
		        }).catch(error=>{
		            console.log(error.response)
		        })
		    }
		}

  }).mount("#myApp")
  </script>
</body>
</html>