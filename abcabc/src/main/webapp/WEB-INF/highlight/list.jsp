<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>

</head>
<div class="top_space"  style="height: 220px;"></div>

<!-- 제목 -->
<div class="breadcumb-area">
    <div class="container h-100">
        <div class="row h-100 align-items-center">
            <div class="col-12">
                <div class="bradcumb-title text-center">
                    <h2>하이라이트</h2>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 검색 -->
<div class="breadcumb-nav">
        <div class="container">
            <div class="row text-center">
                <div class="col-10">
                    <select id="helightSelect">
                    	<option></option>
                    	<option></option>
                    </select>
                    <input type="text" size=65 class="input-sm" name="highlightSearch" ref="highlightSearch" v-model="highlightSearch">
                </div>
            </div>
        </div>
    </div>
<!-- ****** Breadcumb Area End ****** -->


<!-- ****** Archive Area Start ****** -->
<section class="archive-area section_padding_80" id="listApp">
    <div class="container">
        <div class="row">
            <!-- Single Post -->
            <div class="col-10 col-md-6 col-lg-4" v-for="vo in food_list">
                <div class="single-post wow fadeInUp" data-wow-delay="0.1s">
                    <!-- Post Thumb -->
                    <div class="highlight_thumbnails">
                       <a :href="'../food/detail_before.do?fno='+vo.fno">
                        <img :src="vo.thumbnails" style="width: 200px;height: 150px">
                       </a>
                    </div>
                    <!-- Post Content -->
                    <div class="post-content">
                        <div class="post-meta d-flex">


                        </div>
                        <a :href="'../food/detail_before.do?fno='+vo.fno">
                            <h4 class="post-headline">{{vo.title}}</h4>
                        </a>
                    </div>
                </div>
            </div>
            
            <ul class="boardPhoto">
				<li>
					<span class="photo"><a href="#"><img src="//lgcxydabfbch3774324.cdn.ntruss.com/KBO_FILE/news%2fimages%2f2024%2f10%2f13%2f202410131443770305_670b756432311.jpg" alt="" style="width: 50px; height:30px; "></a></span>
					<div class="txt">
						<strong><a href="#">‘홈런포 3방+레예스 QS투’ 삼성, LG 10-4 완파하며 1차전 선승</a></strong>
						<p>프로야구 삼성 라이온즈가 LG 트윈스 꺾고 1차전 기선을 제압했다
							<span class="text-left">{{publishedAt}}</span>
						</p>
					</div>
				</li>
			</ul>

            

            <div class="col-12">
                <div class="pagination-area d-sm-flex mt-15">
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
    </div>
</section>

<!-- <script type="text/javascript">
    $(document).ready(function() {
        $.ajax({
            type: "GET",
            dataType: "json",
            url: "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&status=&playlistId=PLuY-NTS_5IpzwH3FfskfFOrnui5O5NlkC&key=AIzaSyBIGT4K45TpQVfaN7Uta1gxYfRdWdbtFD0",
            contentType : "application/json",
            success : function(data) {
                data.items.forEach(function(element, index) {
                    $('body').append('<iframe width="560" height="315" src="https://www.youtube.com/embed/'+element.id.videoId+'" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>');
                });
            },
            complete : function(data) {
            },
            error : function(xhr, status, error) {
                console.log("유튜브 요청 에러: "+error);
            }
        });
    });
</script>	 -->

<script>
 let listApp=Vue.createApp({
	 //Model => 데이터관리 
	 data(){
		 return  {
			 food_list:[],
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
				 start++;
			 }
			 return arr
		 },
		 dataRecv(){
			 axios.get('../food/list_vue.do',{
				params:{
					 page:this.curpage
				}
			 }).then(response=>{
				 console.log(response.data)
				 this.food_list=response.data.list
				 this.curpage=response.data.curpage
				 this.totalpage=response.data.totalpage
				 this.startPage=response.data.startPage
				 this.endPage=response.data.endPage
			 }).catch(error=>{
				 console.log(error.response)
			 })
		 }
	 }
 }).mount('#listApp')
</script>
    
</body>
</html>