package com.cf.studio.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Equipment)实体类
 *
 * @author makejava
 * @since 2025-01-03 19:23:37
 */
public class Equipment implements Serializable {
    private static final long serialVersionUID = 970502200508301141L;

    private Integer id;

    private String name;

    private String description;

    private Date borrowTime;

    private Date returnTime;

    private String borrowerName;


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

    public Date getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

}

