<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/jsfile.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>[ 게시판 ]</h1>
		<c:if test="${not empty sessionScope.loginId}">
			<input type="button" value="글쓰기" onclick="location.href='boardWrite'">
		</c:if>
		<c:if test="${not empty errorMsg}">
			<script type="text/javascript">
				alert('${errorMsg}');
			</script>
			<c:remove var="errorMsg"/>
		</c:if>
		<input type="button" value="처음으로" onclick="location.href='${pageContext.request.contextPath}/'"/>
		<input type="button" value="목록보기" onclick="location.href='boardList'"/>
		<c:if test="${not empty listBoard}">
			<table border="1">
				<tr>
					<th colspan="5">
						<form id="pagingForm" action="list" method="get">
							<div align="right">
								<select name="searchTitle" style="height: 30px;">
									<option value="title">제목</option>
									<option value="custid">작성자</option>
									<option value="content">내용</option>
								</select>
								<input type="hidden" name="page" id="page"/>
								<input type="text" name="searchText" value="${searchText}" style="height: 20px;"/>
								<input type="button" onclick="pagingForSubmit(1)" value="검색"/>
							</div>
						</form>
					</th>
				</tr>
				<tr>
					<th>글번호</th>
					<th style="width: 200px;">제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
				<c:forEach items="${listBoard}" var="board">
					<tr>
						<td align="center">${board.boardnum}</td>
						<td><a href="boardRead?boardnum=${board.boardnum}" type="hidden">${board.title}</a></td>
						<td><a>${board.custid}</a></td>
						<td align="center"><fmt:formatDate value="${board.inputdate}" type="date" dateStyle="medium" /></td>
						<td align="center">${board.hits}</td>
					</tr>
				</c:forEach>
			</table>
			<div>
			<a href="javascript:pagingForSubmit(${navi.currentPage - navi.pagePerGroup})">◁◁</a>
			<a href="javascript:pagingForSubmit(${navi.currentPage - 1})">◀</a>
			<c:forEach begin="${navi.startPageGroup}" end="${navi.endPageGroup}" var="page">
				<a href='javascript:pagingForSubmit(${page})'>${page}</a>
			</c:forEach>
			<a href="javascript:pagingForSubmit(${navi.currentPage + 1})">▶</a>
			<a href="javascript:pagingForSubmit(${navi.currentPage + navi.pagePerGroup})">▷▷</a>
			</div>
		</c:if>
	</div>
</body>
</html>