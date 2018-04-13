package org.cent.SpringBootDemo.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 接收请求参数模型类
 * @author cent
 * @version 1.0
 */
public class UserModel {
    private Integer id;
    private Long tel;
    private String nickName;
    private String password;
    private String createTime;
    private String updateTime;

    public Integer getId() {
        return id;
    }

    @NotNull(message = "手机号码不能为空")
    public Long getTel() {
        return tel;
    }

    public String getNickName() {
        return nickName;
    }

    @NotBlank(message = "密码不能为空")
    public String getPassword() {
        return password;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }
}
