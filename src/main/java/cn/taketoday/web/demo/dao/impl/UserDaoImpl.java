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
package cn.taketoday.web.demo.dao.impl;

import cn.taketoday.context.annotation.Repository;
import cn.taketoday.web.demo.dao.UserDao;
import cn.taketoday.web.demo.domain.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Today <br>
 *         2018-10-27 09:57
 */
@Repository
public final class UserDaoImpl implements UserDao {

	private Map<String, User> users = new HashMap<>();

	public UserDaoImpl() {
		users.put("666", new User().setAge(20).setId(1).setBrithday(new Date()).setUserId("666").setUserName("杨海健")
				.setPasswd("666").setSex("男"));
		users.put("6666", new User().setAge(20).setId(1).setBrithday(new Date()).setUserId("6666").setUserName("杨海健1")
				.setPasswd("666").setSex("男"));
		users.put("66666", new User().setAge(20).setId(1).setBrithday(new Date()).setUserId("66666").setUserName("杨海健2")
				.setPasswd("666").setSex("男"));
		users.put("666666", new User().setAge(20).setId(1).setBrithday(new Date()).setUserId("666666")
				.setUserName("杨海健3").setPasswd("666666").setSex("男"));
	}

	@Override
	public boolean save(User user) {

		users.put(user.getUserId(), user);

		return true;
	}

	@Override
	public User login(User user) {

		User user_ = users.get(user.getUserId());

		if (user_ == null) {
			return null;
		}
		if (!user_.getPasswd().equals(user.getPasswd())) {
			return null;
		}
		return user_;
	}
}
