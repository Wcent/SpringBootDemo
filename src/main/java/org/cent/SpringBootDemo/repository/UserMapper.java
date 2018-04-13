package org.cent.SpringBootDemo.repository;

import org.cent.SpringBootDemo.domain.User;

import java.util.List;

/**
 * CRUD操作用户抽象接口
 * @author cent
 * @version 1.0
 */
public interface UserMapper {

    User getUserById(Integer id);

    List<User> getUserList();

    int createUser(Long tel, String pwd);

    int updateUser(Integer id, String nickName);

    int deleteUser(Integer id);
}
