<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<html>
<head>
<script type="text/javascript" src="resources/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#ajax1").on("click", function() {
			var mapData = {
				custid : $("#custid").val(),
				password : $("#password").val(),
				text : $("#text").val()
			}
			var textIndex = new Array("custid", "password", "text");
			$.ajax({
				method : "get",
				url : "ajaxtest",
				data : mapData,
				success : function(result) { //200번  값을 받은 경우 처리 함수
					alert(JSON.stringify(result));
					$("#result1").html(result.custid);
					$("#result2").html(result.password);
					$("#result3").html(result.text);
				},
				error : function() {
					alert("error");
				}
			});
		});

		$("#ajax2").on("click", function() {
			$.ajax({
				method : "post",
				url : "ajaxtest2",
				success : function(resp) {
					/* alert(JSON.stringify(resp)); */

					$("#result").html(JSON.stringify(resp));
				},
				error : function() {
					alert("에러다...");
				}
			});
		});

		$("#ajax3").on("click", function() {
			$.ajax({
				method : "post",
				url : "ajaxtest3",
				success : function(resp) {
					/* alert(JSON.stringify(resp)); */
					var content = "";
					$(resp).each(function(index, item) {
						content += "<h3>" + item.custid + " "
							+ item.password + " "
							+ item.text + "</h3><br>";
					});
					$("#result11").html(content);
				},
				error : function() {
					alert("에러다...");
				}
			});
		});
	});
</script>
<title>Home</title>
</head>
<body>
	<h1>Ajax Test</h1>
	<div>
		<input type="text" name="custid" id="custid"><br> <input
			type="password" name="password" id="password"><br> <input
			type="text" name="text" id="text"><br> <input
			type="button" value="Ajax1" id="ajax1">
	</div>
	<div>
		받은 ID : <span id="result1"></span>
	</div>
	<div>
		받은 PW : <span id="result2"></span>
	</div>
	<div>
		받은 Text : <span id="result3"></span>
	</div>

	<h1>Ajax Test2</h1>
	<input type="button" id="ajax2" value="눌러보라">
	<div>
		<span id="result"></span>
	</div>

	<h1>Ajax Test3</h1>
	<input type="button" id="ajax3" value="눌러보라">
	<div>
		<span id="result11"></span>
	</div>
</body>
</html>
