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
    console.log(members);
    displayTable();
}

function createMember(){
    // 사용자 입력 데이터 받기, document로 케스팅 후 value 속성 사용
    var id=document.getElementById('uid').value;
    var name=document.getElementById('uname').value;
    var pw=document.getElementById('pw').value;
    // 배열에 데이터 추가
    addMember(new Member(id,name,pw)); 

    // form 테그의 action 실행이 되지 않도록 반드시 return false
    return false;
    
}

function displayTable(){

    var listHtml = '';
    listHtml += '<table  class="listtable">';
    listHtml += '   <tr>';
    listHtml += '       <th>index</th>';
    listHtml += '       <th>ID(이메일)</th>';
    listHtml += '       <th>비밀번호</th>';
    listHtml += '       <th>이름</th>';
    listHtml += '       <th>관리</th>';
    listHtml += '   </tr>';

    // 배열의 요소를 반복문으로 테그 생성
    for(let i=0; i<members.length; i++){
        listHtml += '   <tr>';
        listHtml += '       <td>'+i+'</td>';
        listHtml += '       <td>'+members[i].id+'</td>';
        listHtml += '       <td>'+members[i].pw+'</td>';
        listHtml += '       <td>'+members[i].name+'</td>';
        listHtml += '       <td> 수정 | 삭제 </td>';
        listHtml += '   </tr>';
    }

    listHtml += '</table>';

    var listTable = document.getElementById('list');
    listTable.innerHTML=listHtml;

}


// 저장, 수정 submit 이벤트 처리
window.onload = function(){

    displayTable();


    // 입력 폼 casting -> onsubmit Event 
    document.getElementById('regForm').onsubmit = createMember;
}