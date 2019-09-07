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
 * along with this program.  If not, see [http://www.gnu.org/licenses/]
 */
package cn.taketoday.web.demo.utils;

import cn.taketoday.web.exception.AccessForbiddenException;
import cn.taketoday.web.exception.BadRequestException;
import cn.taketoday.web.exception.NotFoundException;
import cn.taketoday.web.exception.UnauthorizedException;

/**
 * @author TODAY <br>
 *         2019-09-07 11:10
 */
public abstract class DemoUtils {

    public static BadRequestException badRequest() {
        return new BadRequestException();
    }

    public static UnauthorizedException unauthorized() {
        return new UnauthorizedException();
    }

    public static NotFoundException notFound() {
        return new NotFoundException();
    }

    public static AccessForbiddenException accessForbidden() {
        return new AccessForbiddenException();
    }
}
