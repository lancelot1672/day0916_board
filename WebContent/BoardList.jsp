<%@page import="model.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
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
.header-content > h2{
	text-align: center;
}
.main-content {
	margin-top: 50px;
}
.page-section {
	text-align: center;
}
.btn-section {
	text-align: right;
}
.page {
	font-size: 20px;
}
.table {
	text-align: center;
}
</style>
</head>
<body>
	<%
	HashMap<String, Object> boardPage = (HashMap<String, Object>) request.getAttribute("boardPage");

	int currPage = (int) boardPage.get("currPage");
	int startPage = (int) boardPage.get("startPage");
	int endPage = (int) boardPage.get("endPage");
	int totalPage = (int) boardPage.get("totalPage");

	List<BoardDTO> boardList = (List<BoardDTO>) boardPage.get("boardList");
	%>
	<div class="frame">
		<div class="header-content">
			<h2>이곳은 SSAFY 8기 대전 5반 게시판입니다.</h2>
		</div>
		<div class="main-content">

			<table class="table">
				<thead>
					<tr>
						<th scope="col">글 번호</th>
						<th scope="col">제목</th>
						<th scope="col">작성자</th>
						<th scope="col">작성일시</th>
						<th scope="col">조회수</th>
					</tr>
				</thead>
				<tbody>
					<%
					if (boardPage == null || boardList == null || boardList.size() == 0) {
					%>
					<tr>
						<td colspan="5">작성된 게시글이 없습니다. 게시글을 작성해보세요.</td>
					</tr>

					<%
					} else {
					for (BoardDTO b : boardList) {
					%>
					<tr>
						<td><%=b.getBno()%></td>
						<td><a
							href="<%=request.getContextPath()%>/board?action=search&bno=<%=b.getBno()%>"><%=b.getTitle()%></a></td>
						<td><%=b.getWriter()%></td>
						<td><%=b.getWrite_date()%></td>
						<td><%=b.getRead_count()%></td>
					</tr>
					<%
					}
					}
					%>
				</tbody>
			</table>
			<div class="page-section">
				<%
				if (startPage > 1) {
				%>
				<a class="page"
					href="<%=request.getContextPath()%>/board?action=list&page=<%=startPage - 1%>">[이전]</a>
				<%
				}
				%>
				<%
					for (int p = startPage; p <= endPage; p++) {
				%>
				<a class="page" href="<%=request.getContextPath()%>/board?action=list&page=<%=p%>">[<%=p%>]
				</a>
				<%
					}
				%>
				<%
				if (endPage < totalPage) {
				%>
				<a class="page" 
					href="<%=request.getContextPath()%>/board?action=list&page=<%=endPage + 1%>">[다음]</a>
				<%
				}
				%>
			</div>
			<div class="btn-section">
				<button class="btn btn-secondary" id="btnWrite">글쓰기</button>
			</div>

		</div>
	</div>

</body>
<script>
	document.querySelector("#btnWrite").addEventListener('click',function(){
		location.href = "<%=request.getContextPath()%>/board?action=write";
	});
</script>
</html>