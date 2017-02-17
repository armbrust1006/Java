<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/scripts/jsfile.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty errorMsg}">
		<script type="text/javascript">
			alert('${errorMsg}');
		</script>
	</c:if>
	<div id="login">
		<form action="login" method="post" onsubmit="return ">
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