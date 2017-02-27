<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/scripts/jsfile.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>[ 글 쓰기 ]</h1>
		<form action="boardWrite" method="post" enctype="multipart/form-data" onsubmit="return writeCheck()">
			<input type="hidden" name="custid" value="${sessionScope.loginId}">
			<table>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" id="title" style="width: 250px;"></td>
				</tr>
				<tr>
					<td colspan="2"><textarea rows="20" cols="40" name="content" id="content"></textarea></td>
				</tr>
				<tr align="center">
					<td colspan="2">
					<input type="submit" value="등록"> 
					<input type="button" value="게시판으로" onclick="location.href='boardList'">
					</td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="file" name="originalfile" style="width: 350px;">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>