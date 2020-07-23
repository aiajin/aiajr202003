<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
	alert("${message eq null ? '비밀번호가 일치 하지 않습니다.' : '삭제되었습니다.'}");
	location.href='list.do';
</script>
