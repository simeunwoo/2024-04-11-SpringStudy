<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.section-box {
    background-color: #fff; /* White background */
    border: 1px solid #ccc; /* Light gray border */
    border-radius: 5px; /* Rounded corners */
    padding: 20px;
    margin-bottom: 20px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* Light shadow */
	width: 200px;
}

/* Title styling */
.section-box h3 {
    margin-top: 0;
    font-size: 1.5em;
    color: #333;
    border-bottom: 2px solid #003366; /* Darker blue border */
    padding-bottom: 10px;
}

/* List group styling */
.list-group {
    list-style: none;
    padding: 0;
    margin: 0;
}

.list-group-item {
    padding: 10px 15px;
    border-bottom: 1px solid #eee;
    font-size: 1.1em;
    width :auto;
}

.list-group-item:last-child {
    border-bottom: none;
}

.list-group-item a {
    color: #003366; /* Link color */
    text-decoration: none;
}

.list-group-item a:hover {
    text-decoration: underline;
}
</style>
</head>
<body>
    <div class="section-box">
	      <h3>개인정보</h3>
	    <ul class="list-group">
	      <li class="list-group-item"><a href="../mypage/mypage_update.do">회원수정</a></li>
	      <li class="list-group-item"><a href="../mypage/mypage_delete.do">회원탈퇴</a></li>
	      <li class="list-group-item"><a href="../member/pwd_change.do">비밀번호 변경</a></li>
	    </ul>
	   </div>
	   
	   <div class="section-box">
	      <h3>관리정보</h3>
	    <ul class="list-group">
	      <li class="list-group-item"><a href="#">게시판관리</a></li>
	      <li class="list-group-item"><a href="#">댓글관리</a></li>
	      <li class="list-group-item"><a href="../mypage/mypage_jjim.do">찜관리</a></li>
	      <li class="list-group-item"><a href="#">좋아요관리</a></li>
	      <li class="list-group-item"><a href="../mypage/mypage_buy.do">구매관리</a></li>
	      <li class="list-group-item"><a href="../mypage/mypage_cart.do">장바구니관리</a></li>
	      <li class="list-group-item"><a href="../mypage/mypage_reserve.do">예약관리</a></li>
	    </ul>
	   </div>
	   <div class="section-box">
	      <h3>관리자 메뉴</h3>
	    <ul class="list-group">
	      <li class="list-group-item"><a href="../admin/member_list.do">회원관리</a></li>
	      <li class="list-group-item"><a href="../admin/notice_list.do">공지사항관리</a></li>
	      <li class="list-group-item"><a href="#">구매관리</a></li>
	      <li class="list-group-item"><a href="../admin/admin_reserve.do">예약관리</a></li>
	      <li class="list-group-item"><a href="../admin/reply_list.do">묻고답하기관리</a></li>
	    </ul>
	   </div>
</body>
</html>