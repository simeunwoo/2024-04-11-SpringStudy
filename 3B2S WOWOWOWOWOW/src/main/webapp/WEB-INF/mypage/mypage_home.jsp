<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.mypage-summary {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 20px;
  padding: 20px;
}

.summary-box {
  background-color: #f5f5f5;
  border: 1px solid #ddd;
  padding: 15px;
  border-radius: 8px;
  text-align: center;
  transition: transform 0.2s;
}

.summary-box:hover {
  transform: translateY(-5px);
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}
</style>
</head>
<body>
<section>
<tr>
<h3>${userName }의 마이페이지</h3>
<th>${userName }'s team</th>
<td></td>
</tr>
</section>
<section id="homeApp">
<div class="mypage-container">
<div class="mypage-summary">
  <div class="summary-box">
    <h3>구매</h3>
    <p>{{BuyCount}} 건</p>
  </div>
  <div class="summary-box">
    <h3>장바구니</h3>
    <p>{{CartCount}} 건</p>
  </div>
  <div class="summary-box">
    <h3>티켓 예약</h3>
    <p>{{TicketCount}} 건</p>
  </div>
  <div class="summary-box">
    <h3>호텔 예약</h3>
    <p>{{HotelCount}} 건</p>
  </div>
  <div class="summary-box">
    <h3>내가 쓴 글</h3>
    <p>{{BoardCount}} 건</p>
  </div>
  <div class="summary-box">
    <h3>내가 쓴 댓글</h3>
    <p>{{ReplyCount}} 건</p>
  </div>
</div>
</div>
</section>
<script>
let homeApp = Vue.createApp({
	data(){
		return {
			BuyCount:0,
			CartCount:0,
			TicketCount:0,
			HotelCount:0,
			BoardCount:0,
			ReplyCount:0
		}
	},
    mounted() {
        this.dataRecv()
      },
    methods:{
    	dataRecv(){
    		axios.get('../mypage/mypage_home_vue.do',{
    			
    		}).then(response=>{
    			this.BuyCount = response.data.BuyCount
    			this.CartCount = response.data.CartCount
    			this.TicketCount = response.data.TicketCount
    			this.HotelCount = response.data.HotelCount
    			this.BoardCount = response.data.BoardCount
    			this.ReplyCount = response.data.ReplyCount
    		}).catch(error=>{
    			console.log(error.response)
    		})
    			
    		}
    	}
    }
}).mount('#homeApp')
</script>
</body>
</html>