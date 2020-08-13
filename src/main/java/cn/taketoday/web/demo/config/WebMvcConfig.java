/**
 * Original Author -> 杨海健 (taketoday@foxmail.com) https://taketoday.cn
 * Copyright © TODAY & 2017 - 2020 All Rights Reserved.
 *
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *   
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see [http://www.gnu.org/licenses/]
 */
package cn.taketoday.web.demo.config;

import cn.taketoday.context.Ordered;
import cn.taketoday.context.annotation.Autowired;
import cn.taketoday.context.annotation.Singleton;
import cn.taketoday.context.annotation.Value;
import cn.taketoday.web.config.WebMvcConfiguration;
import cn.taketoday.web.demo.controller.FunctionController;
import cn.taketoday.web.demo.interceptor.LoginInterceptor;
import cn.taketoday.web.registry.FunctionHandlerRegistry;
import cn.taketoday.web.registry.ResourceHandlerRegistry;
import cn.taketoday.web.registry.ViewControllerHandlerRegistry;
import cn.taketoday.web.resource.CacheControl;

/**
 * @author TODAY <br>
 *         2019-07-20 13:48
 */
@Singleton
public class WebMvcConfig implements WebMvcConfiguration {

    // D:\www.yhj.com\webapps\today-web-demo
    @Value("#{site.server.appPath}")
    private String path;

    // swagger-resources/configuration/ui
    @Override
    public void configureResourceHandler(ResourceHandlerRegistry registry) {

        registry.addResourceMapping("/assets/**")
//                .enableGzip()
//                .gzipMinLength(10240)
                .addLocations("file:///D:/www.yhj.com/webapps/today-web-demo/assets/", "file:///" + path + "/upload/");

        registry.addResourceMapping("/webjars/**")
                .addLocations("classpath:/META-INF/resources/webjars/");

        registry.addResourceMapping("/swagger/**")
                .addLocations("classpath:/META-INF/resources/");

        registry.addResourceMapping("/favicon.ico")
                .addLocations("classpath:/favicon.ico")
                .cacheControl(CacheControl.create().publicCache());

        registry.addResourceMapping(LoginInterceptor.class)
                .setOrder(Ordered.HIGHEST_PRECEDENCE)
                .setPathPatterns("/assets/admin/**")
                .addLocations("file:///D:/dev/www.yhj.com/webapps/today-web-demo/assets/admin/");
    }

    @Autowired
    private FunctionController functionController;

    @Override
    public void configureViewController(ViewControllerHandlerRegistry registry) {
        registry.addViewController("/github", "redirect:https://github.com");
        registry.addViewController("/login.do")
                .setResource("redirect:/login");
    }

    @Override
    public void configureFunctionHandler(FunctionHandlerRegistry registry) {

        registry.get("/function", functionController::function);
        registry.get("/function/test", functionController::test);
        registry.get("/function/script", functionController::script);

        registry.get("/function/error/500", (context) -> {
            context.sendError(500);
        });
    }
}
