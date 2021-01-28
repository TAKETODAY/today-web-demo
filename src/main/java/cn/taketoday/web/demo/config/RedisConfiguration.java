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

import cn.taketoday.context.annotation.Props;
import lombok.Getter;
import lombok.Setter;

/**
 * @author TODAY <br>
 *         2019-02-28 19:01
 */
@Getter
@Setter
//@Configuration
@Props(prefix = { "redis.pool.", "redis." })
public class RedisConfiguration {

    private int maxIdle;
    private int minIdle;
    private int timeout;
    private int maxTotal;

    private int database;
    private String address;

    private String password;
    private String clientName;

    private int connectTimeout;

    /**
     * 
     * @param redisson
     * @return
     */
//	@Singleton("limitLock")
//	public Lock limitLock(Redisson redisson) {
//		return redisson.getLock("limitLock");
//	}

//	@Singleton
//	public Codec codec() {
//		return new FstCodec();
//	}

//	@Singleton(destroyMethods = "shutdown")
//	public Redisson redisson(Codec codec) {
//		Config config = new Config();
//		config.setCodec(codec)//
//				.useSingleServer()//
//				.setAddress(address)//
//				.setTimeout(timeout)//
//				.setPassword(password)//
//				.setDatabase(database)//
//				.setClientName(clientName)//
//				.setConnectionPoolSize(maxTotal)//
//				.setConnectTimeout(connectTimeout)//
//				.setConnectionMinimumIdleSize(minIdle)//
//				.setConnectionMinimumIdleSize(maxIdle);
//
//		return (Redisson) Redisson.create(config);
//	}

}
