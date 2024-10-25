<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
<style>
	body
{
  font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
}

#Username
{	
  border:none;
  border-bottom:1px solid;
}

.screen
{
  width:100%;
  height:20px;
  background:#4388cc;
  color:#fff;
  line-height:20px;
  font-size:15px;
}

.smallBox::before
{
  content:".";
  width:15px;
  height:15px;
  float:left;
  margin-right:10px;
}
.greenBox::before
{
  content:"";
  background:Green;
}
.redBox::before
{
  content:"";
  background:Red;
}
.emptyBox::before
{
  content="";
  box-shadow: inset 0px 2px 3px 0px rgba(0, 0, 0, .3), 0px 1px 0px 0px rgba(255, 255, 255, .8);
    background-color:#ccc;
}

.seats
{
  border:1px solid red;background:yellow;
} 



.seatGap
{
  width:40px;
}

.seatVGap
{
  height:40px;
}

table
{
  text-align:center;
}


.Displaytable
{
  text-align:center;
}
.Displaytable td, .Displaytable th {
    border: 1px solid;
    text-align: left;
}

textarea
{
  border:none;
  background:transparent;
}



input[type=checkbox] {
    width:0px;
    margin-right:18px;
}

input[type=checkbox]:before {
    content: "";
    width: 15px;
    height: 15px;
    display: inline-block;
    vertical-align:middle;
    text-align: center;
    box-shadow: inset 0px 2px 3px 0px rgba(0, 0, 0, .3), 0px 1px 0px 0px rgba(255, 255, 255, .8);
    background-color:#ccc;
}

input[type=checkbox]:checked:before {
    background-color:Green;
    font-size: 15px;
}
input[type=checkbox]:disabled:before {
    background-color:red;
    font-size: 15px;
}


	
</style>
</head>
<body onload="onLoaderFunc()">
<section id="top">
        
         <div class="inner-information-text">
            <div class="container">
               <h3>Blog</h3>
               <ul class="breadcrumb">
                  <li><a href="../main/main.do">Home</a></li>
                  <li class="active">티켓예약</li>
               </ul>
            </div>
         </div>
         <div id="reserveApp">
         <div class="inputForm">
<center style="margin-top:20px;">
  ID : <input type="text" id="Username" required value=${sessionId}>
  좌석수 : <input type="number" id="Numseats" required value="1">
  <br/><br/>
  <button id="reserveBtn" onclick="takeData()" style="display:none;">예매시작</button>
</center>
</div>
  

<div class="seatStructure col-md-6" >
<center>
  
<table id="seatsBlock">
 <p id="notification"></p>
  <tr>
    <td colspan="14"><div class="screen">좌석 등급</div></td>
    <td rowspan="20">
      <div class="smallBox greenBox">예약가능 좌석</div> <br/>
      <div class="smallBox redBox">매진 좌석</div><br/>
      <div class="smallBox emptyBox">빈 좌석</div><br/>
    </td>
    
    <br/>
  </tr>
  
  <tr>
    <td></td>
    <td>1</td>
    <td>2</td>
    <td>3</td>
    <td>4</td>
    <td>5</td>
    <td>6</td>
    <td>7</td>
    <td>8</td>
    <td>9</td>
    <td>10</td>
    <td>11</td>
    <td>12</td>
</tr>
  
<tr>
    <td>A</td>
    <c:forEach var="row" begin="1" end="12">
	    <td>	
	    	<c:set var="seat" value="A${row }"></c:set>
	    	<input type="checkbox" id="chkbx1" class="seats" value="${seat }" 
	    		<c:forEach var="vo" items="${list}">
                     <c:if test="${vo.gvo.seat eq seat }">
                         disabled
                     </c:if>
                 </c:forEach>
	    	/>
	    </td>
    </c:forEach>
  </tr>
  
  <tr>
    <td>B</td>
    <c:forEach var="row" begin="1" end="12">
	    <td>	
	    	<c:set var="seat" value="B${row }"></c:set>
	    	<input type="checkbox" id="chkbx1" class="seats" value="${seat }" 
	    		<c:forEach var="vo" items="${list}">
                     <c:if test="${vo.gvo.seat eq seat }">
                         disabled
                     </c:if>
                 </c:forEach>
	    	
	    	/>
	    </td>
    </c:forEach>
  </tr>
  
  <tr>
    <td>C</td>
    <c:forEach var="row" begin="1" end="12">
	    <td>	
	    	<c:set var="seat" value="C${row }"></c:set>
	    	<input type="checkbox" id="chkbx1" class="seats" value="${seat }" 
	    		<c:forEach var="vo" items="${list}">
                     <c:if test="${vo.gvo.seat eq seat }">
                         disabled
                     </c:if>
                 </c:forEach>
	    	
	    	/>
	    </td>
    </c:forEach>
  </tr>
  
<tr>
    <td>D</td>
    <c:forEach var="row" begin="1" end="12">
	    <td>	
	    	<c:set var="seat" value="D${row }"></c:set>
	    	<input type="checkbox" id="chkbx1" class="seats" value="${seat }" 
	    		<c:forEach var="vo" items="${list}">
                     <c:if test="${vo.gvo.seat eq seat }">
                         disabled
                     </c:if>
                 </c:forEach>
	    	
	    	/>
	    </td>
    </c:forEach>
  </tr>
  
<tr>
    <td>E</td>
    <c:forEach var="row" begin="1" end="12">
	    <td>	
	    	<c:set var="seat" value="E${row }"></c:set>
	    	<input type="checkbox" id="chkbx1" class="seats" value="${seat }" 
	    		<c:forEach var="vo" items="${list}">
                     <c:if test="${vo.gvo.seat eq seat }">
                         disabled
                     </c:if>
                 </c:forEach>
	    	
	    	/>
	    </td>
    </c:forEach>
  </tr>
  
<tr class="seatVGap"></tr>
  
<tr>
    <td>F</td>
    <c:forEach var="row" begin="1" end="12">
	    <td>	
	    	<c:set var="seat" value="F${row }"></c:set>
	    	<input type="checkbox" id="chkbx1" class="seats" value="${seat }" 
	    		<c:forEach var="vo" items="${list}">
                     <c:if test="${vo.gvo.seat eq seat }">
                         disabled
                     </c:if>
                 </c:forEach>
	    	
	    	/>
	    </td>
    </c:forEach>
  </tr>
  <tr>
    <td>G</td>
    <c:forEach var="row" begin="1" end="12">
	    <td>	
	    	<c:set var="seat" value="G${row }"></c:set>
	    	<input type="checkbox" id="chkbx1" class="seats" value="${seat }" 
	    		<c:forEach var="vo" items="${list}">
                     <c:if test="${vo.gvo.seat eq seat }">
                         disabled
                     </c:if>
                 </c:forEach>
	    	
	    	/>
	    </td>
    </c:forEach>
  </tr>
<tr>
    <td>H</td>
    <c:forEach var="row" begin="1" end="12">
	    <td>	
	    	<c:set var="seat" value="H${row }"></c:set>
	    	<input type="checkbox" id="chkbx1" class="seats" value="${seat }" 
	    		<c:forEach var="vo" items="${list}">
                     <c:if test="${vo.gvo.seat eq seat }">
                         disabled
                     </c:if>
                 </c:forEach>
	    	
	    	/>
	    </td>
    </c:forEach>
  </tr>
  
<tr>
    <td>I</td>
    <c:forEach var="row" begin="1" end="12">
	    <td>	
	    	<c:set var="seat" value="I${row }"></c:set>
	    	<input type="checkbox" id="chkbx1" class="seats" value="${seat }" 
	    		<c:forEach var="vo" items="${list}">
                     <c:if test="${vo.gvo.seat eq seat }">
                         disabled
                     </c:if>
                 </c:forEach>
	    	
	    	/>
	    </td>
    </c:forEach>
  </tr>
  
<tr>
    <td>J</td>
    <c:forEach var="row" begin="1" end="12">
	    <td>	
	    	<c:set var="seat" value="J${row }"></c:set>
	    	<input type="checkbox" id="chkbx1" class="seats" value="${seat }" 
	    		<c:forEach var="vo" items="${list}">
                     <c:if test="${vo.gvo.seat eq seat }">
                         disabled
                     </c:if>
                 </c:forEach>
	    	
	    	/>
	    </td>
    </c:forEach>
  </tr>
  
  
</table>
  
<br/><button onclick="updateTextArea()">선택 완료</button>
</center>
</div>
      
<br/><br/>

<div class="displayerBoxes col-md-6 text-center">
<center >
  <table class="Displaytable text-center">
  <tr > 
    <th style="display:none;">ID</th>
    <th>경기날짜</th>
    <th>좌석</th>
  </tr>
  <tr>
    <td style="display:none;"><input type=text id="nameDisplay" readonly class="text-center" ></td>
    <td><input type=text id="NumberDisplay" readonly class="text-center" value=${day }></td>
    <td><input type=text id="seatsDisplay" readonly class="text-center"></td>
  </tr>
  <tr class="text-center">
  	<th>좌석등급</th>
  	<th>가격</th>
  </tr>
  <tr>
  	<td><input type=text id="zone" readonly class="text-center" value=${type }></td>
  	<td><input type=text id="price" readonly class="text-center" value=${price }></td>
  </tr>
</table>
  		<td colspan="2"><input class="btn-lg btn-primary" type="button" value="결제하기" style="margin-top:50px;"
  			@click="reserve()"
  		></td>
</center>
</div>
         </div>
         
      </section>
      <script>
      var IMP = window.IMP; 
      IMP.init("imp68206770");
      window.onload = function() {
          document.getElementById("reserveBtn").click();
      };
      function onLoaderFunc()
      {
        $(".seatStructure *").prop("disabled", true);
        $(".displayerBoxes *").prop("disabled", true);
      }
      function takeData()
      {
        if (( $("#Username").val().length == 0 ) || ( $("#Numseats").val().length == 0 ))
        {
        alert("Please Enter your Name and Number of Seats");
        }
        else
        {
          $(".inputForm *").prop("disabled", true);
          $(".seatStructure *").prop("disabled", false);
          document.getElementById("notification").innerHTML = "<b style='margin-bottom:0px;background:yellow;'>좌석을 선택 하세요!!</b>";
        }
      }
	

      function updateTextArea() { 
          
        if ($("input:checked").length == ($("#Numseats").val()))
          {
            $(".seatStructure *").prop("disabled", true);
            
           var allNameVals = [];
           var allNumberVals = [];
           var allSeatsVals = [];
        
           //Storing in Array
           allNameVals.push($("#Username").val());
           allNumberVals.push($("#Numseats").val());
           $('#seatsBlock :checked').each(function() {
             allSeatsVals.push($(this).val());
           });
          
           //Displaying 
           $('#nameDisplay').val(allNameVals);
           $('#seatsDisplay').val(allSeatsVals);
          }
        else
          {
            alert("Please select " + ($("#Numseats").val()) + " seats")
          }
        }


      function myFunction() {
        alert($("input:checked").length);
      }

      $(":checkbox").click(function() {
        if ($("input:checked").length == ($("#Numseats").val())) {
          $(":checkbox").prop('disabled', true);
          $(':checked').prop('disabled', false);
        }
        else
          {
            $(":checkbox").prop('disabled', false);
          }
      });
      
      
      let reserveApp=Vue.createApp({
     		data(){
     			
     			return{
     				tno:0,
     				seats:'',
     				rday:'',
					rtype:'',
     				rprice:0,
     				rseat:''
     			}
     		},
     		mounted(){
        		
     		},
     		methods:{
     			requestPay() {
     		          IMP.request_pay({
     		              pg: "html5_inicis",
     		              pay_method: "card",
     		              merchant_uid: "ORD20180131-0000011",   // 주문번호
     		              name: '한국시리즈'+${num}+'차전',
     		              amount: ${price},         // 숫자 타입
     		              buyer_email: '',
     		              buyer_name: '',
     		              buyer_tel: '',
     		              buyer_addr: '',
     		              buyer_postcode: ''
     		           }, function (rsp) { // callback
     		        	  location.href="../mypage/mypage_main.do"
     		          });
     		       },
     			
     			reserve(){
     				let seats = $('#seatsDisplay').val()
     				console.log(seats)
    				axios.get('../ticket/ticket_main_vue.do',{
    					params:{
    						type:'${type}',
    	     				price:${price},
    	     				seat:seats,
    	     				day:'${day}'
    					}
    				}).then(response=>{
    					// 이동 => mypage
    					console.log(response.data)
    					this.tno = response.data
    					alert(this.tno)
    					axios.post('../ticket/reserve_ok_vue.do',null,{
    					params:{
    	     				tno:this.tno,
    	     				rday:'${day}',
    						rtype:'${type}',
    	     				rprice:${price},
    	     				rseat:seats
    					}
	    				}).then(response=>{
	    					// 이동 => mypage
	    					if(response.data==='yes')
	    					{
	    						alert("yes!!")
	    						this.requestPay()
	    						
	    					}
	    					else
	    					{
	    						alert(response.data)
	    					}
	    					console.log(response.data)
	    				}).catch(error=>{
	    					console.log(error.response)
	    				}) 
    				}).catch(error=>{
    					console.log(error.response)
    				})
    			}
     		}
     	}).mount('#reserveApp')
      </script>
   

 </body>
</html>