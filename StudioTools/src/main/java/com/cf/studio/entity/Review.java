package com.cf.studio.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Review)实体类
 *
 * @author makejava
 * @since 2025-01-03 19:23:38
 */
public class Review implements Serializable {
    private static final long serialVersionUID = 999337043407153612L;

    private Integer id;

    private Integer eventId;

    private Integer userId;

    private Integer rating;

    private String content;

    private Date reviewTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

}

