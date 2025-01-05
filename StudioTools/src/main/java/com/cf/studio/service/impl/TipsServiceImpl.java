package com.cf.studio.service.impl;

import com.cf.studio.entity.Notification;
import com.cf.studio.mapper.TipsMapper;
import com.cf.studio.service.TipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tipsService")
public class TipsServiceImpl implements TipsService {
    @Autowired
    private TipsMapper tipsMapper;



    @Override
    public int sendTips( String title, String content, String senderName, String type, String receiverName) {
        return tipsMapper.insertTips(title, content, senderName, type, receiverName);
    }

    @Override
    public List<Notification> getTips( ) {
        return tipsMapper.selectTips();
    }

}
