package com.cetc10.hjj.task.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName transfer
 */
@TableName(value ="transfer")
public class Transfer implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private Integer inId;

    /**
     * 
     */
    private Integer outId;

    /**
     * 
     */
    private Double account;

    /**
     * 
     */
    private Date date;

    /**
     * 备注
     */
    private String comment;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInId() {
        return inId;
    }

    public void setInId(Integer inId) {
        this.inId = inId;
    }

    /**
     * 
     */
    public Integer getOutId() {
        return outId;
    }

    /**
     * 
     */
    public void setOutId(Integer outId) {
        this.outId = outId;
    }

    /**
     * 
     */
    public Double getAccount() {
        return account;
    }

    /**
     * 
     */
    public void setAccount(Double account) {
        this.account = account;
    }

    /**
     * 
     */
    public Date getDate() {
        return date;
    }

    /**
     * 
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 备注
     */
    public String getComment() {
        return comment;
    }

    /**
     * 备注
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}