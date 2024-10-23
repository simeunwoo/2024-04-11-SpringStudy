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
    
    <link href='https://cdn.jsdelivr.net/npm/@fullcalendar/icalendar@5.11.3/main.css' rel='stylesheet' />
    <script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.15/index.global.min.js"></script>
    
    <style>
        #calendar {
            max-width: 900px;
            margin: 40px auto;
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
    <div id="calendar"></div>
    <div style="height:50px"></div>
</div>

<script>
    let calendarApp = Vue.createApp({
        data() {
            return {
                games: [],
                curpage: 1,
                totalpage: 0,
                startPage: 0,
                endPage: 0,
                isShow: false,
                month: '',
                day: ''
            };
        },
        mounted() {
            let date = new Date();
            let year = date.getFullYear();
            let month = ("0" + (1 + date.getMonth())).slice(-2);
            let day = ("0" + date.getDate()).slice(-2);
            
            var calendarEl = document.getElementById('calendar');
            var calendar = new FullCalendar.Calendar(calendarEl, {
                initialView: 'dayGridMonth',
                
                height: 450,
                
                themeSystem: 'bootstrap',
                editable: true,
                droppable: true,
                dateClick: (info) => {
                    this.day = info.dateStr;
                    this.isShow = true;
                    this.dataRecv(); // 클릭된 날짜에 대한 데이터 가져오기
                }
            });
            calendar.render();
            
            this.dataRecv(); // 초기 데이터 로드
        },
        methods: {
            prev() {
                this.curpage = this.curpage > 1 ? this.curpage - 1 : this.curpage;
                this.dataRecv();
            },
            next() {
                this.curpage = this.curpage < this.totalpage ? this.curpage + 1 : this.curpage;
                this.dataRecv();
            },
            pageChange(page) {
                this.curpage = page;
                this.dataRecv();
            },
            range(start, end) {
                let arr = [];
                for (let i = start; i <= end; i++) {
                    arr.push(i);
                }
                return arr;
            },
            dataRecv() {
                axios.get('../schedule/schedule_vue.do', {
                    params: {
                        month: this.month,
                        day: this.day,
                        page: this.curpage
                    }
                }).then(response => {
                    this.games = response.data.games;
                    this.curpage = response.data.curpage;
                    this.totalpage = response.data.totalpage;
                    this.startPage = response.data.startPage;
                    this.endPage = response.data.endPage;
                    this.month = response.data.month;
                    this.day = response.data.day;
                }).catch(error => {
                    console.log(error.response);
                });
            }
        }
    }).mount('#calendarApp');
</script>

</body>
</html>
