package org.cent.SpringBootDemo.service;

import org.cent.SpringBootDemo.domain.User;
import org.cent.SpringBootDemo.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户业务服务类
 * @author cent
 * @version 1.0
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    public int createUser(Long tel, String pwd) {
        return userMapper.createUser(tel, pwd);
    }

    public int updateUser(Integer id, String nickName) {
        return userMapper.updateUser(id, nickName);
    }

    public int deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }
}
