package com.cetc10.hjj.task.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName interest
 */
@TableName(value ="interest")
public class Interest implements Serializable {
    /**
     * id自增
     */
    @TableId(type = IdType.AUTO)
    private Integer id;


    /**
     * 利率 如 1.35
     */
    private String rate;


    /**
     * 注释
     */
    private String comment;

    /**
     * 存入时间
     */
    private Date date;

    @TableField(exist = false)
    private String DateFomat;

    @TableField(exist = false)
    private Double accrual;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public Double getAccrual() {
        return accrual;
    }

    public void setAccrual(double accrual) {
        this.accrual = accrual;
    }

    public String getDateFomat() {
        return DateFomat;
    }

    public void setDateFomat(String dateFomat) {
        DateFomat = dateFomat;
    }

    /**
     * id自增
     */
    public Integer getId() {
        return id;
    }

    /**
     * id自增
     */
    public void setId(Integer id) {
        this.id = id;
    }


    /**
     * 利率 如 1.35
     */
    public String getRate() {
        return rate;
    }

    /**
     * 利率 如 1.35
     */
    public void setRate(String rate) {
        this.rate = rate;
    }



    /**
     * 注释
     */
    public String getComment() {
        return comment;
    }

    /**
     * 注释
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}