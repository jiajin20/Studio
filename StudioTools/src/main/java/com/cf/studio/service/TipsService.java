package com.cf.studio.service;

import com.cf.studio.entity.Notification;

import java.util.List;

public interface TipsService {
    //发送通知
    int sendTips( String title,String content,String senderName,String type,String receiverName);
    //获取通知
    List<Notification> getTips();
}
