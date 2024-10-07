<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<!-- ****** Breadcumb Area Start ****** -->
    <div class="breadcumb-area" style="background-image: url(../img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
                        <h2>회원 가입</h2>
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
    <section class="single_blog_area section_padding_20" id="joinApp">
        <div class="container">
            <div class="row justify-content-center">
            	<div class="wrapper row3">
			   <form method="post" action="../member/join_ok.do" @submit.prevent="submitForm()">
			    <table class="table">
			     <tr>
			      <th class="text-right" width="20%">ID</th>
			      <td width="80%">
			       <input type="text" size=15 class="input-sm"
			          v-bind:readonly="isReadOnly" name="id" ref="userId" v-model="userId">
			       <input type="button" value="중복체크"
			         class="btn-sm btn-danger" @click="idCheck()">
			         <p>{{idOk}}</p>
			      </td>
			     </tr>
			     <tr>
			      <th class="text-right" width="20%">비밀번호</th>
			      <td width="80%">
			       <input type="password" size=15 class="input-sm" name="pwd" id="pwd">
			       &nbsp;재입력:<input type="password" size=15 class="input-sm" id="pwd1">
			      </td>
			     </tr>
			     <tr>
			      <th class="text-right" width="20%">이름</th>
			      <td width="80%">
			       <input type="text" size=15 class="input-sm" name="name" id="name">
			      </td>
			     </tr>
			     <tr>
			      <th class="text-right" width="20%">성별</th>
			      <td width="80%">
			       <input type="radio" name="sex" value="남자" checked>남자
			       <input type="radio" name="sex" value="여자">여자
			      </td>
			     </tr>
			     <tr>
			      <th class="text-right" width="20%">생년월일</th>
			      <td width="80%">
			       <input type="date" size=20 class="input-sm" name="birthday" id="day">
			      </td>
			     </tr>
			     <tr>
			      <th class="text-right" width="20%">이메일</th>
			      <td width="80%">
			       <input type="text" size=50 class="input-sm" name="email" id="email">
			      </td>
			     </tr>
			     <tr>
			      <th class="text-right" width="20%">우편번호</th>
			      <td width="80%">
			       <input type="text" size=7 class="input-sm" name="post1" readonly id="post1">-
			       <input type="text" size=7 class="input-sm" name="post2" readonly id="post2">
			       <input type=button value="우편번호검색"
			         class="btn btn-sm btn-primary" id="postBtn">
			      </td>
			     </tr>
			     <tr>
			      <th class="text-right" width="20%">주소</th>
			      <td width="80%">
			       <input type="text" size=50 class="input-sm" name="addr1" readonly id="addr1">
			      </td>
			     </tr>
			     <tr>
			      <th class="text-right" width="20%">상세주소</th>
			      <td width="80%">
			       <input type="text" size=50 class="input-sm" name="addr2">
			      </td>
			     </tr>
			     <tr>
			      <th class="text-right" width="20%">전화번호</th>
			      <td width="80%">
			       <select class="input-sm" name="phone1">
			        <option>010</option>
			       </select>
			       <input type="text" size=20 class="input-sm" name="phone2" id="phone2">
			      </td>
			     </tr>
			     <tr>
			      <th class="text-right" width="20%">소개</th>
			      <td width="80%">
			       <textarea rows="5" cols="50" name="content"></textarea>
			      </td>
			     </tr>
			     <tr>
			       <td colspan="2" class="text-center">
			        <input type="submit" value="회원가입"
			         class="btn-sm btn-info" id="joinBtn"
			        >
			        <input type=button value="취소"
			         class="btn-sm btn-warning"
			         onclick="javascript:history.back()"
			        >
			       </td>
			     </tr>
			    </table>
			    </form>
            </div>
        </div>
    </section>
    <script>
		let joinApp=Vue.createApp({
			data(){
				return{
					userId:'',
					idOk:'',
					isReadOnly:false
				}
			},
			methods:{
				idCheck(){
					if(this.userId==='')
					{
						this.$refs.userId.focus()
						return
					}
					axios.get('../member/idcheck_vue.do',{
						params:{
							userId:this.userId
						}
					}).then(response=>{
						console.log(response.data)
						if(response.data==='0')
						{
							this.idOk='사용 가능한 아이디입니다'
							this.isReadOnly=true
						}
						else
						{
							this.idOk='이미 사용 중인 아이디입니다'
							this.userId=''
						}
					}).catch(error=>{
						console.log(error.response)
					})
				}
			}
		}).mount('#joinApp')
	</script>
</body>
</html>