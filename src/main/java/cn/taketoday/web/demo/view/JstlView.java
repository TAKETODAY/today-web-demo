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
package cn.taketoday.web.demo.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.taketoday.context.annotation.Value;
import cn.taketoday.context.factory.InitializingBean;
import cn.taketoday.web.view.JstlViewResolver;
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
public class JstlView extends JstlViewResolver implements InitializingBean {

    @Value("#{view.prefix}")
    private String prefix;

    @Value("#{view.suffix}")
    private String suffix;

    @Value("#{view.encoding}")
    private String encoding;

//	protected Locale locale = Locale.CHINA;

    @Override
    public void resolveView(String templateName, //
            HttpServletRequest request, HttpServletResponse response) throws Throwable //
    {
        super.resolveView(templateName, request, response);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Configuration My Jstl View Resolver Success.");
    }

}
