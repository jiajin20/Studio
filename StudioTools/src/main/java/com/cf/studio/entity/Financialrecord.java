package com.cf.studio.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Financialrecord)实体类
 *
 * @author makejava
 * @since 2025-01-03 19:23:38
 */
public class Financialrecord implements Serializable {
    private static final long serialVersionUID = -69597516943845178L;

    private Integer id;

    private Object recordType;

    private Double amount;

    private Date recordTime;

    private Integer activityId;

    private Integer userId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getRecordType() {
        return recordType;
    }

    public void setRecordType(Object recordType) {
        this.recordType = recordType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}

