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
package cn.taketoday.web.demo.interceptor;

import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import cn.taketoday.web.RequestContext;
import cn.taketoday.web.demo.Constant;
import cn.taketoday.web.demo.view.Json;
import cn.taketoday.web.interceptor.HandlerInterceptor;
import cn.taketoday.web.mapping.WebMapping;

/**
 * 
 * @author Today <br>
 *         2018-10-27 10:13
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean beforeProcess(RequestContext requestContext, WebMapping webMapping) throws Throwable {

        if ((requestContext.nativeSession(HttpSession.class).getAttribute(Constant.USER_INFO)) == null) {

            requestContext.getWriter().write(JSON.toJSONString(Json.failed().setCode(401).setMsg("Login Time Out")));
            return false;
        }
        return true;
    }

}
