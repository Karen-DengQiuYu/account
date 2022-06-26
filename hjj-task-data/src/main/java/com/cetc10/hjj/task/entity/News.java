package com.cetc10.hjj.task.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import java.util.Date;

public class News {
    private int id;
    private String title;
    private Date date;
    private String content;
    @TableField(exist = false)
    private String DateFomat;

    public News(int id, String title, Date date, String content) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.content = content;
    }

    public News() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateFomat() {
        return DateFomat;
    }

    public void setDateFomat(String dateFomat) {
        DateFomat = dateFomat;
    }
}
