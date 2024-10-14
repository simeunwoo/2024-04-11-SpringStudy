<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <!-- Mobile Metas -->
   <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
   <!-- Site Metas -->
   <title>2S3B</title>
   <meta name="keywords" content="">
   <meta name="description" content="">
   <meta name="author" content="">
   <!-- Site Icons -->
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
    <title>${vo.name }</title>
    <script src="https://cdn.jsdelivr.net/npm/vue@3"></script>
    <style>
        body {
            margin: 0; /* 기본 여백 제거 */
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
            position: relative; /* 자식 요소들이 부모 요소에 상대적으로 위치하도록 설정 */
            z-index: 1; /* 배경 이미지보다 위로 표시 */
        }
        #a {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 90px;
        }
        #b {
            text-align: center;
            color: gold;
        }
        #abc{
        	background-color: rgba(255, 255, 255, 0);
        }
    </style>
</head>
<body>
    <div class="background" style="background-image: url('${vo.logo}');"></div> <!-- 배경을 위한 div -->
    <div class="container">
        <div class="header-top">
            <div class="row">
                <aside id="sidebar" class="left-bar">
                    <div class="feature-matchs">
                        <div style="height:50px"></div>
                        <div id="a">
                            <img src="${vo.logo }" style="width:170px;height:170px">
                        </div>
                        <div style="height:40px"></div>
                        <div id="b">
                            ${vo.star }
                        </div>
                        <div style="height:30px"></div>
                        <table class="table" id="abc">
                            <tr>
                                <th width="15%" class="text-right">이름</th>
                                <td width="85%">${vo.name }</td>
                            </tr>
                            <tr>
                                <th width="15%" class="text-right">창단연도</th>
                                <td width="85%">${vo.syear }년</td>
                            </tr>
                            <tr>
                                <th width="15%" class="text-right">연고지</th>
                                <td width="85%">${vo.home }</td>
                            </tr>
                            <tr>
                                <th width="15%" class="text-right">이전팀(전신)</th>
                                <td width="85%">${vo.oldteam }</td>
                            </tr>
                            <tr>
                                <th width="15%" class="text-right">우승</th>
                                <td width="85%">${vo.winyear }년</td>
                            </tr>
                            <tr>
                                <th width="15%" class="text-right">해체연도</th>
                                <td width="85%">
                                    <c:if test="${vo.dyear==0}">
                                        -
                                    </c:if>
                                    <c:if test="${vo.dyear!=0}">
                                        ${vo.dyear}년
                                    </c:if>
                                </td>
                            </tr>
                            <tr>
                                <th width="15%" class="text-right">내용</th>
                                <td width="85%">${vo.content }</td>
                            </tr>
                            <tr>
                                <th width="15%" class="text-right">영구결번</th>
                                <td width="85%">${vo.rno }</td>
                            </tr>
                            <tr>
                                <th width="15%" class="text-right">마스코트</th>
                                <td width="85%">${vo.mascot }</td>
                            </tr>
                        </table>
                    </div>
                </aside>
            </div>
        </div>
    </div>
</body>
</html>
