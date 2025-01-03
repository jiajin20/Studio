package com.cf.studio.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 社团表，存储社团信息(Club)实体类
 *
 * @author makejava
 * @since 2025-01-03 19:23:38
 */
public class Club implements Serializable {
    private static final long serialVersionUID = -66970576425979346L;
/**
     * 社团ID
     */
    private Integer id;
/**
     * 社团名称
     */
    private String name;
/**
     * 社团描述
     */
    private String description;
/**
     * 社团标志
     */
    private String logo;
/**
     * 社团成立时间
     */
    private Date establishedDate;
/**
     * 指导教师姓名
     */
    private String advisorName;


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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Date getEstablishedDate() {
        return establishedDate;
    }

    public void setEstablishedDate(Date establishedDate) {
        this.establishedDate = establishedDate;
    }

    public String getAdvisorName() {
        return advisorName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName;
    }

}

