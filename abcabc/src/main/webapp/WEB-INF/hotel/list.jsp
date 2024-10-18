<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.inner-page-banner{
	width:10px;
}
.image{
	float: left;
	padding : 0.5px;
}
</style>
</head>
<body>
<section id="top">
         <div class="inner-page-banner">
            <div class="container">
            </div>
         </div>
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
      
	<section id="contant" class="contant main-heading team" >
         <div class="row">
            <div class="container">
               <div class="col-md-9">
                  <!-- 반복 -->
                  
                  <div class="feature-post small-blog" v-for="vo in hotel_list" :key="vo.hno">
                     <div class="col-md-4">
                        <div class="feature-img">
                           <img :src="vo.poster" class="img-responsive" alt="#" />
                        </div>
                     </div>
                     <div class="col-md-8">
                        <div class="feature-cont">
                           <div class="post-info">
                              <span>
                                 <h4>{{vo.name}}&nbsp;<a href="#" style="color:orange">{{vo.score}}</a></h4>
                                 <h5>{{vo.address}}</h5>
                              </span>
                           </div>
                           </div>
                            <div class="image" v-for="hvo in vo.imagesList" :key="hvo"  >
                                <img :src="hvo" alt="" style="width:100px;height:100px; ">
                            </div>
                           <div class="post-heading">
                              <div class="full">
                                 <a class="btn" :href="'../hotel/detail_before.do?hno='+vo.hno">더보기</a>
                              </div>
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
                  <!-- 반복 끝 -->
               </div>
               <div class="col-md-3">
                  <div class="blog-sidebar">
                     <div class="search-bar-blog">
                        <form>
                           <input type="text" placeholder="검색" />
                           <button><i class="fa fa-search" aria-hidden="true"></i></button>
                        </form>
                     </div>
                  </div>
                  <div class="blog-sidebar">
                     <h4 class="heading">야구장목록</h4>
                     <div class="category-menu">
                        <ul>
                           <li><a href="#">잠실야구장</a></li>
                           <li><a href="#">고척스카이돔</a></li>
                           <li><a href="#">수원 케이티 위즈파크</a></li>
                           <li><a href="#">랜더스필드</a></li>
                           <li><a href="#">이글스파크</a></li>
                           <li><a href="#">라이온즈파크</a></li>
                           <li><a href="#">챔피언스필드</a></li>
                           <li><a href="#">사직야구장</a></li>
                           <li><a href="#">NC파크</a></li>
                        </ul>
                     </div>
                  </div>
                 
               </div>
            </div>
         </div>
      </section>
      
      <script>
      	let listApp=Vue.createApp({
      		data(){
      			return {
      				hotel_list:[],
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
    					start++
    				}
    				return arr
    			},
    			dataRecv(){
    				axios.get('../hotel/list_vue.do',{
    					params:{
    						page:this.curpage
    					}
    				}).then(response=>{
    					console.log(response.data)
    					this.hotel_list=response.data.list
    					this.curpage=response.data.curpage
    					this.totalpage=response.data.totalpage
    					this.startPage=response.data.startPage
    					this.endPage=response.data.endPage
    				}).catch(error=>{
    					console.log(error.response)
    				})
    			}
      		}
      	}).mount('#contant')
      </script>
</body>
</html>