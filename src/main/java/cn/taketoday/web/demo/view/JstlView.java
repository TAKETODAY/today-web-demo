/**
 * Original Author -> 杨海健 (taketoday@foxmail.com) https://taketoday.cn
 * Copyright © Today & 2017 - 2018 All Rights Reserved.
 * 
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package cn.taketoday.web.demo.view;

import cn.taketoday.context.annotation.Value;
import cn.taketoday.web.WebApplicationContext;
import cn.taketoday.web.view.JstlViewResolver;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Today <br>
 *         2018-10-27 14:39
 */
@Slf4j
@NoArgsConstructor
//@Component(Constant.VIEW_RESOLVER)
public final class JstlView extends JstlViewResolver {

	@Value("#{view.prefix}")
	protected String prefix;

	@Value("#{view.suffix}")
	protected String suffix;

	@Value("#{view.encoding}")
	protected String encoding;

	protected Locale locale = Locale.CHINA;

	@Override
	public void resolveView(String templateName, //
			HttpServletRequest request, HttpServletResponse response) throws Exception //
	{
		super.resolveView(templateName, request, response);
	}

	@Override
	public void initViewResolver(WebApplicationContext applicationContext) {
		log.info("Configuration My Jstl View Resolver Success.");
	}

}
