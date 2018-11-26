# TODAY WEB DEMO

> TODAY WEB Framework Demo [TODAY WEB](https://github.com/TAKETODAY/today-web)

> 整个项目不需要在web.xml中声明有关框架的 `Listener`,`Servlet`,`Filter`

> 可以在web.xml中指定配置文件:

```xml
<context-param>
	<param-name>WebMvcConfigLocation</param-name>
	<param-value>xxx.xml</param-value>
</context-param>
```
> 声明配置文件位置的步骤可有可无。
- 声明配置文件位置后应用启动速度更快
- 未声明配置文件位置，框架会扫描项目下所有目录速度慢
- 如果没有发现配置文件将使用默认配置
- 支持多个配置文件

> XML配置文件:

```xml
<!DOCTYPE Web-Configuration PUBLIC 
	"-//TODAY BLOG//Web - Configuration DTD 2.0//CN"
		"https://taketoday.cn/framework/web/dtd/web-configuration-2.3.0.dtd">

<Web-Configuration>

	<static-resources mapping="/assets/*" />

	<multipart class="cn.taketoday.web.multipart.CommonsMultipartResolver">
		<upload-encoding>#{upload.encoding}</upload-encoding>
		<upload-maxFileSize>#{upload.maxFileSize}</upload-maxFileSize>
		<upload-maxRequestSize>#{upload.maxRequestSize}</upload-maxRequestSize>
		<upload-fileSizeThreshold>#{upload.fileSizeThreshold}</upload-fileSizeThreshold>
	</multipart>

	<!-- <view-resolver class="cn.taketoday.web.view.JstlViewResolver"> -->
	<view-resolver class="cn.taketoday.web.view.FreeMarkerViewResolver">
		<view-prefix>#{view.prefix}</view-prefix>
		<view-suffix>#{view.suffix}</view-suffix>
		<view-encoding>#{view.encoding}</view-encoding>
	</view-resolver>
	
	<common prefix="/error/">
		<view res="400" name="BadRequest" />
		<view res="403" name="Forbidden" />
		<view res="404" name="NotFound" />
		<view res="500" name="ServerIsBusy" />
		<view res="405" name="MethodNotAllowed" />
	</common>
	
</Web-Configuration>
```

> Properties 配置

```properties
############################################ view 
view.suffix 	= .ftl
view.encoding 	= UTF-8
view.prefix 	= /WEB-INF/ftl

############################################ upload
upload.encoding 	= UTF-8
upload.maxFileSize 	= 10240000
upload.maxRequestSize 		= 1024000000
upload.fileSizeThreshold	= 1000000000

############################################ freemarker
freemarker.tag_syntax 				= auto_detect
freemarker.template_update_delay 	= 0
freemarker.locale 					= UTF-8
freemarker.default_encoding 		= UTF-8
freemarker.number_format	 		= 0.####
freemarker.datetime_format 			= yyyy-MM-dd HH:mm:ss
freemarker.date_format 				= yyyy-MM-dd
freemarker.time_format				= HH:mm:ss
freemarker.url_escaping_charset		= UTF-8
freemarker.classic_compatible 		= true
freemarker.template_exception_handler 	= ignore
freemarker.log_template_exceptions 		= false

```
> 实例
- [普通参数注入实例](src/main/java/cn/taketoday/web/demo/controller/IndexController.java)
- [注解参数注入实例](src/main/java/cn/taketoday/web/demo/controller/AnnotationController.java)
- [登录实例](src/main/java/cn/taketoday/web/demo/controller/UserController.java)
- [文件上传实例](src/main/java/cn/taketoday/web/demo/controller/FileController.java)
- [RequestBody实例](src/main/java/cn/taketoday/web/demo/controller/RequestBodyController.java)
- [PathVariable实例](src/main/java/cn/taketoday/web/demo/controller/PathVariableController.java)
- [自定义模板解析器实例](src/main/java/cn/taketoday/web/demo/view/JstlView.java)
- [自定义参数转换器实例](src/main/java/cn/taketoday/web/demo/converter/DateConverter.java)
- [自定义多段式文件上传解析器实例](src/main/java/cn/taketoday/web/demo/multipart/CustomMultipartResolver.java)
- [AOP](src/main/java/cn/taketoday/web/demo/aspect/LogAspect.java)


### 联系方式
- 邮箱 taketoday@foxmail.com

### 开源协议

请查看 [GNU GENERAL PUBLIC LICENSE](https://github.com/TAKETODAY/today-web-demo/blob/master/LICENSE)

