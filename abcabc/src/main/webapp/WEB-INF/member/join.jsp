<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style type="text/css">
p {
  /* 수평 중앙 정렬하기 */
  margin-right: 450px;
  color: red;
}
</style>
</head>
<body>
<div class="top_space"  style="height: 220px;"></div>

<div class="breadcumb-area">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
                        <h2>회원가입</h2>
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
              <form method="post" action="../member/join_ok.do" @submit="submitForm()">
			    <table class="table">
			     <tr>
			      <th class="text-right" width="30%">ID</th>
			      <td width="70%" >
			       <input type="text" size=15 class="input-sm" v-bind:readonly="isReadOnly" name="userId" ref="userId" v-model="userId">
			       &nbsp;
			       <input type="button" value="중복체크" class="btn-sm btn-danger" @click="idCheck()">
			       <p>{{idOk}}</p>
			      </td>
			     </tr>
			     <tr>
			      <th class="text-right" width="30%" style="border: none;">비밀번호</th>
			      <td width="70%" style="border: none;">
			       <input type="password" size=15 class="input-sm" name="userPwd" ref="userPwd" v-model="userPwd" @keyup="pwdValidate()">
			       <div class="text-center">
			       <p>{{pwdOk}}</p>
			       </div>
			      </td>
			     </tr>
			     <tr>
			      <th class="text-right" width="40%" style="border: none;">비밀번호 확인</th>
			      <td width="60%" style="border: none;">
			       <input type="password" size=15 class="input-sm" name="userPwd2" ref="userPwd2" v-model="userPwd2" @keyup="pwdValidate2()">

			      </td>
			     </tr>
			     <tr>
			      <th class="text-right" width="30%" style="border: none;">이름</th>
			      <td width="70%" style="border: none;">
			       <input type="text" size=15 class="input-sm" name="userName" ref="userName" v-model="userName">
			      </td>
			     </tr>
			     <tr>
			      <th class="text-right" width="30%" style="border: none;">성별</th>
			      <td width="70%" style="border: none;">
			       <input type="radio" name="sex" value="남자" checked v-model="sex">남자
			       <input type="radio" name="sex" value="여자" v-model="sex">여자
			      </td>
			     </tr>
			     <tr>
			      <th class="text-right" width="30%" style="border: none;">생년월일</th>
			      <td width="70%" style="border: none;">
			       <input type="date" size=20 class="input-sm" name="birthday" v-model="birthday" ref="birthday">
			      </td>
			     </tr>
			     <tr>
			      <th class="text-right" width="30%" style="border: none;">이메일</th>
			      <td width="70%" style="border: none;">
			       <input type="text" size=50 class="input-sm" name="email" ref="email" v-model="email">
			      </td>
			     </tr>
			     <tr>
			      <th class="text-right" width="30%" style="border: none;">우편번호</th>
			      <td width="70%" style="border: none;">
			       <input type="text" size=10 class="input-sm" name="post" readonly ref="post" v-model="post">
			       &nbsp;
			       <input type=button class="btn-sm" value="우편번호검색" @click="postFind()" >
			      </td>
			     </tr>
			     <tr>
			      <th class="text-right" width="30%" style="border: none;">주소</th>
			      <td width="70%" style="border: none;">
			       <input type="text" size=50 class="input-sm" name="addr1" readonly ref="addr1" v-model="addr1">
			      </td>
			     </tr>
			     <tr>
			      <th class="text-right" width="30%" style="border: none;">상세주소</th>
			      <td width="70%" style="border: none;">
			       <input type="text" size=50 class="input-sm" name="addr2" ref="addr2" v-model="addr2">
			      </td>
			     </tr>
			     <tr>
			      <th class="text-right" width="30%" style="border: none;">전화번호</th>
			      <td width="70%" style="border: none;">
			       <select class="input-sm" name="phone1" v-model="phone1">
			        <option>010</option>
			        <option>017</option>
			        <option>011</option>
			       </select> &nbsp;
			       <input type="text" size=10 class="input-sm" name="phone2" ref="phone2" v-model="phone2" oninput="this.value = this.value.replace(/[^0-9.]/g, '')" maxlength="4"> &nbsp;
			       <input type="text" size=10 class="input-sm" name="phone3" ref="phone2" v-model="phone3" oninput="this.value = this.value.replace(/[^0-9.]/g, '')" maxlength="4">
			      </td>
			     </tr>
			     <tr>
			       <td colspan="2" class="text-center">
			        <input type="submit" value="회원가입" class="btn-sm ">
			        &nbsp;&nbsp;
			        <input type=button value="취소" class="btn-sm " onclick="javascript:history.back()">
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
	 return {
		 userId:'',
		 idOk:'',
		 isReadOnly:false,
		 post:'',
		 addr1:'',
		 addr2:'',
		 userName:'',
		 phone1:'',
		 phone2:'',
		 phone3:'',
		 birthday:'',
		 userPwd:'',
		 userPwd2:'',
		 email:'',
		 sex:'',
		 pwdOk:''
	 }
 },
 methods:{
	 pwdValidate(){
		 let pwd=String(this.userPwd)
		 let num=pwd.search(/[0-9]/g)
		 let eng=pwd.search(/[a-z]/g)
		 if(pwd==='')
		 {
			 this.pwdOk=''
			 return
		 }
		 
		 if(pwd.length<8 || pwd.length>20)
		 {
			this.pwdOk='비밀번호는 8자리~20자리 이내로 입력하세요' 
			return
		 }
		 
		 else if(pwd.search(/\s/)!=-1)
	     {
			 this.pwdOk="비밀번호는 공백없이 입력하세요"
			 return
	     }
		 else if(num<0 || eng<0)
		 {
			 this.pwdOk="비밀번호는 영문,숫자를 혼합해서 입력해야 합니다"
			 return
		 }
		 else
		 {
			 this.pwdOk=''
			 return
		 }
	 },
	 pwdValidate2(){
		 if(this.userPwd!=this.userPwd2)
		 {
			 this.pwdOk='비밀번호가 일치하지 않습니다'
		 }
		 else
		 {
			 this.pwdOk=''
		 }
	 },
	 submitForm(e){
		 alert("회원가입이 완료되었습니다")
		 if(this.userId && this.userName && this.userPwd && this.sex 
			 && this.userPwd2 && this.birthday && this.post 
			 && this.addr1 && this.addr2 && this.email && this.idOk!='' && this.pwdOk!=''
		   )
		 {
			 alert("정상 수행")
			 return true
		 }
		 
		 if(this.userId===''||this.idOk!='')
		 {
			 this.$refs.userId.focus()
		 }
		 else if(this.userName==='')
		 {
			 this.$refs.userName.focus()
		 }
		 else if(this.userPwd==='')
		 {
			 this.$refs.userPwd.focus()
		 }
		 else if(this.userPwd2==='')
		 {
			 this.$refs.userPwd2.focus()
		 }
		 else if(this.userPwd!==this.userPwd2)
		 {
			 this.userPwd=''
			 this.userPwd2=''
		 }
		 else if(this.phone2==='')
		 {
			 this.$refs.phone2.focus()
		 }
		 else if(this.phone3==='')
		 {
			 this.$refs.phone3.focus()
		 }
		 else if(this.email==='')
		 {
			 this.$refs.email.focus()
		 }
		 e.preventDefault()
	 },
	 postFind(){
		 let _this=this
		 new daum.Postcode({
			 oncomplete:function(data)
			 {
				 _this.post=data.zonecode
				 _this.addr1=data.address
			 }
		 }).open()
	 },
	 idCheck(){
		 if(this.userId==='')
		 {
			 this.$refs.userId.focus()
			 this.idOk='아이디를 입력해주십시오'
			 return
		 }
		 axios.get('../member/idcheck_vue.do',{
			 params:{
				 userId:this.userId
			 }
		 }).then(response=>{
			 console.log(response.data)
			 if(response.data===0)
			 {
				 this.idOk='사용가능한 아이디입니다'
				 this.isReadOnly=true
				 
			 }
			 else
			 {
				 this.idOk='이미 사용중인 아이디입니다'
				 this.userId=''
				 this.$refs.userId.focus()
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