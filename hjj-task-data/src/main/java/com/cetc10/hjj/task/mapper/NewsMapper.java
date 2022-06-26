package com.cetc10.hjj.task.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cetc10.hjj.task.entity.News;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface NewsMapper extends BaseMapper<News> {

    @Insert("insert into news(title,author,date,content) values(#{title},#{author},#{date},#{content})")
    int addNews(News news);

    @Select("select count(1) from news")
    int getTotal();

    @Select("select * from news order by date desc limit #{arg0},#{arg1}")
    List<News> newsList(int start, int count);

    @Select("select * from news order by date desc")
    List<News> newsListAll();

    List<News> newsListAllByKw(@Param("keyword") String keyword);

    @Select("select * from news where id=#{arg0}")
    News findById(int id);


    @Update("update news set title=#{title},author=#{author},date=#{date},content=#{content} where id=#{id}")
    int editor(News news);
}
