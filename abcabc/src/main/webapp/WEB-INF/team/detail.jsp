<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vue 3 새 창 열기 예제</title>
    <script src="https://cdn.jsdelivr.net/npm/vue@3"></script>
</head>
<body><!-- 
	<div class="container">
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
	</div>-->
    <div class="container">
        <div class="header-top">
            <div class="row">
                <h4>Points Table</h4>
                <aside id="sidebar" class="left-bar">
                    <div class="feature-matchs">
                        <table class="table table-bordered table-hover">
                            <tr>
                                <th></th>
                                <th>이름</th>
                                <th>소속팀</th>
                                <th>나이</th>
                                <th>게임</th>
                                <th>홈런</th>
                                <th>안타</th>
                                <th>타점</th>
                                <th>볼넷</th>
                                <th>삼진</th>
                                <th>WAR</th>
                            </tr>
                            <tr>
                                <td>${vo.name }</td>
                                <td>
                                    <a href="#">${vo.syear }</a>
                                </td>
                               <td><img src="#" class="logo-image">${vo.content }</td>

                                <td>${vo.winyear }</td>
                                <td>${vo.home }</td>
                                <td>${vo.dyear }</td>
                                <td>${vo.oldteam }</td>
                                <td>${vo.logo }</td>
                                <td>${vo.rno }</td>
                                <td>${vo.mascot }</td>
                                <td>${vo.mimage }</td>
                            </tr>
                        </table>
                        </div></aside></div></div></div>

    
</body>
</html>
