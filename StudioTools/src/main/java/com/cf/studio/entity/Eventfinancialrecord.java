package com.cf.studio.entity;

import java.io.Serializable;

/**
 * (Eventfinancialrecord)实体类
 *
 * @author makejava
 * @since 2025-01-03 19:23:38
 */
public class Eventfinancialrecord implements Serializable {
    private static final long serialVersionUID = -75724355745694494L;

    private Integer eventId;

    private Integer financialRecordId;


    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getFinancialRecordId() {
        return financialRecordId;
    }

    public void setFinancialRecordId(Integer financialRecordId) {
        this.financialRecordId = financialRecordId;
    }

}

