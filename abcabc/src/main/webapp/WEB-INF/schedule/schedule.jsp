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
    <h2>{{ month }}월 {{ day }}일 경기 결과</h2>
    <div v-if="games.length > 0">
      <div v-for="vo in games" :key="vo.sno">
        <p>
          {{ vo.away }} (원정) {{ vo.awayscore }} - {{ vo.home }} (홈) {{ vo.homescore }}
        </p>
      </div>
    </div>
    <div v-else>
      <p>경기가 없습니다.</p>
    </div>
  </div>
</div>
</div>
<script>
    let scheduleApp = Vue.createApp({
        data() {
            return {
                games: [],
                month: 3,  // 초기값, 필요에 따라 변경 가능
                day: 23,   // 초기값, 필요에 따라 변경 가능
            }
        },
        mounted() {
            this.dataRecv() // 페이지 로드 시 데이터 가져오기
        },
        methods: {
            dataRecv() {
                axios.get('../schedule/schedule_vue.do', {
                    params: {
                        month: this.month,
                        day: this.day
                    }
                }).then(response => {
                    console.log(response.data)
                    this.games = response.data.games
                }).catch(error => {
                    console.log(error.response)
                })
            },
            updateDate(newMonth, newDay) {
                this.month = newMonth;
                this.day = newDay;
                this.dataRecv(); // 날짜 변경 후 데이터 새로 받기
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



















