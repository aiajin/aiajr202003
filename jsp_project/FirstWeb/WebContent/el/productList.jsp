<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="product" class="model.Product" scope="session"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>상품 선택</h1>
	
	<form action="productSelect.jsp" method="post">
	
		<select name="sel">
		<%
			for(String item : product.getProductList()){
				out.println("<option >"+item+"</option>");
			}
		%>
		</select>
		<br>
		<input type="submit">
	
	</form>

</body>
</html>











