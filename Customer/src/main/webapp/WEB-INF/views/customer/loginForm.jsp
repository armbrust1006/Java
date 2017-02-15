<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="login" method="post">
			<table>
				<tr>
					<th>ID</th>
					<td><input type="text" name="custid"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td><input type="submit" value="로그인"> <input
						type="button" value="되돌아가기" onclick="location.href='./'"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>