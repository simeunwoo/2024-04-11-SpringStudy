<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px
}
.row{
   margin: 0px auto;
   width: 800px
}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
</head>
<body>
	<div class="container">
    <h3 class="text-center">상세보기</h3>
    <div class="row">
     <table class="table">
      <tr>
        <td class="text-center" rowspan="7" width=30%>
         <img :src="vo.poster" style="width:240px;height:350px">
        </td>
        <td colspan="2">
          <h3>{{vo.title}}</h3>
        </td>
      </tr>
      <tr>
        <td style="color:gray" width="20%">음식종류</td>
        <td width="50%">{{vo.chef}}</td>
      </tr>
      <tr>
        <td style="color:gray" width="20%">주소</td>
        <td width="50%">{{vo.chef_poster}}</td>
      </tr>
      <tr>
        <td style="color:gray" width="20%">전화</td>
        <td width="50%">{{vo.chef_profile}}</td>
      </tr>
      <tr>
        <td style="color:gray" width="20%">영업시간</td>
        <td width="50%">{{vo.info1}}</td>
      </tr>
      <tr>
        <td style="color:gray" width="20%">주차</td>
        <td width="50%">{{vo.info2}}</td>
      </tr>
      <tr>
        <td style="color:gray" width="20%">테마</td>
        <td width="50%">{{vo.info3}}</td>
      </tr>
     </table>
     <table class="table">
       <tr>
         <td>{{vo.content}}</td>
       </tr>
     </table>
    </div>

  </div>
  <script>
  	let detailApp=Vue.createApp({
  		data(){
  			return{
  				vo:{},
  				no:${no}
  			}
  		},
  		mounted(){
  			axios.get('../recipe/detail_vue.do',{
  				params:{
  					no:this.no
  				}
  			}).then(response=>{
  				console.log(response.data)
  				this.vo=response.data
  			}).catch(error=>{
  				console.log(error.response)
  			})
  		}
  	}).mount('.container')
  </script>
</body>
</html>