<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
   <!-- Basic -->
   <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <!-- Mobile Metas -->
   <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
   <!-- Site Metas -->
   <title>2S3B</title>
   <meta name="keywords" content="">
   <meta name="description" content="">
   <meta name="author" content="">
   <!-- Site Icons -->
   <link rel="shortcut icon" href="" type="image/x-icon" />
   <link rel="apple-touch-icon" href="">
   <!-- Bootstrap CSS -->
   <link rel="stylesheet" href="../css/bootstrap.min.css">
   <!-- Site CSS -->
   <link rel="stylesheet" href="../css/style.css">
   <!-- Colors CSS -->
  <!--  <link rel="stylesheet" href="../css/colors.css"> -->
   <!-- ALL VERSION CSS -->	
<!--    <link rel="stylesheet" href="../css/versions.css"> -->
   <!-- Responsive CSS -->
   <link rel="stylesheet" href="../css/responsive.css">
   <!-- Custom CSS -->
   <link rel="stylesheet" href="../css/custom.css">
   <!-- font family -->
   <link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
   <!-- end font family -->
   <link rel="stylesheet" href="../css/3dslider.css" />
   <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
   <link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
   <script src="../js/3dslider.js"></script>
       <!-- VueJS -->
    <script src="https://unpkg.com/vue@3"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<style type="text/css">
body {
    background-color: #f5f5f5;
}
.layout{
	display: flex;
    gap: 50px;
    justify-content: center;
}
/* 헤더를 전체 페이지 너비로 확장 */
.inner-page-banner {
    width: 100%; /* 전체 너비 */
    background-color: #f5f5f5; /* 헤더 배경색 */
    padding: 20px 0; /* 상하 패딩 */
    box-sizing: border-box;
}


/* 마이페이지를 감싸는 큰 네모 박스 */
.mypage-container {
    width: 100%;
    max-width: 1200px; /* 적당한 최대 너비 */
    margin: 0 auto; /* 가운데 정렬 */
    padding: 20px; /* 내부 여백 */
    border: 2px solid #003366; /* 테두리 추가 */
    border-radius: 10px; /* 모서리 둥글게 */
    background-color: #fff; /* 배경색 */
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1); /* 그림자 효과 */
}

/* 테이블 스타일 */
.table {
    width: 100%;
    border-collapse: collapse; /* 테이블 셀 간격 없애기 */
}

.table th, .table td {
    padding: 12px 15px; /* 테이블 셀 내부 여백 */
    border-bottom: 1px solid #ddd; /* 행 사이에 구분선 */
    text-align: center;
}

.table th {
    background-color: #f7f7f7; /* 헤더 배경색 */
    font-weight: bold;
}

.table td a {
    color: #333;
    text-decoration: none;
}

.table td a:hover {
    text-decoration: underline;
}

/* 버튼 스타일 */
.btn-xs {
    padding: 5px 10px;
    font-size: 12px;
}

.btn-success {
    background-color: #28a745;
    color: white;
}

.btn-danger {
    background-color: #dc3545;
    color: white;
}

.text-center {
    margin-top: 20px;
}

/* 페이지 이동 버튼 */
.text-center {
    margin-top: 20px;
}

.container {
    margin-bottom: 50px;
}

.breadcrumb {
    list-style: none;
    border-radius: 4px;
    margin-top: 20px;
    float : right;
}


</style>

   </head>
	<body>
	
  <!-- ****** Header Start ****** -->
    <tiles:insertAttribute name="header"/>
    <!-- ****** Header End ****** -->
    
    <section id="top">
         
         <div class="inner-information-text" style="background-color: #fff;">
            <div class="container">
               <h3>마이페이지</h3>
               <ul class="breadcrumb" style="border-radius: 4px; padding: 8px 15px;" >
                  <li><a href="../main/main.do">Home</a></li>
                  <li class="active">MyPage</li>
               </ul>
            </div>
         </div>
      </section>
      
    <!-- ****** Home Start ****** -->
    <section class="archive-area section_padding_80">
        <div class="container">
        <div class="padding" style="height:50px;"></div>
            <div class="row layout">
			    <div class="col-sm-2">
			    	<tiles:insertAttribute name="mypage_menu"/>
			    </div>
			    <div class="col-sm-10">
			    	<tiles:insertAttribute name="mypage_home"/>

			   </div>
			</div>
		</div>
	</section>
    <!-- ****** Home End ****** -->


    <!-- ****** Footer Start ****** -->
    <tiles:insertAttribute name="footer"/>
    <!-- ****** Footer End ****** -->

      <a href="#home" data-scroll class="dmtop global-radius"><i class="fa fa-angle-up"></i></a>
      <!-- ALL JS FILES -->
      <script src="../js/all.js"></script>
      <!-- ALL PLUGINS -->
      <script src="../js/custom.js"></script>
   </body>
</html>