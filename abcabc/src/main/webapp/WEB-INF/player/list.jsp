<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue@3.2.45/dist/vue.global.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>
<div style="height:500px"></div>
<!-- Wrapper for slides -->
               <div class="carousel-inner" role="listbox">
                  <!-- First slide -->
                  <div class="item active deepskyblue" data-ride="carousel" data-interval="5000">
                  <img src="m1.jpg" alt="Slide 1 Image" style="width:900px;height:720px" class="img-fluid">
                     <div class="carousel-caption">
                        <div class="col-lg-7 col-md-7 col-sm-12 col-xs-12"></div>
                        <div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
                           <div class="slider-contant" data-animation="animated fadeInRight">
                              <h3>If you Don’t Practice<br>You <span class="color-yellow">Don’t Derserve</span><br>to win!</h3>
                              <p>If you use this site regularly and would like to help keep the site on the Internet,<br>
                                 please consider donating a small sum to help pay..
                              </p>
                              <button class="btn btn-primary btn-lg">Read More</button>
                           </div>
                        </div>
                     </div>
                  </div>
                  <!-- /.item -->
                  <!-- Second slide -->
                  <div class="item skyblue" data-ride="carousel" data-interval="5000">
                  <img src="m2.jpg" alt="Slide 1 Image" class="img-fluid">
                     <div class="carousel-caption">
                        <div class="col-lg-7 col-md-7 col-sm-12 col-xs-12"></div>
                        <div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
                           <div class="slider-contant" data-animation="animated fadeInRight">
                              <h3>If you Don’t Practice<br>You <span class="color-yellow">Don’t Derserve</span><br>to win!</h3>
                              <p>You can make a case for several potential winners of<br>the expanded European Championships.</p>
                              <button class="btn btn-primary btn-lg">Button</button>
                           </div>
                        </div>
                     </div>
                  </div>
                  <!-- /.item -->
                  <!-- Third slide -->
                  <div class="item darkerskyblue" data-ride="carousel" data-interval="5000">
                  <img src="m3.jpg" alt="Slide 1 Image" class="img-fluid">
                     <div class="carousel-caption">
                        <div class="col-lg-7 col-md-7 col-sm-12 col-xs-12"></div>
                        <div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
                           <div class="slider-contant" data-animation="animated fadeInRight">
                              <h3>If you Don’t Practice<br>You <span class="color-yellow">Don’t Derserve</span><br>to win!</h3>
                              <p>You can make a case for several potential winners of<br>the expanded European Championships.</p>
                              <button class="btn btn-primary btn-lg">Button</button>
                           </div>
                        </div>
                     </div>
                  </div>
                  <!-- /.item -->
               </div>

            <div class="container">
               <div class="header-top">
                  <div class="row">
				<h4>Points Table</h4>
                  <aside id="sidebar" class="left-bar">
                     <div class="feature-matchs">
                        <table class="table table-bordered table-hover">
                           <thead>
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
                           </thead>
                           <tbody>
                              <tr v-for="vo in bList">
                                 <td>{{vo.bno}}</td>
                                 <td>
                                 	<a :href="'../player/detail.do?bno='+vo.bno">{{vo.name}}</a>
                                 </td>
                                 <td><img :src="vo.logo">{{vo.team}}</td>
                                 <td>{{vo.age}}</td>
                                 <td>{{vo.game}}</td>
                                 <td>{{vo.win}}</td>
                                 <td>{{vo.lose}}</td>
                                 <td>{{vo.save}}</td>
                                 <td>{{vo.hold}}</td>
                                 <td>{{vo.era}}</td>
                                 <td>{{vo.war}}</td>
                              </tr>
                           </tbody>
                           <tfoot>
                           		<tr>
									<td colspan="5" class="text-center">
										<input type="button" class="btn btn-sm btn-success" value="이전" @click="bPrev()">
											{{bCurpage}} 페이지 / {{bTotalpage}} 페이지
										<input type="button" class="btn btn-sm btn-success" value="다음" @click="bNext()">
									</td>
								</tr>
                           </tfoot>
                        </table>
                     </div>
                  </aside></div></div></div>
	<script>
		let PlayerApp=Vue.createApp({
			data(){
				return{
					bList:[],
					pList:[],
					bCurpage:1,
					pCurpage:1,
					bTotalpage:0,
					pTotalpage:0,
				}
			},
			mounted(){
				this.dataRecv()
			},
			methods:{
				dataRecv(){
					axios.get('../player/list_vue.do',{
						params:{
							bPage:this.bCurpage,
							pPage:this.pCurpage
						}
					}).then(response=>{
						console.log(response.data)
						this.bList=response.data.bList
						this.pList=response.data.pList
						this.bCurpage=response.data.bCurpage
						this.pCurpage=response.data.pCurpage
						this.bTotalpage=response.data.bTotalpage
						this.pTotalpage=response.data.pTotalpage
					})
				},
				bPrev(){
					this.bCurpage=this.bCurpage>1?this.bCurpage-1:this.bCurpage
					this.dataRecv()
				},
				bNext(){
					this.bCurpage=this.bCurpage<this.bTotalpage?this.bCurpage+1:this.bCurpage
					this.dataRecv()
				},
				pPrev(){
					this.pCurpage=this.pCurpage>1?this.pCurpage-1:this.pCurpage
					this.dataRecv()
				},
				pNext(){
					this.pCurpage=this.pCurpage<this.pTotalpage?this.pCurpage+1:this.pCurpage
					this.dataRecv()
				}
			}
		}).mount('.container')
	</script>
</body>
</html>