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
package cn.taketoday.web.demo.controller;

import cn.taketoday.context.annotation.Autowired;
import cn.taketoday.web.RequestMethod;
import cn.taketoday.web.annotation.ActionMapping;
import cn.taketoday.web.annotation.Controller;
import cn.taketoday.web.annotation.Interceptor;
import cn.taketoday.web.annotation.ResponseBody;
import cn.taketoday.web.demo.domain.User;
import cn.taketoday.web.demo.interceptor.LoginInterceptor;
import cn.taketoday.web.demo.service.UserService;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author Today <br>
 *         2018-10-27 10:09
 */
@Controller
public final class UserController extends BaseController {

	private static final long serialVersionUID = -1;

	@Autowired
	private UserService userService;

	@ResponseBody(false)
	@ActionMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		return "/login/login";
	}

	@ResponseBody(false)
	@ActionMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession session, User user, HttpServletRequest request) {

		User login = userService.login(user);
		if (login == null) {
			request.setAttribute("msg", "登录失败");
			return "/error";
		}
		request.setAttribute("msg", "登录成功");
		session.setAttribute(USER_INFO, login);
		return "redirect:/user/info";
	}

	@ResponseBody(false)
	@ActionMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "/register/register";
	}

	@ActionMapping(value = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request, User user) {

		if (!userService.register(user)) {
			return "error!";
		}
		return "redirect:/login";
	}

	@ActionMapping(value = "/user/info", method = RequestMethod.GET)
	@Interceptor({ LoginInterceptor.class })
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
		request.setAttribute("msg", "日期注入测试");
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
