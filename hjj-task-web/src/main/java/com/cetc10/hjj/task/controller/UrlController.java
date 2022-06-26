package com.cetc10.hjj.task.controller;

import com.cetc10.hjj.task.entity.Bill;
import com.cetc10.hjj.task.entity.Url;
import com.cetc10.hjj.task.entity.User;
import com.cetc10.hjj.task.service.UrlService;
import com.cetc10.hjj.task.service.UserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("url")
public class UrlController {

    @Autowired
    private UrlService urlService;
    @Autowired
    private UserService userService;
    @Autowired
    private HttpSession session;
    @ApiOperation(value="urlList",notes = "urlList")
    @GetMapping(value = "/findUrl")
    public List<Url> findUrl() {
        String username = (String) session.getAttribute("username");
        return urlService.getUrlByUserUsername(username);
    }
    @ApiOperation(value="权限管理",notes = "权限管理")
    @GetMapping(value = "/getUserUrl")
    public PageInfo<User> getUserUrl(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                     @RequestParam(value = "size", required = false , defaultValue = "10") Integer size){
        return userService.getUserUrl(page,size);
    }

    @ApiOperation(value="修改状态",notes = "修改状态")
    @PostMapping(value = "/updateUserUrl")
    public void updateUserUrl(long userId,long urlId){
        urlService.updateUserUrl(userId,urlId);
    }


}
