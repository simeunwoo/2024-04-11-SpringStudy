<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
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
   <link rel="stylesheet" href="../css/font-awesome.min.css">
   <link rel="stylesheet" href="../css/font-awesome.css">
   
   <link rel="shortcut icon" href="" type="image/x-icon" />
   <link rel="apple-touch-icon" href="">
   <!-- Bootstrap CSS -->
   <link rel="stylesheet" href="../css/bootstrap.min.css">
   <!-- Site CSS -->
   <link rel="stylesheet" href="../css/style.css">
   <!-- Colors CSS -->
   <link rel="stylesheet" href="../css/colors.css">
   <!-- ALL VERSION CSS -->	
   <link rel="stylesheet" href="../css/versions.css">
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
   <script src="../js/all.js"></script>
      <!-- ALL PLUGINS -->
      <script src="../js/custom.js"></script>

<meta charset="UTF-8">

<!-- 번역 스크립트 등 -->
<!-- 부분 번역금지 -->
<meta name="google" content="notranslate">
<!--  -->      
<script>    
$(document).ready(function(){        
	$(".trans>a").click(function(){
		$(this).next("div").toggleClass("languageselect");        
	});    
});
</script>
<!-- 번역 스크립트 -->
<script src="https://translate.google.com/translate_ax	/element.js?cb=googleTranslateElementInit"></script>
<script src="https://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
<script type="text/javascript">	
	/* 구글 번역 초기화 */
	function googleTranslateElementInit() {new google.translate.TranslateElement({pageLanguage: 'ko', includedLanguages : 'ko,en,zh-CN,ja', autoDisplay: false, layout: google.translate.TranslateElement.InlineLayout.HORIZONTAL}, 'google_translate_element');}
</script>

<style>




header {
  background-color: #003366; /* 헤더 배경색 */
  width: 100%;
}

.navbar, .container1 {
  margin: 0;
  padding: 0;
}
/* 위에 헤더 전체 색 적용*/
/*
*/
	.trans a{cursor:pointer;}
	.trans .languageselect{display:none;}
	
/* 번역기이미지 */
#transimgs{
height: 45px;
width: 60px;
}
/* 번역기 툴바 제거 */
	.VIpgJd-ZVi9od-ORHb-OEVmcd {
		display: none; // add !important if required 
  	}
/* 드롭다운 메뉴를 Match 버튼 바로 아래에 붙이기 */
.dropdown-menu.mega-dropdown-menu {
    position: absolute !important;
    top: 100% !important; /* Match 버튼 바로 아래 */
    left: 0 !important; /* 버튼의 왼쪽에 정렬 */
    padding: 10px !important;
    background-color: #003366 !important;
    border: 1px solid #003366 !important;
    box-shadow: 0 4px 8px rgba(0, 51, 102, 0.1) !important; /* 그림자 추가 */
}

/* 드롭다운 메뉴를 중앙 정렬 대신 Match 버튼에 맞춤 */
.dropdown.mega-dropdown {
    position: relative !important;
}

.menu-inner {
    list-style-type: none !important;
    padding-left: 0 !important;
    margin: 0 !important;
}

/* 텍스트가 줄바꿈되지 않도록 설정 */
.menu-inner li a {
    display: block !important;
    padding: 8px 15px !important;
    text-decoration: none !important;
    color: #fff !important;
    white-space: nowrap !important; /* 줄바꿈 방지 */
}

.menu-inner li a:hover {
    background-color: #003366 !important;
}

li.col-sm-4 {
    float: none !important;
    margin: 0 !important;
    text-align: left !important;
}
#flags{
	width:20px;
	height:10px;
}


.dropdown-toggle{
	color:white !important;
}
</style>


<title>2S3B</title>
</head>
  <body class="game_info" data-spy="scroll" data-target=".header">
      <!-- LOADER -->
      <div id="preloader">
         <img class="preloader" src="../images/loading-img.gif" alt="">
      </div>
      <!-- END LOADER -->
         <header>
            <div class="container container1"  >
               
               <div class="header-bottom">
                  <div class="row">
                     <div class="col-md-12">
                        <div class="full">
                           <div class="main-menu-section">
                              <div class="menu">
                                    <div class="navbar-header">
                                       <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".js-navbar-collapse">
                                       <span class="sr-only">Toggle navigation</span>
                                       <span class="icon-bar"></span>
                                       <span class="icon-bar"></span>
                                       <span class="icon-bar"></span>
                                       </button>
                                       <a class="navbar-brand" href="#">Menu</a>
                                    </div>
                                    
                                    
                                    
                                    
                                     <div class="logo" style="margin-right:50px;">
                              <a href="../main/main.do"><img src="../images/logo.png" alt="#" /></a>
                           </div>
                           
                           
                           
                           
                                    <div class="collapse navbar-collapse js-navbar-collapse">
                                       <ul class="nav navbar-nav">
                                          <li class="active"><a href="../main/main.do">Home</a></li>
                                          <li class="dropdown mega-dropdown">
                                             <a href="match" class="dropdown-toggle" data-toggle="dropdown">일정/기록<span class="caret"></span></a>				
                                             <ul class="dropdown-menu mega-dropdown-menu"  style="width:170px;height:180px;">
                                               
                                                <li class="col-sm-4">
                                                   <ul class="menu-inner">
                                                      <li><a href="../schedule/schedule.do">경기일정&결과</a></li>
                                                      <li><a href="../team/ranking.do">순위</a></li>
                                                      <li><a href="../seoul/weather.do">오늘의 날씨</a></li>
                                                      <li><a href="../stadium/cctv.do">경기장 주변 교통</a></li>
                                                   </ul>
                                                </li>
                                             </ul>
                                          </li>
                                          <li class="dropdown mega-dropdown">
                                             <a href="match" class="dropdown-toggle" data-toggle="dropdown">구장/선수/팀<span class="caret"></span></a>				
                                             <ul class="dropdown-menu mega-dropdown-menu"  style="width:110px;height:225px; width:60px;">
                                               
                                                <li class="col-sm-4">
                                                   <ul class="menu-inner">
                                                      <li><a href="../stadium/list.do">구장 정보</a></li>
                                                      <li><a href="../team/list.do">팀 정보</a></li>
                                                      <li><a href="../player/batter_list.do">타자 정보</a></li>
                                                      <li><a href="../player/pitcher_list.do">투수 정보</a></li>
                                                      <li><a href="../player/vs.do">선수 비교</a></li>
                                                   </ul>
                                                </li>
                                             </ul>
                                          </li>
                                          <li class="dropdown mega-dropdown">
                                             <a href="match" class="dropdown-toggle" data-toggle="dropdown">하이라이트/뉴스<span class="caret"></span></a>				
                                             <ul class="dropdown-menu mega-dropdown-menu"  style="width:200px;height:90px;">
                                               
                                                <li class="col-sm-4">
                                                   <ul class="menu-inner">
                                                      <li><a href="#">경기별 하이라이트</a></li>
                                                      <li><a href="../news/list.do">뉴스</a></li>
                                                   </ul>
                                                </li>
                                             </ul>
                                          </li>
                                          <li class="dropdown mega-dropdown">
                                             <a href="match" class="dropdown-toggle" data-toggle="dropdown">구매/예약<span class="caret"></span></a>				
                                             <ul class="dropdown-menu mega-dropdown-menu"  style="height:180px;">
                                               
                                                <li class="col-sm-4">
                                                   <ul class="menu-inner">
                                                      <li><a href="../kbogoods/list.do">굿즈</a></li>
                                                      <li><a href="../ticket/ticketchoice.do">티켓</a></li>
                                                      <li><a href="../train/list.do">기차</a></li>
                                                      <li><a href="../hotel/list.do">숙소</a></li>
                                                   </ul>
                                                </li>
                                             </ul>
                                          </li>
                                          <li class="dropdown mega-dropdown">
                                             <a href="match" class="dropdown-toggle" data-toggle="dropdown">커뮤니티<span class="caret"></span></a>				
                                             <ul class="dropdown-menu mega-dropdown-menu"  style="width:170px;height:135px;">
                                               
                                                <li class="col-sm-4">
                                                   <ul class="menu-inner">
                                                      <li><a href="../notice/list.do">공지사항</a></li>
                                                      <li><a href="../board/list.do">게시판</a></li>
                                                      <li><a href="../gnd/list.do">갤러리/자료실</a></li>
                                                   </ul>
                                                </li>
                                             </ul>
                                          </li>
                                          
                                               <c:if test="${sessionScope.userId!=null }">
					                            <li class="myadpage">
					                            	
					                            	
						                            	<sec:authorize access="hasRole('ROLE_ADMIN')">
						                            		<li class="active"><a href="../adminpage/adminpage_main.do">관리자페이지</a></li>
						                            	</sec:authorize>
						                            	<sec:authorize access="hasRole('ROLE_USER')">
						                            		<li class="active"><a href="../mypage/mypage_main.do">마이페이지</a></li>
						                            	</sec:authorize>
					                            </li>
                            				</c:if>
                                       </ul>
                                       
                                       
                                       
                                       
                                       
                                       <!-- Searchbar자리 -->








            
                           
                           <!-- button section -->
                           <ul class="login">
                           <c:if test="${sessionScope.userId==null }">
                              <li class="login-modal">
                                 <a href="../member/login.do" class="login"><i class="fa fa-lock"></i>로그인</a>
                              </li>
                              <li>
                                 <div class="cart-option">
                                    <a href="../member/join.do"><i class="fa fa-user-plus"></i>회원가입</a>
                                 </div>
                              </li>
                           </c:if>
                              <li>
                                 <div class="cart-option">
                                    <a href="../cs/main.do"><i class="fa fa-user-plus"></i>고객센터</a>
                                 </div>
                              </li>
                           </ul>
                           <c:if test="${sessionScope.userId!=null }">
	                            <div class="login">
	                            	${sessionScope.userName }(
		                            	<sec:authorize access="hasRole('ROLE_ADMIN')">관리자</sec:authorize>
		                            	<sec:authorize access="hasRole('ROLE_USER')">일반 사용자</sec:authorize>
	                            	)
	                            	님께서 로그인되었습니다&nbsp;&nbsp;
	                                <a href="../member/logout.do">로그아웃</a>
	                            </div>
                            </c:if>
                            <!-- start translation -->
                           <ul class="">
                              <li class="trans text-right">
                              		<!-- 번역기능 추가 -->
                              			<div class="translation-links google_translate_element">
                              				<a href="javascript:void(0)" class="Korean" data-lang="ko">
                              					<img src="../images/flag_korea.png" class="한국어" id ="transimgs" alt="한국어" data-lang="ko" 
                              						style="width:40px;height:30px;"
                              					>
                              				</a>
                              				<a href="javascript:void(0)" class="English" data-lang="en">
                              					<img src="../images/flag_america.png" class="영어" id ="transimgs" alt="English" data-lang="en"
                              						style="width:40px;height:30px;"
                              					>
                              				</a>
                              				<a href="javascript:void(0)" class="Chinese" data-lang="zh-CN">
                              					<img src="../images/flag_china.png" class="중국어" id ="transimgs" alt="中国語" data-lang="zh-CN"
                              						style="width:40px;height:30px;"
                              					>
                              				</a>
                              				<a href="javascript:void(0)" class="Japanese" data-lang="ja" >
                              					<img src="../images/flag_japan.png" class="일본어" id ="transimgs" alt="日本語" data-lang="ja"
                              						style="width:40px;height:30px;"
                              					>
                              				</a>
                              			</div>
                              			<div id="google_translate_element" style="display: none"></div>
                              													
                              </li>
                           </ul>
                           <!-- end translation -->      
 


















								<!--  -->
                                       
                                       
                                       
                                       
                                       
                                       
                                       
                                       
                                       
                                       
                                       
                                       
                                       
                                       
                                    </div>
                                    <!-- /.nav-collapse -->
                                








                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </header>
<!-- 번역기능 -->	
<script type="text/javascript">
	/* 새 UI 선택 클릭 이벤트가 발생하면
       감춤 처리한 구글 번역 콤보리스트에
       선택한 언어를 적용해 변경 이벤트를 발생시키는 코드  */
	document.querySelector('.translation-links').addEventListener('click',function(event) {
		let el = event.target;
		if(el != null){
			while(el.nodeName == 'FONT'){el = el.parentElement;}//data-lang 속성이 있는 태그 찾기
			const tolang = el.dataset.lang; // 변경할 언어 코드 얻기
			const gtcombo = document.querySelector('.goog-te-combo');
			if (gtcombo == null) {
				alert("Error: Could not find Google translate Combolist.");
				return false;
			}
			gtcombo.value = tolang; // 변경할 언어 적용
			gtcombo.dispatchEvent(new Event('change')); // 변경 이벤트 트리거
		}
		return false;
	});
</script>

</body>
</html>