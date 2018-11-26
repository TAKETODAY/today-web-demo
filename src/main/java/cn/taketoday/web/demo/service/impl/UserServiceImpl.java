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
package cn.taketoday.web.demo.service.impl;

import cn.taketoday.context.annotation.Autowired;
import cn.taketoday.context.annotation.Service;
import cn.taketoday.web.demo.aspect.Logger;
import cn.taketoday.web.demo.dao.UserDao;
import cn.taketoday.web.demo.domain.User;
import cn.taketoday.web.demo.service.UserService;

/**
 * 
 * @author Today <br>
 *         2018-10-27 09:56
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	@Logger("login in service")
	public User login(User user) {
		return userDao.login(user);
	}

	@Override
	public boolean register(User user) {
		return userDao.save(user);
	}

}
