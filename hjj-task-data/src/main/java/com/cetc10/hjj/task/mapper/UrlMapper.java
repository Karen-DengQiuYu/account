package com.cetc10.hjj.task.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cetc10.hjj.task.entity.Url;
import com.cetc10.hjj.task.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UrlMapper extends BaseMapper<Url> {

}
