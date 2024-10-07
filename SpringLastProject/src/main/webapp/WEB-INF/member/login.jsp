<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
</head>
<body>
	<div class="breadcumb-area" style="background-image: url(../img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
                        <h2>로그인</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="breadcumb-nav">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    
                </div>
            </div>
        </div>
    </div>
    <section class="single_blog_area section_padding_20" id="loginApp">
        <div class="container" style="width:450px">
            <div class="row">
            	<form action="../member/login.do" method="post" id="frm">
	            	<table class="table">
	            		<tr>
	            			<th class="text-center" width="20%">아이디</th>
	            			<td width="80%">
	            				<input type="text" name="userId" ref="userId" v-model="userId">
	            			</td>
	            		</tr>
	            		<tr>
	            			<th class="text-center" width="20%">비밀 번호</th>
	            			<td width="80%">
	            				<input type="password" name="userPwd" ref="userPwd" v-model="userPwd">
	            			</td>
	            		</tr>
	            		<tr>
	            			<td colspan="2">
	            				<input type="checkbox" name="remember-me">자동 로그인
	            			</td>
	            		</tr>
	            		<tr>
	            			<td colspan="2" class="text-center" style="color:red">${message }</td>
	            		</tr>
	            		<tr>
	            			<td colspan="2" class="text-center">
	            				<input type="button" value="로그인" class="btn-danger btn-sm"
	            				  @click="login()">
	            				<input type="button" value="취소" class="btn-sm btn-primary"
	            				  onclick="javascript:history.back()">
	            			</td>
	            		</tr>
	            	</table>
            	</form>
            </div>
        </div>
    </section>
    <script>
    	let logApp=Vue.createApp({
    		data(){
    			return{
    				userId:'',
    				userPwd:''
    			}
    		},
    		methods:{
    			login(){
    				if(this.userId==="")
    				{
    					this.$refs.userId.focus()
    					return
    				}
    				if(this.userPwd==="")
    				{
    					this.$refs.userPwd.focus()
    					return
    				}
    				$('#frm').submit()
    			}
    		}
    	}).mount('#loginApp')
    </script>
</body>
</html>