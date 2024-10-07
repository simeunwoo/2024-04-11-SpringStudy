<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
	<meta charset="UTF-8">
	<title>서울시 열린데이터 광장 OpenAPI 샘플(Javascript)</title>
</head>
<body>
<script>
	var xhr = new XMLHttpRequest();
	var url = 'http://openapi.seoul.go.kr:8088/sample/xml/CardSubwayStatsNew/1/5/20220301'; /* URL */
	xhr.open('GET', url);
	xhr.onreadystatechange = function () {
		if (this.readyState == xhr.DONE) {  // <== 정상적으로 준비되었을때
		if(xhr.status == 200||xhr.status == 201){ // <== 호출 상태가 정상적일때
			alert('Status: '+this.status+
				'\nHeaders: '+JSON.stringify(this.getAllResponseHeaders())+
				'\nBody: '+this.responseText);
			}
		}
	};
	xhr.send('');
</script>
</body>
</html>