<%@page import="model.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardDTO board  = (BoardDTO) request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=board.getTitle() %></title>
</head>
<body>
	제목 : <input type="text" value="<%= board.getTitle() %>" disabled="disabled">
	<br>
	<textarea rows="20" cols="50"><%= board.getContent() %></textarea>
	<p>작성자 : <%=board.getWriter() %></p>
	<p>작성일 : <%=board.getWrite_date() %></p>
	<button id="" >수정하기</button>
</body>
</html>