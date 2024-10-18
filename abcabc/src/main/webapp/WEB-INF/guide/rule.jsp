<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>야구 용어 가이드</title>
<style type="text/css">
    .card-container {
      display: flex;
      flex-wrap: wrap;
      gap: 20px;
      justify-content: center;
      padding: 20px;
      margin-bottom: 50px;
    }
    .card {
      border: 1px solid #ddd;
      padding: 20px;
      width: 300px;
      border-radius: 10px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
      transition: transform 0.2s;
    }
    .card:hover {
      transform: scale(1.05);
    }
    .card-title {
      font-weight: bold;
      font-size: 1.5em;
      margin-bottom: 10px;
    }
    .card-description {
      font-size: 0.9em;
      color: #555;
      overflow: hidden;
      text-overflow: ellipsis;
      white-space: nowrap;
    }
    .card img {
      width: 100%;
      height: 150px;
      object-fit: cover;
      margin-bottom: 10px;
    }

    /* 검색창과 버튼을 한 줄로 배치 */
    .search-container {
      display: flex;
      justify-content: center;
      align-items: center;
      margin-bottom: 20px;
    }
    .search-container input {
      flex: 1;
      max-width: 400px;
      margin-right: 10px;
      padding: 10px;
    }
    .search-container button {
      padding: 10px 20px;
    }
    .card {
  position: relative;
  width: 300px; /* 카드의 가로 크기 */
  height: 250px; /* 카드의 세로 크기 */
  border: 1px solid #ddd;
  padding: 20px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}
.card-container {
  perspective: 1000px; /* 3D 효과를 위한 원근감 설정 */
}
    .more-button {
  position: absolute;
  bottom: 10px;
  right: 10px;
  border: none;
  cursor: pointer;
  border-radius: 5px;
}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
<section id="top">
    <div class="inner-page-banner">
        <div class="container">
        </div>
    </div>
    <div class="inner-information-text">
        <div class="container">
            <h3>Guide</h3>
            <ul class="breadcrumb">
                <li><a href="../main/main.do">Home</a></li>
                <li class="active">Rule</li>
            </ul>
        </div>
    </div>
</section>

<div class="container" id="ruleApp" v-cloak>
  <h1 class="text-center">야구 용어 가이드</h1>
  <div class="card-container">
<!-- 검색 -->  
<div class="container">
  <div class="search-container">
    <input type="text" style="width:200px;" ref="rs" v-model="rs" @keydown.enter="Search()" placeholder="홈런">
    <button class="btn btn-primary" @click="search">검색</button>
  </div>
</div>
    <div class="card" v-for="vo in ruleList" :key="vo.no">
      <div class="card-title">{{ vo.subject }}</div>
      <div class="card-description">{{ vo.content.substring(0, 100) }}...</div> <!-- 첫 100자만 출력 -->
      <a :href="'../guide/rule_detail.do?no=' + vo.no" class="more-button btn btn-xs btn-primary">자세히 보기</a>
    <!--   <div v-if="today === vo.dbday">
        <img src="../img/icon/new.gif" alt="새로운 항목">
      </div> -->
    </div>
  </div>

  <!-- 페이지네이션 -->
  <div class="text-center" style="margin-bottom:20px;">
    <button class="btn-sm btn-danger" v-on:click="prev">이전</button>
    {{ curpage }} page / {{ totalpage }} pages
    <button class="btn-sm btn-danger" @click="next">다음</button>
  </div>
</div>

<script>
// Vue 인스턴스
let ruleApp = Vue.createApp({
    data() {
        return {
            ruleList: [],
            curpage: 1,
            totalpage: 0,
            today: '',
            searchQuery: ''
        };
    },
    mounted() {
        this.dataRecv();
    },
    methods: {
    	Search() {
            // 검색 요청
    		if(this.rs==="")
			{
				this.$refs.rs.focus()
				return 
			}
			this.curpage=1
			this.dataRecv()
		 },
        prev() {
            if (this.curpage > 1) {
                this.curpage--;
                this.dataRecv();
            }
        },
        next() {
            if (this.curpage < this.totalpage) {
                this.curpage++;
                this.dataRecv();
            }
        },
        dataRecv() {
            axios.get('../guide/rule_vue.do', {
                params: {
                    page: this.curpage
                }
            }).then(response => {
                console.log(response.data); // 데이터 확인
                this.ruleList = response.data.ruleList;
                this.curpage = response.data.curpage;
                this.totalpage = response.data.totalpage;
                this.today = response.data.today;
            }).catch(error => {
                console.log(error.response);
            });
        }
    }
}).mount('#ruleApp');
</script>
</body>
</html>
