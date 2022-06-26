//package com.cetc10.hjj.task.entity;
//
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.annotation.TableId;
//import com.baomidou.mybatisplus.annotation.TableName;
//import com.fasterxml.jackson.annotation.JsonFormat;
//
//import java.util.Date;
//
//@TableName("echarts")
//public class Echarts {
//    /**
//     * 指定为自动增长id
//     */
//    @TableId(value = "id",type = IdType.AUTO)
//    private Long id;
//    private String name;
//    private Integer count;
//    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
//    private Date date;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getCount() {
//        return count;
//    }
//
//    public void setCount(Integer count) {
//        this.count = count;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//}
