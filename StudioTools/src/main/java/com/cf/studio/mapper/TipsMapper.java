package com.cf.studio.mapper;

import com.cf.studio.entity.Notification;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TipsMapper {
    //新建通知
    @Insert("insert into notification(title,content,sender_name,publish_date,type,receiver_name) values(#{title},#{content},#{senderName},now(),#{type},#{receiverName})")
    int insertTips(String title,String content,String senderName,String type,String receiverName);
    //获取通知
    @Select("select * from notification")
    List<Notification> selectTips();
}
