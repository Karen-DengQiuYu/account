package com.cetc10.hjj.task.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cetc10.hjj.task.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where id=#{arg0}")
    User findById(int id);

    @Select("select * from user")
    List<User> findAll();

    @Insert("insert into user(username,password) values(#{username},#{password})")
    int add(User user);

    @Delete("delete from user where id=#{arg0}")
    int delete(int id);

    @Select("select * from user where username=#{username} and password=#{password}")
    User selectByUsernamePassword(String username, String password);
}
