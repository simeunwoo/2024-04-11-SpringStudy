<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue@3"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.table tr td {
    vertical-align: middle;
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
<section class="single_blog_area section_padding_20" id="rankingApp">
        <div class="container">
            <div class="row justify-content-center">
              
			    <table class="table">
			     
			     <tr>
			      <th class="text-center" class="text-right" width="20%">연도</th>
			      <td width="80%">
			       <select class="input-sm" @change="teamRanking(year)" name="year" ref="year" v-model="year">
			       <option v-for="year in years" :key="year" :value="year">{{year}}년</option>
			       </select>
			      </td>
			     </tr>
			      <table class="table table-bordered table-hover">
                            <tr>
                                <th width="7%" class="text-center">순위</th>
                                <th width="25%" class="text-center">팀</th>
                                <th width="13%" class="text-center">경기수</th>
                                <th width="10%" class="text-center">승</th>
                                <th width="10%" class="text-center">무</th>
                                <th width="10%" class="text-center">패</th>
                                <th width="10%" class="text-center">승차</th>
                                <th width="15%" class="text-center">승률</th>
                            </tr>
                            <tr v-for="vo in selectedList">
                                <td class="text-center">{{vo.ranking}}</td>
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;<img :src="vo.logo" style="width:45px;height:45px" class="logo-image">
                                  &nbsp;&nbsp;{{vo.team}}</td>
                                <td class="text-center">{{vo.game}}</td>
                                <td class="text-center">{{vo.win}}</td>
                                <td class="text-center">{{vo.draw}}</td>
                                <td class="text-center">{{vo.lose}}</td>
                                <td class="text-center">{{vo.cha}}</td>
                                <td class="text-center">{{vo.winper}}</td>
                            </tr>
                        </table>
			    </table>
            </div>
        </div>
    </section>
    <script>
    	let rankingApp=Vue.createApp({
    		data(){
    			return{
    				list:[],
    				years:[],
    				year:2024,
    				selectedList:[] // 선택된 연도의 데이터
    			}
    		},
    		mounted(){
    			this.dataRecv()
    			this.yearList()
    		},
    		methods:{
    			teamRanking(year){
    				console.log("선택 연도 : "+year)
    				this.selectedList=this.list.filter(vo=>vo.year===year.toString())
    				console.log(this.selectedList);
    			},
    			dataRecv(){
    				axios.get('../team/ranking_vue.do',{
    					params:{
    						year:this.year
    					}
    				}).then(response=>{
        				console.log(response.data)
        				this.list=response.data.list
        				this.year=response.data.year
        				
        				this.selectedList=this.list.filter(vo=>vo.year===this.year)
        			}).catch(error=>{
        				console.log(error.response)
        			})
    			},
    			yearList(){
    				for(let i=1982;i<=2024;i++)
    				{
    					this.years.push(i)
    				}
    			}
    		}
    	}).mount('#rankingApp')
    </script>
</body>
</html>