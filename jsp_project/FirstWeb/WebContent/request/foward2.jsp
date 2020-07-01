<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table border="1">
		<tr>
			<td>이름</td>
			<td> <%= request.getParameter("username") %></td>
		</tr>
		<tr>
			<td>직업</td>
			<td> <%= request.getParameter("job") %></td>
		</tr>
		<tr>
			<td>관심사</td>
			<td> 
				<%
					String[] likes = request.getParameterValues("like");
				
					for(int i=0; i<likes.length; i++){
						out.println(likes[i]+"<br>"); // java<br>
					}
				
				%>
			<%--= request.getParameter("like") --%> </td>
		</tr>
		
	</table>

	
</body>
</html>