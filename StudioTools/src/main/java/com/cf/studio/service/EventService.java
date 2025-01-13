package com.cf.studio.service;

import com.cf.studio.entity.Event;

import java.time.LocalDateTime;
import java.util.List;

public interface EventService {
   //添加活动
   int addEvent(String name, String description, LocalDateTime event_time, LocalDateTime end_time,String location, String status, String organizer_name,int club_id);
   //获取活动列表
   List<Event> getEventByClubId (int id);
   //活动签到
   int signup(int userid,int eventid,int is_on_leave,String sign_in_code);
}
