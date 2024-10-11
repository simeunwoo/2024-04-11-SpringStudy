<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 
<script src="https://cdn.jsdelivr.net/npm/vue@3.2.45/dist/vue.global.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script> -->
    <script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
    .logo-image {
        width: 20px;
        height: 20px;
    }
</style>
</head>
<body>
		<div class="container">
		    <!-- 고정 이미지 -->
		    <div class="text-center" style="text-align: center;">
		        <img src="../player/m1.jpg" style="width:1200px;height:720px">
		        <div class="carousel-caption">
		            <div class="col-lg-7 col-md-7 col-sm-12 col-xs-12"></div>
		            <div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
		                <div class="slider-contant" data-animation="animated fadeInRight">
		                </div>
		            </div>
		        </div>
		    </div>
		</div>

            <div class="container" id="pitcherTable">
               <div class="header-top">
                  <div class="row">
                  <input type="text" size="25" ref="fd" v-model="fd" @keydown.enter="playerFind()">&nbsp;
	              <button style="width:70px;height:35px"class="btn-sm btn-primary" @click="playerFind()">검색</button>
	              <div style="height:10px"></div>
                  <aside id="sidebar" class="left-bar">
                     <div class="feature-matchs">
                     
                        <table class="table table-bordered table-hover">
                           
                              <tr>
                                 <th></th>
                                 <th>이름</th>
                                 <th>소속팀</th>
                                 <th>나이</th>
                                 <th>게임</th>
                                 <th>승</th>
                                 <th>패</th>
                                 <th>세이브</th>
                                 <th>홀드</th>
                                 <th>ERA</th>
                                 <th>WAR</th>
                              </tr>
                          
                              <tr v-for="vo in list">
                                 <td>{{vo.pno}}</td>
                                 <td>
                                 	<a :href="'../player/pitcher_detail.do?pno='+vo.pno">{{vo.name}}</a>
                                 </td>
                                 <td><img :src="vo.logo" class="logo-image">{{vo.team}}</td>
                                 <td>{{vo.age}}</td>
                                 <td>{{vo.game}}</td>
                                 <td>{{vo.win}}</td>
                                 <td>{{vo.lose}}</td>
                                 <td>{{vo.save}}</td>
                                 <td>{{vo.hold}}</td>
                                 <td>{{vo.era}}</td>
                                 <td>{{vo.war}}</td>
                              </tr>
                          
                        </table>
                        
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
                  </div></div></div>
                  </aside></div>
	<script>
		let playerApp=Vue.createApp({
			data(){
				return{
					list:[],
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
			methods:{
				playerFind(){
            		if(this.fd==="")
            		{
            			this.$refs.fd.focus()
            			return
            		}
            		this.curpage=1
            		this.dataRecv()
            	},
				prev() {
                    this.curpage=this.startPage-1
                    this.dataRecv()
                },
                next() {
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
					axios.get('../player/pitcher_list_vue.do',{
						params:{
							page:this.curpage,
							fd:this.fd
						}
					}).then(response=>{
						console.log(response.data)
						this.list=response.data.list
						this.curpage=response.data.curpage
						this.totalpage=response.data.totalpage
						this.startPage=response.data.startPage
                        this.endPage=response.data.endPage
                        /*
                        for(let i=0;i<this.list.length;i++)
                        {
                        	this.list[i].pno=i+1
                        } */
					}).catch(error=>{
						console.log(error.response)
					})
				}
			}
		}).mount('#pitcherTable')
	</script>
</body>
</html>