<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성 화면</title>
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
	text-align: center;
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
	<div class="frame">
		<div class="header-content">
			<h2>새 글 작성</h2>
		</div>
		<div class="main-content">
			<form action="board" method="post" id="board">
			<input type="hidden" name="action" value="write">
			<table class="table">
				<tr>
					<td>제목:</td>
					<td><input type="text" class="form-control" name="title" id="title" placeholder="제목을 입력하세요"></td>
				</tr>
				<tr>
					<td>작성자:</td>
					<td><input type="text" class="form-control" name="writer" id="writer" placeholder="너의 이름은?"></td>
				</tr>
				<tr>
					<td>내용:</td>
					<td><textarea class="form-control" rows="20" name="content" id="content" placeholder="길게 한 200자 써주면 안돼??"></textarea></td>
				</tr>
			</table>
				<div class="btn-section">
					<button class="btn btn-secondary" type="button" id="btnBack">뒤로가기</button>
					<input class="btn btn-secondary" type="submit" value="작성완료">
				</div>
			</form>

		</div>

	</div>
</body>
<script type="text/javascript">
	document.querySelector('#btnBack').addEventListener('click',function(){
		if(confirm('지금 작성한 페이지의 정보가 날라갑니다.')){
			history.back();
		}
	});
	document.getElementById('board').addEventListener('submit', function(e){
		//유효성 체크
		const title = title.value;
		const writer = writer.value;
		const content = content.value;
		
		if(!title){
			alert('제목을 입력하세요!!');
			e.preventDefault();
			return;
		}
		if(!writer){
			alert('작성자를 입력하세요!!');
			e.preventDefault();
			return;
		}
		if(!content){
			alert('내용을 입력하세요1!');
			e.preventDefault();
			return;
		}

	});
</script>
</html>