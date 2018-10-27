<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>用户信息</title>
	</head>
<body>

	<h1>${msg}</h1>
	${CDN}
	<#list users as user>
		用户名：${user.userId}<br/>
		姓名：${user.userName}<br/>
		性别：${user.sex}<br/>
		年龄：${user.age}<br/>
	</#list>

</body>
</html>
