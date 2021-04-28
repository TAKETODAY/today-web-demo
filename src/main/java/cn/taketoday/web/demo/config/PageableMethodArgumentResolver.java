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

import cn.taketoday.context.Ordered;
import cn.taketoday.context.annotation.Order;
import cn.taketoday.context.annotation.Singleton;
import cn.taketoday.context.utils.StringUtils;
import cn.taketoday.web.RequestContext;
import cn.taketoday.web.demo.utils.DemoUtils;
import cn.taketoday.web.handler.MethodParameter;
import cn.taketoday.web.resolver.ParameterResolver;

/**
 * @author TODAY <br>
 *         2019-09-07 11:06
 */
@Singleton
@Order(Ordered.HIGHEST_PRECEDENCE)
public class PageableMethodArgumentResolver implements ParameterResolver {

    private static final String PARAMETER_SIZE = "size";
    private static final String PARAMETER_CURRENT = "page";

    private int maxListSize;
    private int defaultListSize;

    @Override
    public boolean supports(MethodParameter parameter) {
        return parameter.isAssignableTo(Pageable.class);
    }

    @Override
    public Object resolveParameter(RequestContext request, MethodParameter parameter) throws Throwable {
        return new RequestContextPageable(request, defaultListSize, maxListSize);
    }

    public int getMaxListSize() {
        return maxListSize;
    }

    public void setMaxListSize(int maxListSize) {
        this.maxListSize = maxListSize;
    }

    public int getDefaultListSize() {
        return defaultListSize;
    }

    public void setDefaultListSize(int listSize) {
        this.defaultListSize = listSize;
    }

    public final static class RequestContextPageable implements Pageable {

        private final int maxListSize;
        private final int defaultListSize;

        private Integer size;
        private Integer current;
        private final RequestContext request;

        public RequestContextPageable(RequestContext request, int listSize, int maxListSize) {
            this.request = request;
            this.defaultListSize = listSize;
            this.maxListSize = maxListSize;
        }

        @Override
        public int getCurrent() {

            if (current == null) {
                final String parameter = request.getParameter(PARAMETER_CURRENT);
                if (StringUtils.isEmpty(parameter)) {
                    current = 1;
                }
                else if ((current = Integer.valueOf(parameter)) <= 0) {
                    throw new IllegalArgumentException("only 'page > 0'");
                }
            }
            return current.intValue();
        }

        @Override
        public int getSize() {
            if (size == null) {
                int s;
                final String parameter = request.getParameter(PARAMETER_SIZE);
                if (StringUtils.isEmpty(parameter)) {
                    s = defaultListSize;
                }
                else {
                    s = Integer.parseInt(parameter);
                    if (s <= 0) {
                        throw new IllegalArgumentException("only 'size > 0'");
                    }
                    if (s > maxListSize) {
                        throw DemoUtils.accessForbidden();
                    }
                }
                return size = s;
            }
            return size.intValue();
        }

    }

}
