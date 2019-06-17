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
package cn.taketoday.web.demo.view;

import java.util.function.Function;

import javax.servlet.http.HttpServletResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author TODAY <br>
 *         2019-04-17 17:46
 */
@Setter
@Getter
@NoArgsConstructor
@SuppressWarnings("serial")
public class Json implements Result {

    private String msg;
    private Object data;
    private int code = 200;
    private boolean success;

    /**
     * Apply the common {@link Json} result
     * 
     * @param <T>
     * @param func
     *            the {@link Function}
     * @param param
     *            parameter
     * @return
     */
    public static final <T> Json apply(Function<T, Boolean> func, T param) {
        if (func.apply(param)) {
            return Json.ok();
        }
        return Json.failed();
    }

    /**
     * 
     * @param <T>
     * @param success
     * @return
     */
    public static final <T> Json apply(boolean success) {
        if (success) {
            return Json.ok();
        }
        return Json.failed();
    }

    /**
     * @param success
     *            if success
     * @param status
     *            error status
     * @param message
     *            the message of the response
     * @param data
     *            response data
     */
    public static Json create(boolean success, int status, String message, Object data) {
        return new Json()//
                .setData(data)//
                .setMsg(message)//
                .setCode(status)//
                .setSuccess(success);
    }

    public static Json ok() {
        return create(true, STATUS_SUCCESS, OPERATION_SUCCESS, null);
    }

    public static Json ok(String message, Object data) {
        return create(true, STATUS_SUCCESS, message, data);
    }

    public static Json ok(Object data) {
        return create(true, STATUS_SUCCESS, OPERATION_SUCCESS, data);
    }

    public static Json ok(String message) {
        return create(true, STATUS_SUCCESS, message, null);
    }

    /**
     * default failed json
     * 
     * @return
     */
    public static Json failed() {
        return create(false, STATUS_FAILED, OPERATION_FAILED, null);
    }

    /**
     * @param data
     * @return
     */
    public static Json failed(Object data) {
        return create(false, STATUS_FAILED, OPERATION_FAILED, data);
    }

    /**
     * @param message
     * @return
     */
    public static Json failed(String message) {
        return create(false, STATUS_FAILED, message, null);
    }

    /**
     * @param message
     * @param data
     * @return
     */
    public static Json failed(String message, Object data) {
        return create(false, STATUS_FAILED, message, data);
    }

    public static Json failed(String message, int status) {
        return create(false, status, message, null);
    }

    public static Json failed(String message, int status, Object data) {
        return create(false, status, message, data);
    }

    public static Json badRequest() {
        return badRequest(BAD_REQUEST);
    }

    /**
     * @param msg
     * @return
     */
    public static Json badRequest(String msg) {
        return create(false, HttpServletResponse.SC_BAD_REQUEST, msg, null);
    }

    public static Json notFound() {
        return notFound(NOT_FOUND);
    }

    public static Json notFound(String msg) {
        return create(false, HttpServletResponse.SC_NOT_FOUND, msg, null);
    }

    public static Json unauthorized() {
        return failed(UNAUTHORIZED, HttpServletResponse.SC_UNAUTHORIZED);
    }

    public static Json unauthorized(String msg) {
        return failed(msg, HttpServletResponse.SC_UNAUTHORIZED);
    }

    @Override
    public Object getData() {
        return data;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public boolean isSuccess() {
        return success;
    }

    @Override
    public String getMessage() {
        return msg;
    }

    @Override
    public String toString() {
        return new StringBuilder()//
                .append("{\"msg\":\"").append(msg)//
                .append("\",\"code\":\"").append(code)//
                .append("\",\"data\":\"").append(data)//
                .append("\",\"success\":\"").append(success)//
                .append("\"}")//
                .toString();
    }

}
