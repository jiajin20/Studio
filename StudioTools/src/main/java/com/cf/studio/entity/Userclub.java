package com.cf.studio.entity;

import java.io.Serializable;

/**
 * (Userclub)实体类
 *
 * @author makejava
 * @since 2025-01-03 19:23:38
 */
public class Userclub implements Serializable {
    private static final long serialVersionUID = 693127019626634860L;

    private Integer userId;

    private Integer clubId;


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

}

