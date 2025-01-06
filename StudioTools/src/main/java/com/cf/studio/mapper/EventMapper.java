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
    @Select("select club_id from userclub where user_id=#{userid}")
    Integer getclubByuserid (int userid);
    @Select("select status from event where id=#{id}")
    String getStatusById (int id);
    @Insert("insert into registration(user_id,event_id,is_on_leave,sign_in_code,sign_time,club_id)values(#{userid},#{eventid},#{is_on_leave},#{sign_in_code},now(),#{club_id})")
    int addRegistration(int userid,int eventid,int is_on_leave,String sign_in_code,int club_id);
    @Select("select * from registration where user_id=#{userid} and event_id=#{eventid}")
    Integer getRegistrationByUserId (int userid,int eventid);
}
