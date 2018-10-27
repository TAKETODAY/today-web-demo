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
package cn.taketoday.web.demo;

import cn.taketoday.context.annotation.Configuration;
import cn.taketoday.context.annotation.Props;
import cn.taketoday.context.annotation.Value;
import cn.taketoday.context.exception.ConfigurationException;
import cn.taketoday.context.factory.InitializingBean;
import cn.taketoday.web.ServletContextAware;

import javax.servlet.ServletContext;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Today <br>
 *         2018-10-27 10:14
 */
@Setter
@Getter
@Configuration
@Props(prefix = "site.")
public final class Config implements Constant, ServletContextAware, InitializingBean {

	private static final long serialVersionUID = 2021083013784359309L;

	private String cdn;
	private String icp;
	private String host;
	private String name;
	private String index;
	private String upload;
	private String keywords;
	private String copyright;
	private String baiduCode;

	@Value("#{site.server.path}")
	private String serverPath;

	private String description;
	private String otherFooterInfo;

	private ServletContext servletContext;

	public Config() {

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (servletContext == null) {
			throw new ConfigurationException("Servlet Context Can't Be null");
		}
		servletContext.setAttribute(KEY_CONTEXT_PATH, servletContext.getContextPath());
		servletContext.setAttribute(START_TIME, System.currentTimeMillis());
		servletContext.setAttribute(ICP, icp);
		servletContext.setAttribute(HOST, host);
		servletContext.setAttribute(CDN, cdn);
		servletContext.setAttribute(KEYWORDS, keywords);
		servletContext.setAttribute(SITE_NAME, name);
		servletContext.setAttribute(COPYRIGHT, copyright);
		servletContext.setAttribute(BAIDU_CODE, baiduCode);
		servletContext.setAttribute(UPLOAD_ROOT_PATH, upload);
		servletContext.setAttribute(DESCRIPTION, description);
		servletContext.setAttribute(OTHER_FOOTER_INFO, otherFooterInfo);
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}
