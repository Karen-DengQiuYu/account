package com.cetc10.hjj.task.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cetc10.hjj.task.entity.Url;
import com.cetc10.hjj.task.entity.User;
import com.cetc10.hjj.task.entity.UserUrl;
import com.cetc10.hjj.task.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UrlService urlService;
    public User findById(int id) {
//        User user = userMapper.findById(id);
        User user = userMapper.findById(id);
        return user;
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public User add(User user) {
        int flag = userMapper.add(user);
        if (flag==1) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
        return user;
    }

    public void delete(int id){
        int flag = userMapper.delete(id);
        if (flag==1) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    public User selectByUsername(String username){
        return userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
    }

    public void register(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        int falg = userMapper.selectCount(queryWrapper.eq("username", username));
        if (falg==1){
            return;
        }
        userMapper.insert(user);
    }

    public User selectByUsernamePassword(String username, String password) {
        String encode = passwordEncoder.encode(password);
        return userMapper.selectByUsernamePassword(username, encode);
    }

    public PageInfo<User> getUserUrl(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<User> userList = userMapper.selectList(null);
        for (User user : userList) {
            List<Url> allUrl = urlService.getAllUrl();
            for (Url url : allUrl) {
                boolean flag = false;
                List<UserUrl> allUrlByUserId = urlService.getAllUrlByUserId(user.getId());
                for (UserUrl userUrl : allUrlByUserId) {
                    if(url.getId()==userUrl.getUrlId()){
                        flag =true;
                        break;
                    }
                }
                url.setState(flag);
            }
            user.setUrlList(allUrl);
        }
        return new PageInfo<>(userList);
    }

    public void deleteByName(String username) {
        userMapper.delete(new QueryWrapper<User>().eq("username",username));
    }

    public void UpdateById(int id, String password) {
        String encode = passwordEncoder.encode(password);
        userMapper.update(null,new UpdateWrapper<User>().eq("id",id).set("password",encode));
    }

    public User getByUsername(String username) {
       return userMapper.selectOne(new QueryWrapper<User>().eq("username",username));
    }

    public int getUserIdbyName(String username){
        return userMapper.selectOne(new QueryWrapper<User>().eq("username",username)).getId();

    }
}
