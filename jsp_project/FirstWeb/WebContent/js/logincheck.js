
// 사용자 입력 폼 Casting
// 기본적인 유요성 

// <form> casting
var form = document.getElementById('loginForm');

form.setAttribute('action', 'http://www.naver.com');

// onsubmit 
form.onsubmit = function(){

    // <input> casting
    var uid = document.getElementById('id');
    var upw = document.getElementById('pw');

    if(uid.value==null || uid.value.length<1){
        alert('아이디를 입력해주세요.');
        return false;
    }

    if(upw.value==null || upw.value.length<1){
        alert('비밀번호를 입력해주세요.');
        return false;
    }


}

