<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
	<div>
		<h1>[ Spring Web 5 - SE Bank Step 4 ]</h1>
		<c:if test="${not empty sessionScope.loginId}">
			<hr>
			<h4>
				<c:out
					value="${sessionScope.loginName}(${sessionScope.loginId})님 환영합니다!"></c:out>
			</h4>
			<hr>
		</c:if>
		<ul>
			<c:choose>
				<c:when test="${empty loginId}">
					<li><a href="join">회원가입</a></li>
					<li><a href="login">로그인</a></li>
				</c:when>
				<c:when test="${not empty loginId}">
					<li><a href="logout">로그아웃</a></li>
					<li><a href="update">개인정보 수정</a></li>
				</c:when>
			</c:choose>
			<li><a href="board">게시판</a></li>
		</ul>
	</div>
</body>
</html>
