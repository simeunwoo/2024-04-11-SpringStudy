<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	    <!-- 고정 이미지 -->
	    <div class="text-center" style="text-align: center;">
	        <img src="../player/m1.jpg" style="width:1200px;height:720px">
	        <div class="carousel-caption">
	            <div class="col-lg-7 col-md-7 col-sm-12 col-xs-12"></div>
	            <div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
	                <div class="slider-contant" data-animation="animated fadeInRight">
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
<section class="single_blog_area section_padding_20" id="joinApp">
        <div class="container">
            <div class="row justify-content-center">
              <form method="post" action="../member/join_ok.do" @submit="submitForm()">
			    <table class="table">
			     
			     <tr>
			      <th class="text-right" width="20%">연도</th>
			      <td width="80%">
			       <select class="input-sm" name="phone1" v-model="phone1">
			        <option>010</option>
			        <option>010</option>
			        <option>010</option>
			        <option>010</option>
			        <option>010</option>
			       </select>
			      </td>
			     </tr>
			    </table>
			    </form>
            </div>
        </div>
    </section>
</body>
</html>