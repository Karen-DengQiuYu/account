package com.cetc10.hjj.task.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cetc10.hjj.task.entity.News;
import com.cetc10.hjj.task.mapper.NewsMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Transactional
    public boolean addNews(String title,String content) {
        News news = new News();
        news.setDate(new Date());
        news.setTitle(title);
        news.setContent(content);
        int flag = newsMapper.insert(news);
        return flag == 1 ? true : false;
    }



    public PageInfo<News> getPager(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<News> newslist = newsMapper.selectList(new QueryWrapper<News>().orderByDesc("date"));
        for (News news : newslist) {
            Date date = news.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateFormat = sdf.format(date);
            news.setDateFomat(dateFormat);
        }
        PageInfo<News> pageInfo = new PageInfo<>(newslist);
        return pageInfo;
    }

    public List<News> findStudentsByPage(int currentPage, int pageSize) {
        if (currentPage < 1) {
            currentPage = 1;
        }
        int start = (currentPage - 1) * pageSize;
        return newsMapper.newsList(start, pageSize);
    }


    public List<News> newsListAll() {
        return newsMapper.newsListAll();
    }

    public List<News> newsListAll(String keyword) {
        return newsMapper.newsListAllByKw(keyword);
    }


    public News findById(int id) {
        News news = newsMapper.findById(id);
        Date date = news.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateFormat = sdf.format(date);
        news.setDateFomat(dateFormat);
        return news;
    }

    public int delete(int id) {
        return newsMapper.deleteById(id);
    }


    @Transactional
    public boolean editorNews(News news) {
        int flag = newsMapper.editor(news);
        return flag == 1 ? true : false;
    }

}
