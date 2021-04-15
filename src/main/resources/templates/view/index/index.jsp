<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML> 
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Index ${q}</title>
	</head>
<body>

<h3>URL: ${url}
<br>
	<c:forEach items="${q}" var="it">
		q:${it}<br>
	</c:forEach>
	
	<c:forEach items="${Q}" var="w">
		Q:${w}<br>
	</c:forEach>

<br>
	userId:${userId}
<br>
	userName:${userName}
<br>
</h3>
</body>
</html>
