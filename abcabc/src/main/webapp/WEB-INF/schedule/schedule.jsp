<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>경기 일정</title>
    <script src="https://unpkg.com/vue@3"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../css/calendar.css">
    <script src="../js/calendar.js"></script>
    <style>
        /* 여기에 필요한 스타일을 추가하세요 */
        #calendar{
            display: flex;
            flex-wrap: wrap;
        }
        .calendar-day{
            width: 14.28%; /* 7 days in a week */
            padding: 10px;
            text-align: center;
            cursor: pointer;
            border: 1px solid #ddd;
            margin: 2px;
        }
        .calendar-day:hover{
            background-color: #f0f0f0;
        }
        .selected{
            background-color: #007bff;
            color: white;
        }
        .schedule-logo{
        	width: 35px;
        	height: 35px;
        }
        .a{
        	display: flex;
    		justify-content: space-around;
    		align-items: center;
        }
    </style>
</head>
<body>
<div class="container">
    <!-- 고정 이미지 -->
    <div class="text-center">
        <img src="../player/m1.jpg" style="width:1200px;height:30px">
    </div>
</div>

<div class="container" id="calendarApp">
    <div style="height:50px"></div>
    <div class="header">
        <h1>2024년 {{ month }}월</h1>
        <div class="left" @click="prevMonth"></div>
        <div class="right" @click="nextMonth"></div>
    </div>

    <div id="calendar"></div>

    <div id="gameApp" class="details">
        <h2>{{ month }}월 {{ day }}일 경기 결과</h2>
        <div v-if="games.length > 0">
            <div v-for="vo in games" :key="vo.sno" class="a">
            	<img :src="vo.awayimage" class="schedule-logo">
                <p class="event">
                    {{ vo.away }}&nbsp; {{ vo.awayscore }} - {{ vo.homescore }} &nbsp;{{ vo.home }}
                </p>
                <img :src="vo.homeimage" class="schedule-logo">
            </div>
        </div>
        <div v-else>
            <p class="event empty">경기가 없습니다.</p>
        </div>

        <div class="pagination-area d-sm-flex mt-15">
            <ul class="pagination">
                <li class="page-item" v-if="startPage > 1">
                    <a class="page-link" @click="prev"><i class="fa fa-angle-double-left" aria-hidden="true"></i> 이전</a>
                </li>
                <li :class="page === curpage ? 'page-item active' : 'page-item'" v-for="i in range(startPage, endPage)" :key="i">
                    <a class="page-link" @click="pageChange(i)">{{ month }}월 {{ day }}일</a>
                </li>
                <li class="page-item" v-if="endPage < totalpage">
                    <a class="page-link" @click="next">다음 <i class="fa fa-angle-double-right" aria-hidden="true"></i></a>
                </li>
            </ul>
        </div>
    </div>
    <div style="height:200px"></div>
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
                month: moment().month() + 1,
                day: moment().date(),
                currentMonthYear: moment().format('YYYY-MM')
            };
        },
        mounted() {
            this.generateCalendar();
            this.dataRecv();
        },
        methods: {
            prevMonth() {
                this.month--; // 월 감소
                if (this.month < 1) {
                    this.month = 12; // 12월로 변경
                    this.currentMonthYear = moment(this.currentMonthYear).subtract(1, 'years').format('YYYY-MM');
                } else {
                    this.currentMonthYear = moment(this.currentMonthYear).month(this.month - 1).format('YYYY-MM');
                }
                this.updateCalendar();
            },
            nextMonth() {
                this.month++; // 월 증가
                if (this.month > 12) {
                    this.month = 1; // 1월로 변경
                    this.currentMonthYear = moment(this.currentMonthYear).add(1, 'years').format('YYYY-MM');
                } else {
                    this.currentMonthYear = moment(this.currentMonthYear).month(this.month - 1).format('YYYY-MM');
                }
                this.updateCalendar();
            },
            updateCalendar() {
                this.generateCalendar();
                this.dataRecv(); // 새 달로 변경 시 데이터 다시 로드
            },
            generateCalendar() {
                const calendar = document.getElementById('calendar');
                calendar.innerHTML = ''; // 기존 달력 초기화
                const startOfMonth = moment(this.currentMonthYear).startOf('month');
                const endOfMonth = moment(this.currentMonthYear).endOf('month');

                let startDay = startOfMonth.day();
                let daysInMonth = endOfMonth.date();

                for (let i = 0; i < startDay; i++) {
                    calendar.innerHTML += '<div class="calendar-day"></div>';
                }

                for (let day = 1; day <= daysInMonth; day++) {
                    const dayElement = document.createElement('div');
                    dayElement.classList.add('calendar-day');
                    dayElement.innerText = day;

                    dayElement.addEventListener('click', () => {
                        const selectedDate = moment(this.currentMonthYear + '-' + day);
                        this.setDate(selectedDate);
                        highlightSelectedDate(dayElement);
                        this.curpage = 1;
                        this.dataRecv();
                    });

                    calendar.appendChild(dayElement);
                }
            },
            pageChange(page) {
                this.curpage = page;
                this.dataRecv();
            },
            setDate(selectedDate) {
                this.month = selectedDate.month() + 1;
                this.day = selectedDate.date();
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
                    this.startPage = Math.max(1, this.curpage - 1);
                    this.endPage = Math.min(this.totalpage, this.startPage + 2);
                    if (this.endPage - this.startPage < 2) {
                        this.endPage = Math.min(this.startPage + 2, this.totalpage);
                    }
                }).catch(error => {
                    console.log(error.response);
                });
            }
        }
    }).mount('#calendarApp');

    function highlightSelectedDate(selectedElement) {
        const days = document.querySelectorAll('.calendar-day');
        days.forEach(day => day.classList.remove('selected'));
        selectedElement.classList.add('selected');
    }
</script>

</body>
</html>
