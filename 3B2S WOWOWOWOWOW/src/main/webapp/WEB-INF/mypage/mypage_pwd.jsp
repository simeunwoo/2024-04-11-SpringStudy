<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
</head>
<body>
	<div id="JoinUpdateApp">
	   <table class="table">
	    <tr>
	      <td class="text-center" colspan="6">
	        <h4>회원수정</h4>
	      </td>
	    </tr>
   <section class="single_blog_area section_padding_20" id="JoinUpdateApp">
        <div class="container">
            <div class="row justify-content-center">
              <form method="post" action="../mypage/update_ok.do" @submit="submitForm()">
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
    </select>
    &nbsp;
    <input type="text" size=10 class="input-sm" name="phone2" v-model="phone2" maxlength="4">
    &nbsp;
    <input type="text" size=10 class="input-sm" name="phone3" v-model="phone3" maxlength="4">
  </td>
</tr>
			     <tr>
			       <td colspan="2" class="text-center">
			        <input type="submit" value="수정" class="btn-sm ">
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
let JoinUpdateApp=Vue.createApp({
 data(){
	 return {
		 userId: "${userId}",
		 post:'',
		 addr1:'',
		 addr2:'',
		 userName:'',
		 phone1:'',
		 phone2:'',
		 phone3:'',
		 birthday:'',
		 email:'',
		 sex:'',
		 pwdOk:''
	 }
 },
 mounted() {
	    axios.get('../mypage/mypage_update_vue.do', {
	        params: {
	            userId: this.userId // 로그인된 사용자 ID
	        }
	    }).then(response => {
	        // 서버에서 받은 데이터를 Vue 데이터 속성에 저장
	        let member = response.data;
	        this.post = member.post;
	        this.addr1 = member.addr1;
	        this.addr2 = member.addr2;
	        this.userName = member.userName;
	        this.phone1 = member.phone1;
	        this.phone2 = member.phone2;
	        this.phone3 = member.phone3;
	        this.email = member.email;
	        this.sex = member.sex;
	        // 비밀번호는 빈 칸으로 두고, 새로운 입력만 받도록 설정
	        this.userPwd = '';
	        this.userPwd2 = '';
	    }).catch(error => {
	        console.log(error.response);
	    });
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
	 submitForm(e) {
		    // 필수 입력값을 모두 확인 후 수정 요청 처리
		    if (this.userId && this.userName && this.userPwd && this.userPwd2 && this.sex &&
		        this.email && this.phone1 && this.phone2 && this.phone3 && this.post &&
		        this.addr1 && this.addr2 && this.pwdOk === '') {

		        // 서버로 수정 요청을 보내는 axios 호출
		        axios.post('../mypage/update_ok.do', {
		            userId: this.userId,
		            userPwd: this.userPwd,
		            userPwd2: this.userPwd2,
		            userName: this.userName,
		            sex: this.sex,
		            email: this.email,
		            post: this.post,
		            addr1: this.addr1,
		            addr2: this.addr2,
		            phone1: this.phone1,
		            phone2: this.phone2,
		            phone3: this.phone3
		        }).then(response => {
		            if (response.data === 'success') {
		                alert('수정이 완료되었습니다.');
		                location.href = '../mypage/mypage_view.do'; // 수정 완료 후 이동할 페이지
		            } else {
		                alert('수정 중 오류가 발생했습니다. 다시 시도해주세요.');
		            }
		        }).catch(error => {
		            console.error('수정 요청 중 오류:', error);
		            alert('수정 요청 중 오류가 발생했습니다.');
		        });
		    } else {
		        // 필수 입력값이 없는 경우 경고 및 포커스 이동
		        if (!this.userId) {
		            this.$refs.userId.focus();
		        } else if (!this.userName) {
		            this.$refs.userName.focus();
		        } else if (!this.userPwd) {
		            this.$refs.userPwd.focus();
		        } else if (!this.userPwd2) {
		            this.$refs.userPwd2.focus();
		        } else if (this.userPwd !== this.userPwd2) {
		            alert('비밀번호가 일치하지 않습니다.');
		            this.userPwd = '';
		            this.userPwd2 = '';
		            this.$refs.userPwd.focus();
		        } else if (!this.phone2) {
		            this.$refs.phone2.focus();
		        } else if (!this.phone3) {
		            this.$refs.phone3.focus();
		        } else if (!this.email) {
		            this.$refs.email.focus();
		        } else {
		            alert('입력값을 확인해주세요.');
		        }
		    }

		    e.preventDefault(); // 조건 충족 시 폼 제출을 중단합니다.
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
	 }
 }
}).mount('#JoinUpdateApp')
</script>
</body>
</html>