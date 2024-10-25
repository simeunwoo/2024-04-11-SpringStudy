<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$('header').css({display:'none'});	
})
</script>
<script src="http://dapi.kakao.com/v2/maps/sdk.js?appkey=72fa81817487692b6dc093004af97650&libraries=services"></script>
<style>
body {
    margin: 0;
    font-family: Arial, sans-serif; /* 폰트 설정 */
}
.background {
	background-size: cover;
	background-position: center;
	filter: blur(5px);
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	z-index: -1;
}
.container {
    position: relative;
    z-index: 1;
    padding: 20px;
}
#a {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 180px;
}
#abc {
	background-color: rgba(255, 255, 255, 0.9);
	border-collapse: collapse;
	width: 100%;
}
#abc th, #abc td {
	border: 1px solid #ddd; 
	padding: 12px 15px; 
	text-align: center;
}
#abc th {
	background-color: #f4f4f4;
	color: #333;
	font-weight: bold;
}
#abc td {
	background-color: #fff; 
	color: #555;
}
.header, .footer {
    display: none;
}
.cBtn {
    display: flex;
    justify-content: center;
    margin-top: 20px;
}
.cBtn .btn {
    padding: 10px 20px;
    background-color: #003366;
    color: white;
    text-decoration: none;
    transition: background-color 0.3s ease;
    border-radius: 20px;
}
.cBtn .btn:hover {
    background-color: #000;
}
</style>
</head>
<body>
 <div class="background" style="background-image: url('${vo.poster}');"></div> <!-- 배경을 위한 div -->
    <div class="container">
        <div class="header-top">
            <div class="row">
                <aside id="sidebar" class="left-bar">
                    <div class="feature-matchs">
                        <div style="height:50px"></div>
                        <div id="a" style="width: 100%; height: 240px; margin-top: -30px;margin-bottom:-50px">
                            <img src="http://www.bluer.co.kr${vo.poster}" style="width: 240px; height: 240px; object-fit: cover;">
                        </div>
                        <div style="height:40px"></div>
                        <div style="height:30px"></div>
                        <table class="table" id="abc">
                            <tr>
                                <th width="15%" class="text-right">상호명</th>
                                <td width="85%">${vo.name }</td>
                            </tr>
                            <tr>
                                <th width="15%" class="text-right">분류</th>
                                <td width="85%">${vo.tag }</td>
                            </tr>
                            <tr>
                                <th width="15%" class="text-right">전화번호</th>
                                <td width="85%">${vo.phone }</td>
                            </tr>
                            <tr>
                                <th width="15%" class="text-right">주소</th>
                                <td width="85%">${vo.address }</td>
                            </tr>
                            <tr>
                                <th width="15%" class="text-right">운영시간</th>
                                <td width="85%">${vo.time }</td>
                            </tr>
                            <tr>
                                <th width="15%" class="text-right">주차</th>
                                <td width="85%">${vo.parking }</td>
                            </tr>
                            <tr>
                                <th width="15%" class="text-right">후기</th>
                                <td width="85%">${vo.review }</td>
                            </tr>
                        </table>
                    </div>
                </aside>
            </div>
        </div>
    </div>
    <div class="col-md-12">
      <div id="map" style="width:650px;height:300px;margin-top: -20px;margin-bottom: 20px"></div>
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
    <div class="cBtn">
       <a class="btn" style="margin-bottom: 30px" href="javascript:void(0);" onclick="window.close()">닫기</a>
    </div> 
</body>
</html>