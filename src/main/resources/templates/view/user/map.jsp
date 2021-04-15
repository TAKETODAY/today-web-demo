<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>${msg}</title>
	</head>
<body>

	<h1>${msg}</h1>

	<form action="map" method="POST">
		userId:<input type="text" name="users['today_1'].userId"><br>
		age:<input type="text" name="users['today'].age"><br>
		userName:<input type="text" name="users['today'].userName"><br>
		sex: 男：<input type="radio" name="users['today'].sex" value="男"> 
		女：<input type="radio" name="users['today'].sex" value="女"><br>
		passwd:<input type="password" name="users['today'].passwd"><br></br>
		<input type="submit" value="提交">
	</form>

</body>
</html>
