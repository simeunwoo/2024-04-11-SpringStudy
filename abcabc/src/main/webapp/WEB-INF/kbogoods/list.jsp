<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	.page-link:hover{
		cursor: pointer;
}
</style>
</head>
<body>
<div class="top_space"  style="height: 220px;"></div>

<div id="listApp">
<!-- 제목 -->
<div class="breadcumb-area">
    <div class="container h-100">
        <div class="row h-100 align-items-center">
            <div class="col-16">
                <div class="bradcumb-title text-center">
                    <h2 style="font-size: 50px;">굿 즈</h2>
                </div>
            </div>
        </div>
    </div>
</div>
 <div class="breadcumb-nav" style="margin-bottom: 50px;">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item">
                            
                             <input type=text style="color: black;" size=25 ref="fd" v-model="fd" @keydown.enter="kboGoodsFind()">
                            </li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>

<section class="archive-area section_padding_80">
<div class="container">
    <div class="row">
        <!-- Single Post -->
        <div class="col-16 col-md-6 col-lg-4" v-for="vo in kboGoods_list"  style="margin-bottom: 50px;">
            <div class="single-post wow fadeInUp" data-wow-delay="0.1s">
                <!-- Post Thumb -->
                <div class="text-center">
                   <a :href="'../kboGoods/detail_before.do?gno='+vo.gno">
                    <img :src="vo.poster" style="width: 250px; ">
                   </a>
                </div>
                <!-- Post Content -->
                <div class="post-content">
                   <a :href="'../kboGoods/detail_before.do?gno='+vo.gno">
                       <h4 style=" font-size: 20px;">{{vo.name}}</h4>
                   </a>	
               </div>
               <div class="kbogoods_price" >
               		<a :href="'../kboGoods/detail_before.do?gno='+vo.gno" style="color:#888;">{{vo.price}}</a>
               </div>
           </div>
       </div>
	</div>
</div>
</section>
            

       <div class="col-16">
           <div class="pagination-area d-sm-flex mt-15  text-center">
               <nav aria-label="#">
                   <ul class="pagination">
                       <li class="page-item" v-if="startPage>1">
                           <a class="page-link" @click="prev()"><i class="fa fa-angle-double-left" aria-hidden="true"></i> 이전</a>
                       </li>
                       
                       <li :class="i===curpage?'page-item active':'page-item'" v-for="i in range(startPage,endPage)">
                           <a class="page-link" @click="pageChange(i)">{{i}}</a>
                       </li>
            
                       <li class="page-item" v-if="endPage<totalpage">
                           <a class="page-link" @click="next()">다음 <i class="fa fa-angle-double-right" aria-hidden="true"></i></a>
                       </li>
                   </ul>
               </nav>
               <div class="page-status">
                   <p>{{curpage}} page / {{totalpage}} pages</p>
               </div>
           </div>
       </div>

</div>




<script>
	let listApp=Vue.createApp({
	 data(){
		 return {
			 kboGoods_list:[],
			 curpage:1,
			 totalpage:0,
			 startPage:0,
			 endPage:0,
			 fd:''
		 }
	 },
	 mounted(){
		 this.dataRecv()
	 },
	 // 사용자 정의 함수 => 이벤트 처리 , 공통으로 적용 
	 methods:{
		 kboGoodsFind(){
			 //공란시 focus
			/* if(this.fd==="")
			{
				this.$refs.fd.focus()
				return 
			} */
			this.curpage=1
			this.dataRecv()
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
		 
		 // 공통으로 사용되는 함수 => 서버연결후에 데이터 읽기
		 dataRecv(){
			 axios.get('../kboGoods/find_vue.do',{
				 params:{
					 page:this.curpage,
					 fd:this.fd
				 }
			 }).then(response=>{
				 // 정상 수행시 => 데이터를 읽어온다 
				 console.log(response.data)
				 this.kboGoods_list=response.data.list
				 this.curpage=response.data.curpage
				 this.totalpage=response.data.totalpage
				 this.startPage=response.data.startPage
				 this.endPage=response.data.endPage
			 }).catch(error=>{
				 // 서버에서 에러 발생
				 alert(error.response)
				 console.log(error.response)
			 })
		 }
	 }
	}).mount('#listApp')
</script>
    
</body>
</html>