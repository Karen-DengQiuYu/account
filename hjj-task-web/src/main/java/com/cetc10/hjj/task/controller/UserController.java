package com.cetc10.hjj.task.controller;


import com.cetc10.hjj.task.entity.User;
import com.cetc10.hjj.task.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Api(value = "desc of class")
@RestController
@CrossOrigin
//@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private HttpSession session;

    @GetMapping(value = "/getSession")
    public User GetSession() {
        String username = (String) session.getAttribute("username");
        return userService.getByUsername(username);

    }

    @GetMapping(value = "/findById/{id}")
    public User findById(@PathVariable("id") Integer id) {
        User user = userService.findById(id);
        System.out.println(user);
        return  user;
    }

    @RequestMapping(value = "/findAll")
    public List<User> findAll(){
        List<User> userList = userService.findAll();
        return userList;
    }


    @ApiOperation(value="删除用户",notes = "删除用户")
    @GetMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        userService.delete(id);
    }

    @ApiOperation(value="删除用户根据session",notes = "删除用户根据session")
    @PostMapping(value = "/deleteByName")
    public void deleteByName(){
        String username = (String) session.getAttribute("username");
        userService.deleteByName(username);
    }

    //    注册
    @ApiOperation(value="注册",notes = "注册")
    @PostMapping(value = "/register")
    public void Register(String username, String password) {
        userService.register(username, password);
    }

    //    注册
    @ApiOperation(value="修改密码",notes = "修改密码")
    @PostMapping(value = "/updateById")
    public void UpdateById(int id, String password) {
        userService.UpdateById(id, password);
    }

//    //登录
//    @PostMapping(value = "/login")
//    //@ResponseBody
//    public User Login(String username, String password) {
//        User user= userService.selectByUsernamePassword(username, password);
//        return user;
//    }
}
