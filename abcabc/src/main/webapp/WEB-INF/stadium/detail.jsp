<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://dapi.kakao.com/v2/maps/sdk.js?appkey=72fa81817487692b6dc093004af97650&libraries=services"></script>
<style type="text/css">
.listBtn {
    display: flex;       
    justify-content: center;  
    margin-top: 30px;
}
.listBtn .btn {

    padding: 10px 20px;
    background-color: #666;
    text-decoration: none;
    transition: background-color 0.3s ease;
}
.listBtn .btn:hover {
    background-color: #000;
}
.kode-forminfo {
    overflow: hidden;
    display: flex;
    align-items: center;
    justify-content: center;
    width: 500px;
    height: 350px;
}
.stadium-info {
  display: flex;
  align-items: flex-start;
  background-color: #fff;
  padding: 20px;
  margin-top: 30px;
  margin-bottom: 40px;
  border: 1px solid #fff;
  border-radius: 8px;
}

.stadium-info img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  border-radius: 5px;
}

.stadium-info table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
}

.stadium-info table th, .stadium-info table td {
  padding: 12px 15px;
  border: 1px solid #ddd;
  text-align: left;
}

.stadium-info table th {
  background-color: #f2f2f2;
  font-weight: bold;
  text-align: center;
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
    <section id="detailApp" class="contant main-heading team">
      <div class="row">
         <div class="container">
            <div class="contact">
               <div class="col-md-12">
				  <div class="stadium-info">
				    <div class="kode-forminfo" style="flex: 1; margin-right: 20px;">
				      <img src="${vo.poster }" alt="stadium poster">
				    </div>
				    <div class="kode-form-list" style="flex: 1;">
				      <table>
				        <tr>
				          <th>구장명</th>
				          <td>${vo.name}</td>
				        </tr>
				        <tr>
				          <th>개장</th>
				          <td>${vo.openyear}</td>
				        </tr>
				        <tr>
				          <th>지역</th>
				          <td>${vo.location}</td>
				        </tr>
				        <tr>
				          <th>홈 구단</th>
				          <td>${vo.hometeam}</td>
				        </tr>
				        <tr>
				          <th>좌석수(수용인원)</th>
				          <td>${vo.seat}석 (${vo.inwon}명)</td>
				        </tr>
				        <tr>
				          <th>구장 설명</th>
				          <td>${vo.content}</td>
				        </tr>
				      </table>
				    </div>
				  </div>
				</div>
               <div class="col-md-12">
                  <div id="map" style="width:100%;height:400px;"></div>
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
                		            content: '<div style="width:150px;text-align:center;padding:6px 0;">${vo.name}</div>'
                		        });
                		        infowindow.open(map, marker);

                		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
                		        map.setCenter(coords);
                		    } 
                		    });    
                        </script>
                  </div> 
                  
                  <div class="col-md-12">
				    <div class="listBtn">
				        <a class="btn" href="../stadium/list.do">목록</a>
				    </div>
				  </div> 
               </div>
           </div>
        </div>
      
    </section>
</body>
</html>