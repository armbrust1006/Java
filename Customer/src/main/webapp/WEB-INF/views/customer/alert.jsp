<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	var message = '${message}';
	var url = '${url}';
	alert(message);
	if (url == '') {
		document.location.href = './';
	} else {
		document.location.href = url;
	}
</script>
<title>Insert title here</title>
</head>
<body>

</body>
</html>              