package cn.taketoday.web.demo.view;

import java.util.function.Function;

import javax.servlet.http.HttpServletResponse;

import cn.taketoday.web.demo.Constant;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author TODAY <br>
 *         2019-04-17 17:46
 */
@Setter
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
            return Json.success();
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
            return Json.success();
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
    public static Json createResult(boolean success, int status, String message, Object data) {
        return new Json()//
                .setData(data)//
                .setMsg(message)//
                .setCode(status)//
                .setSuccess(success);
    }

    public static Json success() {
        return createResult(true, STATUS_SUCCESS, Constant.OPERATION_SUCCESS, null);
    }

    public static Json success(String message, Object data) {
        return createResult(true, STATUS_SUCCESS, message, data);
    }

    public static Json success(Object data) {
        return createResult(true, STATUS_SUCCESS, Constant.OPERATION_SUCCESS, data);
    }

    public static Json success(String message) {
        return createResult(true, STATUS_SUCCESS, message, null);
    }

    /**
     * default failed json
     * 
     * @return
     */
    public static Json failed() {
        return createResult(false, STATUS_FAILED, Constant.OPERATION_FAILED, null);
    }

    /**
     * @param data
     * @return
     */
    public static Json failed(Object data) {
        return createResult(false, STATUS_FAILED, Constant.OPERATION_FAILED, data);
    }

    /**
     * @param data
     * @return
     */
    public static Json failed(int status) {
        return createResult(false, status, Constant.OPERATION_FAILED, null);
    }

    /**
     * @param message
     * @return
     */
    public static Json failed(String message) {
        return createResult(false, STATUS_FAILED, message, null);
    }

    /**
     * @param message
     * @param data
     * @return
     */
    public static Json failed(String message, Object data) {
        return createResult(false, STATUS_FAILED, message, data);
    }

    public static Json failed(String message, int status) {
        return createResult(false, status, message, null);
    }

    public static Json failed(String message, int status, Object data) {
        return createResult(false, status, message, data);
    }

    public static Json badRequest() {
        return status(HttpServletResponse.SC_BAD_REQUEST);
    }

    /**
     * @param msg
     * @return
     */
    public static Json badRequest(String msg) {
        return createResult(false, HttpServletResponse.SC_BAD_REQUEST, msg, null);
    }

    public static Json notFound() {
        return status(HttpServletResponse.SC_NOT_FOUND);
    }

    public static Json notFound(String msg) {
        return createResult(false, HttpServletResponse.SC_NOT_FOUND, msg, null);
    }

    public static Json unauthorized() {
        return status(HttpServletResponse.SC_UNAUTHORIZED);
    }

    public static Json status(int status) {
        return failed(status);
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
