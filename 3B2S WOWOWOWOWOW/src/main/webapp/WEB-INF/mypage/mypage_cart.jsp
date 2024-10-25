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
	        <h4>장바구니 관리</h4>
	      </td>
	    </tr>
	    <tr>
	      <th class="text-center">번호</th>
	      <th class="text-center"></th>
	      <th class="text-center">수량</th>
	      <th class="text-center">사이즈</th>
	      <th class="text-center">가격</th>
	      <th class="text-center">등록일</th>
	      <th class="text-center">비고</th>
	    </tr>
	    <tr v-for="cart_vo in cart_list">
	      <td class="text-center">{{cart_vo.cno}}</td>
	      <td class="text-center">
	       <img :src="cart_vo.gvo.poster" style="width:30px;height: 30px">
	      </td>
	      <td class="text-center">{{cart_vo.account}}</td>
	      <td class="text-center">{{cart_vo.gsize}}</td>
	      <td class="text-center">{{cart_vo.gvo.price}}</td>
	      <td class="text-center">{{cart_vo.dbday}}</td>
	      <td class="text-center">
	        <button class="bbtn btn-sm" @click="goodsBuy(cart_vo.cno,cart_vo.gno)">구매</button>
	        <button class="bbtn btn-sm" @click="goodsCancel(cart_vo.cno)">취소</button>
	        <button class="bbtn btn-sm" @click="goodsDetail(cart_vo.gno)">상품상세</button>
	      </td>
	    </tr>
	   </table>
	   <div v-if="isShow">
	     <h4>상품 상세보기</h4>
	     <table class="table">
                           <tr>
                             <td width=30% class="text-center" rowspan="8">
                               <img :src="detail_data.poster" style="width: 100%">
                             </td>
                             <td colspan="2">
                               <h4>{{detail_data.name}}</h4>
                             </td>
                            </tr>
                            <tr>
                              <td colspan="2">
                               {{detail_data.sub}}
                             </td>
                            </tr>
                            <tr>
                              <td style="color:pink">가격</td>
                              <td>{{detail_data.price}}</td>
                            </tr>
                            <tr>
                              <td style="color:gray">배송</td>
                              <td>{{detail_data.delivery}}</td>
                            </tr>
                      </table>
	   </div>
	   
	</div>
	<script>
	var IMP = window.IMP; 
    IMP.init("imp68206770");
	let mypageApp=Vue.createApp({
		data(){
			return {
				cart_list:[],
				detail_data:{},
				isShow:false,
				goods_vo:{},
				member_vo:{}
			}
		},
		mounted(){
			axios.get('../mypage/mypage_cart_vue.do')
			.then(response=>{
				console.log(response.data)
				this.cart_list=response.data
			}).catch(error=>{
				console.log(error.response)
			})
		},
		methods:{
			requestPay() {
    		    IMP.request_pay({
    		        pg: "html5_inicis",
    		        pay_method: "card",
    		        merchant_uid: "ORD20180131-0000011",   // 주문번호
    		        name: this.goods_vo.name,
    		        amount: this.goods_vo.price,         // 숫자 타입
    		        buyer_email: this.member_vo.email,
    		        buyer_name: this.member_vo.userName,
    		        buyer_tel: this.member_vo.phone,
    		        buyer_addr: this.member_vo.addr1+" "+this.member_vo.addr2,
    		        buyer_postcode: this.member_vo.post
    		     }, function (rsp) { // callback
    		    	location.href="../mypage/mypage_buy.do"
    		    });
    	    },
			goodsBuy(cno,gno){
    	    	
				axios.get('../kbogoods/buy_vue.do',{
					params:{
						cno:cno,
						gno:gno
					}
				}).then(response=>{
					console.log(response.data)
					this.goods_vo=response.data.gvo
					this.member_vo=response.data.mvo
					//alert(this.goods_vo.price)
					this.requestPay()
				}).catch(error=>{
					console.log(error.response)
				})
			},
			goodsCancel(cno){
				axios.get('../kbogoods/cart_cancel_vue2.do',{
					params:{
						cno:cno
					}
				}).then(response=>{
					this.cart_list=response.data
				}).catch(error=>{
					console.log(error.response)
				})
			},
			goodsDetail(gno){
				this.isShow=true
				axios.get('../kbogoods/goods_detail_vue.do',{
					params:{
						gno:gno
					}
				}).then(response=>{
					console.log(response.data)
					this.detail_data=response.data
				}).catch(error=>{
					console.log(error.response)
				})
			}
		}
	}).mount("#mypageApp")
	</script>
</body>
</html>