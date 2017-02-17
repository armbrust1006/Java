<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>[ 게시판 ]</h1>
		<c:if test="${not empty sessionScope.loginId}">
			<input type="button" value="글쓰기"
				onclick="location.href='board/write'">
		</c:if>
		<form action="">
			<table>
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
					<th></th>
				</tr>
				<c:forEach items="${board}">
					<tr>
						<td>${boardnum}</td>
						<td><a href="/board/boardRead?${boardnum}" type="hidden">${title}</a></td>
						<td><a>${custid}</a></td>
						<td><fmt:formatDate value="${inputdate}" type="date"
								dateStyle="medium" /></td>
						<td>${hits}</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
</body>
</html>