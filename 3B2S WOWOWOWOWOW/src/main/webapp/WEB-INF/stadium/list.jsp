<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<style type="text/css">
.stadium-post-widget {
    margin-bottom: 30px;
    border: 1px solid #ebebeb; 
    border-radius: 8px;
    overflow: hidden;
}
.stadium-post-widget .image-container {
    position: relative;
    overflow: hidden;
}
.stadium-post-widget img {
    width: 100%; 
    height: 220px;
    object-fit: fill; 
    border-top-left-radius: 8px;
    border-top-right-radius: 8px;
    transition: transform 0.3s ease;
}
.stadium-post-widget .overlay {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.3);
    opacity: 0; 
    transition: opacity 0.3s ease;
    border-top-left-radius: 8px;
    border-top-right-radius: 8px;
}
.stadium-post-widget .image-container:hover img {
    transform: scale(1.05);
}
.stadium-post-widget .image-container:hover .overlay {
    opacity: 1; 
}
.stadium-post-detail {
    margin-top: 15px;
    margin-bottom: 5px;
    margin-left: 10px;
    margin-right: 10px;
    padding-left: 10px;
    display: flex;
    justify-content: space-between;
    align-items: center;
}
.stadium-post-detail .info {
    display: block;
}
.stadium-post-detail .btn {
    padding: 12px 25px;
    background-color: #003366;
    color: white;
    transform: translate(-10px, -8px);
    transition: background-color 0.3s ease;
}
.stadium-post-detail .btn:hover {
    background-color: #000;
}
.stadium-post-detail h2 {
    margin-bottom: -10px;
}
.stadium-post-detail h2 a:hover {
    color: #666; 
}
span.loc {
    display: inline-block;
    margin-bottom: 8px;
}
</style>
</head>
<body>
    <section>
        <div class="stadium-page-banner">
            <div class="container">
            </div>
        </div>
        <div class="inner-information-text">
            <div class="container">
                <h3>Stadium</h3>
                <ul class="breadcrumb">
                    <li><a href="../main/main.do">Home</a></li>
                    <li class="active"><a href="../stadium/list.do">Stadium</a></li>
                </ul>
            </div>
        </div>
    </section>

    <section class="contant" id="listApp" style="margin-top: 50px;margin-bottom: 30px;">
    <div class="container">
        <div class="row">
          <c:forEach var="vo" items="${list }">
            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                <div class="stadium-post-widget">
                    <a href="../stadium/detail.do?no=${vo.no }">
                      <div class="image-container">
                        <img src="${vo.poster}" alt="" class="img-responsive">
                        <div class="overlay"></div>
                       </div>
                    </a>
                    <div class="stadium-post-detail">
                        <div class="info">
                            <h2 class="clamp-text-one-line">
                                <a href="../stadium/detail.do?no=+${vo.no }">${vo.name}</a>
                            </h2>
                            <span class="loc">${vo.location} / ${vo.hometeam}</span>
                        </div>
                        <a class="btn" href="../stadium/detail.do?no=+${vo.no }"><i class="fas fa-arrow-right"></i></a>
                    </div>
                </div>
            </div>
           </c:forEach>
        </div>
    </div>
    </section> 

</body>
</html>