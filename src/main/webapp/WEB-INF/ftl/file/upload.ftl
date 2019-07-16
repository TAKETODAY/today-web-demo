<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta id="contextPath" content="${contextPath}">
<title>文件</title>
</head>

<style>
.progress {
	width: 300px;
	height: 20px;
	border: 1px solid hotpink;
	border-radius: 20px;
	overflow: hidden;
}

.step {
	height: 100%;
	width: 0;
	background: greenyellow;
}
</style>
<body>

	<form action="${contextPath}/upload" method="POST"
		enctype="multipart/form-data">
		FILE :<input type="file" name="uploadFile" /><br /> <input
			type="submit" value="上传文件" />
	</form>

	<br>
	<br>
	<input type="file" name="uploadFile" id="file">
	<br>
	<br>

	<form action="${contextPath}/upload/multi" method="POST"
		enctype="multipart/form-data">
		FILE 1:<input type="file" name="files" /><br /> FILE 2:<input
			type="file" name="files" /><br /> FILE 3:<input type="file"
			name="files" /><br /> <input type="submit" value="上传文件" />
	</form>

	<button onclick="post()">请求 单POJO requestBody</button>
	<button onclick="postList()">请求 List POJO requestBody</button>


	<div id="data"></div>

</body>

<script type="text/javascript" src="${contextPath}/assets/js/jquery.min.js"></script>
<script type="text/javascript">
	/* function ajax(url,params,method,async,callback,errCall){
	 $.ajax({
	 "url":url,
	 "data":params,
	 "type":method,
	 "async":async,
	 "contentType ": "application/json; charset=utf-8",
	 "dataType":"json",
	 "traditional": true,
	 "success":function(data){
	 callback(data);
	 },
	 "error":function(){
	 if(errCall != null){
	 errCall();
	 }
	 }
	 });
	 } */

	function ajax(url, params, method, async, callback, errCall) {
		$.ajax({
			"url" : url,
			"data" : params,
			"type" : method,
			"async" : async,
			"contentType" : "application/json; charset=utf-8",
			"dataType" : "json",
			"traditional" : true,
			"success" : function(data) {
				callback(data);
			},
			"error" : function() {
				if (errCall != null) {
					errCall();
				}
			}
		});
	}

	var users = [ {
		"userName" : "TODAY",
		"age" : 20,
		"userId" : "666",
		"passwd" : "6666",
		"sex" : "男"
	}, {
		"userName" : "TODAY1",
		"age" : 70,
		"userId" : "6665",
		"passwd" : "66666",
		"sex" : "男"
	}, {
		"userName" : "TODAY2",
		"age" : 70,
		"userId" : "66655",
		"passwd" : "666666",
		"sex" : "男"
	}, {
		"userName" : "TODAY3",
		"age" : 60,
		"userId" : "666555",
		"passwd" : "6666666",
		"sex" : "男"
	} ]

	var user = "{\"userName\": \"TODAY\", \"age\" : 20 ,\"passwd\": \"passwd\"}";

	function post() {
		ajax(contextPath + "/body", "{\"user\":" + user + "}", "POST", true,
				function(data) {
					alert(data.userName);
					alert(data.age);
					alert(data.passwd);
				}, function() {
					alert("error");
				});
	}

	function postList() {
		ajax(contextPath + "/body/list", "{\"users\":" + JSON.stringify(users)
				+ "}", "POST", true, function(data) {
			$.each(data, function(index, user) {
				$("#data").append(user.sex + "</br>");
				$("#data").append(user.age + "</br>");
				$("#data").append(user.userId + "</br>");
				$("#data").append(user.userName + "</br>");
			});
		}, function() {
			alert("error");
		});
	}
</script>

<script>
	var contextPath = $("#contextPath").attr("content");
	$("#file").change(function() {
		var formData = new FormData();
		formData.append("uploadFile", $('#file')[0].files[0]);
		$.ajax({
			url : contextPath + "/upload",
			data : formData,
			cache : false,
			type : "POST",
			processData : false,
			contentType: "multipart/form-data",
			contentType : false,
			success : function(data) {
				alert(data);
			}
		})
	})
</script>


<script>
	//  如果我们要使用 ajax2.0 结合FormData 来提交数据 必须使用 post
	/**
	document.querySelector('input[type=button]').onclick = function() {
		//1.创建对象
		var xhr = new XMLHttpRequest();
		//2.设置请求行(get请求数据写在url后面)
		xhr.open('post', './upload');
		//3.设置请求头(get请求可以省略,post不发送数据也可以省略)
		// 如果使用的时 formData可以不写 请求头 写了 无法正常上传文件
		//  xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		//3.5注册回调函数
		xhr.onload = function() {
			console.log(xhr.responseText);
		}
		// XHR2.0新增 上传进度监控
		xhr.upload.onprogress = function(event) {
			//  console.log(event);
			var percent = event.loaded / event.total * 100 + '%';
			console.log(percent);
			// 设置 进度条内部step的 宽度
			document.querySelector('.step').style.width = percent;
		}
		// XHR2.0新增 
		var data = new FormData(document.querySelector('form'));
		//4.请求主体发送(get请求为空，或者写null，post请求数据写在这里，如果没有数据，直接为空或者写null)
		xhr.send(data);
	}
	*/
</script>

</html>
