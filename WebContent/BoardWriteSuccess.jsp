<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글작성 완료</title>
</head>
<body>
<script>
	alert('글 작성이 완료되었습니다.');
	location.href= '<%= request.getContextPath() %>/board?action=list';
</script>
</body>
</html>