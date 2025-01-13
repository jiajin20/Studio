package com.cf.studio.service.impl;

import com.cf.studio.entity.Event;
import com.cf.studio.mapper.EventMapper;
import com.cf.studio.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service("EventService")
public class EventServiceImpl implements EventService {
    @Autowired
    private EventMapper eventMapper;
    // 添加活动
    @Override
    public int addEvent(String name, String description, LocalDateTime event_time,LocalDateTime end_time ,String location, String status, String organizer_name,int club_id) {
        return eventMapper.addEvent(name, description, event_time,end_time, location, status, organizer_name,club_id);
    }
    // 获取所有活动
    @Override
    public List<Event> getEventByClubId(int id) {
        return eventMapper.getEventByClubId(id);
    }
    //活动签到
    @Override
    public int signup(int userid,int eventid, int is_on_leave, String sign_in_code) {
        Integer registrationId = eventMapper.getRegistrationByUserId(userid, eventid);
        if (registrationId != null) {
            return 0;
        }
        Integer clubid=eventMapper.getclubByuserid(userid);
        if (clubid==null){
            return 0;
        }
        String status = eventMapper.getStatusById(eventid);
        if (!"ongoing".equals(status)) {
            return 0;
        }
        int result = eventMapper.addRegistration(userid, eventid, is_on_leave, sign_in_code,clubid);
        return result > 0 ? 1 : 0;
    }

}
