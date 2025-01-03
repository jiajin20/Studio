package com.cf.studio.entity;

import java.io.Serializable;

/**
 * (Userevent)实体类
 *
 * @author makejava
 * @since 2025-01-03 19:23:38
 */
public class Userevent implements Serializable {
    private static final long serialVersionUID = 113723416652379116L;

    private Integer userId;

    private Integer eventId;


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

}

