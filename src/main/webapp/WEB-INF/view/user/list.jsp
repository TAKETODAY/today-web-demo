<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>用户信息</title>
	</head>
<body>

	<h1>${msg}</h1>

	<c:forEach items="${users}" var="user">
		用户名：${user.userId}<br/>
		姓名：${user.userName}<br/>
		性别：${user.sex}<br/>
		年龄：${user.age}<br/>
	</c:forEach>

</body>
</html>
