package com.cf.studio.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * 报名表，中间表，表示用户报名参加活动(Registration)实体类
 *
 * @author makejava
 * @since 2025-01-03 19:23:38
 */
public class Registration implements Serializable {
    private static final long serialVersionUID = -74218572748453983L;
/**
     * 用户ID
     */
    private Integer userId;
/**
     * 活动ID
     */
    private Integer eventId;
/**
     * 报名时间
     */
    private Date registrationTime;
/**
     * 是否请假
     */
    private Integer isOnLeave;
/**
     * 签到码
     */
    private String signInCode;
    private Date signtime;
    private int clubid;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public Integer getIsOnLeave() {
        return isOnLeave;
    }

    public void setIsOnLeave(Integer isOnLeave) {
        this.isOnLeave = isOnLeave;
    }

    public String getSignInCode() {
        return signInCode;
    }

    public void setSignInCode(String signInCode) {
        this.signInCode = signInCode;
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Date getSigntime() {
        return signtime;
    }

    public void setSigntime(Date signtime) {
        this.signtime = signtime;
    }

    public int getClubid() {
        return clubid;
    }

    public void setClubid(int clubid) {
        this.clubid = clubid;
    }
}

