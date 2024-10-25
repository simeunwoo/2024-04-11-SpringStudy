<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.ticket-click:hover{
	cursor: pointer;
}
</style>
</head>
<body>
<section id="top">
         <div class="inner-information-text">
            <div class="container">
               <h3>Blog</h3>
               <ul class="breadcrumb">
                  <li><a href="../main/main.do">Home</a></li>
                  <li class="active">티켓</li>
               </ul>
            </div>
         </div>
      </section>
      <section class="single_blog_area section_padding_80" id="reserveApp">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-12 col-lg-12">
                    <div class="row no-gutters">
                    	<table class="table">
                    		<tr>
                    			<td width="40%" height="500">
                    				<table class="table">
                    					<tr>
                    						<td colspan="2" class="text-center">
                    							<h4 >좌석 등급</h4>
                    						</td>
                    					</tr>
                    					<tr>
                    						<td colspan="2" class="text-center">
                    							<button class="btn-xs btn-success" @click="typeChange('그린존')">그린존</button>
                    							<button class="btn-xs btn-info" @click="typeChange('레드존')">레드존</button>
                    							<button class="btn-xs btn-danger" @click="typeChange('네이비존')">네이비존</button>
                    							<button class="btn-xs btn-primary" @click="typeChange('익사이팅존')">익사이팅존</button>
                    							<button class="btn-xs btn-warning" @click="typeChange('VIP존')">VIP존</button>
                    						</td>
                    					</tr>
                    				</table>
                    				<div style="overflow-y:auto;height:500px">
                    					<table class="table">
                    						<tr>
                    							<th></th>
                    							<th class="text-left">티켓</th>
                    							<th></th>
                    						</tr>
                    						<tr v-for="vo in glist" class="ticket-click" @click="ticketSelect(vo.tno,vo.num,vo.game_date)">
                    							<td class="text-center">한국시리즈{{vo.num}}차전</td>
                    							<td class="text-center">
                    								<img src="../images/koreanseries.png" style="width:35px;height:35px">
                    							</td>
                    							<td>{{vo.game_date}}</td>
                    						</tr>
                    						
                    					</table>
                    				</div>
                    			</td>
                    			
                    			<td width="45%" height="500" rowspan="2">
                    				<table class="table">
                    					<tr>
                    						<td colspan="2" class="text-center">
                    							<h4>예약 정보</h4>
                    						</td>
                    					</tr>
                    					<tr>
                    						<td colspan="2" class="text-center">
                    							<img :src="image" style="width:200px;height:150px">
                    						</td>
                    					</tr>
                    					<tr>
                    						<th width="30%" class="text-center">경기</th>
                    						<td width="70%">{{name}}</td>
                    					</tr>
                    					<tr>
                    						<th width="30%" class="text-center">예약일</th>
                    						<td width="70%">{{day}}</td>
                    					</tr>
                    					<tr>
                    						<th width="30%" class="text-center">좌석등급</th>
                    						<td width="70%">{{type}}</td>
                    					</tr>
                    					<tr>
                    						<th width="30%" class="text-center">인원</th>
                    						<td width="70%">{{inwon}}</td>
                    					</tr>
                    					<tr>
                    						<th width="30%" class="text-center">인원</th>
                    						<td width="70%">{{price}}</td>
                    					</tr>
                    					<tr v-show="isReserveBtn">
                    						<td colspan="2" class="text-center">
		                    					<button class="btn-lg btn-danger" @click="reserve()">좌석선택</button>
                    						</td>
                    					</tr>
                    				</table>
                    			</td>
                    		</tr>
                    		<tr>
                    		</tr>
                    	</table>
                    </div>
                </div>
            </div>
        </div>
    </section>
     <script>
     let id ="${id}"
     if(id !=null && id !== ""){
	     		alert("티켓은 한게임당 1좌석 구매원칙입니다!!")
     		} else {
     			alert("로그인후 이용이 가능한 서비스입니다")
     			location.href="../member/login.do"
     		}
     	let ticketApp = Vue.createApp({
     		
     		data(){
     			return {
     				image:'../images/koreanseries.jpg',
     				price:'',
     				glist:[],
     				type:'',
     				inwon:1,
     				day:'',
     				name:'',
     				tno:0,
     				num:0,
     				game_date:''
     			}
     		},
     		mounted(){
     			this.dataRecv()
     		},
     		methods:{
     			login(){
     				location.href="../member/login.do";
     			},
     			reserve() {
     			    	
     			        location.href = "../ticket/ticket_main.do?price="+this.price+"&type="+this.type+"&day="+this.day+"&num="+this.num; // 여기에서 이동
     			  
     			},
     			ticketSelect(tno,num,game_date){
    				this.name='한국시리즈'+num+'차전'
    				this.num=num
    				this.day=game_date
	    			this.isReserveBtn=true
    			},
     			typeChange(type){
     				this.type=type
     				if(type=='그린존'){
     					this.price='13000'
     				} else if(type=='레드존'){
     					this.price='16000'
     				}else if(type=='네이비존'){
     					this.price='20000'
     				}else if(type=='익사이팅존'){
     					this.price='25000'
     				}else if(type=='VIP존'){
     					this.price='80000'
     				}
     				this.dataRecv()
     				console.log(type)
     			},
     			dataRecv(){
     				axios.get('../ticket/ticketchoice_vue.do',{
     					params:{
     						
     					}
     				}).then(response=>{
     					console.log(response.data)
     					this.glist = response.data.glist
     				}).catch(error=>{
     					console.log(error.response)
     				})
     			}
     		}
     	}).mount('#reserveApp')
     </script>
</body>
</html>
