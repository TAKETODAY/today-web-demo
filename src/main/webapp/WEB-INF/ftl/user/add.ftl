<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>用户信息</title>
	</head>
<body>

	<h1>${msg}</h1>

	<#assign length = 3 />

	<form action="list" method="GET">
		<#list 1..length as i>
			userId:<input type="text" name="users[${i}].userId"><br>
			age:<input type="text" name="users[${i}].age"><br>
			userName:<input type="text" name="users[${i}].userName"><br>
			sex: 男：<input type="radio" name="users[${i}].sex" value="男"> 
			女：<input type="radio" name="users[${i}].sex" value="女"><br>
			passwd:<input type="password" name="users[${i}].passwd"><br></br>
		</#list>
		<input type="submit" value="添加用户">
	</form>

</body>
</html>
