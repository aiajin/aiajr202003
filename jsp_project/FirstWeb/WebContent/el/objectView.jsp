<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>교재 리스트 (배열)</h1>
	<ul>
		<li>${requestScope.bookNames[0]}</li>
		<li>${requestScope.bookNames[1]}</li>
		<li>${bookNames[2]}</li>
	</ul>
	
	<h1>학습 순서 (List)</h1>
	<ol>
		<li>${requestScope.study[0]}</li>
		<li>${requestScope.study[1]}</li>
		<li>${study[2]}</li>
		<li>${study[3]}</li>
	</ol>
	
	<h1>학생정보 (Map)</h1>
	<ul>
		<li>전공 : ${requestScope.student.dept}</li>
		<li>이름 : ${student.name}</li>
		<li>전화번호 : ${student.phoneNumber}</li>
	</ul>
	
	
	
	
	
	
	
	
	

</body>
</html>






