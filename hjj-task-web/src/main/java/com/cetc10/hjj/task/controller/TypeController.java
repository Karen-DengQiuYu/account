package com.cetc10.hjj.task.controller;

import com.cetc10.hjj.task.entity.Type;

import com.cetc10.hjj.task.service.TypeService;

import com.cetc10.hjj.task.vo.MsgVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@Api("分类管理")
@RestController
@RequestMapping("/type")
@CrossOrigin
public class TypeController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private HttpSession session;

    @GetMapping("add")
    public void add(double hope,String typeName){
        String username = (String) session.getAttribute("username");
        typeService.add(username,typeName,hope);

    }

    @DeleteMapping("delete")
    public void delete(int id){
        typeService.delete(id);
    }

    @GetMapping("/selectHopeById/{id}")
    public Type selectHopeById(@PathVariable("id") int id){
        return typeService.selectHopeById(id);
    }



    @GetMapping("selectByUser")
    public List<Type> selectByUser(){
        String username = (String) session.getAttribute("username");
       return typeService.selectByUserName(username);
    }

    @GetMapping("getName")
    public String getName(Integer id){
        return typeService.NameById(id);
    }





}
