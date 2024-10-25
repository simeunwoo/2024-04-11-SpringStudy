<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
/* .train-page-banner {
     float: left;
     width: 100%;
     min-height: 500px;
     background-image: url('../images/train-banner.jpg');
     background-position: center center;
     background-repeat: no-repeat;
     background-size: cover;
     position: relative;
} */
</style>
</head>
<body>
  <section>
    <div class="train-page-banner">
        <div class="container">
        </div>
     </div>
     <div class="inner-information-text">
        <div class="container">
           <h3>기차 예약</h3>
           <ul class="breadcrumb">
              <li><a href="../main/main.do">Home</a></li>
              <li class="active"><a href="../train/list.do">기차 예약</a></li>
           </ul>
        </div>
     </div>
  </section>
  <section id="contant" class="contant main-heading team">
     <div class="row">
        <div class="container">
           <div class="contact">
              <div class="col-md-12">
                 <div class="map"> 
                    <div class="tlist" style="width: 700">
					    <div class="train-title"></div>
							<div class="search" style="width: 700px">
								<div class="columnchk" style="float: right;">
									<select name="">
										<option value="all">전체 검색
										<option value="tnum">열차번호
										<option value="r_start">출발역
										<option value="r_end">도착역
									</select>
									<input type="text" size="25" name="keyword" value="" class="keyword">&nbsp;&nbsp;
									<input type="submit" value="검색" class="searchbtn">
								</div>
															</div>
							<table class="table table-hover" style="width: 700; padding: 10;">
								<thead>
								<tr>
									<th><span>열차번호</span></th>
									<th><span>열차종류</span></th>
									<th><span>출발역</span></th>
									<th><span>도착역</span></th>
									<th><span>출발시간</span></th>
									<th><span>도착시간</span></th>
									<th><span>요금</span></th>
								</tr>
								</thead>
							</table>
							<table class="table table-hover" style="width: 700; padding: 10;">
								<thead>
								<tr>
									<th><span>열차번호</span></th>
									<th><span>열차종류</span></th>
									<th><span>출발역</span></th>
									<th><span>도착역</span></th>
									<th><span>출발시간</span></th>
									<th><span>도착시간</span></th>
									<th><span>요금</span></th>
								</tr>
								</thead>
							</table>
							<table class="table table-hover" style="width: 700; padding: 10;">
								<thead>
								<tr>
									<th><span>열차번호</span></th>
									<th><span>열차종류</span></th>
									<th><span>출발역</span></th>
									<th><span>도착역</span></th>
									<th><span>출발시간</span></th>
									<th><span>도착시간</span></th>
									<th><span>요금</span></th>
								</tr>
								</thead>
							</table>
							<table class="table table-hover" style="width: 700; padding: 10;">
								<thead>
								<tr>
									<th><span>열차번호</span></th>
									<th><span>열차종류</span></th>
									<th><span>출발역</span></th>
									<th><span>도착역</span></th>
									<th><span>출발시간</span></th>
									<th><span>도착시간</span></th>
									<th><span>요금</span></th>
								</tr>
								</thead>
							</table>
						  </div>
                     </div>
                  </div>
                  <div class="col-md-6">
                     <div class="contact-info">
                        <div class="kode-section-title">
                           
                        </div>
                     </div>
                  </div>
                  <div class="col-md-6">
                     <div class="contact-us">
                        
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </section>
</body>
</html>