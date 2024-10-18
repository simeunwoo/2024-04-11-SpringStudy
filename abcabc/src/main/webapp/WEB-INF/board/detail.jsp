<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 상세보기</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
/* 전체 컨테이너 */
.container {
   margin-top: 50px;
}

/* 게시판 상세보기 큰 네모 박스 */
.board-container {
   width: 100%;
   max-width: 1000px;
   margin: 0 auto;
   padding: 20px;
   border: 2px solid #003366; /* 칠판 같은 테두리 */
   border-radius: 10px;
   background-color: #fff;
   box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1); /* 그림자 효과 */
}

/* 테이블 스타일 */
.table {
   width: 100%;
   border-collapse: collapse; /* 셀 간 간격 제거 */
}

.table th, .table td {
   padding: 12px 15px;
   border-bottom: 1px solid #ddd; /* 구분선 */
   text-align: center;
}

.table th {
   background-color: #f7f7f7;
   font-weight: bold;
}

.table td {
   background-color: white;
   text-align: center;
}

/* 수정, 삭제, 목록 버튼 */
.text-right .btn {
   margin-left: 5px;
}

pre {
   white-space: pre-wrap;
   background-color: white;
   border: none;
}

/* 상단 헤더 스타일 */
.inner-page-banner {
   width: 100%;
   background-color: #f5f5f5;
   padding: 20px 0;
   box-sizing: border-box;
   text-align: center;
   font-size: 24px;
}

.breadcrumb {
   margin-top: 10px;
}

.container {
    margin-bottom: 50px; 
}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
<section id="top">
   <div class="inner-page-banner">
      <div class="container">
         <h3>자유게시판</h3>
         <ul class="breadcrumb">
            <li><a href="../main/main.do">Home</a></li>
            <li>게시판</li>
         </ul>
      </div>
   </div>
</section>

<section id="detailApp">
   <div class="container">
      <!-- 게시판 상세보기 큰 네모 박스 -->
      <div class="board-container">
         <h3 class="text-center">내용보기</h3>
         <div class="row">
            <table class="table">
               <tr>
                  <th width="20%">번호</th>
                  <td width="30%">{{ vo.no }}</td>
                  <th width="20%">작성일</th>
                  <td width="30%">{{ vo.dbday }}</td>
               </tr>
               <tr>
                  <th width="20%">이름</th>
                  <td width="30%">{{ vo.name }}</td>
                  <th width="20%">조회수</th>
                  <td width="30%">{{ vo.hit }}</td>
               </tr>
               <tr>
                  <th width="20%">제목</th>
                  <td colspan="3">{{ vo.subject }}</td>
               </tr>
               <tr>
                  <td colspan="4" class="text-left" valign="top" height="200">
                     <pre>{{ vo.content }}</pre>
                  </td>
               </tr>
               <tr>
                  <td colspan="4" class="text-right">
                     <a :href="'../board/update.do?no=' + vo.no" class="btn btn-xs" v-show="sessionId === vo.id">수정</a>
                     <button class="btn btn-xs" @click="boardDelete()" v-show="sessionId === vo.id">삭제</button>
                     <a href="../board/list.do" class="btn btn-xs">목록</a>
                  </td>
               </tr>
            </table>
         </div>
      </div>
   </div>
</section>

<script>
   let detailApp = Vue.createApp({
      data() {
         return {
            vo: {},
            no: ${no},
            sessionId: '${sessionId}'
         };
      },
      mounted() {
         axios.get('../board/detail_vue.do', {
            params: {
               no: this.no
            }
         }).then(response => {
            console.log(response.data);
            this.vo = response.data;
         }).catch(error => {
            console.log(error.response);
         });
      },
      methods: {
         boardDelete() {
            axios.get('../board/delete_vue.do', {
               params: {
                  no: this.no
               }
            }).then(response => {
               if (response.data === 'yes') {
                  location.href = "../board/list.do";
               } else {
                  alert('삭제 실패');
                  console.log(response.data);
               }
            }).catch(error => {
               console.log(error.response);
            });
         }
      }
   }).mount('#detailApp');
</script>

</body>
</html>
