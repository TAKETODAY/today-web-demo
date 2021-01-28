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
				"https://taketoday.cn/framework/web/dtd/web-configuration-2.3.3.dtd">

<!--
 	"https://taketoday.cn/framework/web/dtd/web-configuration-2.3.3.dtd">
-->
<Web-Configuration>

    <controller prefix="/error/">
        <action resource="400" name="BadRequest" status="400" />
        <action resource="403" name="Forbidden" status="403" />
        <action resource="404" name="NotFound" status="404" />
        <action resource="500" name="ServerIsBusy" status="500" />
        <action resource="405" name="MethodNotAllowed" status="405" />
    </controller>

    <controller>
        <action resource="redirect:https://taketoday.cn" name="today" />
        <action resource="redirect:https://github.com" name="github" />
        <action resource="redirect:/login" name="login.do" />
    </controller>

    <controller class="cn.taketoday.web.demo.controller.XMLController" name="xmlController" prefix="/xml/">
        <action name="obj" method="obj" />
        <action name="test" resource="test" method="test"/>
    </controller>

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
upload.maxFileSize 	= 1024MB
upload.maxRequestSize 		= 1GB
upload.fileSizeThreshold	= 2048MB

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
> 示例
- [普通参数注入示例](src/main/java/cn/taketoday/web/demo/controller/IndexController.java)
- [注解参数注入示例](src/main/java/cn/taketoday/web/demo/controller/AnnotationController.java)
- [登录示例](src/main/java/cn/taketoday/web/demo/controller/UserController.java)
- [文件上传示例](src/main/java/cn/taketoday/web/demo/controller/FileController.java)
- [RequestBody示例](src/main/java/cn/taketoday/web/demo/controller/RequestBodyController.java)
- [PathVariable示例](src/main/java/cn/taketoday/web/demo/controller/PathVariableController.java)
- [自定义多段式文件上传解析器示例](src/main/java/cn/taketoday/web/demo/multipart/CustomMultipartResolver.java)
- [AOP示例](src/main/java/cn/taketoday/web/demo/aspect/LogAspect.java)
- [原型Controller示例](src/main/java/cn/taketoday/web/demo/controller/PrototypeController.java)
- [RedirectModel示例](src/main/java/cn/taketoday/web/demo/controller/RedirectModelController.java)
- [拦截器示例](src/main/java/cn/taketoday/web/demo/controller/InterceptorController.java)
- [StandardArgumentsController示例](src/main/java/cn/taketoday/web/demo/controller/StandardArgumentsController.java)
- [@ControllerAdvice示例](src/main/java/cn/taketoday/web/demo/config/ApplicationExceptionAdvice.java)
- [WebMvcConfiguration示例](src/main/java/cn/taketoday/web/demo/config/WebMvcConfig.java)
- [自定义参数转换器示例](src/main/java/cn/taketoday/web/demo/converter/DateConverter.java)
- [自定义参数解析器示例](src/main/java/cn/taketoday/web/demo/config/UserSessionParameterResolver.java)
- [自定义参数解析器示例](src/main/java/cn/taketoday/web/demo/config/PageableMethodArgumentResolver.java)

### 联系方式

- 邮箱 taketoday@foxmail.com

### 开源协议

请查看 [GNU GENERAL PUBLIC LICENSE](https://github.com/TAKETODAY/today-web-demo/blob/master/LICENSE)

