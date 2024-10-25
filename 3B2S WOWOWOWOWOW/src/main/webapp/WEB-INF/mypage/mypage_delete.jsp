<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div id="deleteApp">
        <table class="table">
            <tr>
                <td class="text-center" colspan="2">
                    <h4>회원 탈퇴</h4>
                </td>
            </tr>
            <tr>
                <th class="text-right" width="30%">ID</th>
                <td width="70%">
                    <input type="text" size=15 class="input-sm" v-bind:readonly="true" name="userId" v-model="userId">
                </td>
            </tr>
            <tr>
                <th class="text-right" width="30%">비밀번호</th>
                <td width="70%">
                    <input type="password" size=15 class="input-sm" name="userPwd" v-model="userPwd" @keyup="pwdValidate()">
                    <div class="text-center">
                    </div>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="text-center">
                    <input type="submit" value="삭제" class="btn-sm " @click.prevent="deleteUser">
                    &nbsp;&nbsp;
                    <input type="button" value="취소" class="btn-sm " onclick="javascript:history.back()">
                </td>
            </tr>
        </table>
    </div>

    <script>
        let deleteApp = Vue.createApp({
            data() {
                return {
                    userId: "${userId}", // JSP에서 전달된 userID 사용
                    userPwd: ''
                };
            },
            methods: {
                pwdValidate() {
                    // 비밀번호 유효성 검사 로직 (필요시 추가)
                },
                deleteUser() {
                    if (this.userPwd === '') {
                        alert('비밀번호를 입력해 주세요.');
                        return;
                    }

                    // 사용자 탈퇴 요청
                    axios.get('../mypage/mypage_delete_vue.do', {
                        userId: this.userId,
                        userPwd: this.userPwd
                    }).then(response => {
                        if (response.data === 'yes') {
                            alert('회원 탈퇴가 완료되었습니다.');
                            location.href = "../main/main.do"; // 탈퇴 후 이동할 페이지
                        } else {
                            alert('탈퇴 실패: 비밀번호가 올바르지 않습니다.');
                        }
                    }).catch(error => {
                        console.log(error.response);
                        alert('탈퇴 중 오류가 발생했습니다.');
                    });
                }
            }
        }).mount('#deleteApp');
    </script>
</body>
</html>