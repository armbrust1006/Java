<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/scripts/jsfile.js"></script>
<title>ID Checks</title>
</head>
<body>
	<div>
		<form action="idCheck" method="post" onsubmit="return idCheck()">
			<input type="text" name="custid" id="custid" value="${id}"> <input
				type="submit" value="ID 체크" placeholder="ID 입력">
		</form>
		<c:if test="${check}">
			<c:choose>
				<c:when test="${choice}">
					<c:out value="사용 가능한 아이디 입니다."></c:out>
					<input type="button" value="사용하기" onclick="idSelect('${id}')">
				</c:when>
				<c:otherwise>
					<c:out value="중복된 아이디가 있습니다. 다른 아이디를 입력해주세요!"></c:out>
				</c:otherwise>
			</c:choose>
		</c:if>
	</div>
</body>
</html>