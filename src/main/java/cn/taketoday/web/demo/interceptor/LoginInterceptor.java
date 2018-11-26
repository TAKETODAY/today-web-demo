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
package cn.taketoday.web.demo.interceptor;

import cn.taketoday.web.demo.Constant;
import cn.taketoday.web.interceptor.HandlerInterceptor;
import cn.taketoday.web.mapping.HandlerMapping;
import cn.taketoday.web.utils.Json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author Today <br>
 *         2018-10-27 10:13
 */
public final class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean beforeProcess(HttpServletRequest request, //
			HttpServletResponse response, HandlerMapping handlerMapping) throws Exception //
	{
		if ((request.getSession().getAttribute(Constant.USER_INFO)) == null) {
			response.getWriter().print(JSON.toJSONString(new Json(false).setCode(401).setMsg("Login Time Out")));
			return false;
		}
		return true;
	}

}