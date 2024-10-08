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
    <section class="single_blog_area section_padding_80" id="detailApp">
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
   									<img src="https://statiz.sporki.com${vo.image }" style="width:101px;height:134px">
   									&nbsp;&nbsp;<h3>${vo.name }</h3>
   									&nbsp;<img src="${vo.logo }" style="width:130px;height:130px">
   									&nbsp;<h3>${vo.team }</h3>
                            	</td>
                            </tr>
                            <tr>
                                <th width="20%" class="text-center">나이</th>
                                <td width="13%" class="text-center">${vo.age }</td>
                                <th width="20%" class="text-center">경기</th>
                                <td width="13%" class="text-center">${vo.game }</td>
                                <th width="20%" class="text-center">이닝</th>
                                <td width="14%" class="text-center">${vo.inning }</td>
                            </tr>
                            <tr>
                                <th width="20%" class="text-center">승</th>
                                <td width="13%" class="text-center">${vo.win }</td>
                                <th width="20%" class="text-center">패</th>
                                <td width="13%" class="text-center">${vo.lose }</td>
                                <th width="20%" class="text-center" style="color:red">평균자책점(ERA)</th>
                                <td width="14%" class="text-center" style="color:red">${vo.era }</td>
                            </tr>
                            <tr>
                                <th width="20%" class="text-center">피안타</th>
                                <td width="13%" class="text-center">${vo.hit }</td>
                                <th width="20%" class="text-center">탈삼진</th>
                                <td width="13%" class="text-center">${vo.strikeout }</td>
                                <th width="20%" class="text-center">볼넷</th>
                                <td width="14%" class="text-center">${vo.ball }</td>
                            </tr>
                            <tr>
                                <th width="20%" class="text-center">세이브</th>
                                <td width="13%" class="text-center">${vo.save }</td>
                                <th width="20%" class="text-center">홀드</th>
                                <td width="13%" class="text-center">${vo.hold }</td>
                                <th width="20%" class="text-center" style="color:red">WAR</th>
                                <td width="14%" class="text-center" style="color:red">${vo.war }</td>
                            </tr>
                        </table></div></aside></div></div></div></div></div></div></div></section>
	<script>
		
	</script>
</body>
</html>