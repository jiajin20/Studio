package com.cf.studio.mapper;

import com.cf.studio.entity.Event;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

public interface EventMapper {
    @Insert("insert into event(name,description,event_time,end_time,location,status,organizer_name,club_id )values(#{name},#{description},#{event_time},#{end_time},#{location},#{status},#{organizer_name},#{club_id})")
    int addEvent(String name, String description, LocalDateTime event_time,LocalDateTime end_time, String location, String status, String organizer_name,int club_id);
    @Select("select * from event where club_id=#{id}")
    List<Event> getEventByClubId (int id);
}
