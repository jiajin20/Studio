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
    @Override
    public int addEvent(String name, String description, LocalDateTime event_time,LocalDateTime end_time ,String location, String status, String organizer_name,int club_id) {
        return eventMapper.addEvent(name, description, event_time,end_time, location, status, organizer_name,club_id);
    }

    @Override
    public List<Event> getEventByClubId(int id) {
        return eventMapper.getEventByClubId(id);
    }
}
