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
<!-- ���� -->
<div class="breadcumb-area">
    <div class="container h-100">
        <div class="row h-100 align-items-center">
            <div class="col-16">
                <div class="bradcumb-title text-center">
                    <h2 style="font-size:40px;">���� ��������</h2>
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
	                      <td style="color:pink">����</td>
	                      <td>{{detail_data.price}}</td>
	                    </tr>
	                    <tr>
	                      <td style="color:gray">��ۺ�</td>
	                      <td>{{detail_data.simple_delivery}}</td>
	                    </tr>
	                    <tr>
	                      <td colspan="2">
	                        <select class="input-sm" style="width:350px" @change="accountChange()" ref="account" v-model="account" >
	                         <option value="1" selected>1��</option>
	                         <option value="2">2��</option>
	                         <option value="3">3��</option>
	                         <option value="4">4��</option>
	                         <option value="5">5��</option>
	                        </select>
	                      </td>
	                    </tr>
	                    <tr>
	                      <td colspan="2" class="text-right">
	                       �� �ݾ�:<span style="color:bule">{{total_price}}��</span>
	                      </td>
	                    </tr>
	                    <tr>
	                      <td colspan="2" class="text-center">
	                       <c:if test="${sessionScope.userId!=null }">
	                       	<button class="" @click="kbogoodsBuy()">�ٷα���</button>&nbsp;
	                       	<button class="" @click="kbogoodsCart()">��ٱ���</button>&nbsp;
	                       </c:if>
	                      <c:if test="${sessionScope.userId==null }">
	                        <button class="" @click="notLoginAlert()">�ٷα���</button>&nbsp;
	                       	<button class="" @click="notLoginAlert()">��ٱ���</button>&nbsp;
	                      
	                       </c:if>
	                        <button class="" onclick="javascript:history.back()">���</button>
	                      </td>
	                    </tr>
	                 </table>
	                 
	                 <div class="">
	                 <table class="table kbogoodscontent text-center">
	                 	<tr class="text-center">
	                 		<td>
	                 			<a style="font-size: 15px; ">�󼼺���</a>
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
			//alert("����:"+this.account);
			this.total_price=this.account * this.detail_data.origin_price + this.detail_data.origin_delivery
		},
		// 1. ����â 
		requestPay() {
		    IMP.request_pay({
		        pg: "html5_inicis",
		        pay_method: "card",
		        merchant_uid: "ORD20180131-0000011",   // �ֹ���ȣ
		        name: this.detail_data.name,
		        amount: this.total_price,         // ���� Ÿ��
		        buyer_email: '',
		        buyer_name: '',
		        buyer_tel: '',
		        buyer_addr: '',
		        buyer_postcode: ''
		     }, function (rsp) { // callback
		    	
		    });
	    },
		// 2. ��ٱ��� ==> 0
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
					alert("��ٱ��� ��⿡ �����ϼ̽��ϴ�\n"+response.data)
				}
				
			}).catch(error=>{
				console.log(error.response)
			})
		},
		// 2. ����  ===> spring_cart : 1
		kbogoodsBuy(){
			// ������� �б� => ȸ�� ���� / ��ǰ ���� (�̹� ���� ����) => ������û 
			this.requestPay()
		},
		// ===> mypage�� �̵� 
		// 3. ���� / ��ٱ��� : ��� 
	    notLoginAlert(){
	 		alert("�α��� �� �̿� �����մϴ�");
		}
		
	  }
  }).mount("#detailApp")
 </script>

</body>
</html>