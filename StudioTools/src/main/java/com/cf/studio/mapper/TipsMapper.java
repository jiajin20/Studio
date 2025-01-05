package com.cf.studio.mapper;

import com.cf.studio.entity.Notification;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TipsMapper {
    @Insert("insert into notification(title,content,sender_name,publish_date,type,receiver_name) values(#{title},#{content},#{senderName},now(),#{type},#{receiverName})")
    int insertTips(String title,String content,String senderName,String type,String receiverName);
    @Select("select * from notification")
    List<Notification> selectTips();
}
