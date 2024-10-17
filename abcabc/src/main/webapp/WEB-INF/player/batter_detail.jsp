<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
google.charts.load('current', {packages: ['corechart', 'bar']});
</script>
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
	<div class="breadcumb-area" style="background-image: url(../img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
                        <h2></h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="breadcumb-nav">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    
                </div>
            </div>
        </div>
    </div>
    <section class="single_blog_area section_padding_80" id="chartApp">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-12 col-lg-8">
                    <div class="row no-gutters">

                        <!-- Single Post -->
                        <div class="col-12 col-sm-12">
                            
                            <!-- Related Post Area -->
                            <div class="related-post-area section_padding_50">
                              
                                <div class="related-post-slider owl-carousel">
                                    <!-- Single Related Post-->
	                                    <div class="single-post">
	                                        <!-- Post Thumb -->
	                                        <div class="post-thumb">
	                                            <img src="#" alt="">
	                                        </div>
	                                    </div>
                                </div>
                            </div>
                            
        <div class="header-top">
            <div class="row">
                <h4>Points Table</h4>
                <aside id="sidebar" class="left-bar">
                    <div class="feature-matchs text-center">
                        <table class="table table-bordered table-hover" style="font-size:16px;margin:0 auto">
                            <tr>
                            	<td colspan="6" class="text-center">
   									<img :src="'https://statiz.sporki.com'+vo.image" style="width:101px;height:134px">
   									&nbsp;&nbsp;<h3>{{vo.name}}</h3>
   									&nbsp;<img :src="vo.logo" style="width:130px;height:130px">
   									&nbsp;<h3>{{vo.team}}</h3>
                            	</td>
                            </tr>
                            <tr>
                                <th width="20%" class="text-center">나이</th>
                                <td width="13%" class="text-center">{{vo.age}}</td>
                                <th width="20%" class="text-center">경기</th>
                                <td width="13%" class="text-center">{{vo.game}}</td>
                                <th width="20%" class="text-center" style="color:red">타율</th>
                                <td width="14%" class="text-center" style="color:red">{{vo.avg}}</td>
                            </tr>
                            <tr>
                                <th width="20%" class="text-center">안타</th>
                                <td width="13%" class="text-center">{{vo.h1}}</td>
                                <th width="20%" class="text-center">2루타</th>
                                <td width="13%" class="text-center">{{vo.h2}}</td>
                                <th width="20%" class="text-center">3루타</th>
                                <td width="14%" class="text-center">{{vo.h3}}</td>
                            </tr>
                            <tr>
                                <th width="20%" class="text-center">홈런</th>
                                <td width="13%" class="text-center">{{vo.homerun}}</td>
                                <th width="20%" class="text-center">타점</th>
                                <td width="13%" class="text-center">{{vo.rbi}}</td>
                                <th width="20%" class="text-center">도루</th>
                                <td width="14%" class="text-center">{{vo.steel}}</td>
                            </tr>
                            <tr>
                                <th width="20%" class="text-center">삼진</th>
                                <td width="13%" class="text-center">{{vo.strikeout}}</td>
                                <th width="20%" class="text-center">볼넷</th>
                                <td width="13%" class="text-center">{{vo.ball}}</td>
                                <th width="20%" class="text-center" style="color:red">WAR</th>
                                <td width="14%" class="text-center" style="color:red">{{vo.war}}</td>
                            </tr>
                         </table></div></aside></div></div></div></div></div>
                        
                        </div>
                        <div>
                        </div>
                        	<div id="chart_div" style="width: 900px; height: 500px;"></div>
                        	<div style="height:80px"></div>
                        	<div id="chart2_div" style="width: 900px; height: 500px;"></div>
                        	<div style="height:80px"></div>
                        </div></section>
    	
	<script>
		let chartApp=Vue.createApp({
			data(){
				return{
					vo:{},
					bno:${bno}
				}
			},
			mounted(){
				axios.get('../player/batter_detail_vue.do',{
					params:{
						bno:this.bno
					}
				}).then(response=>{
					console.log(response.data)
					this.vo=response.data
					
					this.drawDetailChart()
					this.drawImportantChart()
				}).catch(error=>{
					console.log(error.response)
				})
				
			},
			methods:{
				drawDetailChart() {
				      var data = google.visualization.arrayToDataTable([
				        ['', '김도영 (Do-Yeong Kim)', this.vo.name],
				        ['경기수', 141, this.vo.game],
				        ['안타', 189, this.vo.h1],
				        ['2루타', 29, this.vo.h2],
				        ['3루타', 10, this.vo.h3],
				        ['홈런', 38, this.vo.homerun],
				        ['타점', 109, this.vo.rbi],
				        ['볼넷', 66, this.vo.ball],
				        ['삼진', 110, this.vo.strikeout],
				        ['도루', 40, this.vo.steel]
				      ]);

				      var materialOptions = {
				        chart: {
				          title: this.vo.name+'와(과) 김도영 (Do-Yeong Kim)의 세부 기록 비교 차트',
				          subtitle: '비교 항목 : 경기수, 안타, 2루타, 3루타, 홈런, 타점, 볼넷, 삼진, 도루'
				        },
				        hAxis: {
				          title: '',
				          minValue: 0,
				        },
				        vAxis: {
				          title: 'City'
				        },
				        bars: 'horizontal'
				      };
				      var materialChart = new google.charts.Bar(document.getElementById('chart_div'));
				      materialChart.draw(data, materialOptions);
				    },
			
				drawImportantChart() {
				      var data = google.visualization.arrayToDataTable([
				        ['', '김도영 (Do-Yeong Kim)', this.vo.name],
				        ['WAR(승리기여도)', 8.32, this.vo.war],
				        ['타율', 0.347, this.vo.avg]
				      ]);

				      var materialOptions = {
				        chart: {
				          title: this.vo.name+'와(과) 김도영 (Do-Yeong Kim)의 WAR, 타율 기록 비교 차트',
				          subtitle: '비교 항목 : WAR(승리기여도), 타율'
				        },
				        hAxis: {
				          title: '',
				          minValue: 0,
				        },
				        vAxis: {
				          title: 'City'
				        },
				        bars: 'horizontal'
				      };
				      var materialChart = new google.charts.Bar(document.getElementById('chart2_div'));
				      materialChart.draw(data, materialOptions);
				    }
			}
		}).mount('#chartApp')
	</script>
</body>
</html>