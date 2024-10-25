<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>	
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<style type="text/css">
.page-link:hover{
	cursor: pointer;
}
.sample{
	display: none;
}
</style>

</head>
<body>

 <div id="detailApp">
<!-- 제목 -->
<div class="breadcumb-area">
    <div class="container h-100">
        <div class="row h-100 align-items-center">
            <div class="col-16">
                <div class="bradcumb-title text-center">
                    <h2 style="font-size:40px;">굿즈 상세페이지</h2>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="breadcumb-nav titlemargin">
     <div class="container">
         <div class="row text-center">

         </div>
     </div>
</div>
<section class="single_blog_area section_padding_80" >
	<div class="container ">
	    <div class="row">
	            <div class="row no-gutters ">
	            
	                 <table class="table" style="margin: 0 auto; font-size: 130%; color: black;  ">
	                   <tr>
	                     <td width=30% class="text-center" rowspan="8">
	                       <img :src="detail_data.poster" style="width: 100%">
	                     </td>
	                    </tr>
	                    <tr>
	                  		<td colspan="5">{{detail_data.name}}</td>
	                    </tr>
	                    <tr>
	                      <td style="color:pink">가격</td>
	                      <td>{{detail_data.price}}</td>
	                    </tr>
	                    <tr>
	                      <td style="color:gray">배송비</td>
	                      <td>{{detail_data.simple_delivery}}</td>
	                    </tr>
	                    <tr>
	                      <td colspan="2">
	                        <select class="input-sm" style="width:350px" @change="accountChange()" ref="account" v-model="account" >
	                         <option value="1" selected>1개</option>
	                         <option value="2">2개</option>
	                         <option value="3">3개</option>
	                         <option value="4">4개</option>
	                         <option value="5">5개</option>
	                        </select>
	                      </td>
	                    </tr>
	                    <tr>
	                      <td colspan="2" class="text-right">
	                       총 금액:<span style="color:bule">{{total_price}}원</span>
	                      </td>
	                    </tr>
	                    <tr>
	                      <td colspan="2" class="text-center">
	                       <c:if test="${sessionScope.userId!=null }">
	                       	<button class="" @click="kbogoodsBuy()">바로구매</button>&nbsp;
	                       	<button class="" @click="kbogoodsCart()">장바구니</button>&nbsp;
	                       </c:if>
	                      <c:if test="${sessionScope.userId==null }">
	                        <button class="" @click="notLoginAlert()">바로구매</button>&nbsp;
	                       	<button class="" @click="notLoginAlert()">장바구니</button>&nbsp;
	                      
	                       </c:if>
	                        <button class="" onclick="javascript:history.back()">목록</button>
	                      </td>
	                    </tr>
	                 </table>
	                 
	                 <div class="">
	                 <table class="table kbogoodscontent text-center">
	                 	<tr class="text-center">
	                 		<td>
	                 			<a style="font-size: 15px; ">상세보기</a>
	                 		</td>
	                 	</tr>
	                 	<tr>
	                 		 <td style="border: none;"><img :src="detail_data.origin_content"></td>
	                 	</tr>
	                 	<tr>
	                 		 <td style="border: none;"><img :src="detail_data.origin_content1"></td>
	                 	</tr>
	                 </table>
	                 </div>

	        </div>
	    </div>
	</div>
</section>

</div>

<script>
var IMP = window.IMP; 
IMP.init("imp68206770");
  let detailApp=Vue.createApp({
	  data(){
		  return {
			  detail_data:{},
			  gno:${gno},	
			  total_price:0,
			  account:1
		  }
	  },
	  mounted(){
		 axios.get('../kboGoods/detail_vue.do',{
			 params:{
				 gno:this.gno
			 }
		 }).then(response=>{
			 console.log(response.data)
			 this.detail_data=response.data
		 }).catch(error=>{
			 console.log(error.response)
		 })
	  },
	  methods:{
		accountChange(){
			//alert("수량:"+this.account);
			this.total_price=this.account * this.detail_data.origin_price + this.detail_data.origin_delivery
		},
		// 1. 구매창 
		requestPay() {
		    IMP.request_pay({
		        pg: "html5_inicis",
		        pay_method: "card",
		        merchant_uid: "ORD20180131-0000011",   // 주문번호
		        name: this.detail_data.name,
		        amount: this.total_price,         // 숫자 타입
		        buyer_email: '',
		        buyer_name: '',
		        buyer_tel: '',
		        buyer_addr: '',
		        buyer_postcode: ''
		     }, function (rsp) { // callback
		    	
		    });
	    },
		// 2. 장바구니 ==> 0
	    kbogoodsCart(){
			axios.post('../kbogoods/cart_insert.do',null,{
				params:{
					account:this.account,
					gno:this.gno
				}
			}).then(response=>{
				if(response.data==="yes")
				{
					location.href="../mypage/mypage_cart.do"
				}
				else
				{
					alert("장바구니 담기에 실패하셨습니다\n"+response.data)
				}
				
			}).catch(error=>{
				console.log(error.response)
			})
		},
		// 2. 구매  ===> spring_cart : 1
		kbogoodsBuy(){
			// 출력정보 읽기 => 회원 정보 / 상품 정보 (이미 전송 받음) => 서버요청 
			this.requestPay()
		},
		// ===> mypage로 이동 
		// 3. 구매 / 장바구니 : 취소 
	    notLoginAlert(){
	 		alert("로그인 시 이용 가능합니다");
		}
		
	  }
  }).mount("#detailApp")
 </script>

</body>
</html>