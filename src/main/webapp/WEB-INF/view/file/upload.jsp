<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta id="contextPath" content="${contextPath}">
		<title>文件</title>
	</head>
<body>

	<form action="${contextPath}/upload" method="POST" enctype="multipart/form-data">
		FILE :<input type="file" name="uploadFile" /><br /> 
		<input type="submit" value="上传文件" />
	</form>
	
	<br>
	<br>
	<input type="file" name="uploadFile" id="file">
	<br>
	<br>
	
	<form action="${contextPath}/upload/multi" method="POST" enctype="multipart/form-data">
		FILE 1:<input type="file" name="files" /><br /> 
		FILE 2:<input type="file" name="files" /><br /> 
		FILE 3:<input type="file" name="files" /><br /> 
		<input type="submit" value="上传文件" />
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

function ajax(url,params,method,async,callback,errCall){
	$.ajax({
		"url":url,
		"data":params,
		"type":method,
		"async":async,
		"contentType": "application/json; charset=utf-8",
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
}

var users = [
	{"userName" : "TODAY", "age" : 20, "userId" : "666", "passwd" : "6666", "sex" : "男"},
	{"userName" : "TODAY1", "age" : 70, "userId" : "6665", "passwd" : "66666" ,  "sex" : "男"},
	{"userName" : "TODAY2", "age" : 70, "userId" : "66655", "passwd" : "666666" , "sex" : "男"},
	{"userName" : "TODAY3", "age" : 60, "userId" : "666555", "passwd" : "6666666",  "sex" : "男"}
]

var user = "{\"userName\": \"TODAY\", \"age\" : 20 ,\"passwd\": \"passwd\"}";

function post(){
	ajax(contextPath+"/body","{\"user\":" + user+ "}", "POST",true,function(data){
		alert(data.userName);
		alert(data.age);
		alert(data.passwd);
	}, function(){
		alert("error");
	});
}

function postList(){
	ajax(contextPath+"/body/list", "{\"users\":"+JSON.stringify(users)+ "}", "POST",true,function(data){
		$.each(data, function (index, user) {
			$("#data").append(user.sex + "</br>");
			$("#data").append(user.age + "</br>");
			$("#data").append(user.userId + "</br>");
			$("#data").append(user.userName + "</br>");
		});

	}, function(){
		alert("error");
	});
}

</script>

<script>
	var contextPath = $("#contextPath").attr("content");
    $("#file").change(function () {
        var formDate = new FormData();
        formDate.append("uploadFile",$('#file')[0].files[0]);
        $.ajax({
            url:contextPath +  "/upload",
            data:formDate,
            cache: false,
            type:"POST",
            processData: false,
/*             contentType: "multipart/form-data", */
            contentType: false,
            success:function (data) {
                alert(data);
            }
        })
    })
</script>

</html>
