<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.bbtn {
 background: #003366;
 color: #fff;
 border-radius: 50px;
 font-weight: 500;
 transition: ease all 1s;
 margin-right: 3px;
}
</style>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
</head>
<body>
	<div id="mypageApp">
	   <table class="table">
	    <tr>
	      <td class="text-center" colspan="6">
	        <h4>댓글 관리</h4>
	      </td>
	    </tr>
	   <table class="table">
                    <thead>
	    <tr>
         <th width="10%">번호</th>
         <th width="45%">내용</th>
         <th width="15%">이름</th>
         <th width="20%">작성일</th>
	    </tr>
                    </thead>
                    <tbody>
                        <tr v-for="vo in comment_list">
                            <td>{{ vo.no }}</td>
                            <td>
                                <a :href="'../board/detail.do?no=' + vo.no">{{ vo.msg }}</a>
                                <sup v-if="today === vo.dbday"><img src="../img/icon/new.gif"></sup>
                            </td>
                            <td>{{ vo.name }}</td>
                            <td>{{ vo.dbday }}</td>
                        </tr>
                    </tbody>
                </table>
	   
	   </table>
	   <div v-if="isShow">
	     <h4>내용 상세보기</h4>
	     <table class="table">
                           <tr>
                             <td colspan="2">
                               <h4>{{detail_data.no}}</h4>
                             </td>
                            </tr>
                            <tr>
                              <td colspan="2">
                               {{detail_data.msg}}
                             </td>
                            </tr>
                      </table>
	   </div>
	   
	</div>
	<script>
	let mypageApp=Vue.createApp({
		data() {
	         return {
	            comment_list:[],
	            detail_data:{},
	            isShow:false,
	            comment_vo:{},
	            member_vo:{}
	         };
	      },
	     mounted() {
	          axios.get('../mypage/mypage_comment_vue.do')
	            .then(response => {
	              console.log(response.data);
	              this.comment_list = response.data;
	           }).catch(error => {
	              console.log(error.response);
	           });
	        },
		methods:{
			boardDelete() {
	            axios.get('../mypage/mypage_comment_delete_vue.do', {
	               params: {
	                  no: this.no
	               }
	            }).then(response => {
	               if (response.data === 'yes') {
	                  location.href = "../mypage/mypage_comment.do";
	               } else {
	                  alert('삭제 실패');
	                  console.log(response.data);
	               }
	            }).catch(error => {
	               console.log(error.response);
	            });
	         }
	      }
	}).mount("#mypageApp")
	</script>
</body>
</html>