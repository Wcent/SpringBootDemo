package org.cent.SpringBootDemo.repository.impl;

import org.cent.SpringBootDemo.domain.User;
import org.cent.SpringBootDemo.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CRUD操作用户接口实现类，使用jdbc链接数据库
 * @author cent
 * @version 1.0
 */
@Repository
public class UserMapperImpl implements UserMapper {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User getUserById(Integer id) {
        List<User> userList = jdbcTemplate.query("SELECT * FROM SpringBootDB.user WHERE id = ?",
                new Object[] {id}, new BeanPropertyRowMapper(User.class));
        if (userList != null && userList.size() > 0) {
            User user = userList.get(0);
            return user;
        } else {
            return null;
        }
    }

    @Override
    public List<User> getUserList() {
        List<User> userList = jdbcTemplate.query("SELECT * FROM SpringBootDB.user",
                new BeanPropertyRowMapper(User.class));
        if (userList != null && userList.size() > 0) {
            return userList;
        } else {
            return null;
        }
    }

    @Override
    public int createUser(Long tel, String pwd) {
        return jdbcTemplate.update("INSERT INTO SpringBootDB.user(tel, password, nick_name) " +
                "VALUES(?, ?, ?)", tel, pwd, tel);
    }

    @Override
    public  int updateUser(Integer id, String nickName) {
        return jdbcTemplate.update("UPDATE SpringBootDB.user SET nick_name = ? WHERE id = ?", nickName, id);
    }

    @Override
    public int deleteUser(Integer id) {
        return jdbcTemplate.update("DELETE FROM SpringBootDB.user WHERE id = ?", id);
    }
}
