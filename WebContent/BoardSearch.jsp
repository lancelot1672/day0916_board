<%@page import="model.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
BoardDTO board = (BoardDTO) request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=board.getTitle()%></title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<style>
a {
	text-decoration: none;
	color: black;
}

.frame {
	margin: 100px 400px;
}

.header-content>h2 {
	text-align: center;
}

.main-content {
	margin-top: 50px;
}

.page-section {
	text-align: center;
}

.btn-section {
	text-align: center;
}

.page {
	font-size: 20px;
}

</style>
</head>
<body>
	<div class="frame">		
		<div class="header-content">
			<h2>게시글 수정하기 ~ !!!</h2>
		</div>
		<div class="main-content">
			<form action="board" method="post" id="board">
				<input type="hidden" name="action" value="write">
				<table class="table">
					<tr>
						<td>제목:</td>
						<td><input type="text" class="form-control" name="title"
							id="title" value="<%=board.getTitle()%>" disabled="disabled"></td>
					</tr>
					<tr>
						<td>내용:</td>
						<td><textarea class="form-control" rows="20" name="content"
								id="content" style="text-align: left;">
							<%=board.getContent() %>	
							</textarea>
						</td>
					</tr>
					<tr>
						<td>작성자:</td>
						<td><%=board.getWriter()%></td>
					</tr>
					<tr>
						<td>작성일:</td>
						<td><%=board.getWrite_date()%></td>
					</tr>
				</table>
				<div class="btn-section">
					<button class="btn btn-secondary" type="button" id="btnBack">뒤로가기</button>
					<input class="btn btn-secondary" type="button" value="수정하기" disabled="disabled">
				</div>
			</form>

		</div>
	</div>
</body>
<script type="text/javascript">
	document.querySelector('#btnBack').addEventListener('click',function(){
			history.back();
	});
</script>

</html>