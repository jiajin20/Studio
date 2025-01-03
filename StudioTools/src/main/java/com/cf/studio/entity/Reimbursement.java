package com.cf.studio.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Reimbursement)实体类
 *
 * @author makejava
 * @since 2025-01-03 19:23:38
 */
public class Reimbursement implements Serializable {
    private static final long serialVersionUID = 140866405923689575L;

    private Integer id;

    private Double amount;

    private Date reimbursementTime;

    private String reimbursementDescription;

    private Integer activityId;

    private Integer userId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getReimbursementTime() {
        return reimbursementTime;
    }

    public void setReimbursementTime(Date reimbursementTime) {
        this.reimbursementTime = reimbursementTime;
    }

    public String getReimbursementDescription() {
        return reimbursementDescription;
    }

    public void setReimbursementDescription(String reimbursementDescription) {
        this.reimbursementDescription = reimbursementDescription;
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

