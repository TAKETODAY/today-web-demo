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

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import cn.taketoday.context.annotation.Autowired;
import cn.taketoday.web.RequestMethod;
import cn.taketoday.web.annotation.ActionMapping;
import cn.taketoday.web.annotation.Controller;
import cn.taketoday.web.annotation.GET;
import cn.taketoday.web.annotation.Interceptor;
import cn.taketoday.web.annotation.ResponseBody;
import cn.taketoday.web.demo.aspect.Logger;
import cn.taketoday.web.demo.domain.User;
import cn.taketoday.web.demo.interceptor.LoginInterceptor;
import cn.taketoday.web.demo.service.UserService;
import cn.taketoday.web.ui.RedirectModel;
import cn.taketoday.web.validation.Errors;

/**
 * 
 * @author Today <br>
 *         2018-10-27 10:09
 */
@Controller
public class UserController extends BaseController {

    private static final long serialVersionUID = -1;

    @Autowired
    private UserService userService;

    @GET("/login")
    @Logger("登录界面")
    public String login() {
        return "/login/login";
    }

    @Logger("登录")
//	@POST("/login")
    @ActionMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, RedirectModel redirectModel, @Valid User user, Errors error) {
        if (!error.hasErrors()) {

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
        System.err.println(error.getAllErrors());
        redirectModel.attribute("msg", error.getAllErrors().toString());
        return "redirect:/login";
    }

    @Logger("注册界面")
//	@ResponseStatus(value = 500, msg = "ERROR")
    @ActionMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "/register/register";
    }

    @Logger("注册")
    @ActionMapping(value = "/register", method = RequestMethod.POST)
    public String register(HttpServletRequest request, User user) {

        if (!userService.register(user)) {
            return "error!";
        }
        return "redirect:/login";
    }

    @ActionMapping(value = "/user/info", method = RequestMethod.GET)
    @Interceptor(LoginInterceptor.class)
    public String user(HttpServletRequest request) {
        request.setAttribute("msg", "用户信息 ");
        return "/user/info";
    }

    @Interceptor(LoginInterceptor.class)
    @ActionMapping(value = "/user/list", method = RequestMethod.GET)
    public String list(HttpServletRequest request, List<User> user) {
        request.setAttribute("msg", "用户信息");
        request.setAttribute("users", user);
        return "/user/list";
    }

    @ActionMapping(value = "/user/add", method = RequestMethod.GET)
    public String add(HttpServletRequest request) {
        request.setAttribute("msg", "添加用户");
        request.setAttribute("max", 5);
        return "/user/add";
    }

    @ResponseBody
    @ActionMapping(value = "/user/add", method = RequestMethod.POST)
    public String add(List<User> users) {
        System.out.println(users);
        return users.toString();
    }

    @ActionMapping(value = "/user/map", method = RequestMethod.GET)
    public String addMap(HttpServletRequest request) {
        request.setAttribute("msg", "添加用户");
        return "/user/map";
    }

    @ResponseBody
    @ActionMapping(value = "/user/map", method = RequestMethod.POST)
    public String add(Map<String, User> users) {
        System.out.println(users);
        return users.toString();
    }

    @ActionMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {

        session.invalidate();
        return "redirect:/login";
    }

    @ActionMapping(value = "/user/date", method = RequestMethod.GET)
    public String date(HttpServletRequest request) {
        request.setAttribute("msg", "自定义参数解析器测试");
        return "/param/date";
    }

    @ResponseBody
    @ActionMapping(value = "/user/date", method = RequestMethod.POST)
    public User date(User user) {
        return user;
    }

    @ResponseBody
    @ActionMapping(value = "/user/d", method = RequestMethod.GET)
    public Date date(Date date) {
        return date;
    }

    @ResponseBody
    @ActionMapping(value = "/user/set", method = RequestMethod.POST)
    public Set<User> set(Set<User> users) {
        return users;
    }

}
