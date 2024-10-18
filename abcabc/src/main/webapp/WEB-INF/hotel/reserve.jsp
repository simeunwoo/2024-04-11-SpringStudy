<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='https://cdn.jsdelivr.net/npm/@fullcalendar/icalendar@5.11.3/main.css' rel='stylesheet' />
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.15/index.global.min.js"></script>

</head>
<body>
	<section id="top">
   <div class="inner-page-banner">
            <div class="container">
            </div>
         </div>
         <div class="inner-information-text">
            <div class="container">
               <h3>reserve</h3>
               <ul class="breadcrumb">
                  <li><a href="index.html">Home</a></li>
                  <li class="active">reserve</li>
               </ul>
            </div>
         </div>
      </section>
      <section id="hotelreserve" class="contant main-heading team">
         <div class="row">
            <div class="container">
               <div class="contact">
                  <div class="col-md-12">
                  		<table class="table">
                    		<tr>
                    		<td width="35%" height="500" rowspan="2" >
                    				<table class="table">
                    					<tr>
                    						<td colspan="2">
                    							<h4>예약 정보</h4>
                    						</td>
                    					</tr>
                    					<tr>
                    						<td colspan="2" class="text-center">
                    							<img :src="poster" style="width:200px;height:150px">
                    						</td>
                    					</tr>
                    					<tr>
                    						<th width="30%" class="text-center">호텔명</th>
                    						<td width="70%">{{name}}</td>
                    					</tr>
                    					<tr>
                    						<th width="30%" class="text-center">예약일</th>
                    						<td width="70%">{{day}}</td>
                    					</tr>
                    					<tr>
                    						<th width="30%" class="text-center">방등급</th>
                    						<td width="70%">{{room}}</td>
                    					</tr>
                    					<tr>
                    						<th width="30%" class="text-center">가격</th>
                    						<td width="70%">{{price}}</td>
                    					</tr>
                    					<tr v-show="isReserveBtn">
                    						<td colspan="2" class="text-center">
                    							<button class="btn-lg btn-danger" @click="reserve()">예약</button>
                    						</td>
                    					</tr>
                    				</table>
                    			</td>
                    			<td width="45%" height="500">
                    				<table class="table">
                    					<tr>
                    						<td>
                    							<h4>예약일 정보</h4>
                    						</td>
                    					</tr>
                    					<tr v-show="isDate">
                    						<td>
                    							<div id="calendar"></div>
                    						</td>
                    					</tr>
                    				</table>
                    			</td>
                    			<td width="35%" height="150">
                    				<table class="table">
                    					<tr>
                    						<td>
                    							<h4>방 등급</h4>
                    						</td>
                    					</tr>
                    					<tr v-show="isRoom">
                    						<td class="text-center">
                    							 <span class="btn btn-lg btn-primary" v-for="i in room_list" style="margin-left:1px;"
                    							  @click="roomSelect(i)">
                    								{{i}}
                    							</span> 
                    						</td>
                    					</tr>
                    				</table>
                    			</td>
                    		</tr>
                    	</table>
                  </div>
               </div>
           </div>
        </div>
     </section>
     <script>
     	let reserveApp=Vue.createApp({
     		data(){
     			return{
     				isDate:true,
     				hotel_vo:{},
     				day:'',
     				isReserveBtn:false,
     				isRoom:false,
     				name:'',
     				poster:'',
     				price:0,
     				baseprice: 0,
     				day:'',
    				time:'',
    				rdays: [],
    				room:'',
    				room_list:[],
     			}
     		},
     		mounted(){
     			let date = new Date();
        	    let year = date.getFullYear();
        	    let month = ("0" + (1 + date.getMonth())).slice(-2);
        	    let day = ("0" + date.getDate()).slice(-2);
        	    
        		let _this=this
        		document.addEventListener('DOMContentLoaded', function() {
        		    var calendarEl = document.getElementById('calendar');
        		    var calendar = new FullCalendar.Calendar(calendarEl, {
        		    	initialView: 'dayGridMonth',
        		    /*	headerToolbar: {
        		            left: 'prev,next today',
        		            center: 'title'
        		          }, */
        		          height:450,
        		          validRange: {
        		        	    start: year+"-"+month+"-"+day
        		          },
        		          themeSystem: 'bootstrap',	// 이렇게 설정하면 다크모트 라이트모드 가능
        		          editable: true,
        		          droppable: true, // this allows things to be dropped onto the calendar !!!
        		          dateClick: ((info) => {
        		               //location.href="http://daum.net"
        		               //alert('Click Date:'+info.dateStr)
        	/* 	               _this.day=info.dateStr
        		               _this.isTime=true */
        		               
        		               let selectedDay = new Date(info.dateStr).getDate();
                               // 예약 가능한 날짜인지 확인
                               if (_this.rdays.includes(selectedDay)) {
                                   _this.day = info.dateStr;
                                   _this.isRoom = true;  // 예약 버튼 표시
                               } else {
                                   alert("예약이 불가능한 날짜입니다.");
                               }
        		          }),
        		          dayCellDidMount: function (info) {
        		              let day = new Date(info.date);
        		              let today = new Date();

        		              // 오늘 이후의 날짜만 색상 변경
        		              if (day >= today) {
        		                  let dayNumber = day.getDate();
        		                  if (_this.rdays.includes(dayNumber)) {
        		                      // 예약 가능한 날짜는 녹색 배경
        		                      info.el.style.backgroundColor = 'rgb(255,250,223)';
        		                  } else {
        		                      // 예약 불가능한 날짜는 회색 배경
        		                      info.el.style.backgroundColor = '#F1F1F1';
        		                  }
        		              }
        		          }
        		        });
        		    calendar.render();
        		    });
        		
        		this.dataRecv()
     		},
     		methods:{
     			reserve(){
    				axios.post('../hotel/reserve_ok_vue.do',null,{
    					params:{
    						hno:${hno},
    						rday:this.day,
    						rroom:this.room,
    						rprice:this.price
    					}
    				}).then(response=>{
    					// 이동 => mypage
    					if(response.data==='yes')
    					{
    						alert("yes!!")
    						/* location.href="../mypage/mypage_reserve.do" */
    					}
    					else
    					{
    						alert(response.data)
    					}
    					console.log(response.data)
    				}).catch(error=>{
    					console.log(error.response)
    				})
    			},
     			roomSelect(i){
    				this.room=i
    				if(i=='C'){
    					this.price=Math.round(this.baseprice*1.2)
    				} else if(i=='B'){
    					this.price=Math.round(this.baseprice*1.4)
    				} else if(i=='A') {
    					this.price=Math.round(this.baseprice*1.8)
    				} else if(i=='S') {
    					this.price=Math.round(this.baseprice*2.2)
    				}
    					
    				this.isReserveBtn=true
    			},
     			dataRecv(){
     				axios.get('../hotel/reserve_vue.do',{
     					params:{
     						hno:${hno}
     					}
     				}).then(response=>{
     					console.log(response.data)
     					this.name=response.data.hotel_vo.name
     					this.baseprice = response.data.hotel_vo.price;  
     	                this.price = this.baseprice; 
     					let availableDatesStr = response.data.hotel_vo.rdays; 
     	                this.rdays = availableDatesStr.split(',').map(day => parseInt(day));
     	                this.room_list=response.data.rList
     	                this.poster=response.data.hotel_vo.poster
     	                console.log(response.data.rList)
     				}).catch(error=>{
     					console.log(error.response)
     				})
     			}
     		}
     	}).mount('#hotelreserve')
     </script>
</body>
</html>