package org.cent.SpringBootDemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 用户实体类
 * @author cent
 * @version 1.0
 */
public class User {
    private Integer id;
    private Long tel;
    private String nickName;
    private String password;
    private String createTime;
    private String updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "{id:" + id +
                ",tel:" + tel +
                ",nickName:" + nickName +
                ",password:" + password +
                ",createTime:" + createTime +
                ",updateTime:" + updateTime +
                "}";
    }
}
