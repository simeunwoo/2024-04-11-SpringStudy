<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- ****** Instagram Area Start ****** -->
	    <div class="instargram_area owl-carousel section_padding_100_0 clearfix" id="portfolio">
	
	        <!-- Instagram Item -->
	        <c:forEach var="vo" items="${cList }">
		        <div class="instagram_gallery_item">
		            <!-- Instagram Thumb -->
		            <img src="http://www.menupan.com${vo.poster }"class="img-rounded">
		            <!-- Hover -->
		            <div class="hover_overlay">
		                <div class="yummy-table">
		                    <div class="yummy-table-cell">
		                        <div class="follow-me text-center">
		                            <a href="../food/detail.com?fno=${vo.fno }"><i class="fa fa-instagram" aria-hidden="true"></i> ${vo.name }</a>
		                        </div>
		                    </div>
		                </div>
		            </div>
		        </div>
	        </c:forEach>
	    </div>
	    

    <!-- ****** Footer Menu Area Start ****** -->
    <footer class="footer_area">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="footer-content">
                        <!-- Logo Area Start -->
                        <div class="footer-logo-area text-center">
                            <a href="index.html" class="yummy-logo">Yummy Blog</a>
                        </div>
                        <!-- Menu Area Start -->
                        <nav class="navbar navbar-expand-lg">
                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#yummyfood-footer-nav" aria-controls="yummyfood-footer-nav" aria-expanded="false" aria-label="Toggle navigation"><i class="fa fa-bars" aria-hidden="true"></i> Menu</button>
                            <!-- Menu Area Start -->
                            <div class="collapse navbar-collapse justify-content-center" id="yummyfood-footer-nav">
                                <ul class="navbar-nav">
                                    <li class="nav-item active">
                                        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">Features</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">Categories</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">Archive</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">About</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">Contact</a>
                                    </li>
                                </ul>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-12">
                    <!-- Copywrite Text -->
                    <div class="copy_right_text text-center">
                        <p>제작 : 쌍용강북교육센터<i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">심은우</a></p>
                    </div>
                </div>
            </div>
        </div>
    </footer>
</body>
</html>