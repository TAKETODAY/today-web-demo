<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>注册</title>
	</head>
<body>


	<form action="register" method="POST">
		userId:<input type="text" name="userId"><br>
		age:<input type="text" name="age"><br>
		userName:<input type="text" name="userName"><br>
		sex: 男：<input type="radio" name="sex" value="男"> 女：<input type="radio" name="sex" value="女"><br>
		passwd:<input type="password" name="passwd"><br>
		<input type="submit" value="立即注册">
	</form>



</body>
</html>
