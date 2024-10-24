<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<style type="text/css">
.container{
   margin-top: 50px;
}
.row{
   margin: 0px auto;
   width: 800px
}
</style>
</head>
<body>
	<div class="container">
		<h3 class="text-center">ElasticSearch 검색</h3>
		<div class="row">
			<input type="text" size="20" v-model="name" class="input-sm"
			  @keydown.enter="search()">
			<button class="btn-sm btn-primary" @click="search()">검색</button>
		</div>
		<div style="height:10px"></div>
		<div class="row">
			<div class="col-md-4" v-for="vo in batter_list">
			    <div class="thumbnail">
			      <a href="#">
			        <img :src="'https://statiz.sporki.com'+vo._source.image" style="width:230px;height:150px">
			        <div class="caption">
			          <p>{{vo._source.name}}</p>
			        </div>
			      </a>
			    </div>
			  </div>
		</div>
	</div>
	<script>
		let app=Vue.createApp({
			data(){
				return{
					batter_list:[],
					name:''
				}
			},
			methods:{
				search(){
					axios.get('http://localhost:8080/web/batter/find_vue.do',{
						params:{
							name:this.name
						}
					}).then(response=>{
						console.log(response.data.hits.hits)
						this.batter_list=response.data.hits.hits
					}).catch(error=>{
						console.log(error.response)
					})
				}
			}
		}).mount('.container')
	</script>
</body>
</html>