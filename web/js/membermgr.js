// 회원 정보를 저장할 배열 생성
var members=[];

// 회원 데이터를 객체화 시킬 생성자 함수
function Member(mid, mname, mpw){
    this.id=mid;
    this.name=mname;
    this.pw=mpw;
}

// 공통 함수 : 메서드 정의
Member.prototype.toString = function() {
    var makeHtml = '';
    makeHtml += '<td>';
    makeHtml += this.id;
    makeHtml += '</td>';
    makeHtml += '<td>';
    makeHtml += this.name;
    makeHtml += '</td>';
    makeHtml += '<td>';
    makeHtml += this.pw;
    makeHtml += '</td>';
    return makeHtml;
}


// 데이터 저장함수
function addMember(member){
    members.push(member);

    console.log(members)
}

function createMember(){

    alert(111);
    var id=document.getElementById('uid').value;
    var name=document.getElementById('uname').value;
    var pw=document.getElementById('pw').value;

    members.push(new Member(id,name,pw)); 
    
    console.log(members);

    return false;
    
}


// 저장, 수정 submit 이벤트 처리
window.onload = function(){
    document.getElementById('regForm').onsubmit = createMember;
}