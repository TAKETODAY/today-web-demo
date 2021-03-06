package cn.taketoday.web.demo.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public final class User implements Serializable {

    private static final long serialVersionUID = 8795680197276813853L;

    private Integer id = null;
    private Integer age = null;
    private String sex = null;

    @NotBlank(message = "密码不能为空")
    private String passwd = null;

    @NotBlank(message = "用户名不能为空")
    private String userId = null;

    private String userName = null;

    private Date brithday = null;

    public User() {

    }

    @Override
    public String toString() {
        return " {\"id\":\"" + id + "\", \"userName\":\"" + userName + "\", \"age\":\"" + age + "\", \"passwd\":\"" + passwd + "\", \"userId\":\"" + userId + "\", \"sex\":\"" + sex + "\", \"brithday\":\"" + brithday + "\"}";
    }
}
