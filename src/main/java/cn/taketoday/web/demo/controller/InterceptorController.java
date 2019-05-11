/**
 * Original Author -> 杨海健 (taketoday@foxmail.com) https://taketoday.cn
 * Copyright © TODAY & 2017 - 2019 All Rights Reserved.
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
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package cn.taketoday.web.demo.controller;

import cn.taketoday.web.annotation.GET;
import cn.taketoday.web.annotation.Interceptor;
import cn.taketoday.web.annotation.RequestMapping;
import cn.taketoday.web.annotation.RestController;
import cn.taketoday.web.demo.interceptor.FirstInterceptor;
import cn.taketoday.web.demo.interceptor.FourthInterceptor;
import cn.taketoday.web.demo.interceptor.LoginInterceptor;
import cn.taketoday.web.demo.interceptor.SecondInterceptor;
import cn.taketoday.web.demo.interceptor.ThirdInterceptor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author TODAY <br>
 *         2019-04-09 17:11
 */
@Slf4j
@RestController
@RequestMapping("interceptor")
@Interceptor({ FirstInterceptor.class, SecondInterceptor.class, ThirdInterceptor.class, FourthInterceptor.class })
public class InterceptorController {

	@GET
	@Interceptor(LoginInterceptor.class)
	public String index() {
		log.info("index");
		return "index";
	}

	@GET("/exclude/first")
	@Interceptor(exclude = FirstInterceptor.class)
	public String exclude() {
		log.info("exclude FirstInterceptor");
		return "exclude FirstInterceptor";
	}

	@GET("/exclude/all")
	@Interceptor(exclude = { //
			FirstInterceptor.class, SecondInterceptor.class, ThirdInterceptor.class, FourthInterceptor.class //
	})
	public String excludeAll() {
		log.info("exclude All");
		return "exclude All";
	}

}
