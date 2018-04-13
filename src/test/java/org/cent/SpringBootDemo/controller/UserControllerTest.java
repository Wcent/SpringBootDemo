package org.cent.SpringBootDemo.controller;

import org.cent.SpringBootDemo.domain.User;
import org.cent.SpringBootDemo.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

/**
 * UserController CRUD测试
 * @author cent
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    private static User firstUser;
    private static User lastUser;

    @Autowired
    private MockMvc mockMvc;
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
    public void getUserById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/" + firstUser.getId().toString()))
                .andExpect(MockMvcResultMatchers.status().isOk());
//                .andExpect(MockMvcResultMatchers.content().string(firstUser.toString()));
    }

    @Test
    public void getUserList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/all"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void createUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/user/add?tel=321&password=UserController"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void updateUser() throws Exception {
        String url = "/user/" + lastUser.getId().toString() + "?nickName=UserControllerTest";
        mockMvc.perform(MockMvcRequestBuilders.put(url))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void deleteUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/user/" + firstUser.getId().toString()))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}