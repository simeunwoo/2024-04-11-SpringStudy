<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style type="text/css">
/* 헤더를 전체 페이지 너비로 확장 */
.inner-page-banner {
    width: 100%; /* 전체 너비 */
    background-color: #f5f5f5; /* 헤더 배경색 */
    padding: 20px 0; /* 상하 패딩 */
    box-sizing: border-box;
}

/* 게시판을 감싸는 큰 네모 박스 */
.board-container {
    width: 100%;
    max-width: 1200px; /* 적당한 최대 너비 */
    margin: 0 auto; /* 가운데 정렬 */
    padding: 20px; /* 내부 여백 */
    border: 2px solid #003366; /* 칠판처럼 테두리 추가 */
    border-radius: 10px; /* 모서리 둥글게 */
    background-color: #fff; /* 배경색 */
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1); /* 그림자 효과 */
}

/* 게시판 테이블 스타일링 */
.table {
    width: 100%;
    border-collapse: collapse; /* 테이블 셀 간격 없애기 */
}

.table th, .table td {
    padding: 12px 15px; /* 테이블 셀 내부 여백 */
    border-bottom: 1px solid #ddd; /* 행 사이에 구분선 */
    text-align: center;
}

.table th {
    background-color: #f7f7f7; /* 헤더 배경색 */
    font-weight: bold;
}

.table td a {
    color: #333;
    text-decoration: none;
}

.table td a:hover {
    text-decoration: underline;
}

/* 페이지 이동 버튼 */
.text-center {
    margin-top: 20px;
}


.container {
    margin-bottom: 50px;
}

</style>
</head>
<body>
<section id="top">
    <div class="inner-page-banner">
        <div class="container">
        </div>
    </div>
    <div class="inner-information-text">
        <div class="container">
            <h3>Blog</h3>
            <ul class="breadcrumb">
                <li><a href="../main/main.do">Home</a></li>
                <li class="active">Hotel</li>
            </ul>
        </div>
    </div>
</section>

<section id="contant" class="contant main-heading team">
    <div class="container">
        <div class="col-md-12">
            <!-- 게시판 리스트를 감싸는 큰 네모 상자 -->
            <div class="board-container" id="listApp">

                <!-- 게시판 테이블 -->
                <table class="table">
                    <thead>
                        <tr>
                            <th width="10%">번호</th>
                            <th width="45%">제목</th>
                            <th width="15%">이름</th>
                            <th width="20%">작성일</th>
                            <th width="10%">조회수</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="vo in board_list">
                            <td>{{ vo.no }}</td>
                            <td>
                                <a :href="'../board/detail.do?no=' + vo.no">{{ vo.subject }}</a>
                                <sup v-if="today === vo.dbday"><img src="../img/icon/new.gif"></sup>
                            </td>
                            <td>{{ vo.name }}</td>
                            <td>{{ vo.dbday }}</td>
                            <td>{{ vo.hit }}</td>
                        </tr>
                    </tbody>
                </table>
                <div style="margin-bottom:30px;">
                <c:if test="${sessionScope.userId!=null }">
                    <a href="../board/insert.do" class="btn btn-sm btn-primary">새글</a>
                </c:if>
                </div>

                <!-- 페이지 네비게이션 -->
                <div class="text-center">
                    <button class="btn-sm btn-primary" v-on:click="prev()">이전</button>
                    {{ curpage }} page / {{ totalpage }} pages
                    <button class="btn-sm btn-primary" @click="next()">다음</button>
                </div>
            </div>
        </div>
    </div>
</section>

<script>
// Vue 인스턴스
let listApp = Vue.createApp({
    data() {
        return {
            board_list: [],
            curpage: 1,
            totalpage: 0,
            today: ''
        };
    },
    mounted() {
        this.dataRecv();
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
        dataRecv() {
            axios.get('../board/list_vue.do', {
                params: {
                    page: this.curpage
                }
            }).then(response => {
                this.board_list = response.data.list;
                this.curpage = response.data.curpage;
                this.totalpage = response.data.totalpage;
                this.today = response.data.today;
            }).catch(error => {
                console.log(error.response);
            });
        }
    }
}).mount('#listApp');
</script>
</body>
</html>
