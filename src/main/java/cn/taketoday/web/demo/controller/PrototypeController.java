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

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import cn.taketoday.context.annotation.Autowired;
import cn.taketoday.context.annotation.Prototype;
import cn.taketoday.web.RequestMethod;
import cn.taketoday.web.annotation.ActionMapping;
import cn.taketoday.web.annotation.GET;
import cn.taketoday.web.annotation.RequestMapping;
import cn.taketoday.web.annotation.RootController;
import cn.taketoday.web.demo.aspect.Logger;
import cn.taketoday.web.demo.domain.User;
import cn.taketoday.web.demo.service.UserService;
import cn.taketoday.web.ui.RedirectModel;
import cn.taketoday.web.validation.Errors;

/**
 * @author TODAY <br>
 *         2018-10-27 10:10
 */
@Prototype
@RootController
@RequestMapping("/prototype")
public class PrototypeController extends BaseController {

    private static final long serialVersionUID = -2144421103258985200L;

//	@Resource
    @Autowired
    private UserService userService;

    @GET("/login")
    @Logger("登录界面")
    public String login() {
        return "/login/login";
    }

    @Logger("登录")
//  @POST("/login")
    @ActionMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, RedirectModel redirectModel, @Valid User user, Errors error) {

        if (error.hasErrors()) {
            System.err.println(error.getAllErrors());
            redirectModel.attribute("msg", error.getAllErrors().toString());
            return "redirect:/login";
        }

        User login = userService.login(user);
        if (login == null) {
            redirectModel.attribute("userId", user.getUserId());
            redirectModel.attribute("msg", "登录失败");
            return "redirect:/login";
        }
        redirectModel.attribute("msg", "登录成功");
        session.setAttribute(USER_INFO, login);
        return "redirect:/user/info";
    }
}
