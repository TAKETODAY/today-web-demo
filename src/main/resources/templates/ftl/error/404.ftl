<!DOCTYPE HTML>
<html>
<head>
	<title>404 Not Found</title>
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://unpkg.com/nprogress@0.2.0/nprogress.css" type="text/css">
<style type="text/css">
	*{margin:0;font-family:Verdana,"Microsoft YaHei"!important;padding:0}
	body{background:#dad9d7;font-family:Verdana,"Microsoft YaHei"!important}
	.bg{width:100%;background:url(${CDN}/assets/images/404/back.jpg);background-repeat:no-repeat;background-position:center}
	.img{background:url(${CDN}/assets/images/404/head.png) no-repeat;position:relative;top:160px;width:178px;height:166px}
	#box{width:100%;height:100%}
	#code{font-size:55px;margin-top:170px;font-family:Verdana,"Microsoft YaHei"!important}
	#msg{margin:20px 0 20px 0}
	a{font-size:15px;text-decoration:none;color:#333}
	a:hover{text-decoration:underline}
	#home{margin-bottom:-5px;margin-right:2px}
	#refresh{margin-left:10px;margin-bottom:-5px;margin-right:3px}
	p{font-family:Verdana,"Microsoft YaHei"!important;margin-top:10px;font-size:15px}
	@media(max-width:768px){#code{font-size:35px;font-family:Verdana,"Microsoft YaHei"!important}}
	@media(max-width:500px){#code{font-size:25px;margin-top:-120px;font-family:Verdana,"Microsoft YaHei"!important}
	#msg{margin-top:230px;font-family:Verdana,"Microsoft YaHei"!important}a{margin-top:20px}.img{top:120px}}
</style>
</head>
<body>
	<div class="bg" align="center">
		<div id="box">
			<div class="img"></div>
			<div id="code">404 NOT Found !</div>
			<div id="msg" style="font-size: 15px">您请求的页面,我找遍了整个服务器都没找到 !</div>
		</div>
		<a class="text" href="${contextPath}/index"><img id="home" src="${CDN}/assets/images/404/home.png" width="23"/>返回首页</a>
		<a class="text" href="javascript:(location=location)">
			<img id="refresh" src="${CDN}/assets/images/404/refresh.png" width="20"/>刷新页面
		</a>
		<p style="color:#7e8283;">${Copyright}</p>
	</div>
</body>
<script type="text/javascript" src="https://unpkg.com/nprogress@0.2.0/nprogress.js"></script>
<script type="text/javascript">
	NProgress.configure({ minimum: 0.2 ,ease: 'ease', speed: 500,trickleRate: 0.1});
	NProgress.start();
	window.onload=function () {
		NProgress.done();
	}
	</script>
</html>
