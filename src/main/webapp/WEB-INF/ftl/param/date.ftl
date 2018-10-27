<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>${msg}</title>
	</head>
<body>

	<h1>${msg}</h1>

	<form action="date" method="POST">
			userId:<input type="text" name="userId"><br>
			age:<input type="text" name="age"><br>
			userName:<input type="text" name="userName"><br>
			sex: 男：<input type="radio" name="sex" value="男"> 
			女：<input type="radio" name="sex" value="女"><br>
			passwd:<input type="password" name="passwd"><br>
			brithday:<input type="date" name="brithday"><br></br>
		<input type="submit" value="添加用户">
	</form>
	
</body>
</html>
