<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
                  <li class="active">GnD</li>
               </ul>
            </div>
         </div>
      </section>
      
   <section id="contant" class="contant main-heading team" >
         <div class="row">
            <div class="container">
               <div class="col-md-9">
                  <!-- 반복 -->
                  
                  <div class="feature-post small-blog" v-for="vo in gnd_list" :key="vo.hno">
                     <div class="col-md-4">
                        <div class="feature-img">
                           <img :src="vo.image" class="img-responsive" style="width:150px;height:90px;" />
                        </div>
                     </div>
                     <div class="col-md-8">
                        <div class="feature-cont">
                           <div class="post-info">
                              <span>
                                 <h4>{{vo.content}}&nbsp;<a href="#" style="color:orange">{{vo.team}}</a></h4>
                              </span>
                           </div>
                           </div>
                            
                           <div class="post-heading">
                              <div class="full">
                                 <a class="btn" href="#">더보기</a>
                              </div>
                           </div>
                     </div>
                  </div>
                  
                 <div class="col-md-9">
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
                <div class="col-md-3">
                  
                  <div class="blog-sidebar">
                     <h4 class="heading">야구장목록</h4>
                     <div class="category-menu">
                        <ul>
                           <li><a href="#" @click="findteam('KIA타이거즈')" >KIA타이거즈</a></li>
                           <li><a href="#" @click="findteam('삼성라이온즈')">삼성라이온즈</a></li>
                           <li><a href="#" @click="findteam('LG트윈스')">LG트윈스</a></li>
                           <li><a href="#" @click="findteam('두산베어스')">두산베어스</a></li>
                           <li><a href="#" @click="findteam('KT위즈')">KT위즈</a></li>
                           <li><a href="#" @click="findteam('SSG랜더스')">SSG랜더스</a></li>
                           <li><a href="#" @click="findteam('롯데자이언츠')">롯데자이언츠</a></li>
                           <li><a href="#" @click="findteam('한화이글스')">한화이글스</a></li>
                           <li><a href="#" @click="findteam('NC다이노스')">NC다이노스</a></li>
                           <li><a href="#" @click="findteam('키움히어로즈')">키움히어로즈</a></li>
                           <li><a href="#" @click="findteam('국대')">국대</a></li>
                        </ul>
                     </div>
                  </div>
                 
               
                </div>
                </div>
                </section>
                
                <script>
                let listApp=Vue.createApp({
                    data(){
                       return {
                          gnd_list:[],
                          curpage:1,
                          totalpage:0,
                          startPage:0,
                          endPage:0,
                          teamName:''
                          
                       }
                    },
                    mounted(){
                       this.dataRecv()
                    },
                    methods:{
                    	findteam(teamName) {
                    		this.teamName = teamName
                    		console.log(teamName)
                    		 axios.get('../gnd/team_vue.do',{
                                 params:{
                                	 page:this.curpage,
                                	 team:teamName
                                 }
                              }).then(response=>{
                                 console.log(response.data)
                                 this.gnd_list=response.data.list
                                 this.curpage=response.data.curpage
                                 this.totalpage=response.data.totalpage
                                 this.startPage=response.data.startPage
                                 this.endPage=response.data.endPage
                              }).catch(error=>{
                                 console.log(error.response)
                              })
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
                     dataRecv(){
                        axios.get('../gnd/list_vue.do',{
                           params:{
                              page:this.curpage
                           }
                        }).then(response=>{
                           console.log(response.data)
                           this.gnd_list=response.data.list
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