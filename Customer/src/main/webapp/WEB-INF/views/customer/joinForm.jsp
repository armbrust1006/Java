<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="resources/scripts/jsfile.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<title>JoinForm</title>
</head>
<body>
	<div align="center">
		<form action="join" method="post" onsubmit="return joinCheck()">
			<table border="1">
				<tr>
					<td align="center">ID</td>
					<th align="left"><input type="text" name="custid" id="custid"
						readonly="readonly"></th>
					<th><input type="button" value="ID 중복확인"
						onclick="idCheckForm()"></th>
				</tr>
				<tr>
					<td align="center">비밀번호</td>
					<th colspan="2" align="left"><input type="password"
						name="password" id="password1"></th>
				</tr>
				<tr>
					<td align="center">비밀번호 확인</td>
					<th colspan="2" align="left"><input type="password"
						id="password2"></th>
				</tr>
				<tr>
					<td align="center">이름</td>
					<th colspan="2" align="left"><input type="text" name="name"
						id="name"></th>
				</tr>
				<tr>
					<td align="center">이메일</td>
					<th colspan="2" align="left"><input type="text" name="email"
						id="email"></th>
				</tr>
				<tr>
					<td align="center">고객구분</td>
					<th colspan="2" align="left"><input type="radio"
						name="division" value="personal" checked> 개인 <input
						type="radio" name="division" value="conpany"> 기업</th>
				</tr>
				<tr>
					<td align="center">식별번호</td>
					<th colspan="2" align="left"><input type="text" name="idno"
						id="idno"></th>
				</tr>
				<tr>
					<td align="center">주소</td>
					<th colspan="2"><input type="text" name="address" id="address"
						style="width: 300px;"></th>
				</tr>
				<tr align="center">
					<th colspan="3"><input type="submit" value="가입">
						&nbsp;&nbsp;<input type="reset" value="다시 쓰기">
						&nbsp;&nbsp;<input type="button" value="되돌아가기"
						onclick="location.href='./'"></th>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>