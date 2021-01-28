/**
 * Original Author -> 杨海健 (taketoday@foxmail.com) https://taketoday.cn
 * Copyright © TODAY & 2017 - 2021 All Rights Reserved.
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

import javax.servlet.http.HttpSession;

import cn.taketoday.context.annotation.Singleton;
import cn.taketoday.web.RequestContext;
import cn.taketoday.web.demo.Constant;
import cn.taketoday.web.exception.UnauthorizedException;
import cn.taketoday.web.handler.MethodParameter;
import cn.taketoday.web.resolver.OrderedParameterResolver;

/**
 * @author TODAY <br>
 *         2019-07-25 00:56
 */
@Singleton
public class UserSessionParameterResolver implements OrderedParameterResolver {

    @Override
    public boolean supports(MethodParameter parameter) {
        return parameter.isAnnotationPresent(UserSession.class);
    }

    @Override
    public Object resolveParameter(final RequestContext requestContext, final MethodParameter parameter) throws Throwable {

        final Object attribute = requestContext.nativeSession(HttpSession.class).getAttribute(Constant.USER_INFO);
        if (attribute == null) {
            throw new UnauthorizedException();
        }
        return attribute;
    }

    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE;
    }
}
