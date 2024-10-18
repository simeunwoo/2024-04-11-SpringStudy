<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://dapi.kakao.com/v2/maps/sdk.js?appkey=7afa4d414b029c6c74c3e45d6d3e8214&libraries=services"></script>
<style type="text/css">
h2{
	font-size: ;
	font:bolder;
}
li{
	float:left;
}
.btnloc{
	float:right;
	padding:15px;
	margin:2px;
}
</style>
</head>
<body>
   <section id="top">
   <div class="inner-page-banner">
            <div class="container">
            </div>
         </div>
         <div class="inner-information-text">
            <div class="container">
               <h3>Contact</h3>
               <ul class="breadcrumb">
                  <li><a href="index.html">Home</a></li>
                  <li class="active">Contact</li>
               </ul>
            </div>
         </div>
      </section>
      <section id="contant hoteldetail" class="contant main-heading team">
         <div class="row">
            <div class="container">
               <div class="contact">
                  <div class="col-md-12">
                  
                     <div class="contact-info">
                        <div class="kode-section-title">
                           	<span style="padding:15px;color:red; font-size: xx-large;font:bolder;">${vo.name }</span>
                           	<span style="color:orange; font-size: x-large;">${vo.score }</span>
                           	<span style="color:black; float:right;font:bolder; font-size: x-large;">${price }원</span>
                        </div>
                        <div class="kode-forminfo">
	                        <div class="col-md-6">
		                        <img  src="${vo.poster }" style="width:490px;height:490px;">
	                        </div>
	                        <div class="col-md-6">
		                        <c:forEach var="images" items="${vo.imagesList}" varStatus="hvo">
		                        	<div class="col-md-6">
		                        	<div class="col-md-6" style="margin:.5px;">
		                        	
									    <img src="${images}" style="width:244px;height:244px;"/>
		                        	</div>
		                        	</div>
								</c:forEach>
	                        </div>
                        
                        	<div width="20px"></div>
	                           <ul class="kode-form-list detaildata" style="padding:15px;">
	                              <li>
	                                 <p><strong>■&nbsp;주소 : ${vo.address }</strong></p>
	                              </li>
	                              <li>
	                                 <p><strong>■&nbsp;기본 정보</strong> </p>
	                              </li>
	                              <li>
	                                 <p><strong>1.&nbsp;체크인(Check-in):&nbsp;/&nbsp;${vo.checkin }&nbsp;&nbsp;체크아웃(Check-out):&nbsp;&nbsp;${vo.checkout }</p>
	                                 <p><strong>2.&nbsp;와이파이 무료 이용</strong> </p>
	                                 <p><strong>3.&nbsp;애완동물 동반 불가능</strong> </p>
	                                 <p><strong>4.&nbsp;차/커피 메이커</strong> </p>
	                              </li>
	                              <li>
	                                 <p><strong>■&nbsp;편의시설</strong> </p>
	                              </li>
	                              <li>
	                                 <p> <strong>1.&nbsp;피트니스센터</strong></p>
	                                 <p> <strong>2.&nbsp;무료주차</strong></p>
	                                 <p> <strong>3.&nbsp;비즈니스 센터</strong></p>
	                              </li>
	                           </ul>
                        </div>
                        <div class="btnloc">
                              <button class="btn btn-sm btn-primary">좋아요</button>
                              <button class="btn btn-sm btn-primary">찜하기</button>
                              <c:if test="${sessionScope.userId!=null }">
                              <a class="btn" href="../hotel/reserve.do?hno=${hno }">예약하기</a>
                            </c:if>
                        </div>
                     <table class="table">
                        <tr>
                             <td>
                                <div id="map" style="width:100%;height:235px"></div>
                             </td>
                          </tr>
                     </table>
                     <script>
                            var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
                        mapOption = {
                            center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
                            level: 3 // 지도의 확대 레벨
                              };  

                          // 지도를 생성합니다    
                          var map = new kakao.maps.Map(mapContainer, mapOption); 
              
                          // 주소-좌표 변환 객체를 생성합니다
                          var geocoder = new kakao.maps.services.Geocoder();
              
                          // 주소로 좌표를 검색합니다
                          geocoder.addressSearch('${vo.address}', function(result, status) {
                                               
                              // 정상적으로 검색이 완료됐으면 
                               if (status === kakao.maps.services.Status.OK) {
              
                                  var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
              
                                  // 결과값으로 받은 위치를 마커로 표시합니다
                                  var marker = new kakao.maps.Marker({
                                      map: map,
                                      position: coords
                                  });
              
                                  // 인포윈도우로 장소에 대한 설명을 표시합니다
                                  var infowindow = new kakao.maps.InfoWindow({
                                      content: '<div style="width:150px;text-align:center;padding:6px 0;">${vo.name }</div>'
                                  });
                                  infowindow.open(map, marker);
              
                                  // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
                                  map.setCenter(coords);
                              } 
                          });  
                            </script>
                  </div>
                 
               </div>
            </div>
         </div>
         </div>
      </section>
</body>
</html>