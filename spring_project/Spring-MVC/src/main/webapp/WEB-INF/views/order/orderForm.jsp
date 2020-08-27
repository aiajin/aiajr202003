<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
	<h1>주문</h1>
	<hr>
	<form method="post" id="form">
		<table>
			<tr>
				<td>상품1- ID</td>
				<!--  List<OrderItem> orderItems  -->
				<td><input type="text" name="orderItems[0].itemId"></td>
			</tr>
			<tr>
				<td>상품1- 개수</td>
				<!--  List<OrderItem> orderItems  -->
				<td><input type="number" name="orderItems[0].number"></td>
			</tr>
			<tr>
				<td>상품1- 주의사항</td>
				<!--  List<OrderItem> orderItems  -->
				<td><input type="text" name="orderItems[0].remark"></td>
			</tr>
			<tr>
				<td>상품2- ID</td>
				<!--  List<OrderItem> orderItems  -->
				<td><input type="text" name="orderItems[1].itemId"></td>
			</tr>
			<tr>
				<td>상품2- 개수</td>
				<!--  List<OrderItem> orderItems  -->
				<td><input type="number" name="orderItems[1].number"></td>
			</tr>
			<tr>
				<td>상품2- 주의사항</td>
				<!--  List<OrderItem> orderItems  -->
				<td><input type="text" name="orderItems[1].remark"></td>
			</tr>
			<tr>
				<td>상품3- ID</td>
				<!--  List<OrderItem> orderItems  -->
				<td><input type="text" name="orderItems[2].itemId"></td>
			</tr>
			<tr>
				<td>상품3- 개수</td>
				<!--  List<OrderItem> orderItems  -->
				<td><input type="number" name="orderItems[2].number"></td>
			</tr>
			<tr>
				<td>상품3- 주의사항</td>
				<!--  List<OrderItem> orderItems  -->
				<td><input type="text" name="orderItems[2].remark"></td>
			</tr>
			<tr>
				<td>배송지 : 우편번호</td>
				<!-- Address address -->
				<td><input type="text" name="address.zipcode"></td>
			</tr>
			<tr>
				<td>배송지 : 기본주소</td>
				<!-- Address address -->
				<td><input type="text" name="address.address1"></td>
			</tr>
			<tr>
				<td>배송지 : 상세주소</td>
				<!-- Address address -->
				<td><input type="text" name="address.address2"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit"> </td>
			</tr>

		</table>
	</form>






<script>
	$(document).ready(function(){
		
        $("#form").submit(function(){
            
            alert(1);
            
            var params = $("#form").serialize();
            var param = $("#form").serializeArray();
            console.log(params);
            console.log(param);
            
            
            $.ajax({
                url:'http://localhost:8080/mvc/order/order',
                type: 'post',
                data: param,
                success:function(data){
                    console.log(data);
                }
            });
            
            
            
            return false;

        });
        
		
		
		
	});
</script>










</body>
</html>