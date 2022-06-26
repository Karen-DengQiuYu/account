package com.cetc10.hjj.task.controller;


import com.cetc10.hjj.task.entity.News;
import com.cetc10.hjj.task.service.NewsService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/news")
@Api
@CrossOrigin
public class NewsController {

    @Autowired
    private NewsService newsService;


    /**********************前台页面*********************/
    /*新闻列表 分页*/
    @ApiOperation(value="新闻列表page",notes = "新闻列表page")
    @GetMapping("/newsList")
    public PageInfo<News> newsList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                   @RequestParam(value = "size", required = false , defaultValue = "6") Integer size){
        PageInfo<News> pager = newsService.getPager(page, size);
        return pager;
    }



    /*新闻列表*/
    @GetMapping("lists")
    @ResponseBody//转换为json对象
    /*如果有参的时候就是模糊查询，如果无参的时候就是全查询这里用到了动态sql查询*/
    public List<News> newsListAll(String keyword) {
        List<News> lists = newsService.newsListAll(keyword);
        return lists;
    }

    /*查看新闻内容页面*/
    @GetMapping("{id}")
    @ResponseBody
    public News newsDetail(@PathVariable int id) {
        News news = newsService.findById(id);
        return news;
    }



    /**********************后台管理页面*********************/

    /*添加新闻逻辑*/
    @PostMapping("add")
    public void addNews(String title,String content) {
        newsService.addNews(title,content);
    }


    /*修改新闻*/
    @PostMapping("editor")
    public void editorNews(News news) {
        news.setDate(new Date());
        newsService.editorNews(news);

    }

    /*删除新闻逻辑*/
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        newsService.delete(id);
    }



}
