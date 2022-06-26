package com.cetc10.hjj.task;


import com.cetc10.hjj.task.entity.User;
import com.cetc10.hjj.task.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SampleTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testPagehelper(){
        PageHelper.startPage(1,2);//使用PageHelper设置分页条件
        List<User> users = userMapper.findAll();
        for(User user : users){
            System.out.println(user);
        }
    }


}