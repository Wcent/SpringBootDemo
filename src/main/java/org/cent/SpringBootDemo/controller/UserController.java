package org.cent.SpringBootDemo.controller;

import org.cent.SpringBootDemo.domain.User;
import org.cent.SpringBootDemo.domain.UserModel;
import org.cent.SpringBootDemo.enums.ResultCode;
import org.cent.SpringBootDemo.service.UserService;
import org.cent.SpringBootDemo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户控制类
 * @author cent
 * @version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 按id查询用户
     * @param id 用户号
     * @return 统一结果描述报文
     */
    @GetMapping("/{id}")
    public Result getUserById(@PathVariable("id") Integer id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return new Result(ResultCode.SUCCESS, user);
        } else {
//            return new Result(ResultCode.SUCCESS);
            return new Result(ResultCode.NO_USER);
        }
    }

    /**
     * 查询所有用户列表
     * @return 统一结果描述报文
     */
    @GetMapping("/all")
    public Result getUserList() {
        List<User> list = userService.getUserList();
        if (list.size() > 0) {
            return new Result(ResultCode.SUCCESS, list);
        } else {
//            return new Result(ResultCode.SUCCESS);
            return new Result(ResultCode.NO_USER);
        }
    }

    /**
     * 新增用户，对象直接获取传参，传参必须与对象属性命名一致
     * @param userModel 用户对象
     * @return 统一结果描述报文
     */
    @PostMapping("/add")
    public Result createUser(@RequestBody @Valid UserModel userModel) {
        if (userService.createUser(userModel.getTel(), userModel.getPassword()) > 0) {
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.ADD_ERROR);
        }
    }

    /**
     * 按id更新用户昵称
     * @param id 用户号
     * @param nickName 昵称
     * @return 统一结果描述报文
     */
    @PutMapping("/{id}")
    public Result updateUser(@PathVariable("id") Integer id, @RequestParam("nickName") String nickName) {
        if (userService.updateUser(id, nickName) > 0) {
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.UPDATE_ERROR);
        }
    }

    /**
     * 按id删除用户
     * @param id 用户号
     * @return 统一结果描述报文
     */
    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable("id") Integer id) {
        if (userService.deleteUser(id) > 0) {
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.DELETE_ERROR);
        }
    }
}
