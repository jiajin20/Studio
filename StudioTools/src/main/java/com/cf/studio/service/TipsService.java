package com.cf.studio.service;

import com.cf.studio.entity.Notification;

import java.util.List;

public interface TipsService {
    int sendTips( String title,String content,String senderName,String type,String receiverName);
    List<Notification> getTips();
}
