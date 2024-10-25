<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
/* .cs-page-banner {
     float: left;
     width: 100%;
     min-height: 400px;
     background-image: url('../images/cs-banner.jpg');
     background-position: center center;
     background-repeat: no-repeat;
     background-size: cover;
     position: relative;
} */
.icon-section {
    display: flex;
    justify-content: center; 
    margin-bottom: 20px;
    gap: 50px; 
}
.icon-box {
    background-color: #fff;
    border: 1px solid #ddd;
    border-radius: 8px;
    padding: 10px;
    width: 150px; 
    text-align: center;
    margin: 0;
}
.icon {
    font-size: 2.5em;
    margin-bottom: 10px;
}
.icon-box p {
    font-size: 1.2em;
    margin: 0;
}
.support-section {
    display: flex;
    margin-top: 50px;
    margin-bottom: 20px;
}
.support-box {
    background-color: #fff;
    margin-left: 80px;
    padding: 30px;
    width: 40%;
    text-align: center;
}
.support-box:first-child {
    border-right: 1px solid #ddd;
}
.button {
    display: inline-block;
    padding: 10px 20px;
    background-color: #000;
    color: #fff;
    text-decoration: none;
    border-radius: 5px;
    font-size: 1em;
}
.button:hover {
    background-color: #444;
}
</style>
</head>
<body>
  <section>
    <div class="cs-page-banner">
        <div class="container">
        </div>
     </div>
     <div class="inner-information-text">
        <div class="container">
           <h3>고객센터</h3>
           <ul class="breadcrumb">
              <li><a href="../main/main.do">Home</a></li>
              <li class="active"><a href="../cs/main.do">고객센터</a></li>
           </ul>
        </div>
     </div>
  </section>
  <section id="contant" class="contant main-heading team">
  <div class="dark-section" style="background:url(../images/cs2.jpg);margin-top: -50px">
            <div class="container">
               <div class="row">
                  <div class="col-md-12 col-sm-12">
                     <div class="heading-main">
                        <h2 style="color: black;">자주 묻는 질문</h2>
                     </div>
                     <div class="testimonial-slider">
                        <div class="carousel slide" data-ride="carousel" id="quote-carousel">
                           <!-- Carousel Slides / Quotes -->
                           <div class="carousel-inner text-center">
                              <!-- Quote 1 -->
                              <div class="item active">
                                 <blockquote>
                                    <div class="row">
                                       <div class="col-sm-10 col-sm-offset-1">
                                          <small>Someone famous</small>
                                          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. !</p>
                                       </div>
                                    </div>
                                 </blockquote>
                              </div>
                              <!-- Quote 2 -->
                              <div class="item">
                                 <blockquote>
                                    <div class="row">
                                       <div class="col-sm-10 col-sm-offset-1">
                                          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. </p>
                                          <small>Someone famous</small>
                                       </div>
                                    </div>
                                 </blockquote>
                              </div>
                              <!-- Quote 3 -->
                              <div class="item">
                                 <blockquote>
                                    <div class="row">
                                       <div class="col-sm-10 col-sm-offset-1">
                                          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. .</p>
                                          <small>Someone famous</small>
                                       </div>
                                    </div>
                                 </blockquote>
                              </div>
                           </div>
                           <!-- Bottom Carousel Indicators 
                           <ol class="carousel-indicators">
                              <li data-target="#quote-carousel" data-slide-to="0" class="active"><img class="img-responsive " src="https://s3.amazonaws.com/uifaces/faces/twitter/mantia/128.jpg" alt="">
                              </li>
                              <li data-target="#quote-carousel" data-slide-to="1"><img class="img-responsive" src="https://s3.amazonaws.com/uifaces/faces/twitter/adhamdannaway/128.jpg" alt="">
                              </li>
                              <li data-target="#quote-carousel" data-slide-to="2"><img class="img-responsive" src="https://s3.amazonaws.com/uifaces/faces/twitter/brad_frost/128.jpg" alt="">
                              </li>
                           </ol>-->
                           <!-- Carousel Buttons Next/Prev -->
                           <a data-slide="prev" href="#quote-carousel" class="left carousel-control"><i class="fa fa-chevron-left"></i></a>
                           <a data-slide="next" href="#quote-carousel" class="right carousel-control"><i class="fa fa-chevron-right"></i></a>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
    <div class="row">
      <div class="container">
        <h1 style="margin-bottom: -10px;color: white;">-</h1>
        <div class="icon-section">
            <div class="icon-box">
                <a href="../board/list.do"><div class="icon">🔔</div>
                <p style="text-align: center;">공지사항</p>
                </a>
            </div>
            <div class="icon-box">
                <div class="icon">📖</div>
                <p style="text-align: center;">게시판</p>
            </div>
            <div class="icon-box">
                <div class="icon">❓</div>
                <p style="text-align: center;">QnA</p>
            </div>
            <div class="icon-box">
                <div class="icon">💬</div>
                <p style="text-align: center;">1:1 문의</p>
            </div>
            <div class="icon-box">
                <div class="icon">⚾️</div>
                <p style="text-align: center;">가이드</p>
            </div>
        </div>
        <div class="support-section">
            <div class="support-box">
                <h2 style="margin-bottom: 20px;">채팅 문의</h2>
                <p style="text-align: center;">카카오톡 채팅 상담을 통해 다양한 문의를</p>
                <p style="text-align: center; margin-bottom: 20px;">실시간으로 편리하게 해결하실 수 있습니다.</p>
                <a href="#" class="button">바로가기</a>
            </div>
            <div class="support-box">
                <h2 style="margin-bottom: 20px;">전화 문의</h2>
                <h3 style="text-align: center;"> 고객센터 : 02-1234-1234</h3>
                <p style="text-align: center;">평일 9:00 ~ 6:00 (점심시간 13:00 ~ 14:00)</p>
                <p style="text-align: center;">주말 및 법정 공휴일 휴무</p>
                <a href="#" class="button">바로가기</a>
            </div>
        </div>
    </div>
    </div>
    </section>
</body>
                  <!-- <div class="col-md-12">
                     <div class="map"> 
                        
                     </div>
                  </div>
                  <h2>자주 묻는 질문</h2>
                  <div class="col-md-12">
                     <div class="contact-info">
                        <div class="kode-section-title">
                           <h3>Contact Info</h3>
                        </div>
                        <div class="kode-forminfo">
                           <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam aliquip..</p>
                           <ul class="kode-form-list">
                              <li>
                                 <i class="fa fa-home"></i> 
                                 <p><strong>Address:</strong> 805 consectetur adipiscing elit, sed do eiusmod tempor</p>
                              </li>
                              <li>
                                 <i class="fa fa-phone"></i> 
                                 <p><strong>Phone:</strong>  123 456 7890</p>
                              </li>
                              <li>
                                 <i class="fa fa-envelope-o"></i> 
                                 <p><strong>Email:</strong> Info@sportyleague.com</p>
                              </li>
                           </ul>
                        </div>
                     </div>
                  </div>
                  <div class="col-md-6">
                     <div class="contact-us">
                        <form method="post" class="comments-form" id="contactform">
                           <ul>
                              <li><input type="text" id="name" name="name" class="required" placeholder="Name *"></li>
                              <li><input type="text" id="email" name="email" class="required email" placeholder="Email *"></li>
                              <li><input type="text" name="address" id="address" placeholder="Address:"></li>
                              <li><textarea name="message" id="message" placeholder="Add your message"></textarea></li>
                              <li><input class="thbg-color" type="submit" value="send"></li>
                           </ul>
                           <div class="hidden-me" id="contact_form_responce">
                              <p></p>
                           </div>
                        </form>
                     </div>
                  </div> -->
  
</body>
</html>