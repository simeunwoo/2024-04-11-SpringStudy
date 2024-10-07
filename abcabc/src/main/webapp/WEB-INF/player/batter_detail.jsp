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
                        <h2>{{vo.name}}</h2>
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
    <section class="single_blog_area section_padding_80">
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
                                    <c:forTokens items="${vo.images }" delims="^" var="img">
	                                    <div class="single-post">
	                                        <!-- Post Thumb -->
	                                        <div class="post-thumb">
	                                            <img src="http://www.menupan.com${img }" alt="">
	                                        </div>
	                                    </div>
                                    </c:forTokens>
                                </div>
                            </div>
                            <table class="table">
                              <tr>
                                <td width="30%" class="text-center">
                                	<img src="http://www.menupan.com${vo.poster }" style="width:100%">
                                </td>
                                <td colspan="2">
                                	<h3>${vo.name }&nbsp;<span style="color:orange">${vo.score }</span></h3>
                                </td>
                              </tr>
                              <tr>
                              	<td width="15%" class="text-center">주소</td>
                              	<td width="55%" class="text-center">${vo.address }</td>
                              </tr>
                              <tr>
                              	<td width="15%" class="text-center">전화</td>
                              	<td width="55%" class="text-center">${vo.phone }</td>
                              </tr>
                              <tr>
                              	<td width="15%" class="text-center">음식 종류</td>
                              	<td width="55%" class="text-center">${vo.type }</td>
                              </tr>
                              <tr>
                              	<td width="15%" class="text-center">주차</td>
                              	<td width="55%" class="text-center">${vo.parking }</td>
                              </tr>
                              <tr>
                              	<td width="15%" class="text-center">영업 시간</td>
                              	<td width="55%" class="text-center">${vo.time }</td>
                              </tr>
                            </table>
                            <table class="table">                            	
                            	<tr>
                            		<td>${vo.theme }</td>
                            	</tr>
                            	<tr>
                            		<td>${vo.content }</td>
                            	</tr>
                            	<tr>
                            		<td class="text-right">
                            			<a href="#" class="btn btn-xs btn-danger">굿</a>
                            			<a href="#" class="btn btn-xs btn-success">찜</a>
                            			<a href="#" class="btn btn-xs btn-info">예약</a>
                            			<a href="../food/list.do" class="btn btn-xs btn-warning">목록</a>
                            		</td>
                            	</tr>
                            	<tr>
                            		<td>
                            			<div id="map" style="width:100%;height:350px"></div>
                            		</td>
                            	</tr>
                            </table>
</body>
</html>