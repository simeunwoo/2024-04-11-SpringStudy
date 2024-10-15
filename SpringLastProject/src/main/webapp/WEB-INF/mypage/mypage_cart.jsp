<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
				<th class="text-center">가격</th>
				<th class="text-center">등록일</th>
				<th class="text-center">비고</th>
			</tr>
			<tr v-for="cart_vo in cart_list">
				<td class="text-center">{{cart_vo.cno}}</td>
				<td class="text-center">
					<img :src="cart_vo.gvo.goods_poster" style="width:30px;height:30px">
				</td>
				<td class="text-center">{{cart_vo.account}}</td>
				<td class="text-center">{{cart_vo.gvo.goods_price}}</td>
				<td class="text-center">{{cart_vo.dbday}}</td>
				<td class="text-center">
					<button class="btn-sm btn-success" @click="goodsBuy(cart_vo.cno,cart_vo.gno)">구매</button>
					<button class="btn-sm btn-info" @click="goodsCancel(cart_vo.cno)">취소</button>
					<button class="btn-sm btn-warning" @click="goodsDetail(cart_vo.gno)">상품 상세</button>
				</td>
			</tr>
		</table>
		<div v-if="isShow">
			<h4>상품 상세 보기</h4>
				<table class="table">
                           <tr>
                             <td width=30% class="text-center" rowspan="8">
                               <img :src="detail_data.goods_poster" style="width: 100%">
                             </td>
                             <td colspan="2">
                               <h4>{{detail_data.goods_name}}</h4>
                             </td>
                            </tr>
                            <tr>
                              <td colspan="2">
                               {{detail_data.goods_sub}}
                             </td>
                            </tr>
                            <tr>
                              <td style="color:pink">{{detail_data.goods_discount}}%</td>
                              <td>{{detail_data.goods_price}}</td>
                            </tr>
                            <tr>
                              <td style="color:green">첫번째 구매</td>
                              <td>{{detail_data.goods_first_price}}</td>
                            </tr>
                            <tr>
                              <td style="color:gray">배송</td>
                              <td>{{detail_data.goods_delivery}}</td>
                            </tr>
			</table>
		</div>
	</div>
	<script>
		 var IMP = window.IMP;
	     IMP.init("imp68206770");
		let mypageApp=Vue.createApp({
			data(){
				return{
					cart_list:[],
					goods_detail:{},
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
				requestPay(gvo,mvo) {
	    		    IMP.request_pay({
	    		        pg: "html5_inicis",
	    		        pay_method: "card",
	    		        merchant_uid: "ORD20180131-0000011",   // 주문번호
	    		        name: gvo.goods_name,
	    		        amount: gvo.price,         // 숫자 타입
	    		        buyer_email: mvo.email,
	    		        buyer_name: mvo.userName,
	    		        buyer_tel: mvo.phone,
	    		        buyer_addr: mvo.addr1+" "+mvo.addr2,
	    		        buyer_postcode: mvo.post
	    		     }, function (rsp) { // callback
	    		    	location.href="../mypage/mypage_buy.do"
	    		    });
	    	    },
				goodsBuy(cno){
					axios.get('../goods/goods_buy_vue.do',{
						params:{
							cno:cno,
							gno:gno
						}
					}).then(response=>{
						console.log(respnse.data)
						this.goods_vo=response.data.gvo
						this.member_vo=response.data.mvo
						
						requsetPay(this.goods_vo,this.member_vo)
					}).catch(error=>{
						console.log(error.response)
					})
				},
				goodsCancel(cno){
					axios.get('../goods/cart_cancel_vue.do',{
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
					axios.get('../goods/goods_detail_vue.do',{
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
		}).mount('#mypageApp')
	</script>
</body>
</html>