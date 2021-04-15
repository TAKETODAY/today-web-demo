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

	<form action="set" method="POST">
		<c:forEach begin="0" step="1" end="${max}" varStatus="i">
		
			userId:<input type="text" name="users[${i.index}].userId"><br>
			age:<input type="text" name="users[${i.index}].age"><br>
			userName:<input type="text" name="users[${i.index}].userName"><br>
			sex: 男：<input type="radio" name="users[${i.index}].sex" value="男"> 
			女：<input type="radio" name="users[${i.index}].sex" value="女"><br>
			passwd:<input type="password" name="users[${i.index}].passwd"><br></br>
	
		</c:forEach>
		<input type="submit" value="添加用户">
	</form>

</body>
</html>
