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
                                <th width="20%" class="text-center">이닝</th>
                                <td width="14%" class="text-center">{{vo.inning}}</td>
                            </tr>
                            <tr>
                                <th width="20%" class="text-center">승</th>
                                <td width="13%" class="text-center">{{vo.win}}</td>
                                <th width="20%" class="text-center">패</th>
                                <td width="13%" class="text-center">{{vo.lose}}</td>
                                <th width="20%" class="text-center" style="color:red">평균자책점(ERA)</th>
                                <td width="14%" class="text-center" style="color:red">{{vo.era}}</td>
                            </tr>
                            <tr>
                                <th width="20%" class="text-center">피안타</th>
                                <td width="13%" class="text-center">{{vo.hit}}</td>
                                <th width="20%" class="text-center">탈삼진</th>
                                <td width="13%" class="text-center">{{vo.strikeout}}</td>
                                <th width="20%" class="text-center">볼넷</th>
                                <td width="14%" class="text-center">{{vo.ball}}</td>
                            </tr>
                            <tr>
                                <th width="20%" class="text-center">세이브</th>
                                <td width="13%" class="text-center">{{vo.save}}</td>
                                <th width="20%" class="text-center">홀드</th>
                                <td width="13%" class="text-center">{{vo.hold}}</td>
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
					pno:${pno}
				}
			},
			mounted(){
				axios.get('../player/pitcher_detail_vue.do',{
					params:{
						pno:this.pno
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
				        ['', '류현진 (Hyun-Jin Ryu)', this.vo.name],
				        ['경기수', 141, this.vo.game],
				        ['승', 189, this.vo.win],
				        ['패', 29, this.vo.lose],
				        ['피안타', 10, this.vo.hit],
				        ['볼넷', 38, this.vo.ball],
				        ['이닝', 109, this.vo.inning],
				        ['세이브', 66, this.vo.save],
				        ['홀드', 110, this.vo.hold]
				      ]);

				      var materialOptions = {
				        chart: {
				          title: this.vo.name+'와(과) 류현진 (Hyun-Jin Ryu)의 세부 기록 비교 차트',
				          subtitle: '비교 항목 : 경기수, 승, 패, 피안타, 볼넷, 이닝, 세이브, 홀드'
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
				        ['', '류현진 (Hyun-Jin Ryu)', this.vo.name],
				        ['WAR(승리기여도)', 9.34, this.vo.war],
				        ['ERA(평균자책점)', 1.82, this.vo.era]
				      ]);

				      var materialOptions = {
				        chart: {
				          title: this.vo.name+'와(과) 류현진 (Hyun-Jin Ryu)의 WAR, ERA 기록 비교 차트',
				          subtitle: '비교 항목 : WAR(승리기여도), ERA(평균자책점)'
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