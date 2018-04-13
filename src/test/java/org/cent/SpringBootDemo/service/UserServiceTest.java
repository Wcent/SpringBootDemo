package org.cent.SpringBootDemo.service;

import org.cent.SpringBootDemo.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * UserService CRUD测试
 * @author cent
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    private static User firstUser;
    private static User lastUser;

    @Autowired
    private UserService userService;

    @Before
    public void setUp() {
        List<User> userList = userService.getUserList();
        if (userList.size() > 0) {
            firstUser = userList.get(0);
            lastUser = userList.get(userList.size()-1);
        }
    }

    @Test
    public void getUserById() {
        User user = userService.getUserById(firstUser.getId());
        Assert.assertEquals(firstUser.getId(), user.getId());
    }

    @Test
    public void getUserList() {
        List<User> userList = userService.getUserList();
    }

    @Test
    public void createUser() {
        userService.createUser(123L, "UserService");
        List<User> userList = userService.getUserList();
        User user = userList.get(userList.size()-1);
        Assert.assertEquals(new Long(123), user.getTel());
        Assert.assertEquals("UserService", user.getPassword());
    }

    @Test
    public void updateUser() {
        userService.updateUser(lastUser.getId(), "UserServiceTest");
        Assert.assertEquals("UserServiceTest", userService.getUserById(lastUser.getId()).getNickName());
    }

    @Test
    public void deleteUser() {
        userService.deleteUser(firstUser.getId());
    }
}