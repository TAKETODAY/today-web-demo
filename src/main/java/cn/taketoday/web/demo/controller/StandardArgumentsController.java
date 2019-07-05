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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.security.Principal;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.taketoday.web.annotation.GET;
import cn.taketoday.web.annotation.POST;
import cn.taketoday.web.annotation.RequestMapping;
import cn.taketoday.web.annotation.RestController;

/**
 * 
 * @author TODAY <br>
 *         2019-02-16 12:11
 */
@RestController
@RequestMapping("/standard")
public class StandardArgumentsController {

    // request related

    @GET("/request")
    public String standardRequestArgs(HttpServletRequest request, Principal user, Locale locale) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("request = ").append(request).append(", ");
        buffer.append("userPrincipal = ").append(user).append(", ");
        buffer.append("requestLocale = ").append(locale);
        return buffer.toString();
    }

    @POST("/request/reader")
    public String requestReader(BufferedReader requestBodyReader) throws IOException {
        return "Read char request body = " + requestBodyReader.readLine();
    }

    @GET("/response")
    public String response(HttpServletResponse response) {
        return "response = " + response;
    }

    @GET("/response/writer")
    public void availableStandardResponseArguments(Writer responseWriter) throws IOException {
        responseWriter.write("Wrote char response using Writer");
    }

    @GET("/response/os")
    public void availableStandardResponseArguments(OutputStream os) throws IOException {
        os.write("Wrote binary response using OutputStream".getBytes());
    }

    // HttpSession
    @GET("/session")
    public String session(HttpSession session) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("session=").append(session);
        return buffer.toString();
    }

}
