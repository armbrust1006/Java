<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="scripts/jsfile.js"></script>
<link rel="stylesheet" type="css" href="css/style.css">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="join" method="post">
			<table>
				<tr>
					<td>ID</td>
					<th><input type="text" name="custid" readonly="readonly"></th>
					<th><input type="button" value="ID 중복확인" onclick="idCheck()"></th>
				</tr>
				<tr>
					<td>비밀번호</td>
					<th colspan="2"><input type="password" name="password"></th>
				</tr>
				<tr>
					<td>이름</td>
					<th colspan="2"><input type="text" name="name"></th>
				</tr>
				<tr>
					<td>이메일</td>
					<th colspan="2"><input type="text" name="email"></th>
				</tr>
				<tr>
					<td>고객구분</td>
					<th colspan="2"><input type="radio" name="division"
						value="personal" checked> 개인 <input type="radio"
						name="division" value="conpany"> 기업</th>
				</tr>
				<tr>
					<td>식별번호</td>
					<th colspan="2"><input type="text" name="idno"></th>
				</tr>
				<tr>
					<td>주소</td>
					<th colspan="2"><input type="text" name="address"
						style="width: 290px;"></th>
				</tr>
				<tr align="center">
					<th colspan="3"><input type="submit" value="가입">
						&nbsp;&nbsp;<input type="reset" value="다시 쓰기">
						&nbsp;&nbsp;<input type="button" value="되돌아가기"
						onclick="localhost.href='/'"></th>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>