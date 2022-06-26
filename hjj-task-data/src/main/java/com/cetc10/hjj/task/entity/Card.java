package com.cetc10.hjj.task.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 
 * @TableName card
 */
@TableName(value ="card")
public class Card implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private long id;

    /**
     * 
     */
    private long userId;


    /**
     * 账号名
     */
    private String cardName;

    /**
     * 卡余额 可以为负数 为负数就是 花呗
     */
    private Double cardOverage;


    private int interestId;

    @TableField(exist = false)
    private Interest interest;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public Interest getInterest() {
        return interest;
    }

    public void setInterest(Interest interest) {
        this.interest = interest;
    }

    public int getInterestId() {
        return interestId;
    }

    public void setInterestId(int interestId) {
        this.interestId = interestId;
    }

    /**
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * 
     */
    public long getUserId() {
        return userId;
    }

    /**
     * 
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }


    /**
     * 账号名
     */
    public String getCardName() {
        return cardName;
    }

    /**
     * 账号名
     */
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    /**
     * 余额
     * @return
     */
    public Double getCardOverage() {
        return cardOverage;
    }

    public void setCardOverage(Double cardOverage) {
        this.cardOverage = cardOverage;
    }
}