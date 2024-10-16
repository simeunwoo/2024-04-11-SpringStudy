<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
              
			    <table class="table" v-for="vo in list">
			     
			     <tr>
			      <th class="text-right" width="20%">연도</th>
			      <td width="80%">
			       <select class="input-sm" @change="teamRanking(vo.year)" name="year1" ref="year1" v-model="year1">
			        <option v-for="year in years" :key="year" :value="year">{{year}}</option>
			       </select>
			      </td>
			     </tr>
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
    				year1:2024
    			}
    		},
    		mounted(){
    			this.dataRecv()
    			this.yearList()
    		},
    		methods:{
    			teamRanking(year){
    				console.log("선택 연도 : "+year)
    			},
    			dataRecv(){
    				axios.get('../team/ranking_vue.do')
    				.then(response=>{
        				console.log(response.data)
        				this.list=response.data.list
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