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
package cn.taketoday.web.demo.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.taketoday.context.annotation.ParameterConverter;
import cn.taketoday.context.conversion.Converter;
import cn.taketoday.context.exception.ConversionException;

/**
 * 
 * @author Today <br>
 * 		2018-08-08 07:19
 */
@ParameterConverter
public final class DateConverter implements Converter<String, Date> {
	
	@Override
	public Date doConvert(String source) throws ConversionException {
		
		if (source == null) {
			return null;
		}
		try {
			
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(source);
		} catch (ParseException e) {
			throw new ConversionException();
		}
	}
	
}


