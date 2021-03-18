function login() {
    let data = {
        userId : $('#userId')[0].value,
        userPw : $('#userPw')[0].value
    }
    console.log(data)
    $.ajax({
        type: 'POST',
        url: '/signin',
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(data)
    }).done(function (data) {
        if(data === 1){
            alert('로그인 성공')
            location.href = '/';
        }else if(data === 2){
            alert('비밀번호 오류')
        }else{
            alert('아이디 오류')
        }
    });
}
function logout() {
    location.href = '/logout'
}
function signUp() {
    let userGender = $('#male')[0].checked === true ? 'M' : 'F';
    let data = {
        userId : $('#signUpUserId')[0].value,
        userName : $('#signUpUserName')[0].value,
        userPw : $('#signUpUserPw')[0].value,
        userGender : userGender,
        userPhoneNumber : $('#signUpUserPhoneNumber')[0].value,
    }
    $.ajax({
        type: 'POST',
        url: '/signup',
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(data)
    }).done(function (data) {
        if(data === 1){
            alert('회원가입 성공')
            location.href = '/login'
        }else{
            alert('회원가입 실패')
        }
    });
}