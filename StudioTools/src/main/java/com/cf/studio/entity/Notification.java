package com.cf.studio.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Notification)实体类
 *
 * @author makejava
 * @since 2025-01-03 19:23:38
 */
public class Notification implements Serializable {
    private static final long serialVersionUID = -58601413060232177L;

    private Integer id;

    private String title;

    private String content;

    private String senderName;

    private Date publishDate;

    private Object type;

    private String receiverName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "Asia/Shanghai")
    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

}

