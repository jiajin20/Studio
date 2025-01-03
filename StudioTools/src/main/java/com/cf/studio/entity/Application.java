package com.cf.studio.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Application)实体类
 *
 * @author makejava
 * @since 2025-01-03 19:23:38
 */
public class Application implements Serializable {
    private static final long serialVersionUID = 275155008797664909L;

    private Integer userId;

    private Integer clubId;

    private Object type;

    private Object status;

    private Date applicationDate;

    private String reason;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}

