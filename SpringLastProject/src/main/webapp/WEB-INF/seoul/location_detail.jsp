<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ****** Breadcumb Area Start ****** -->
    <div class="breadcumb-area" style="background-image: url(../img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
                        <h2>서울 명소 상세 보기</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="breadcumb-nav">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"></li>
                            <li class="breadcrumb-item active" aria-current="page"></li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ****** Breadcumb Area End ****** -->

    <!-- ****** Archive Area Start ****** -->
    <section class="archive-area section_padding_80" id="detailApp">
        <div class="container">
            <div class="row">
            </div>
        </div>
    </section>
    <script>
    	let detailApp=Vue.createApp({
    		// Model : 데이터 관리
    		data(){
    			// 멤버 변수 => 변경이 되면 => HTML에 적용
    			return{
    				
    			}
    		},
    		// ViewModel : 데이터를 변경하여 HTML로 전송 / View => HTML
    		// MVVM => Vue에서 사용하는 디자인 패턴
    		mounted(){
    			// 서버로부터 데이터 읽기
    		},
    		methods:{
    			// 지도 출력
    		}
    	}).mount('#detailApp')
    </script>
</body>
</html>