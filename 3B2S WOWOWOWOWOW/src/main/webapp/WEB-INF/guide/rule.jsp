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
    
    /* 카드 스타일 */
    .card {
      width: 300px;
      height: 250px;
      perspective: 1000px; /* 3D 효과를 위한 원근감 */
      position: relative;
    }
    
    /* 카드 안의 내용 */
    .card-inner {
      width: 100%;
      height: 100%;
      position: relative;
      transform-style: preserve-3d;
      transition: transform 0.6s;
    }
    
    /* 카드 앞면 */
    .card-front, .card-back {
      position: absolute;
      width: 100%;
      height: 100%;
      backface-visibility: hidden;
      border: 1px solid #ddd;
      border-radius: 10px;
      padding: 20px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }
    
    .card-front {
      background-color: white;
      display: flex;
      justify-content: center;
      align-items: center;
      flex-direction: column;
      z-index: 1; /* 카드 앞면이 항상 위에 보이도록 설정 */
    }
    
    /* 카드 뒷면 */
    
    .card-back .card-title {
  display: none; /* 제목을 숨깁니다 */
}

.card-back .card-description {
  white-space: normal; /* 긴 설명도 모두 보이도록 설정 */
}
    .card-back {
      background-color: #f5f5f5;
      transform: rotateY(180deg);
      display: flex;
      justify-content: center;
      align-items: center;
      flex-direction: column;
    }
    
    /* 카드가 뒤집힐 때 */
    .flipped .card-inner {
      transform: rotateY(180deg);
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

    .more-button {
      position: absolute;
      bottom: 10px;
      right: 10px;
      border: none;
      cursor: pointer;
      border-radius: 5px;
      background-color: #006633;
      width : 100px;
    }
    
    .simple-button {
      position: absolute;
      left: 63%; /* 가운데 정렬 */
      border: none;
      cursor: pointer;
      border-radius: 5px;
      margin-top: 186px;
      background-color: gold;
      width : 100px;
    }

    .back-button {
      position: absolute;
      bottom: 10px;
      left: 10px;
      border: none;
      cursor: pointer;
      border-radius: 5px;
    }
    

</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
<div class="container" id="ruleApp" v-cloak>
  <div class="header">
    <h1 class="text-center" style="display: inline-block;">야구 용어 가이드</h1>
    <div class="search-container" style="display: inline-block; float: right;">
      <input type="text" v-model="searchQuery" placeholder="검색어를 입력하세요" class="search-input">
      <button class="btn btn-primary search-button" @click="searchTerms">검색</button>
    </div>
  </div>
  <div class="card-container">
    <div class="card" v-for="vo in ruleList" :key="vo.no" :class="{ flipped: vo.isFlipped }">
      <div class="card-inner" @click="flipCard(vo.no)">
        <!-- 카드 앞면 -->
        <div class="card-front">
          <div class="card-title">{{ vo.subject }}</div>
      <button class="simple-button btn btn-xs btn-primary" @click.stop="flipCard(vo.no)">뜻 보기</button> <!-- @click.stop 추가 -->
        </div>
        
        <!-- 카드 뒷면 -->
        <div class="card-back">
          <div class="card-title">더 자세한 내용</div>
          <div class="card-description">{{ vo.content }}</div>
          <button class="back-button btn btn-xs btn-secondary" @click.stop="flipCard(vo.no)">뒤로</button>
        </div>
      </div>
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
            ruleList: [],    // 전체 야구 용어 리스트
            curpage: 1,      // 현재 페이지
            totalpage: 0,    // 전체 페이지 수
            searchQuery: ''  // 검색어 입력값
        };
    },
    computed: {
        // 검색어에 맞춰 필터링된 용어 리스트를 반환합니다.
        filteredList() {
            if (this.searchQuery) {
                return this.ruleList.filter(vo =>
                    vo.subject.toLowerCase().includes(this.searchQuery.toLowerCase())
                );
            }
            return this.ruleList;
        }
    },
    methods: {
        searchTerms() {
            // 검색어를 입력하고 버튼을 눌렀을 때 호출
            this.curpage = 1;   // 검색 후 페이지를 1로 초기화
        },
        dataRecv() {
            // 서버에서 데이터를 받아옵니다
            axios.get('../guide/rule_vue.do', {
                params: {
                    page: this.curpage
                }
            }).then(response => {
                // 데이터를 받아와서 ruleList에 저장
                this.ruleList = response.data.ruleList.map(vo => {
                    return { ...vo, isFlipped: false };
                });
                this.curpage = response.data.curpage;
                this.totalpage = response.data.totalpage;
            }).catch(error => {
                console.log(error.response);
            });
        },
        flipCard(no) {
            // 카드를 뒤집는 함수
            this.ruleList = this.ruleList.map(vo => {
                if (vo.no === no) {
                    vo.isFlipped = !vo.isFlipped;
                }
                return vo;
            });
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
        }
    },
    mounted() {
        // 컴포넌트가 마운트되면 데이터를 받아옵니다.
        this.dataRecv();
    }
}).mount('#ruleApp');

</script>
</body>
</html>
