<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.page-link:hover{
	cursor: pointer;
}
</style>
</head>
<body>
	<!-- ****** Breadcumb Area Start ****** -->
    <div class="breadcumb-area" style="background-image: url(../img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
                        <h2>맛집 검색</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="breadcumb-nav">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"></li>
                            <input type="text" size="25" ref="fd" v-model="fd">
                        </ol>
                    </nav>
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
                <div class="col-12 col-md-6 col-lg-4" v-for="vo in food_list">
                    <div class="single-post wow fadeInUp" data-wow-delay="0.1s">
                        <!-- Post Thumb -->
                        <div class="post-thumb">
                        	<a :href="'../food/detail_before.do?fno='+vo.fno">
                            	<img :src="'http://www.menupan.com'+vo.poster" style="width:350px;height:200px">
                            </a>
                        </div>
                        <!-- Post Content -->
                        <div class="post-content">
                            <div class="post-meta d-flex">
                                <div class="post-author-date-area d-flex">
                                    <!-- Post Author -->
                                    <div class="post-author">
                                        <a href="#">{{vo.type}}</a>
                                    </div>
                                    <!-- Post Date -->
                                    <div class="post-date">
                                        <a href="#" style="color:orange">{{vo.score}}</a>
                                    </div>
                                </div>
                                <!-- Post Comment & Share Area -->
                                <div class="post-comment-share-area d-flex">
                                    <!-- Post Favourite -->
                                    <div class="post-favourite">
                                        <a href="#"><i class="fa fa-heart-o" aria-hidden="true"></i> {{vo.hit}}</a>
                                    </div>
                                    <!-- Post Comments -->
                                    <div class="post-comments">
                                        <a href="#"><i class="fa fa-comment-o" aria-hidden="true"></i> 12</a>
                                    </div>
                                    <!-- Post Share -->
                                    <div class="post-share">
                                        <a href="#"><i class="fa fa-share-alt" aria-hidden="true"></i></a>
                                    </div>
                                </div>
                            </div>
                            <a :href="'../food/detail_before.do?fno='+vo.fno">
                                <h4 class="post-headline">{{vo.name}}</h4>
                            </a>
                        </div>
                    </div>
                </div>

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
                            <p>{{curpage}} / {{totalpage}}</p>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </section>
    <script>
    	let findApp=Vue.createApp({
    		data(){
    			return{
    				food_list:[],
    				curpage:1,
    				totalpage:0,
    				startPage:0,
    				endPage:0,
    				fd:'동작'
    			}
    		},
    		// window.onload => 시작과 동시에 (브라우저에 출력하기 전 : 출력할 데이터를 서버로부터 읽기)
    		mounted(){
    			this.dataRecv()
    		},
    		// 사용자 정의 함수 => 이벤트 처리, 공통으로 적용
    		methods:{
    			// 공통으로 사용되는 함수 => 서버 연결 후에 데이터 읽기
    			dataRecv(){
    				axios.get('../food/find_vue.do',{
    					params:{
    						page:this.curpage,
    						fd:this.fd
    					}
    				}).then(response=>{
    					// 정상 수행 시 => 데이터를 읽어 온다
    					console.log(response.data)
    				}).catch(error=>{
    					// 서버에서 에러 발생 시 사용
    					console.log(error.response)
    				})
    			}
    		},
    		// 데이터가 갱신되는 경우
    		updated:{
    			
    		},
    		// components, computed, watch, filter
    		// components => Chef, Seoul / filter => Goods
    	})
    </script>
    <!-- ****** Archive Area End ****** -->
</body>
</html>