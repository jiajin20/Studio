package com.cf.studio.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 活动表，存储社团活动信息(Event)实体类
 *
 * @author makejava
 * @since 2025-01-03 19:23:38
 */
public class Event implements Serializable {
    private static final long serialVersionUID = -44036845379439179L;
/**
     * 活动ID
     */
    private Integer id;
/**
     * 活动名称
     */
    private String name;
/**
     * 活动描述
     */
    private String description;
/**
     * 活动时间
     */
    private Date eventTime;
/**
     * 活动地点
     */
    private String location;
/**
     * 活动最大人数限制
     */
    private Integer maxParticipants;
/**
     * 活动状态（已发布、进行中、已结束）
     */
    private Object status;
/**
     * 活动组织者姓名
     */
    private String organizerName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(Integer maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

}

