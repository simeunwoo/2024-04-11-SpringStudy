<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
    </script>
<style>
 .container {
        text-align: center;
    }
    #chart_div, #chart2_div {
        display: block;
        margin: 0 auto;
    }
</style>
</head>
<body>
<section id="top">
	<div class="inner-information-text">
            <div class="container">
               <h3>Versus</h3>
               <ul class="breadcrumb">
                  <li><a href="../main/main.do">Home</a></li>
                  <li class="active">선수 기록 비교</li>
               </ul>
            </div>
         </div>
      </section>
	
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
    <section id="vsApp">
    	<div id="chart_div" style="width: 1200px; height: 800px;"></div>
    	<div id="chart2_div" style="width: 1200px; height: 800px;"></div>
    </section>
    <script>
    	let vsApp=Vue.createApp({
    		data(){
    			return{
    				bList:[],
    				pList:[]
    			}
    		},
    		mounted(){
    			axios.get('../player/vs_vue.do')
    			.then(response=>{
    				console.log(response.data)
    				this.bList=response.data.bList
    				this.pList=response.data.pList
    				
    				this.drawBatterChart()
    				this.drawPitcherChart()
    			}).catch(error=>{
    				console.log(error.response)
    			})
    		},
    		methods:{
    			drawBatterChart() {
    				var data = [['', '타율 & 승리기여도', { role: 'tooltip' }]]
    				  this.bList.forEach(bvo => {
    				    data.push([bvo.avg, bvo.war, bvo.name+' 타율:'+bvo.avg+', 승리기여도:'+bvo.war])
    				  })
    				var dataTable=google.visualization.arrayToDataTable(data)
    		        var options = {
    		          title: 'KBO 타자들의 타율 및 승리기여도 비교',
    		          hAxis: {title: '타율 (Average)', minValue: 0, maxValue: 0.5},
    		          vAxis: {title: '승리기여도 (WAR)', minValue: -1, maxValue: 9},
    		          legend: { position: 'right' },
    		          series: { 0: { color: 'red' } }
    		        };

    		        var chart = new google.visualization.ScatterChart(document.getElementById('chart_div'));

    		        chart.draw(dataTable, options);
    		      },
    		      drawPitcherChart() {
    		          var data = [['', '평균자책점 & 승리기여도', { role: 'tooltip' }]]
    		          this.pList.forEach(pvo=>{
    		        	  data.push([pvo.era, pvo.war, pvo.name+' 평균자책점:'+pvo.era+', 승리기여도:'+pvo.war])
    		          })
    		  		var dataTable=google.visualization.arrayToDataTable(data)
    		          var options = {
    		            title: 'KBO 투수들의 평균자책점 및 승리기여도 비교',
    		            hAxis: {title: '평균자책점 (ERA)', minValue: 0, maxValue: 12},
    		            vAxis: {title: '승리기여도 (WAR)', minValue: -1, maxValue: 10},
    		            legend: { position: 'right' }
    		          };

    		          var chart = new google.visualization.ScatterChart(document.getElementById('chart2_div'));

    		          chart.draw(dataTable, options);
    		        }
    		}
    	}).mount('#vsApp')
    </script>
</body>
</html>