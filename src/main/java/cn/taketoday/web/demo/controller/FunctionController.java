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
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package cn.taketoday.web.demo.controller;

import java.io.IOException;

import cn.taketoday.context.annotation.Component;
import cn.taketoday.web.RequestContext;
import cn.taketoday.web.annotation.ResponseBody;
import cn.taketoday.web.ui.ModelAndView;

/**
 * 
 * @author Today <br>
 *         2018-10-27 10:07
 */
@Component
@ResponseBody
public class FunctionController {

    public String function(RequestContext request) {
        return "body:" + request.method() + " requestURI -> " + request.requestURI();
    }

    public String test(RequestContext request) {
        return "body:" + request.method() + " test -> " + request.requestURI();
    }

    public void script(RequestContext request) throws IOException {
        ModelAndView modelAndView = new ModelAndView(request);

        modelAndView.setContentType("text/html;charset=UTF-8");
        modelAndView.setView(new StringBuilder("<script>alert('HELLO， 你好 script');</script>"));
    }

}
