<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                <th>이름</th>
                                <th>창단연도</th>
                                <th>내용</th>
                                <th>우승연도</th>
                                <th>연고지</th>
                                <th>사라진연도</th>
                                <th>조상팀</th>
                                <th>로고</th>
                                <th>영구결번</th>
                                <th>마스코트</th>
                                <th>이미지</th>
                            </tr>
                            <tr>
                                <td>${vo.name }</td>
                                <td>
                                    <a href="${vo.logo}">${vo.syear }</a>
                                </td>
                               <td><img src="${vo.logo}" class="logo-image">${vo.content }</td>

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
                        
                        <!--
                        $('#dialog').dialog({
							autoOpen:false,
							modal:true
                        -->

    
</body>
</html>
