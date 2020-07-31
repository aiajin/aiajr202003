<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>주문내역</h1>
	<hr>
	<div>
		주소 : ${orderCommand.address.address1} ${orderCommand.address.address2} (${orderCommand.address.zipcode} )  
	</div>
	
	<c:forEach items="${orderCommand.orderItems}" var="item">
	<div>
		상품 명 : ${item.itemId} / 
		수량 : ${item.number} / 
		주의사항 : ${item.remark}
	</div>
	
	</c:forEach>
	













	
	
</body>
</html>