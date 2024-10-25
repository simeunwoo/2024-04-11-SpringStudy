<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
#container {
	height:600px;
}

.row {
	margin: 0px auto;
	width: 960px
}

.nav-link {
	cursor: pointer;
}

p {
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
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
                  <li class="active">Hotel</li>
               </ul>
            </div>
         </div>
      </section>
	<div class="container" id="container">
		<h3 class="text-center">Elastic Search 검색</h3>
		<div class="row">
			<input type="text" size=20 v-model="name" class="input-sm" 
				@keydown.enter="search()"
			> 
			<button class="btn-sm btn-primary" @click="search()">검색</button>
		</div>
		<div style="height: 10px;"></div>
		<div class="row">
			<div class="col-md-4" v-for="vo in hotel_list">
				<div class="thumbnail">
					<a href="#"> 
					<img :src="vo._source.poster" style="width: 230px; height:150px;">
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
					hotel_list:[],
					name:''
				}
			}, 
			methods:{
				search(){
					console.log("s")
					axios.get('http://localhost:8080/web/hotel/find_vue.do',{
						params:{
							name:this.name
						}
					}).then(response=>{
						console.log(response.data.hits.hits)
						this.hotel_list=response.data.hits.hits
					}).catch(error=>{
						console.log(error.response)
					})
				}
			}
		}).mount("#container")
	</script>
</body>
</html>