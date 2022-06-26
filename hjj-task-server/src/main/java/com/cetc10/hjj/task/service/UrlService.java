package com.cetc10.hjj.task.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cetc10.hjj.task.entity.Url;
import com.cetc10.hjj.task.entity.User;
import com.cetc10.hjj.task.entity.UserUrl;
import com.cetc10.hjj.task.mapper.UrlMapper;
import com.cetc10.hjj.task.mapper.UserMapper;
import com.cetc10.hjj.task.mapper.UserUrlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UrlService {

    @Autowired
    private UserMapper userMapper ;

    @Autowired
    private UrlMapper urlMapper;

    @Autowired
    private UserUrlMapper userUrlMapper;

    public List<Url> getUrlByUserUsername(String username){
        List<Url> urlList = new ArrayList<>();
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
        List<UserUrl> userUrllist = userUrlMapper.selectList(new QueryWrapper<UserUrl>().eq("user_id", user.getId()));
        for (UserUrl userUrl : userUrllist) {
            Url url = urlMapper.selectOne(new QueryWrapper<Url>().eq("id", userUrl.getUrlId()));
            urlList.add(url);
        }
        return urlList;
    }

    public List<Url> getAllUrl(){
       return urlMapper.selectList(null);
    }

    public List<UserUrl> getAllUrlByUserId(long userId){
       return userUrlMapper.selectList(new QueryWrapper<UserUrl>().eq("user_id",userId));
    }

    public void updateUserUrl(long userId, long urlId) {
        UserUrl userUrl = userUrlMapper.selectOne(new QueryWrapper<UserUrl>().eq("user_id", userId).eq("url_id", urlId));
        if(userUrl==null){
            UserUrl userUrlNew = new UserUrl();
            userUrlNew.setUserId(userId);
            userUrlNew.setUrlId(urlId);
            userUrlMapper.insert(userUrlNew);
        }else {
            userUrlMapper.deleteById(userUrl.getId());
        }
    }

}
