package com.cetc10.hjj.task.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cetc10.hjj.task.entity.Type;
import com.cetc10.hjj.task.entity.User;
import com.cetc10.hjj.task.mapper.TypeMapper;
import com.cetc10.hjj.task.util.DateUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

@Service
public class TypeService {
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private UserService userService;
    public void add(String username, String typeName, double hope) {
        Type type = new Type();
        type.setName(typeName);
        if(hope!=0||!"".equals(hope)){
            type.setHope(hope);
        }else{
            type.setHope(0);
        }
        User user = userService.selectByUsername(username);
        type.setUserId(user.getId());
        typeMapper.insert(type);
    }

    public void delete(int id){
        typeMapper.deleteById(id);
    }

    public List<Type> selectByUserName(String name){
        User user = userService.selectByUsername(name);
        QueryWrapper<Type> wrapper =new QueryWrapper<>();
        wrapper.eq("user_id",user.getId());
        List<Type> types = typeMapper.selectList(wrapper);
        return types;
    }

    public String NameById(int id){
        return typeMapper.selectById(id).getName();
    }

    public Type selectHopeById(int id) {
        Type type = typeMapper.selectById(id);
        return type;
    }
}
