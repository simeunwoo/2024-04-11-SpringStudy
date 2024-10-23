<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>경기 일정</title>
    <script src="https://unpkg.com/vue@3"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap" rel="stylesheet">

    
    <link href='https://cdn.jsdelivr.net/npm/@fullcalendar/icalendar@5.11.3/main.css' rel='stylesheet' />
    <script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.15/index.global.min.js"></script>
    
    <style>
        #calendar {
            max-width: 900px;
            margin: 40px auto;
        }
        .team-logo{
        	width: 65px;
        	height: 65px;
        }
        .game-item{
        	display: flex;
    		align-items: center;
    		text-align: center;
    		justify-content: center; /* 중앙 정렬 추가 */
    		margin-bottom: 30px;
        }
        .game-result{
        	font-size: 25px;
        }
        #a{
        	border: 2px solid rgba(0, 0, 0, 0);
	        border-radius: 10px;
	        padding: 10px;
	        margin-top: 20px;
	        background-color: #f9f9f9;
        }
        body {
    font-family: 'Noto Sans KR', sans-serif;
}

        
    </style>
</head>
<body>
<div class="container">
    <!-- 고정 이미지 -->
    <div class="text-center">
        <img src="../player/m1.jpg" style="width:1200px;height:150px">
    </div>
</div>

<div class="container" id="calendarApp">
	<div style="height:50px"></div>
	<div class="col-12 col-md-7">
    <div id="calendar"></div>
    </div>
    <div class="col-12 col-md-5">
    <div id="a">
     <div v-if="games.length > 0">
     	<h2 class="text-center">{{ month }}월 {{ day }}일 경기 결과</h2>
     	<div style="height:30px"></div>
        <div v-for="vo in games" :key="vo.sno" class="game-item">
            <img :src="vo.awayimage" class="team-logo">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <p class="game-result">{{ vo.away }}&nbsp;{{ vo.awayscore }}&nbsp;-&nbsp;{{ vo.homescore }}&nbsp;{{ vo.home }}</p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <img :src="vo.homeimage" class="team-logo">
        </div></div>
    
    <div v-else>
    	<h2 class="text-center">{{ month }}월 {{ day }}일 경기 결과</h2>
        <p>해당 날짜에 경기가 없습니다.</p>
    </div></div>
    </div>
    <div style="height:50px"></div>
</div>

<script>
let calendarApp = Vue.createApp({
    data() {
        return {
            games: [],
            month: this.getCurrentMonth(),
            day: this.getCurrentDay()
        };
    },
    mounted() {
        let calendarEl = document.getElementById('calendar');
        let calendar = new FullCalendar.Calendar(calendarEl, {
            initialView: 'dayGridMonth',
            dateClick: (info) => {
                this.day = parseInt(info.dateStr.split('-')[2]); // 클릭한 날짜의 day 가져오기
                this.month = parseInt(info.dateStr.split('-')[1]); // 클릭한 날짜의 month 가져오기
                this.dataRecv(); // 경기 데이터 가져오기
            }
        });
        calendar.render();
        this.dataRecv();
    },
    methods: {
    	getCurrentMonth() {
            return new Date().getMonth() + 1; // 현재 월 (0부터 시작하므로 +1)
        },
        getCurrentDay() {
            return new Date().getDate(); // 현재 일
        },
        dataRecv() {
            axios.get('../schedule/schedule_vue.do', {
                params: {
                    month: this.month,
                    day: this.day,
                }
            }).then(response => {
                this.games = response.data.games;
            }).catch(error => {
                console.log(error.response);
            });
        }
    }
}).mount('#calendarApp');

</script>

</body>
</html>
