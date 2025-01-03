package com.cf.studio.entity;

import java.io.Serializable;

/**
 * (Userfinancialrecord)实体类
 *
 * @author makejava
 * @since 2025-01-03 19:23:38
 */
public class Userfinancialrecord implements Serializable {
    private static final long serialVersionUID = 708162494438721860L;

    private Integer userId;

    private Integer financialRecordId;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFinancialRecordId() {
        return financialRecordId;
    }

    public void setFinancialRecordId(Integer financialRecordId) {
        this.financialRecordId = financialRecordId;
    }

}

