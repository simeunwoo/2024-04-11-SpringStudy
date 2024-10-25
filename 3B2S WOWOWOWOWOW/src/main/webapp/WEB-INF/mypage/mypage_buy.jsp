<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="mypageApp">
	   <table class="table">
	    <tr>
	      <td class="text-center" colspan="6">
	        <h4>구매 관리</h4>
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
	        <button class="btn-sm btn-info" style="margin-right:3px;" @click="goodsCancel(cart_vo.cno)">취소</button>
	        <button class="btn-sm btn-warning" @click="goodsDetail(cart_vo.gno)">상품상세</button>
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
                              <td style="color:green">사이즈</td>
                              <td>{{detail_data.gsize}}</td>
                            </tr>
                            <tr>
                              <td style="color:gray">배송</td>
                              <td>{{detail_data.delivery}}</td>
                            </tr>
                      </table>
	   </div>
	</div>
	<script>
	let mypageApp=Vue.createApp({
		data(){
			return {
				cart_list:[],
				detail_data:{},
				isShow:false
			}
		},
		mounted(){
			axios.get('../kbogoods/buy_vue.do')
			.then(response=>{
				this.cart_list=response.data
			}).catch(error=>{
				console.log(error.response)
			})
		},
		methods:{
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
		    goodsDetail(gno) {
			      // 현재 보고 있는 상품을 다시 클릭하면 상세보기 접기
			      if (this.currentGno === gno) {
			        this.isShow = !this.isShow;  // 같은 상품이면 토글
			      } else {
			        this.isShow = true;          // 다른 상품이면 상세보기 열기
			        this.currentGno = gno;       // 현재 상품 번호 저장
			        axios.get('../kbogoods/goods_detail_vue.do', {
			          params: {
			            gno: gno
			          }
			        }).then(response => {
			          this.detail_data = response.data;
			        }).catch(error => {
			          console.log(error.response);
			        });
			      }
			    }
			  }
			}).mount("#mypageApp");
	</script>
</body>
</html>