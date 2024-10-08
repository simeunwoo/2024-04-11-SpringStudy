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
	margin-top: 50px;
}
.row{
	margin: 0px auto;
	width: 960px;
}
p{
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
.link{
	cursor: pointer;
}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
<%--
	일반 스프링 : JSP 제어
	화면 이동 => <a>, <form>
	VueJS => 이벤트 => button
--%>
	<div class="container">
		<div class="row">
			<input type="text" size="20" class="input-sm" ref="address" v-model="address"
			  @keydown.enter="find()">
			<input type="button" value="검색" class="btn-sm btn-success" @click="find()">
		</div>
		<div style="height:10px"></div>
		<div class="row">
			<div class="col-md-3" v-for="vo in find_list">
				    <div class="thumbnail">
				      <a href="#">
				        <img :src="'http://www.menupan.com'+vo.poster" style="width:230px;height:150px"
				          :title="vo.address"><!-- 변수값엔 앞에 클론(:) 필수 -->
				        <div class="caption">
				          <p>{{vo.name }}</p>
				        </div>
				      </a>
				    </div>
				 </div>
		</div>
		<div class="row">
			<div class="text-center">
				<ul class="pagination">
					<li v-if="startPage>1"><a class="link" @click="prev()">&lt;&lt;&lt;</a></li>
					<li v-for="i in range(startPage,endPage)" :class="i===curpage?'active':''">
						<a class="link" @click="pageChange(i)">{{i}}</a>
					</li>
					<li v-if="endPage<totalpage"><a class="link" @click="next()">&gt;&gt;&gt;</a></li>
				</ul>
			</div>
		</div>
	</div>
	<script>
		let findApp=Vue.createApp({
			data(){
				return{
					find_list:[],
					address:'동작',
					curpage:1,
					totalpage:0,
					startPage:0,
					endPage:0
				}
			},
			mounted(){
				this.dataRecv()
			},
			methods:{
				range(start,end){
					let arr=[]
					let len=end-start
					for(let i=0;i<=len;i++)
					{
						arr[i]=start
						start++
					}
					return arr
				},
				prev(){
					this.curpage=this.startPage-1
					this.dataRecv()
				},
				next(){
					this.curpage=this.endPage+1
					this.dataRecv()
				},
				pageChange(page){
					this.curpage=page
					this.dataRecv()
				},
				find(){
					if(this.address==="")
					{
						alert("검색어 입력")
						this.$refs.address.focus()
						return
					}
					this.curpage=1
					this.dataRecv()
				},
				dataRecv(){
					axios.get("http://localhost:8080/web/food/find_vue.do",{
						params:{
							page:this.curpage,
							address:this.address
						}
					}).then(response=>{
						this.find_list=response.data.list
						this.address=response.data.address
						this.curpage=response.data.curpage
						this.totalpage=response.data.totalpage
						this.startPage=response.data.startPage
						this.endPage=response.data.endPage
					})
				}
			}
		}).mount('.container')
	</script>
</body>
</html>