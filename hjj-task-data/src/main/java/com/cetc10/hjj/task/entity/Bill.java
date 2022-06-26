package com.cetc10.hjj.task.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName bill
 */
@TableName(value ="bill")
public class Bill implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 分类
     */
    private Integer typeId;
    /**
     *
     */
    private Integer userId;

    /**
     * 金额
     */
    private Double account;

    /**
     * 支付方式 对应了card里的id
     */
    private Integer payMethod;

    /**
     * 更新时间 年月日 时分秒
     */
    private Date date;

    /**
     * 0表示支出 1表示收入
     */
    private Integer state;

    /**
     * 备注
     */
    private String comment;

    /**
     * 类型名称 银行卡
     */
    @TableField(exist = false)
    private String payMethodName;
    @TableField(exist = false)
    private String stateName;
    @TableField(exist = false)
    private String typeName;
    @TableField(exist = false)
    private String DateFomat;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Double getAccount() {
        return account;
    }

    public void setAccount(Double account) {
        this.account = account;
    }

    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPayMethodName() {
        return payMethodName;
    }

    public void setPayMethodName(String payMethodName) {
        this.payMethodName = payMethodName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDateFomat() {
        return DateFomat;
    }

    public void setDateFomat(String dateFomat) {
        DateFomat = dateFomat;
    }
}