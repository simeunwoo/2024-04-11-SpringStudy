<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<!--
C:\springDev\springStudy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringElasticSearchProject\image
-->
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
		<h3 class="text-center">사원 통계</h3>
		<div class="row">
			<div class="text-center">
				<button class="btn-sm btn-danger" @click="sawonGraph()">사원 급여</button>
				<button class="btn-sm btn-primary" @click="jobGraph()">직위별 급여</button>
				<button class="btn-sm btn-info" @click="deptGraph()">부서별 통계</button>
				<button class="btn-sm btn-success" @click="locGraph()">근무지별 통계</button>
				<button class="btn-sm btn-warning" @click="wordcloud()">워드클라우드</button>
			</div>
		</div>
		<div style="height:10px"></div>
		<div class="row">
			<div class="text-center">
				<img :src="'../image/'+image" style="width:100%">
			</div>
		</div>
	</div>
	<script>
		let app=Vue.createApp({
			data(){
				return{
					image:''					
				}
			},
			/*
				response.data={"image":"파일명"}
			*/
			methods:{
				sawonGraph(){
					url='sawon/'
					this.dataRecv(url)
				},
				jobGraph(){
					url='job/'
					this.dataRecv(url)
				},
				deptGraph(){
					url='dept/'
					this.dataRecv(url)
				},
				locGraph(){
					url='loc/'
					this.dataRecv(url)
				},
				wordcloud(){
					url='wordcloud/'
					this.dataRecv(url)
				},
				dataRecv(url){
					axios.get('http://localhost:8000/web/emp/'+url)
					.then(response=>{
						this.image=response.data.image
					}).catch(error=>{
						console.log(error.response)
					})
				}
			}
		}).mount('#container')
	</script>
</body>
</html>